<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="plate" value="settings"/>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎来到Utunan</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/user/usersettings.css">
    <link rel="stylesheet" href="/css/user/usercommon.css">
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
</head>

<body>
<%@include file="../common/header.jsp" %>
<%@include file="common/usercard.jsp"%>
<div class="container" style="margin-top: 30px;">
    <div class="wrapper background">
        <%@include file="common/userfunction.jsp"%>
        <div class="content">
            <div class="title">用户设置</div>
            <div class="changeinfo">
                <span>修改手机号</span>
                <form method="POST" action="changetelephone">
                    <div>
                        <label for="oldtelephone">原手机号</label>
                        <input type="hidden" value="15226569565" id="oldtelephone" />
                        <span>15226569565</span>
                    </div>
                    <div>
                        <label for="newtelephone">新手机号</label>
                        <input id="newtelephone" type="text">
                    </div>
                    <div>
                        <label for="telcode">验证码</label>
                        <input id="telcode" type="text">
                        <button>获取验证码</button>
                    </div>
                    <input type="submit" value="保存">
                </form>
            </div>
            <div class="changeinfo">
                <span>修改邮箱</span>
                <form method="POST" action="changetelephone">
                    <div>
                        <label for="oldemail">原邮箱</label>
                        <input type="hidden" value="15226569565" id="oldemail" />
                        <span>360321381@qq.com</span>
                    </div>
                    <div>
                        <label for="newemail">新邮箱</label>
                        <input type="hidden" id="newemail" />
                        <span>15226569565</span>
                    </div>
                    <div>
                        <label for="emailcode">验证码</label>
                        <input id="emailcode" type="text">
                        <button>获取验证码</button>
                    </div>
                    <input type="submit" value="保存">
                </form>
            </div>
            <div class="changeinfo">
                <span>修改密码</span>
                <form method="POST" action="changetelephone">
                    <div>
                        <label for="oldpassword">旧密码</label>
                        <input id="oldpassword" type="text">
                    </div>
                    <div>
                        <label for="newpassword">新密码</label>
                        <input id="newpassword" type="text">
                    </div>
                    <div>
                        <label for="repassword">确认密码</label>
                        <input id="repassword" type="text">
                    </div>
                    <input type="submit" value="保存">
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
<script src="/js/user/usercommon.js"></script>
<script src="/js/common/common.js"></script>
</html>