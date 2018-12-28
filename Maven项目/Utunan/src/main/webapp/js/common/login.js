permit = document.getElementById('permit');
password = document.getElementById('password');
textpassword=document.getElementById("login_showPwd");
function checkpermit(value) {
    var regt = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;
    var rege = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    return (!regt.test(value)) && (!rege.test(value));
}

function checkpassword(value) {
    var regu = "^[0-9a-zA-Z]{8,16}$";
    var re = new RegExp(regu);
    if (re.test(value)) {
        return true;
    } else {
        return false;
    }
}

function permitcheck() {
    var state = true;
    var reply = ""

    if (checkpermit(permit.value)) {
        state = false;
        reply = "通行证格式错误"
    }
    if (permit.value == '') {
        state = false;
        reply = "通行证不能为空"
    }

    if (state) {
        permit.parentNode.style.border = '1px solid LightSteelBlue';
        return true
    }
    else {
        permit.parentNode.style.border = '1px solid red';
        permit.style.color="red";
        permit.value=reply;
        return false
    }
}

function passwordcheck() {
    var state = true;
    var reply = ""

    if (!checkpassword(password.value)) {
        state = false;
        reply = "密码格式错误"
    }
    if (password.value == '') {
        state = false;
        reply = "密码不能为空"
    }
    if (state) {
        password.parentNode.style.border = '1px solid LightSteelBlue';
        return true
    }
    else {
        textpassword.style.display="block";
        password.style.display="none";
        textpassword.parentNode.style.border = '1px solid red';
        textpassword.style.color="red";
        textpassword.value=reply;
        return false
    }
}

function checkForm() {
    var passstate = passwordcheck()
    var perstate = permitcheck()

    if (passstate && perstate)
        return true
    else
        return false
}

permit.onfocus=function () {
    if (checkpermit(permit.value)) {
        permit.value=""
        permit.style.color="#666";
    }
}

permit.onblur=function () {
    $.ajax({
        type: "post",
        url: "/checkpermit",
        data: {
            userTelephone: permit.value,
            userEmail: permit.value
        },
        dataType: "json",
        success: function (data) {
            if (data == '200') {
                var state = true;
                var reply = ""

                if (checkpermit(permit.value)) {
                    state = false;
                    reply = "通行证格式错误"
                }
                if (permit.value == '') {
                    state = false;
                    reply = "通行证不能为空"
                }

                if (state) {
                    permit.parentNode.style.border = '1px solid LightSteelBlue';
                    return true
                }
                else {
                    permit.parentNode.style.border = '1px solid red';
                    permit.style.color="red";
                    permit.value=reply;
                    return false
                }
            } else {
                permit.parentNode.style.border = '1px solid red';
                permit.style.color="red";
                permit.value="通行证不存在，请先注册";
            }
        },error:function(){
            console.log("通行证验证异常！")
        }
    });

}

password.onfocus=function () {
    if (!checkpassword(password.value)) {
        password.value=""

    }
}
textpassword.onfocus=function () {
    textpassword.value="";
    textpassword.style.display="none";
    password.style.display="block";
    password.value="";
    password.focus();

}
password.onblur=passwordcheck
