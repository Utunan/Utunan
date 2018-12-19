<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date1: 2018/12/4
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>好题尽在优图南</title>
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<div>
    <span>&nbsp;</span>
    <span>&nbsp;</span>
    <form action="/searchresult" method="post">
        <input type="text" name="keyWord" placeholder="在${totleQuestion}道题目中搜索">
        <input type="submit" value="好题尽在优图南">
    </form>
</div>
<div>
    <table>
        <tr>
            <td>科目</td>
            <td>描述</td>
            <td>共有</td>
            <td>已做</td>
        </tr>
        <c:forEach items="${subject}" var="sub">
        <tr>
            <td><a href="/subject?subjectName=${sub.subject.subjectName}" >${sub.subject.subjectName}</a></td>
            <td>${sub.subject.discription}</td>
            <td>${sub.allQuestionNumber}</td>
            <td>${sub.resolveQuestionNumber}</td>
        </tr>
        </c:forEach>
    </table>
</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>
