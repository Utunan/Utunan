<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title></title>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/login.css">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <script src="/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<%@include file="common/header.jsp" %>
<div class="container background">
    <div class="center" id="center">
        <div class="platename">登录</div>
        <form class="loginform" id="loginform" action="/login" method="post" onsubmit="return checkForm()">
            <div class="reply" id="permitreply">${reply}</div>
            <div class="permit inputcase">
                <input type="text" name="permit" id="permit" value="${temppermit}" placeholder="手机号/邮箱">
            </div>
            <div class="reply" id="passwordreply"></div>
            <div class="loginpassword inputcase">
                <input type="password" name="userPassword" id="password" placeholder="(8-16位),由数字和字母组成">
            </div>
            <div class="loginbtn">
                <button id="loginsubmit" type="submit">提交</button>
            </div>
            <span><a href="">忘记密码</a> </span>
            <span><a href="/register">立即注册</a> </span>
        </form>
    </div>
</div>
</body>
<script>
    function checkpermit(value) {
        var regt = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/;
        var rege = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        return (!regt.test(value)) && (!rege.test(value));
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

    function permitcheck() {
        var state = true;
        var reply = ""

        if (checkpermit($('#permit').val())) {
            state = false;
            reply = "通行证格式错误"
        }
        if ($('#permit').val() == '') {
            state = false;
            reply = "通行证不能为空"
        }

        if (state) {
            $('#permit').css('backgroundColor', 'white')
            $('#permitreply').html("")
            return true
        }
        else {
            $('#permit').css('backgroundColor', 'rgba(255,192,203,1)')
            $('#permitreply').html(reply)
            return false
        }
    }

    function passwordcheck() {
        var state = true;
        var reply = ""

        if (!checkpassword($('#password').val())) {
            state = false;
            reply = "密码格式错误"
        }
        if ($('#password').val() == '') {
            state = false;
            reply = "密码不能为空"
        }
        if (state) {
            $('#password').css('backgroundColor', 'white')
            $('#passwordreply').html("")
            return true
        }
        else {
            $('#password').css('backgroundColor', 'rgba(255,192,203,1)')
            $('#passwordreply').html(reply)
            return false
        }
    }

    function checkForm() {
        var passstate = passwordcheck()
        var perstate = permitcheck()

        if (passstate && perstate)
            return true
        else
            return false
    }

    $('#permit').focus(function () {
        if (checkpermit($('#permit').val())) {
            $('#permit').val("")
        }
    })

    $('#permit').blur(function () {
        $.ajax({
            type: "post",
            url: "/checkpermit",
            data: {
                userTelephone: $("#permit").val(),
                userEmail: $("#permit").val()
            },
            dataType: "json",
            success: function (data) {
                if (data == '200') {
                    $('#permitreply').html("")
                    var state = true;
                    var reply = ""

                    if (checkpermit($('#permit').val())) {
                        state = false;
                        reply = "通行证格式错误"
                    }
                    if ($('#permit').val() == '') {
                        state = false;
                        reply = "通行证不能为空"
                    }

                    if (state) {
                        $('#permit').css('backgroundColor', 'white')
                        $('#permitreply').html("")
                        return true
                    }
                    else {
                        $('#permit').css('backgroundColor', 'rgba(255,192,203,1)')
                        $('#permitreply').html(reply)
                        return false
                    }
                } else {
                    $('#permitreply').html("通行证不存在,请先<a href='/register'>注册</a>")
                }
            },error:function(){
                $('#permitreply').html("网站可能崩了,请您先等会儿~")
            }
        });

    })

    $('#password').focus(function () {
        if (!checkpassword($('#password').val())) {
            $('#password').val("")
        }
    })
    $('#password').blur(passwordcheck)

</script>
</html>