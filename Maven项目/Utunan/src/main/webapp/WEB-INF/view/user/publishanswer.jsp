<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="plate" value="publishanswer"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎来到Utunan</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/user/publishanswer.css">
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
            <div class="title">
                <span>发表的回复</span>
            </div>
            <nav id="publishreply" class="publishreply">
                <c:forEach items="${Answers}" var="A">
                    <li>
                        <img src="/images/user/pans.svg"/>
                        <div class="posttop">
                            <span class="posttitle"><a href="">${A.quiz.quizTitle }</a></span>
                        </div>
                        <div class="postreply">
                            <span>您回复了 : <a href="">${A.answerContent}</a></span></div>
                        <div class="postbottom">
                            <span>回复于 : <fmt:formatDate value="${A.answerTime }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                            ·<span>点赞数 : ${A.praiseCount}</span>
                            <span><a href="">删除</a></span>
                        </div>
                    </li>
                </c:forEach>
            </nav>
            <%@include file="common/page.jsp"%>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>
</body>
<script src="/js/user/usercommon.js"></script>
<script src="/js/common/common.js"></script>
</html>