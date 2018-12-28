<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--弹窗登录表单--%>
<div class="modalDialogcontent">
    <div class="formcontent">
        <span class="close_modalDialogcontent">×</span>
        <div class="textcase">
            <div class="logintext">
                <%--<img src="/images/common/logo.png" alt="" srcset="">--%>
                优图南
            </div>
            <div class="wenhou">
                <a href="">登录优图南，开启你的考研之旅</a>
            </div>
        </div>
        <div class="reply"></div>
        <%--<div  class="reply" id="reply"></div>--%>
        <form class="loginform" id="loginform" onsubmit="return false" action="##" method="post">
            <div class="permit inputcase">
                <input type="text" name="permit" id="permit" value="${temppermit}" placeholder="手机号/邮箱">
            </div>
            <div class="loginpassword inputcase">
                <input type="password" name="userPassword" id="password" placeholder="密码（8-16位，由数字和字母组成）"/>
                <input type="text" id="login_showPwd" style="display: none"/>
            </div>
            <div class="loginbtn">
                <button id="submitbutton" type="submit">登&nbsp;&nbsp;录</button>
            </div>
            <span><a id="register" href="/register">立即注册</a> </span>
            <span><a id="forpasswork" href="/forgetpasework">忘记密码</a> </span> <%--还未实现该页面--%>
        </form>
    </div>
</div>
<script>
    /*点击小叉号然后关闭*/
    var close_modalDialogcontent=document.getElementsByClassName("close_modalDialogcontent")[0];
    close_modalDialogcontent.onclick=function(){
        mask.style.display="none";
        modalDialogcontent.style.display="none";
    };
</script>