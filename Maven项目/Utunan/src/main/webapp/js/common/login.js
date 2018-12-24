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
                /*$('#permitreply').html("")*/
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
    password.onfocus();
}
password.onblur=passwordcheck


/*
permit = document.getElementById('permit');
password = document.getElementById('password');
reply = document.getElementById('reply');

state = false;

function checkpermit() {
    var regt = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;
    var rege = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    return (!regt.test(permit.value)) && (!rege.test(permit.value));
}

isonclik = false;
permit.onfocus = function () {
    isonclik = true;
}
permit.onblur = function () {
    if (isonclik) {
        if (permit.value == '') {
            permit.parentNode.style.border = '1px solid red';
            reply.innerHTML = '通行证或密码不能为空'
        } else {
            permit_state = false;
            reply.innerHTML = ''
            var xmlhttp;
            if (window.XMLHttpRequest) {
                xmlhttp = new XMLHttpRequest();
            } else {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            //向后台发送验证信息
            xmlhttp.open("POST", "/checkpermit?permit=" + permit.value, true);
            xmlhttp.send();
            //对返回信息进行验证
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var res = xmlhttp.responseText;
                    if (res == "unsuccessful") {
                        reply.innerHTML = '通行证不存在,请先<a href="/register">注册</a>';
                        permit.parentNode.style.border = '1px solid red';
                    } else {
                        reply.innerHTML = "";
                        state = true;
                        permit.parentNode.style.border = '1px solid LightSteelBlue';
                    }
                }
            }
        }
    }
}

password.onblur = function () {

    if (password.value == '') {
        password.parentNode.style.border = '1px solid red';
        if (state)
            reply.innerHTML = '通行证或密码不能为空';
        if (permit.value == '') {
            permit.parentNode.style.border = '1px solid red';
        }
    }
}


function checkForm() {
    var checkForm_state=true;
    var replywords=""
    if (password.value == '' || permit.value == '') {
        replywords = '通行证或密码不能为空';
        checkForm_state = false;
        if (password.value == '') {
            password.parentNode.style.border = '1px solid red';
        }
        if (permit.value == '') {
            permit.parentNode.style.border = '1px solid red';
        }
    }

    if (checkpermit()) {
        replywords = '请使用手机号或邮箱登录'
        permit.parentNode.style.border = '1px solid red';
        checkForm_state = false;
    }
    reply.innerHTML =replywords
    return checkForm_state;
}

*/
