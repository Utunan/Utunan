<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
    <h2><a href="/quiz1">提问</a></h2>
    <h2><a href="/displayQuizByQuizId?quizId=1">问题页面</a></h2>
    <form action="/searchQuiz" method="post">
        <input type="text" name="searchValue">
        <input type="submit" value="搜索">
    </form>
<%@include file="../common/footer.jsp"%>
</body>

<script src="/js/common.js"></script>
</html>
