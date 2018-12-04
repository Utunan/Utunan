<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<h2><a href="/searchQuestion">题目搜索</a></h2>
<h2>
    <form action="/subject" method="post">
        <input type="hidden" value="${User.userId}" name="userId">
        <input type="submit" value="专项练习">
    </form>
</h2>
<%@include file="../common/footer.jsp"%>
</body>
<script src="/js/common/common.js"></script>
</html>
