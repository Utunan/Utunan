<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="plate" value="follow"/>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>关注用户</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/user/follow.css">
    <link rel="stylesheet" href="/css/user/usercommon.css">
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
</head>

<body>
<%@include file="../common/header.jsp" %>
<%@include file="common/usercard.jsp" %>
<div class="container" style="margin-top: 30px;">
    <div class="wrapper background">
        <%@include file="common/userfunction.jsp" %>
        <div class="content" id="content">
            <div class="title">
                <span>特别关注</span>
            </div>
            <nav id="followuser">
                <c:forEach items="${FollowUsers }" var="u">
                    <li>
                        <div class="headimg">
                            <a href="/member/${u.userId}"><img src="${u.userHeadImg}"></a>
                        </div>
                        <div class="followinfo">
                            <a href="/member/${u.userId}">${u.userNickName }</a>
                            <span>考研年份 : ${u.examTime } 年</span>
                            <span>目标院系&emsp;${u.dreamSchool }</span>
                            <span>所在院校&emsp;${u.userSchool }</span>
                        </div>
                        <div class="nofollow">
                            <a _href="${u.userId }">取消关注</a>
                        </div>
                    </li>
                </c:forEach>
            </nav>
            <script>
                if($('#followuser li').length==0){
                    $('#followuser').remove()
                }
                $('.nofollow a').click(function () {
                    followId=$(this).attr("_href")
                    followa=$(this)
                    console.log(followId)
                    $.ajax({
                        type: "get",
                        url: "/user/cancel",
                        data: {"followedId": followId},
                        dataType: "json",
                        success: function (data) {
                           if(data['state']='success'){
                               followa.parent().parent().fadeOut()

                           }
                        }
                    })

                })
            </script>
            <%@ include file="common/page.jsp" %>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>
</body>
<script src="/js/user/usercommon.js"></script>
<script src="/js/common/common.js"></script>
</html>