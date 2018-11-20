<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/11/19
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List,com.utunan.pojo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>问答列表</title>
</head>
<body>
    <div>
        <h1><a href="quiz1">时间</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="quiz2">热度</a></h1>
    </div>
    <table>
        <tr>
            <td>序号</td>
            <td>用户</td>
            <td>标题</td>
            <td>内容</td>
            <td>时间</td>
            <td>点赞</td>
        </tr>
        <c:forEach items="${page.list}" var="quizs">
            <tr>
                <td>${quizs.quizId}</td>
                <td>${quizs.user.userNickName}</td>
                <td>${quizs.quizTitle}</td>
                <td>${quizs.quizContent}</td>
                <td>${quizs.releaseTime}</td>
                <td>${quizs.praiseCount}</td>
            </tr>
        </c:forEach>
    <table/>
    <div style="width: 300px; height: 20px;">
        <h4>共有${page.totalCount }条数据，一共${page.totalPageNum }页</h4>
        <h4>这是第${page.currentPageNum }页</h4>
        <a href="quiz?pageNum=1">首页</a>&nbsp;&nbsp;
        <a href="quiz?pageNum=${page.prePageNum }">上一页</a>&nbsp;&nbsp;
        <a href="quiz?pageNum=${page.nextPageNum }">下一页</a>&nbsp;&nbsp;
        <a href="quiz?pageNum=${page.totalPageNum }">末页</a>&nbsp;&nbsp;
    </div>
</body>
</html>
