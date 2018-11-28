pagenums = document.getElementsByClassName("pagenum");
for (var i = 0; i < pagenums.length; i++) {
    if (pagenums[i].firstChild.name == pagenum) {
        pagenums[i].style.backgroundColor = "rgba(49, 126, 212, 0.2)";
        pagenums[i].firstChild.style.color = "#fff"
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