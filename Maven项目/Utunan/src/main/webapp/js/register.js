permit = document.getElementById("permit");
vcode = document.getElementById("vcode");
getcode = document.getElementById("getcode");
password = document.getElementById("password");
rpassword = document.getElementById("rpassword");

var gctimer = null;
var issend = false;
var gitimer;
var ispermit = false;
var state=true;



function checkpermit(telephone) {
    var re = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;
    return re.test(telephone);
}

function CheckForm(){

}


permit.onblur = function () {
    if (!checkpermit(permit.value)&&(issend==false)) {
        permit.parentNode.style.border = '1px solid red';
        reply.innerHTML = '手机号填写错误'
    } else {
        permit.parentNode.style.border = '1px solid LightSteelBlue';
        reply.innerHTML = ''
    }
}

getcode.onclick = function () {
    if (checkpermit(permit.value)) {
        reply.innerHTML = ''
        var xmlhttp;
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        } else {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //Ajax的操作

        if (issend == false) {
            issend = true;
            gitimer = 60;
            getcode.innerHTML = '60s后重新发送';
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
    } else {
        if (issend == false)
            reply.innerHTML = '手机号格式错误';
    }
}

