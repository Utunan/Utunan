* <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${User!=null}">
    <c:redirect url="/user"/>
</c:if>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/login.css">
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
</head>
<body>
<header>
    Action speak louder than words.
</header>
<div class="container background">
    <div class="wrapper center">
        <div class="textcase">
            <div class="logintext">
                <a href=""><img src="/images/logo.png" alt="" srcset=""></a>
            </div>
        </div>
        <div  class="reply" id="reply">${reply}</div>
        <form class="loginform" id="loginform" action="/login" method="post" onsubmit="return checkForm()">
            <div class="permit inputcase">
                <input type="text" name="permit" id="permit" value="${temppermit}" placeholder="您的手机/邮箱">
            </div>
            <div class="loginpassword inputcase">
                <input type="password" name="userPassword" id="password" placeholder="请输入密码">
            </div>
            <div class="loginbtn">
                <button type="submit" >提交</button>
            </div>
            <span><a href="">忘记密码</a> </span>
            <span><a href="register">立即注册</a> </span>
        </form>
        <div class="textcase">
            <div class="logintext welcome">
                <a href="">欢迎回来</a>
            </div>
        </div>
    </div>
    <footer>
        <div class="wrapper">
            <nav class="nav">
                <li><a href="">关于我们</a></li>
                <li><a href="">加入我们</a></li>
                <li><a href="">联系我们</a></li>
                <li><a href="">关注我们</a></li>
            </nav>
            <p>
                冀ICP备17013704号
                <br>
                disign by : <span style="color: blueviolet;">写BUG辛苦了</span>
            </p>
        </div>
    </footer>
</div>
</body>
<script src="/js/login.js"></script>
</html>