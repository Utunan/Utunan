<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/12/8
  Time: 14:14
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
<%@include file="header.jsp"%>
<div>
    <h2>搜索条件：${keyWord}</h2>
    <h2>分词结果：<c:forEach items="${keyWords}" var="word">${word}&nbsp;</c:forEach></h2>
    <h2><a href="/searchUser?keyWord=${keyWord}">搜索用户</a>&nbsp;&nbsp;&nbsp;
        <a href="/searchQuiz?keyWord=${keyWord}">搜索提问</a>&nbsp;&nbsp;&nbsp;
        <a href="/searchAnswer?keyWord=${keyWord}">搜索回答</a>
    </h2>
</div>
<div id="content">
<c:if test="${url=='searchUser'}">
    <table>
        <tr>
            <td>用户</td>
            <td>学校</td>
            <td>目标</td>
            <td>积分</td>
        </tr>
        <c:forEach items="${object}" var="user">
            <tr>
                <td>${user.userNickName}</td>
                <td>${user.userSchool}</td>
                <td>${user.dreamSchool}</td>
                <td>${user.userIntegral}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
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
                <li class="home"><a href="/${url }?keyWord=${keyWord}">首页</a></li>
                <li class="next"><a href="/${url }?keyWord=${keyWord}&pageNum=${PageInfo.prePage}"><<</a></li>
                <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                    <li class="pagenum"><a name="${i}" href="/${url }?keyWord=${keyWord}&pageNum=${i}">${i}</a></li>
                </c:forEach>
                <c:choose>
                    <c:when test="${PageInfo.nextPage==0}">
                        <li class="next"><a href="/${url }?keyWord=${keyWord}&pageNum=${PageInfo.pages}">>></a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="next"><a href="/${url }?keyWord=${keyWord}&pageNum=${PageInfo.nextPage}">>></a></li>
                    </c:otherwise>
                </c:choose>
                <li class="tail"><a href="/${url }?keyWord=${keyWord}&pageNum=${PageInfo.pages}">尾页</a></li>
            </nav>
    </div>
</c:if>
<c:if test="${url=='searchAnswer'}">
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
            <c:forEach items="${object}" var="answer">
            <tr>
                <td>${answer.answerId}</td>
                <td>${answer.quiz.quizId}</td>
                <td>回复：${answer.quiz.quizTitle}</td>
                <td>${answer.answerContent}</td>
                <td>${answer.answerTime}</td>
                <td>${answer.praiseCount}</td>
                <td>${answer.parentAnswer}</td>
            </tr>
            </c:forEach>
            <table/>
            <nav id="page" class="page">
                <li class="home"><a href="/${url }?keyWord=${keyWord}">首页</a></li>
                <li class="next"><a href="/${url }?keyWord=${keyWord}&pageNum=${PageInfo.prePage}"><<</a></li>
                <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                    <li class="pagenum"><a name="${i}" href="/${url }?keyWord=${keyWord}&pageNum=${i}">${i}</a></li>
                </c:forEach>
                <c:choose>
                    <c:when test="${PageInfo.nextPage==0}">
                        <li class="next"><a href="/${url }?keyWord=${keyWord}&pageNum=${PageInfo.pages}">>></a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="next"><a href="/${url }?keyWord=${keyWord}&pageNum=${PageInfo.nextPage}">>></a></li>
                    </c:otherwise>
                </c:choose>
                <li class="tail"><a href="/${url }?keyWord=${keyWord}&pageNum=${PageInfo.pages}">尾页</a></li>
            </nav>
    </div>
</c:if>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
