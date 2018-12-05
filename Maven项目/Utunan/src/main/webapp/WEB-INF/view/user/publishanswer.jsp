<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="plate" value="publishanswer"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                        <div class="replytop">
                            <div class="replytype">${A.quiz.tags[0].tagName==null?"Utunan":A.quiz.tags[0].tagName}</div>
                            <div class="replytitle"><a href="">${A.quiz.quizTitle}</a></div>
                            <div class="replydetails"><a href="">>>详情</a></div>
                        </div>
                        <div class="replycontent">
                            <div class="replypraise">赞(${A.quiz.praiseCount})</div>
                            <div class="newreply">
                                <a href="">${A.answerContent}</a>
                            </div>
                            <div class="replytime"><fmt:formatDate value="${A.answerTime }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></div>
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