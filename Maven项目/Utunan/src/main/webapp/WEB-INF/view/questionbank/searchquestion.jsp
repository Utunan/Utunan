<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date1: 2018/12/3
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>在无边无际的题库中摸索</title>
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<div>
    <table>
        <tr>
            <td>题目ID</td>
            <td>章节名称</td>
            <td>题目内容</td>
            <td>题目类型</td>
        </tr>
        <c:forEach items="${questionList}" var="question">
        <tr>
            <td>${question.questionId}</td>
            <td>${question.chapterName}</td>
            <td>${question.questionContent}</td>
            <td>
                <c:choose>
                    <c:when test="${question.questionType=='1'}">
                        选择题
                    </c:when>
                    <c:when test="${question.questionType=='2'}">
                        填空题
                    </c:when>
                    <c:otherwise>
                        程序题
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
        </c:forEach>
    </table>
    <nav id="page" class="page">
        <li class="home"><a href="/${url }?keyWord=${keyWord}">首页</a></li>
        <li class="next"><a href="/${url }?keyWord=${keyWord}&pageNum=${PageInfo.prePage}">上一页</a></li>
        <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
            <li class="pagenum"><a name="${i}" href="/${url }?keyWord=${keyWord}&pageNum=${i}">${i}</a></li>
        </c:forEach>
        <c:choose>
            <c:when test="${PageInfo.nextPage==0}">
                <li class="next"><a href="/${url }?keyWord=${keyWord}&pageNum=${PageInfo.pages}">下一页</a></li>
            </c:when>
            <c:otherwise>
                <li class="next"><a href="/${url }?keyWord=${keyWord}&pageNum=${PageInfo.nextPage}">下一页</a></li>
            </c:otherwise>
        </c:choose>
        <li class="tail"><a href="/${url }?keyWord=${keyWord}&pageNum=${PageInfo.pages}">尾页</a></li>
    </nav>
</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>
