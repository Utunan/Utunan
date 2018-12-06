<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="plate" value="publishquiz"/>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎来到Utunan</title>
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
        <div class="content">
            <div class="title">
                <span>发表的帖子</span>
            </div>
            <nav id="publishpost" class="publishpost">
                <c:forEach items="${Quizzes }" var="Q">
                    <li>
                        <div>
                        <span class="publishtime">
                                <fmt:formatDate value="${Q.releaseTime }" type="date" pattern="yyyy-MM-dd"/>
                        </span>
                            <span class="posttitle">${Q.quizTitle }</span>
                            <span class="publishtype">${Q.tags[0]==null?"Utunan":Q.tags[0].tagName}</span>
                        </div>
                        <p class="postcontent">${Q.quizContent }</p>
                        <span>评论数(${Q.answerCount })</span>
                        <span><a href="">>>详细</a></span>
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