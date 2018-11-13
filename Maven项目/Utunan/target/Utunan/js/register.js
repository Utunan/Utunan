userTelephone = document.getElementById("userTelephone");
vcode = document.getElementById("code");
getcode = document.getElementById("getcode");
password = document.getElementById("password");
rpassword = document.getElementById("rpassword");

var gctimer = null;
var issend = false;
var state = true;
var code_state = false;
var reply_value = "";
var check_state = true;

function checkpermit(telephone) {
    var re = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;
    return re.test(telephone);
}

getcode.onclick = function () {
    if (checkpermit(userTelephone.value)) {
        var xmlhttp;
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        } else {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        if (issend == false) {
            issend = true;
            gitimer = 60;
            getcode.innerHTML = '60s后重新发送';
            gctimer = setInterval(function () {
                getcode.innerHTML = gitimer + 's后重新发送';
                //Ajax的操作
                xmlhttp.open("POST", "/code?userTelephone=" + userTelephone.value, true);
                xmlhttp.send();
                //对返回信息进行验证
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                        var res = xmlhttp.responseText;
                        code_state = true;
                    }
                }
                if (gitimer > 0) {
                    gitimer--;
                } else {
                    clearInterval(gctimer);
                    getcode.innerHTML = "获取验证码"
                    issend = false
                }
            }, 1000)
        } else {
            return false;
        }
    } else {
        if (issend == false)
            reply.innerHTML = '请输入正确的手机号码';
    }
}

function checkForm() {
    reply_value=""
    if (!code_state) {
        reply_value = "请先获取验证码";
        vcode.parentNode.style.border = '1px solid red';
        check_state=false;
    } else
        vcode.parentNode.style.border = '1px solid LightSteelBlue';

    if (checkpermit(userTelephone.value)) {
        userTelephone.parentNode.style.border = '1px solid red';
        reply_value = '请输入正确的手机号码';
        check_state=false;
    } else {
        userTelephone.parentNode.style.border = '1px solid LightSteelBlue';
    }

    if (password.value != rpassword.value) {
        reply_value = '两次输入的密码不相同';
        rpassword.parentNode.style.border = '1px solid red';
        check_state=false;
    } else {
        rpassword.parentNode.style.border = '1px solid LightSteelBlue';
    }


    reply.innerHTML = reply_value;
    return check_state;
}

