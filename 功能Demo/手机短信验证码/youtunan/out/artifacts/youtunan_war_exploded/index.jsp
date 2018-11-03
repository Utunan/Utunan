<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/10/30
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>this is my index page</title>
</head>
<script type="text/javascript" src="jquery-3.3.1.js " ></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(function(){
        $("#sendCode").removeAttr("disabled");//记得括号里，对应的是id
        //发送验证码
        $("#sendCode").click(function(){
            $.ajax({
                url:"code",//ajax提交表单
                data:{
                    "phoneNumber":$("#phoneNumber").val()
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
                        window.location.href="./index.jsp";
                    }
                    else{
                        alert("验证码错误");
                        window.location.href="./index.jsp";
                    }
                },
                error:function(){
                    alert("发送失败请重新发送");
                }

            });
        });
        //倒计时
        var wait=60;
        function time(obj){
            if(wait==0){
                $("#sendCode").removeAttr("disabled");
                $("#sendCode").val("重新获取");
                wait=60;
            }else{
                $("#sendCode").attr("disabled","true");
                $("#sendCode").val(wait+"s");
                wait--;
                setTimeout(function(){//倒计时的方法
                    time(obj);
                },1000);        //1s
            }
        }
    });
    });

</script>
<body>
<form >
    手机号: <input name="phoneNumber" id="phoneNumber"><br>
    验证码: <input type="text" name="code" id="code">
    <button type="button" id="sendCode" name="sendCode">发送验证码</button><br>
    <button type="button" id="login">登录</button>
</form>
</body>
</html>

