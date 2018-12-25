<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="plate" value="settings"/>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>个人设置</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/user/usersettings.css">
    <link rel="stylesheet" href="/css/user/usercommon.css">
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
</head>
<c:choose>
    <c:when test="${passwordreply==null}">
    </c:when>
    <c:otherwise>
        <script>window.location.href="#changepassword"</script>
    </c:otherwise>
</c:choose>
<body>
<%@include file="../common/header.jsp" %>
<%@include file="common/usercard.jsp"%>
<div class="container" style="margin-top: 30px;">
    <div class="wrapper background">
        <%@include file="common/userfunction.jsp"%>
        <div class="content" id="content">
            <div class="title">用户设置</div>
            <div class="changeinfo">
                <div id><span>修改手机号</span></div>
                <form method="POST" action="/user/changetelephone" onsubmit="return onchecktelephone()">
                    <div><span id="telephonereply">${telephonereply}</span></div>
                    <div>
                        <label for="oldtelephone">原手机号</label>
                        <input type="hidden" value="${User.userTelephone}" id="oldtelephone" />
                        <span>${User.userTelephone}</span>
                    </div>
                    <div>
                        <label for="newtelephone">新手机号</label>
                        <input name="newtelephone" id="newtelephone" value="${pretelephonere}" type="text">
                    </div>
                    <div>
                        <label for="telecode">验证码</label>
                        <input name="telecode" id="telecode" type="text">
                        <button type="button" id="gettelecode">获取验证码</button>
                    </div>
                    <input type="submit" value="保存">
                </form>
            </div>
            <div class="changeinfo" id="changeemail">
                <div><span>修改邮箱</span></div>
                <form method="POST" action="/user/changeemail" onsubmit="return oncheckemail()">
                    <div><span id="emailreply">${emailreply}</span></div>
                    <div>
                        <label for="oldemail">原邮箱</label>
                        <input name="oldemail" type="hidden" value="${User.userEmail}" id="oldemail" />
                        <span>${User.userEmail==null?"用户未设置邮箱":User.userEmail}</span>
                    </div>
                    <div>
                        <label for="newemail">新邮箱</label>
                        <input name="newemail" type="text" id="newemail" />
                    </div>
                    <div>
                        <label for="emailcode">验证码</label>
                        <input name="emailcode" id="emailcode" type="text">
                        <button type="button" id="getemailcode">获取验证码</button>
                    </div>
                    <input type="submit" value="保存">
                </form>
            </div>
            <div class="changeinfo" id="changepassword">
                <div><span>修改密码</span></div>
                <form method="POST" action="/user/changepassword" onsubmit="return oncheckpassword()">
                    <div><span id="passwordreply">${passwordreply}</span></div>
                    <div>
                        <label for="oldpassword">旧密码</label>
                        <input name="oldpassword" id="oldpassword" type="text">
                    </div>
                    <div>
                        <label for="newpassword">新密码</label>
                        <input type="password" name="newpassword" id="newpassword" type="text">
                    </div>
                    <div>
                        <label for="repassword">确认密码</label>
                        <input type="password" name="repassword" id="repassword" type="text">
                    </div>
                    <input type="submit" value="保存">
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
<script src="/js/user/usersettings.js"></script>
<script src="/js/user/usercommon.js"></script>
<script src="/js/common/common.js"></script>
</html>