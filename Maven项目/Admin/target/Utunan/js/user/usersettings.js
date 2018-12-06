oldtelephone = document.getElementById("oldtelephone");
newtelephone = document.getElementById("newtelephone");

oldemail = document.getElementById("oldemail");
newemail = document.getElementById("newemail");

oldpassword = document.getElementById("oldpassword");
newpassword = document.getElementById("newpassword");
repassword = document.getElementById("repassword");

gettelecode = document.getElementById("gettelecode");
getemailcode = document.getElementById("getemailcode");

oldtelephone = document.getElementById("oldtelephone");
newtelephone = document.getElementById("newtelephone");


telephonereply = document.getElementById("telephonereply");
emailreply = document.getElementById("emailreply");
passwordreply = document.getElementById("passwordreply");

var gctimer = null;
var egctimer=null;
var telissend = false;
var state = true;
var code_state = false;
var ecode_state=false;
var isregister = true;
var tele_state = true;

function checkvcode(value) {
    reg = /^\d{6}$/;
    if (reg.test(value))
        return true;
    return false;
}

function checkemail() {
    var rege = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    return rege.test(permit.value);
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

function checktele(telephone) {
    var re = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;
    return re.test(telephone);
}

function onchecktelephone() {
    issubmit = true;
    if (telissend == false) {
        telephonereplycon = "请先获取验证码";
        gettelecode.parentElement.children[1].style.border = '1px solid red';
        issubmit = false;
    } else {
        gettelecode.parentElement.children[1].style.border='1px solid LightSteelBlue';
    }
    if (newtelephone.value == "") {
        telephonereplycon = "手机号不能为空";
        newtelephone.style.border = '1px solid red';
        issubmit = false;
    }else{
        newtelephone.style.border ='1px solid LightSteelBlue';
    }
    telephonereply.innerHTML = telephonereplycon;
    return issubmit;
}

function oncheckemail() {
    emailreplycon="";
    state = true;
    if(checkemail(newemail.value)){
        newemail.style.border = '1px solid red';
        state=false;
        emailreplycon="邮箱格式错误"
    }else{
        newemail.style.border = '1px solid LightSteelBlue';
    }
    if (newemail.value == oldemail.value) {
        newemail.style.border = '1px solid red';
        state=false;
        emailreplycon="新老邮箱不能相同"
    } else {
        newemail.style.border = '1px solid LightSteelBlue';
    }
    emailreply.innerHTML(emailreplycon);
    return state;
}

function oncheckpassword() {

}
emlissend=false;
getemailcode.onclick=function(){
    if (newemail.value == oldemail.value) {
        newemail.style.border = '1px solid red';
    } else {
        newemail.style.border = '1px solid LightSteelBlue';
        if (emlissend == false) {
            emlissend = true;
            gitimer = 59;
            getemailcode.innerHTML = '60s后重新发送';
            var xmlhttp;
            if (window.XMLHttpRequest) {
                xmlhttp = new XMLHttpRequest();
            } else {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            //Ajax的操作
            xmlhttp.open("POST", "/emailcode", true);
            xmlhttp.send();
            //对返回信息进行验证
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var res = xmlhttp.responseText;
                    ecode_state = true;
                }
            }
            egctimer = setInterval(function () {
                getemailcode.innerHTML = gitimer + 's后重新发送';
                if (gitimer > 0) {
                    gitimer--;
                } else {
                    clearInterval(gctimer);
                    getemailcode.innerHTML = "获取验证码"
                    emlissend = false
                }
            }, 1000)
        } else {
            return false;
        }
    }
}

gettelecode.onclick = function () {
    if (newtelephone.value != oldtelephone.value) {
        if (checktele(newtelephone.value)) {
            var xmlhttp;
            if (window.XMLHttpRequest) {
                xmlhttp = new XMLHttpRequest();
            } else {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            //向后台发送验证信息
            xmlhttp.open("POST", "/checkpermit?permit=" + newtelephone.value, true);
            xmlhttp.send();


            //对返回信息进行验证
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var res = xmlhttp.responseText;
                    if (res == "successful") {
                        telephonereply.innerHTML = '手机号已被注册';
                        tele_state = false;
                        newtelephone.style.border = '1px solid red';
                    } else {
                        telephonereply.innerHTML = "";
                        state = true;
                        isregister = false;
                        newtelephone.style.border = '1px solid LightSteelBlue';
                    }
                }
            }

            setTimeout(function () {
                if (telissend == false && !isregister) {
                    telissend = true;
                    gitimer = 59;
                    gettelecode.innerHTML = '60s后重新发送';
                    //Ajax的操作
                    xmlhttp.open("POST", "/telecode?checknewtelephone=" + newtelephone.value, true);
                    xmlhttp.send();
                    //对返回信息进行验证
                    xmlhttp.onreadystatechange = function () {
                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                            var res = xmlhttp.responseText;
                            code_state = true;
                        }
                    }
                    gctimer = setInterval(function () {
                        gettelecode.innerHTML = gitimer + 's后重新发送';
                        if (gitimer > 0) {
                            gitimer--;
                        } else {
                            clearInterval(gctimer);
                            gettelecode.innerHTML = "获取验证码"
                            telissend = false
                        }
                    }, 1000)
                } else {
                    return false;
                }
            }, 500)
        } else {
            if (telissend == false) {
                telephonereply.innerHTML = '请输入正确的手机号码';
                newtelephone.style.outline = "1px solid red";
            } else {
                newtelephone.style.border = '1px solid LightSteelBlue';
            }
        }
    } else {
        telephonereply.innerHTML = "新手机号不能与原手机号相同"
    }
}
