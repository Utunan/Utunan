/**
 * Created by BYM on 2016/8/29.
 */
var second = 0;
window.setInterval(function () {
    second ++;
}, 1000);
var tjArr = localStorage.getItem("jsArr") ? localStorage.getItem("jsArr") : '[{}]';
$.cookie('tjRefer', getReferrer() ,{expires:1,path:'/'});
var tjRefer=$.cookie('tjRefer')
// console.log($.cookie('tjRefer'));
// console.log(tjRefer);
window.onbeforeunload = function() {
    // console.log(tjRefer);
    if(tjRefer == ''){
        var tjT = eval('(' + localStorage.getItem("jsArr") + ')');
        if(tjT){
            tjT[tjT.length-1].time += second;
            var jsArr= JSON.stringify(tjT);
            localStorage.setItem("jsArr", jsArr);
        }
    } else {
        var tjArr = localStorage.getItem("jsArr") ? localStorage.getItem("jsArr") : '[{}]';
        var dataArr = {
            'url' : location.href,
            'time' : second,
            'refer' : getReferrer(),
            'search' : location.hash
            // 'timeIn' : Date.parse(new Date()),
            // 'timeOut' : Date.parse(new Date()) + (second * 1000)
        };
        tjArr = eval('(' + tjArr + ')');
        tjArr = dataArr;
        tjArr= JSON.stringify(tjArr);
        localStorage.setItem("jsArr", tjArr);
    }

    $.ajax({
        url:'/schoolLog',//处理数据的地址
        type:'post',//数据提交形式
        data:{
            'pathname' :location.pathname,
            'time' : second
        },
        dataType: "json",
    });
};
function getReferrer() {
    var referrer = '';
    try {
        referrer = window.top.document.referrer;
    } catch(e) {
        if(window.parent) {
            try {
                referrer = window.parent.document.referrer;
            } catch(e2) {
                referrer = '';
            }
        }
    }
    if(referrer === '') {
        referrer = document.referrer;
    }
    return referrer;
}