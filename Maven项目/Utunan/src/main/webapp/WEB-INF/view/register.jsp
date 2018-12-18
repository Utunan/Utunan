<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>快来加入我们吧~</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/register.css">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <script src="/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="container background">
    <div class="center">

        <form id="registerform" class="registerform" action="/register" method="post" onsubmit="return checkForm()">
            <div class="reply" id="telereply">${reply}</div>
            <!--    手机号  -->
            <div class="permit inputcase">
                <input type="text" name="userTelephone" id="userTelephone" placeholder="请输入手机号">
            </div>
            <div class="reply" id="codereply"></div>
            <!--    验证码  -->
            <div class="permit inputcase">
                <input id="code" type="text" name="code" id="vcode" placeholder="请输入验证码">
                <button id="getcode" class="getcode" type="button">获取验证码</button>
            </div>
            <div class="reply" id="passreply"></div>
            <!--    密码    -->
            <div class="registerpassword inputcase">
                <input type="password" name="userPassword" id="password" placeholder="密码(8-16位,由数字和字母组成)">
            </div>
            <div class="reply" id="repassreply"></div>
            <!--    确认密码    -->
            <div class="registerrpassword inputcase">
                <input type="password" name="rpassword" id="rpassword" placeholder="确认密码">
            </div>

            <!--    提交密码    -->
            <div class="registerbtn">
                <button type="submit">提交</button>
            </div>
            <span><a href="">忘记密码</a> </span>
            <span><a href="/login">立即登陆</a> </span>
        </form>
    </div>
</div>

</body>

<script>
    function checkvcode(value) {
        reg = /^\d{6}$/;
        if (reg.test(value))
            return true;
        return false;
    }

    function checkpassword(value) {
        var regu = "^[0-9a-zA-Z]{8,16}$";
        var re = new RegExp(regu);
        if (re.test(value)) {
            return true;
        } else {
            return false;
        }
    }

    function checkpermit(value) {
        var re = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;
        return re.test(value);
    }

    function checkForm() {
        return false;
    }

    $('#userTelephone').focus(function () {
        if (!checkpermit($(this).val())) {
            $(this).val("")
        }
    })
    $('#password').focus(function () {
        if (!checkpassword($(this).val())) {
            $(this).val("")
        }
    })
    $('#code').focus(function () {
        if (!checkvcode($(this).val())) {
            $(this).val("")
        }
    })

    $('#userTelephone').blur(function(){
        var state = true;
        var reply = ""
        if(!checkpermit($(this).val())){
            $(this).css('backgroundColor','rgba(255,192,203,1)');
            reply="手机号格式错误"
            state=false
        }else{
            $(this).css('backgroundColor','white');
            reply=""
            state=false
        }
        $('#telereply').html(reply)
        return state;
    })


    $('#password').blur(function(){
        
    })
    $('#repassword').blur(function () {

    })
    $('#code').blur(function(){

    })
    //是否获取验证码
    var register_state=true

    //是否获取验证码
    var have_code=false



</script>
</html>