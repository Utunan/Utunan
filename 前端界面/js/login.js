﻿permit = document.getElementById('permit');
password = document.getElementById('password');
reply = document.getElementById('reply');

state = false;

function checkpermit() {
    var regt = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;
    var rege = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
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
                        reply.innerHTML = '通行证不存在,请先<a href="register">注册</a>';
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

    if (password.value == '' || permit.value == '') {
        reply.innerHTML = '通行证或密码不能为空';
        if (password.value == '') {
            password.parentNode.style.border = '1px solid red';
        }
        if (permit.value == '') {
            permit.parentNode.style.border = '1px solid red';
        }
        state = false;
    }

    if (checkpermit()) {
        reply.innerHTML = '请使用手机号或邮箱登录'
        permit.parentNode.style.border = '1px solid red';
        state = false;
    }
    return state;
}