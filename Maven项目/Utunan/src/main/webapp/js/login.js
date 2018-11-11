permit = document.getElementById('permit');
password = document.getElementById('password');
reply = document.getElementById('reply');

permit.onblur = function () {
    if (permit.value == '') {
        permit.parentNode.style.border = '1px solid red';
        permit.focus();
        reply.innerHTML = '通行证或密码不能为空'
    } else {
        permit.parentNode.style.border = '1px solid LightSteelBlue';
        reply.innerHTML = ''
        var permitvalue = this.value;
        var xmlhttp;
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        } else {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.open("POST", "/checkpermit?permit=" + permitvalue, true);
        //一顿贼骚气的操作之后,判断用户名是否重复了.

        //Ajax返回的信息


    }
}

password.onblur = function () {
    if (password.value == '') {
        password.parentNode.style.border = '1px solid red';
        password.focus();
        reply.innerHTML = '通行证或密码不能为空';
    } else {
        reply.innerHTML = '';
        password.parentNode.style.border = '1px solid LightSteelBlue';
    }
}



function checkpermit() {
    var regt = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;
    var rege = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
    return (!regt.test(permit.value)) && (!rege.test(permit.value));
}


function checkForm() {
    if (password.value == '' || permit.value == '') {
        reply.innerHTML = '通行证或密码不能为空'
        if (password.value == '') {
            password.focus();
            password.parentNode.style.border = '1px solid red';
        }
        if (permit.value == '') {
            permit.focus();
            permit.parentNode.style.border = '1px solid red';
        }
        return false;
    }

    if (checkpermit()) {
        permit.focus();
        reply.innerHTML = '请使用手机号或邮箱登录'
        return false;
    }


    if (password.value.length < 8 || password.value.length > 16) {
        password.focus();
        reply.innerHTML = '密码格式错误';
        password.parentNode.style.border = '1px solid red';
        password.value = ''
        password.focus();
        return false;
    }
    return true;
}