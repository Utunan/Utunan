var searchtext = document.getElementById("searchtext");

var bnav = document.getElementById('bnav')
var bnavli=bnav.getElementsByTagName("li")

var navbutton = document.getElementById('navbutton')

var bnavtimer = false;
var timer;
var clicktimer = 0;

searchtext.onmouseover=function(){
    searchtext.style.backgroundColor='#fff'
}

navbutton.onclick = function () {
    bnav.style.display = 'block'
    for(var i=0;i<4;i++){
        bnavli[i].style.display='block'
    }
    bnav.style.height = bnav.offsetHeight
    if (clicktimer % 2 == 0) {
        clicktimer++;
        if ((parseInt(bnav.style.height) == 0)) {
            bnav.style.height = 0
            clicktimer++
            clearInterval(timer)
            timer = setInterval(function () {
                bnav.style.height = parseInt(bnav.style.height) + 5 + 'px';
                if (bnav.style.height == '200px') {
                    clearInterval(timer);
                }
            }, 1)
        }
    }
    if (clicktimer % 2 == 1) {
        clicktimer--;
        clearInterval(timer)
        timer = setInterval(function () {
            bnav.style.height = parseInt(bnav.style.height) -5 + 'px';
            if (bnav.style.height == '0px') {
                clearInterval(timer);
            }
        }, 1)

    }
}

window.onresize = function () {
    if (window.innerWidth >= 959) {
        bnav.style.height = 0;
        for(var i=0;i<bnavli.length;i++){
            bnavli[i].style.display=""
        } 
    }
}

var userbox =document.getElementById("userbox");
userbox.onmouseover=function(){
    userinfo.style.display="block";
}

userbox.onmouseout=function(){
    userinfo.style.display="none";
}
