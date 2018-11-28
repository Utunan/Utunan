<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎来到Utunan</title>
    <style>
        #info {
            width: 100%;
            height: 700px;
            line-height: 700px;
            text-align: center;
            font-size:35px;
            color:#6610f2;
        }
    </style>
</head>
<body>
    <div id="info">请等待3秒钟,谢谢~</div>
</body>
<script>
    info=document.getElementById("info")
    timer=2;
    setInterval(function(){
        info.innerHTML="请等待"+timer+"秒钟,谢谢~";
        timer--;
        if(timer<0)
            timer=0
    },1000)
    setTimeout(function(){
        window.location.href = "/homepage"
    },3000);
</script>
</html>
