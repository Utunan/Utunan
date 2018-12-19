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
        <div class="platename">注册</div>
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

        reg = /^\d{6}$/

        if (reg.test(value))
            return true
        return false;
    }

    function checkpassword(value) {

        var regu = "^[0-9a-zA-Z]{8,16}$"
        var re = new RegExp(regu);

        if (re.test(value))
            return true
        else
            return false
    }

    function checkpermit(value) {

        var re = /^0?1[3|4|5|6|7|8][0-9]\d{8}$/
        return re.test(value);

    }


    $('#userTelephone').focus(function () {

        if (!checkpermit($(this).val()))
            $(this).val("")

    })

    $('#password').focus(function () {

        if (!checkpassword($(this).val()))
            $(this).val("")

    })

    $('#code').focus(function () {

        if (!checkvcode($(this).val()))
            $(this).val("")

    })

    function checktel() {
        var state = true
        var reply = ""
        if (!checkpermit($('#userTelephone').val())) {
            $('#userTelephone').css('backgroundColor', 'rgba(255,192,203,1)');
            if ($('#userTelephone').val() == "")
                reply = "手机号不能为空"
            else
                reply = "手机号格式错误"
            state = false
        } else {
            $.ajax({
                type: "post",
                url: "/checkpermit",
                data: {
                    userTelephone: $("#userTelephone").val()
                },
                async: false,
                dataType: "json",
                success: function (data) {
                    if (data == '200') {
                        reply = "手机号已存在,请<a href='/login'>登陆</a>"
                        $('#userTelephone').css('backgroundColor', 'rgba(255,192,203,1)');
                        state = false
                    } else {
                        reply = ""
                        $('#userTelephone').css('backgroundColor', 'rgba(255,255,255,1)');
                    }
                }, error: function () {
                    reply = "网站可能崩了,请您先等会儿~"
                }
            });
        }
        $('#telereply').html(reply)
        return state;
    }

    $('#userTelephone').blur(checktel)

    function checkpass() {
        var state = true
        var reply = ""
        if (!checkpassword($('#password').val())) {
            $('#password').css('backgroundColor', 'rgba(255,192,203,1)');
            if ($('#password').val() == "") {
                reply = "密码不能为空"
            }
            else {
                reply = "密码格式错误"
            }
            state = false
        } else {
            $('#password').css('backgroundColor', 'white')
            reply = ""
        }
        $('#passreply').html(reply)
        return state
    }

    $('#password').blur(checkpass)

    function checkrpass() {
        var state = true
        var reply = ""
        if ($('#rpassword').val() != $('#password').val()) {
            $('#rpassword').css('backgroundColor', 'rgba(255,192,203,1)');
            reply = "两次输入的密码不一样"
            state = false
        } else {
            $('#rpassword').css('backgroundColor', 'white')
            reply = ""
        }
        $('#repassreply').html(reply)
        return state;
    }

    $('#rpassword').blur(checkrpass)

    //是否获取验证码
    var have_code = false

    $('#code').blur(function () {
        var state = true
        var reply = ""
        if (!checkvcode($(this).val())) {
            $(this).css('backgroundColor', 'rgba(255,192,203,1)')
            reply = "验证码格式错误"
            state = false

        } else {
            $(this).css('backgroundColor', 'white')
            reply = ""
        }
        if (!have_code) {
            reply = "请先获取验证码"
            $(this).css('backgroundColor', 'rgba(255,192,203,1)')
            state = false
        } else {
            $(this).css('backgroundColor', 'white')
            reply = ""
        }
        $("#codereply").html(reply)
        return state;
    })


    var time = 59;
    var isgetcode = false;
    var codestate = false;
    $('#getcode').click(
        function () {
            if (checkpermit($('#userTelephone').val())) {

                $.ajax({
                    type: "post",
                    url: "/checkpermit",
                    data: {
                        userTelephone: $("#userTelephone").val()
                    },
                    async: false,
                    success: function (data) {
                        if (data == '200') {
                            $('#telereply').html("手机号已存在,请<a href='/login'>登陆</a>")
                        } else {
                            isgetcode = true;
                            have_code = true
                            $('#telereply').html("")
                            if (codestate == false) {
                                time = 59
                                $.ajax(
                                    {
                                        type: "post",
                                        url: "/code",
                                        data: {
                                            userTelephone: $("#userTelephone").val()
                                        },
                                        success: function (data) {
                                            response = data
                                            codestate = true
                                            $('#getcode').html("60s后重新发送")
                                            if (response == 'success') {
                                                SI = setInterval(function () {
                                                    html = time + "s后重新发送"
                                                    $('#getcode').html(html)
                                                    time--;
                                                    if (time == 0) {
                                                        $('#getcode').html("获取验证码")
                                                        clearInterval(SI);
                                                        codestate = false;
                                                    }
                                                }, 1000)
                                            }
                                        },
                                        error: function (data) {
                                            response = data.responseText
                                            codestate = true
                                            $('#getcode').html("60s后重新发送")
                                            if (response == 'success') {
                                                SI = setInterval(function () {
                                                    html = time + "s后重新发送"
                                                    $('#getcode').html(html)
                                                    time--;
                                                    if (time == 0) {
                                                        $('#getcode').html("获取验证码")
                                                        clearInterval(SI);
                                                        codestate = false;
                                                    }
                                                }, 1000)
                                            }
                                        }
                                    }
                                );
                            }
                        }
                    }, error: function () {
                        $('#telereply').html("网站可能崩了,请您先等会儿~")
                    }
                });


            } else {
                $('#telereply').html("请输入正确的手机号")
                $('#userTelephone').css('backgroundColor', 'rgba(255,192,203,1)')
            }
        }
    )

    function checkForm() {
        state = true;
        if (!checktel()) {
            state = false;
            console.log(1)
        }
        if (checktel())
            if (!have_code) {
                $("#code").css('backgroundColor', 'rgba(255,192,203,1)')
                $('#codereply').html("请填写验证码")
                state = false
                console.log(2)
            }
        if (!checkvcode($('#code').val())) {
            state = false;
            console.log(3)
        }
        if (!checkpass()) {
            state = false;
            console.log(4)
        }
        if (!checkpass()) {
            state = false;
            console.log(5)
        }
        return state
    }
</script>
</html>