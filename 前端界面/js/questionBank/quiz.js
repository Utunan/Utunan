var options = document.getElementsByTagName("li");
var contentDisplay=document.getElementsByClassName("content-display")[0];
var optionsContent=contentDisplay.childNodes;
console.log(optionsContent);

for (var i = 0; i < options.length; i++) {
    options[i].index=i;
    options[i].onclick = function () {
        for (var n = 0; n < options.length; n++) {
            options[n].className ="option";
            optionsContent[n].className="option-content";
        }
        this.className ="active";
        optionsContent[this.index+1].className="active-content"
    }
}

var  array= new Array("#8063b2","#00baad","#ff8571","#f1819c","#ffc979","#4e99ec");
var subjectPlates=document.getElementsByClassName("subject-plate");
for(var i=0;i<subjectPlates.length;i++){
    subjectPlates[i].style.borderColor=array[i];
    var a=subjectPlates[i].getElementsByTagName("a")[0];
    a.style.color=array[i];
}


