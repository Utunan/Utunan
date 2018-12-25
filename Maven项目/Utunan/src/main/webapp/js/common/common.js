currentpageli=document.getElementById("currentpage")

if(currentpageli!=null) {
    pagenums = document.getElementsByClassName("pagenum");
    for(var i=0;i<pagenums.length;i++){
        if($("#currentpage").val()==pagenums[i].firstChild.name){
            pagenums[i].style.backgroundColor= "rgba(0,188,155,1)";
            pagenums[i].firstChild.style.color = "#fff"
        }
    }
}

$('#userheadimg').mouseover(function(){
    $('#userheadop').css("display","block")
})
$('#userheadimg').mouseout(function(){
    $('#userheadop').css("display","none")
})
$('#userheadop').mouseover(function () {
    $('#userheadop').css("display","block")
})
$("#userheadop").mouseout(function (e) {
    evt = window.event || e;
    var obj = evt.toElement || evt.relatedTarget;
    var pa = this;
    if (pa.contains(obj))
        return false;
    else
        userheadop.style.display = "none";
})

postcontents=document.getElementsByClassName("postcontent");
for(var i=0;i<postcontents.length;i++){
    postcontents[i].innerHTML=(postcontents[i].innerHTML.substr(1,150)).replace(/[\r\n]/g,"")
}



if($('#messagecount').html()==""||$('#messagecount').html()<="0"){
    $('#messagecount').css('display',"none");
}
setInterval(function () {
    $.ajax({
        type: "post",
        url: "/user/usermessage",
        data:{"request":"messagecount"},
        success: function (data) {
            if(data=="0"){
                $('#messagecount').css('display',"none");
                $('#messagecount').html(0);
            }else{
                $('#messagecount').css('display',"block");
                $('#messagecount').html(data)
            }
        }
    });
}, 3000)