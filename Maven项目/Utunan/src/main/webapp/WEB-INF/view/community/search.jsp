<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/11/26
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/community/questionIndex.css"/>
    <script> var pagenum="${PageInfo.pageNum}"</script>
</head>
<body>
<div>
    <h2><a href="/searchQuiz?searchValue=${searchValue}">搜索提问</a>&nbsp;&nbsp;&nbsp;
        <a href="/searchComment?searchValue=${searchValue}">搜索回答</a>
    </h2>
</div>
<c:if test="${url=='searchQuiz'}">
    <div>
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
            <c:forEach items="${object}" var="obj">
            <tr>
                <td>${obj.quiz.quizId}</td>
                <td>${obj.quiz.user.userNickName}</td>
                <td>${obj.quiz.quizTitle}</td>
                <td>${obj.quiz.quizContent}</td>
                <td>${obj.quiz.releaseTime}</td>
                <td>${obj.quiz.praiseCount}</td>
                <td>${obj.quiz.answerCount}</td>
                <td>
                    <c:forEach items="${obj.tagList}" var="taglist">
                        ${taglist.tagName}&nbsp;&nbsp;&nbsp;
                    </c:forEach>
                </td>
            </tr>
            </c:forEach>
            <table/>
            <nav id="page" class="page">
                <li class="home"><a href="/${url }?searchValue=${searchValue}">首页</a></li>
                <li class="next"><a href="/${url }?searchValue=${searchValue}&pageNum=${PageInfo.prePage}">上一页</a></li>
                <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                    <li class="pagenum"><a name="${i}" href="/${url }?searchValue=${searchValue}&pageNum=${i}">${i}</a></li>
                </c:forEach>
                <c:choose>
                    <c:when test="${PageInfo.nextPage==0}">
                        <li class="next"><a href="/${url }?searchValue=${searchValue}&pageNum=${PageInfo.pages}">下一页</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="next"><a href="/${url }?searchValue=${searchValue}&pageNum=${PageInfo.nextPage}">下一页</a></li>
                    </c:otherwise>
                </c:choose>
                <li class="tail"><a href="/${url }?searchValue=${searchValue}&pageNum=${PageInfo.pages}">尾页</a></li>
            </nav>
    </div>
</c:if>
<c:if test="${url=='searchComment'}">
    <div>
        <table>
            <tr>
                <td>序号</td>
                <td>问题Id</td>
                <td>问题名称</td>
                <td>回答</td>
                <td>时间</td>
                <td>点赞</td>
                <td>上级评论</td>
            </tr>
            <c:forEach items="${object}" var="obj">
            <tr>
                <td>${obj.answerId}</td>
                <td>${obj.quiz.quizId}</td>
                <td>回复：${obj.quiz.quizTitle}</td>
                <td>${obj.answerContent}</td>
                <td>${obj.answerTime}</td>
                <td>${obj.praiseCount}</td>
                <td>${obj.parentAnswer}</td>
            </tr>
            </c:forEach>
            <table/>
            <nav id="page" class="page">
                <li class="home"><a href="/${url }?searchValue=${searchValue}">首页</a></li>
                <li class="next"><a href="/${url }?searchValue=${searchValue}&pageNum=${PageInfo.prePage}">上一页</a></li>
                <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                    <li class="pagenum"><a name="${i}" href="/${url }?searchValue=${searchValue}&pageNum=${i}">${i}</a></li>
                </c:forEach>
                <c:choose>
                    <c:when test="${PageInfo.nextPage==0}">
                        <li class="next"><a href="/${url }?searchValue=${searchValue}&pageNum=${PageInfo.pages}">下一页</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="next"><a href="/${url }?searchValue=${searchValue}&pageNum=${PageInfo.nextPage}">下一页</a></li>
                    </c:otherwise>
                </c:choose>
                <li class="tail"><a href="/${url }?searchValue=${searchValue}&pageNum=${PageInfo.pages}">尾页</a></li>
            </nav>
    </div>
</c:if>
</body>
</html>
