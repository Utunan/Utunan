<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is my index page</title>
</head>
<script type="text/javascript" src="/js/jquery-3.3.1.js " ></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(function(){
            $("#getcode").removeAttr("disabled");//记得括号里，对应的是id
            //发送验证码
            $("#getcode").click(function(){
                $.ajax({
                    url:"code",//ajax提交表单
                    data:{
                        "userTelephone":$("#userTelephone").val()
                    },
                    type:"post",
                    async:true,
                    dataType:"text",
                    success:function(data){
                        if(data=='true'){
                            alert("验证码已发送");
                            time(this);
                        }else
                            alert("发送失败");
                    },
                    error:function(){
                        alert("error");
                    }
                });
            });

            //验证
            $("#login").click(function(){
                var code=$("#code");
                if(code.val()==''){
                    alert("验证码不能为空");
                    return;
                }
                $.ajax({
                    url:"login",
                    data:{
                        "code":$("#code").val()
                    },
                    type:"post",
                    async:true,
                    dataType:"text",
                    success:function(data){
                        if(data=='true'){
                            alert("成功!");
                        }
                        else{
                            alert("验证码错误");
                        }
                    },
                    error:function(){
                        alert("发送失败请重新发送");
                    }

                });
            });
            //倒计时
            var wait=60;
        });
    });

</script>
<body>
<form >
    手机号: <input name="userTelephone" id="userTelephone"><br>
    验证码: <input type="text" name="code" id="code">
    <input type="button" id="getcode" name="getcode" value="发送验证码"><br>
    <button type="button" id="login">登录</button>
</form>
</body>
</html>

