<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2018/11/24
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List,com.utunan.pojo.*"%>
<html>
<head>
    <title>问题页面</title>
</head>
<body>
    问题：${quiz.quizTitle}<br/>
    用户：${quiz.user.userNickName}<br/>
    发表时间：${quiz.releaseTime}<br/>
    标签：
    <c:forEach items="${quizTagList}" var="quiztag">
        ${quiztag.tag.tagName} &nbsp;
    </c:forEach>
    <br/>
    内容：${quiz.quizContent}<br/>
    点赞数：${quiz.praiseCount}<br/>
    评论数：${commentCountByQuizId}<br/>
    评论有：
    <table>
        <tr>
            <td>评论楼层</td>
            <td>评论人</td>
            <td>评论时间</td>
            <td>考研年份</td>
            <td>所在院校</td>
            <td>目标院校</td>
            <td>评论内容</td>
            <td>点赞数</td>
            <td>子评论</td>
        </tr>
    <c:forEach items="${commentListByQuizId}" var="comment" varStatus="cou">
        <tr>
        <td>${cou.count}</td>
        <td>${comment.user.userNickName}</td>
        <td>${comment.commentTime}</td>
        <td>${comment.user.examTime}</td>
        <td>${comment.user.userSchool}</td>
        <td>${comment.user.dreamSchool}</td>
        <td>${comment.commentContent}</td>
        <td>${comment.commentPraiseCount}</td>
        <td>
        <%--<c:forEach items="${obj.tagList}" var="taglist">
            ${taglist.tagName}&nbsp;&nbsp;&nbsp;
        </c:forEach>--%>
            <a href="#">查看子评论</a>
        </td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
