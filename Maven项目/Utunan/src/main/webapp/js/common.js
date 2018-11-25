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