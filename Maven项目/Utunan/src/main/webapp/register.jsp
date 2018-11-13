<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>快来加入我们吧~</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/register.css">
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
</head>
<body>
<header>
    Come and join us.
</header>
<div class="container background">
    <div class="wrapper center">
        <div class="textcase">
            <div class="registertext">
                <a href=""><img src="images/logo.png" alt="" srcset=""></a>
            </div>
        </div>
        <div class="reply" id="reply"></div>
        <form id="registerform" class="registerform" action="/register" method="post" omsubmit='return checkForm()'>

            <!--    手机号  -->
            <div class="permit inputcase">
                <input type="text" name="userTelephone" id="userTelephone" placeholder="请输入手机号">
            </div>

            <!--    验证码  -->
            <div class="permit inputcase">
                <input id="code" type="text" name="code" id="vcode" placeholder="请输入验证码">
                <button id="getcode" class="getcode" type="button">获取验证码</button>
            </div>

            <!--    密码    -->
            <div class="registerpassword inputcase">
                <input type="password" name="userPassword" id="password" placeholder="密码">
            </div>

            <!--    确认密码    -->
            <div class="registerrpassword inputcase">
                <input type="password" name="rpassword" id="rpassword" placeholder="确认密码">
            </div>

            <!--    提交密码    -->
            <div class="registerbtn">
                <button type="submit">提交</button>
            </div>
            <span><a href="">忘记密码</a> </span>
            <span><a href="">立即注册</a> </span>
        </form>
        <div class="textcase">
            <div class="registertext welcome">
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

<script src="/js/register.js"></script>

</html>