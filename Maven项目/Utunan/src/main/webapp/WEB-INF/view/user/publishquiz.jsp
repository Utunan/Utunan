<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="plate" value="publishquiz"/>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>发表的问答</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/user/publishquiz.css">
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
                <span>发表的问答</span>
            </div>
            <nav id="publishpost" class="publishpost">
                <c:forEach items="${Quizzes }" var="Q">
                    <li>
                        <img src="/images/user/pqzq.svg"/>
                        <div class="posttop">
                            <span class="posttitle"><a href="/quiz/${Q.quizId }">${Q.quizTitle }</a></span>
                        </div>
                        <div class="postbottom">
                            <span>发表于 : <fmt:formatDate value="${Q.releaseTime }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                            ·<span>评论数 : ${Q.answerCount}</span>
                            ·<span>点赞数 : ${Q.praiseCount}</span>
                        </div>
                    </li>
                </c:forEach>
            </nav>
            <%@include file="common/page.jsp" %>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>
</body>
<script src="/js/user/usercommon.js"></script>
<script src="/js/common/common.js"></script>
</html>