currentpageli=document.getElementById("currentpage")

if(currentpageli!=null) {
    currentpage = currentpageli.value;
    pagenums = document.getElementsByClassName("pagenum");
    for(var i=0;i<pagenums.length;i++){
        if(currentpage==pagenums[i].firstChild.name){
            pagenums[i].style.backgroundColor= "rgba(0,188,155,0.2)";
            pagenums[i].firstChild.style.color = "#fff"
        }
    }
}


userheadimg = document.getElementById("userheadimg");
userheadop = document.getElementById("userheadop");

userheadimg.onmouseover = function () {
    userheadop.style.display = 'block';
}


userheadop.onmouseout = function (e) {
    evt = window.event || e;
    var obj = evt.toElement || evt.relatedTarget;
    var pa = this;
    if (pa.contains(obj))
        return false;
    else
        userheadop.style.display = "none";
}

postcontents=document.getElementsByClassName("postcontent");
for(var i=0;i<postcontents.length;i++){
    postcontents[i].innerHTML=(postcontents[i].innerHTML.substr(1,150)).replace(/[\r\n]/g,"")
}