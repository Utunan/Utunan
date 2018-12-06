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
var isregister = true;
var tele_state=true;
function checkvcode(value) {
    reg = /^\d{6}$/;
    if (reg.test(value))
        return true;
    return false;
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
        //向后台发送验证信息
        xmlhttp.open("POST", "/checkpermit?permit=" + userTelephone.value, true);
        xmlhttp.send();


        //对返回信息进行验证
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                var res = xmlhttp.responseText;
                if (res == "successful") {
                    reply.innerHTML = '手机号已被注册';
                    tele_state=false;
                    userTelephone.parentNode.style.border = '1px solid red';
                } else {
                    reply.innerHTML = "";
                    state = true;
                    isregister = false;
                    userTelephone.parentNode.style.border = '1px solid LightSteelBlue';
                }
            }
        }

        setTimeout(function () {
                if (issend == false && !isregister) {
                    issend = true;
                    gitimer = 59;
                    getcode.innerHTML = '60s后重新发送';
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
                    gctimer = setInterval(function () {
                        getcode.innerHTML = gitimer + 's后重新发送';
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
            }, 1000)
    } else {
        if (issend == false)
            reply.innerHTML = '请输入正确的手机号码';
    }
}

function checkForm() {
    reply_value = ""
    check_state = true;
    if (!code_state) {
        reply_value = "请输入正确验证码";
        vcode.parentNode.style.border = '1px solid red';
        check_state = false;
    } else
        vcode.parentNode.style.border = '1px solid LightSteelBlue';

    if (!checkvcode(vcode.value)) {
        reply_value = '请输入正确验证码';
        vcode.parentNode.style.border = '1px solid red';
        check_state = false;
    }

    if (!checkpermit(userTelephone.value)) {
        userTelephone.parentNode.style.border = '1px solid red';
        reply_value = '请输入正确的手机号码';
        check_state = false;
    } else {
        userTelephone.parentNode.style.border = '1px solid LightSteelBlue';
    }

    if (password.value != rpassword.value) {
        reply_value = '两次输入的密码不相同';
        rpassword.parentNode.style.border = '1px solid red';
        check_state = false;
    } else {
        rpassword.parentNode.style.border = '1px solid LightSteelBlue';
    }

    if(!checkpassword(password.value)){
        reply_value = '密码格式不正确';
        password.parentNode.style.border = '1px solid red';
        check_state = false;
    }else{
        password.parentNode.style.border = '1px solid LightSteelBlue';
    }
    if(!tele_state){
        userTelephone.parentNode.style.border = '1px solid red';
        reply_value='手机号已被注册'
    }
    reply.innerHTML = reply_value;
    return check_state;
}

