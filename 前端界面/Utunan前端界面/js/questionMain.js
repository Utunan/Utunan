var options = document.getElementsByClassName("menu-optionSet")[0].getElementsByTagName("li");
for (var i = 0; i < options.length; i++) {
    options[i].onclick = function () {
        for (var n = 0; n < options.length; n++) {
            options[n].className ="option";
        }
        this.className ="active";
    }
}
  
var ask=document.getElementsByClassName("ask")[0];
var mask=document.getElementsByClassName("mask")[0];
var modalDialogcontent=document.getElementsByClassName("modalDialogcontent")[0];
ask.onclick=function(){
    mask.style.display="block";
    modalDialogcontent.style.display="block";
};
var close_modalDialogcontent=document.getElementsByClassName("close_modalDialogcontent")[0];
close_modalDialogcontent.onclick=function(){
    mask.style.display="none";
    modalDialogcontent.style.display="none";
};

