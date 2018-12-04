<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/12/4
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>科目</td>
            <td>共有</td>
            <td>已做</td>
        </tr>
        <c:forEach items="${subject}" var="sub">
        <tr>
            <td>${sub.subject.subjectName}</td>
            <td>${sub.allQuestionNumber}</td>
            <td>${sub.resolveQuestionNumber}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
