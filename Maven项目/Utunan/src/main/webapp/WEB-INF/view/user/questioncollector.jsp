<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="plate" value="questioncollector"/>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎来到Utunan</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/user/questioncollector.css">
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
                <span>题目收藏</span>
            </div>
            <nav id="questioncollector" class="questioncollector">
                <c:forEach items="${Questions }" var="Q">
                    <li>
                        <div class="questiontop">
                            <span><a href="">${Q.subject.subjectName}</a></span>--><span>${Q.chapterName}</span>
                        </div>
                        <p class="questioncontent">
                            ${Q.questionContent}
                        </p>
                        <div class="questionbottom">
                            <span><a href="/user/questioncollector/${Q.questionId}"><img src="/images/user/delete.svg"/></a><a href="/user/questioncollector/${Q.questionId}">取消收藏</a></span>
                            <span><a href="">查看详情</a></span>
                        </div>
                    </li>
                </c:forEach>
            </nav>
            <%@include file="common/page.jsp"%>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
<script src="/js/user/usercommon.js"></script>
<script src="/js/common/common.js"></script>
</html>