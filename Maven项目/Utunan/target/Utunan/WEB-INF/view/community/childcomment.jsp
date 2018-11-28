<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/11/25/025
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List,com.utunan.pojo.*"%>
<html>
<head>
    <title>子评论</title>
</head>
<body>
<table>
    <tr>
        <td>时间</td>
        <td>评论人</td>
        <td>内容</td>
        <td>点赞数</td>
    </tr>
    <c:forEach items="${childCommentList}" var="childcomment" >
        <tr>
            <td>${childcomment.commentTime}</td>
            <td>${childcomment.user.userNickName}</td>
            <td>${childcomment.commentContent}</td>
            <td>${childcomment.commentPraiseCount}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
