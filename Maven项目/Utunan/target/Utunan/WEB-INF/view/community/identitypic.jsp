<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/11/26/026
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论验证码</title>
    <script type="text/javascript">
        function reloadImage(){
            document.getElementById('btn').disable=true;
            document.getElementById('identity').src='/getIdentityPic?time='
                +new Date().getTime();
        }
    </script>
</head>
<body>
<form action="/judgePicCode" method="post">
    <img src="/getIdentityPic" id="identity" onload="btn.disabled= false;">
    <input type="button" value="换个图片" onclick="reloadImage()" id="btn">
    <input type="text" name="userinput"/>
    <input type="submit">
</form>

</body>
</html>
