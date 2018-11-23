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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>问答列表</title>
</head>
<body>
    <div >
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
                <td>回答</td>
                <td>标签</td>
            </tr>
            <c:forEach items="${page.list}" var="obj">
            <tr>
                <td>${obj.quiz.quizId}</td>
                <td>${obj.quiz.user.userNickName}</td>
                <td>${obj.quiz.quizTitle}</td>
                <td>${obj.quiz.quizContent}</td>
                <td>${obj.quiz.releaseTime}</td>
                <td>${obj.quiz.praiseCount}</td>
                <td>${obj.commentNumber}</td>
                <td>
                    <c:forEach items="${obj.tagList}" var="taglist">
                        ${taglist.tagName}&nbsp;&nbsp;&nbsp;
                    </c:forEach>
                </td>
            </tr>
            </c:forEach>
        <table/>
        <div style="height: 20px;">
            <h4>共有${page.totalCount }条数据，一共${page.totalPageNum }页，这是第${page.currentPageNum }页</h4>
            <a href="/${url }?pageNum=1">首页</a>&nbsp;&nbsp;
            <a href="/${url }?pageNum=${page.prePageNum }">上一页</a>&nbsp;&nbsp;
            <a href="/${url }?pageNum=${page.nextPageNum }">下一页</a>&nbsp;&nbsp;
            <a href="/${url }?pageNum=${page.totalPageNum }">末页</a>&nbsp;&nbsp;
        </div>
    </div>
    <br><br><br>
    <div>
        <table style="font-size: 2.5ex">
            <tr><td style="font-size: 3ex">热门标签</td><td></td></tr>
            <c:forEach items="${tag}" var="tags">
                <tr><td>${tags[0].tagName}</td><td>${tags[1]}</td></tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
