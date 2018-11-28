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

</head>
<body>
<div>
    <h2><a href="/searchQuiz?searchValue=${searchValue}">搜索提问</a>&nbsp;&nbsp;&nbsp;
        <a href="/searchComment?searchValue=${searchValue}">搜索回答</a>&nbsp;&nbsp;&nbsp;
        <a href="/searchTag?searchValue=${searchValue}">搜索标签</a>&nbsp;&nbsp;&nbsp;
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
                <a href="/${url }?searchValue=${searchValue}&pageNum=1">首页</a>&nbsp;&nbsp;
                <a href="/${url }?searchValue=${searchValue}&pageNum=${page.prePageNum }">上一页</a>&nbsp;&nbsp;
                <a href="/${url }?searchValue=${searchValue}&pageNum=${page.nextPageNum }">下一页</a>&nbsp;&nbsp;
                <a href="/${url }?searchValue=${searchValue}&pageNum=${page.totalPageNum }">末页</a>&nbsp;&nbsp;
            </div>
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
            <c:forEach items="${page.list}" var="obj">
            <tr>
                <td>${obj.commentId}</td>
                <td>${obj.quizId}</td>
                <td>回复：${obj.quiz.quizTitle}</td>
                <td>${obj.commentContent}</td>
                <td>${obj.commentTime}</td>
                <td>${obj.commentPraiseCount}</td>
                <td>${obj.replyCommentId}</td>
            </tr>
            </c:forEach>
            <table/>
            <div style="height: 20px;">
                <h4>共有${page.totalCount }条数据，一共${page.totalPageNum }页，这是第${page.currentPageNum }页</h4>
                <a href="/${url }?searchValue=${searchValue}&pageNum=1">首页</a>&nbsp;&nbsp;
                <a href="/${url }?searchValue=${searchValue}&pageNum=${page.prePageNum }">上一页</a>&nbsp;&nbsp;
                <a href="/${url }?searchValue=${searchValue}&pageNum=${page.nextPageNum }">下一页</a>&nbsp;&nbsp;
                <a href="/${url }?searchValue=${searchValue}&pageNum=${page.totalPageNum }">末页</a>&nbsp;&nbsp;
            </div>
    </div>
</c:if>
<c:if test="${url=='searchTag'}">
    <div>
        <table>
            <tr>
                <td>序号</td>
                <td>名称</td>
            </tr>
            <c:forEach items="${tagList}" var="tag">
            <tr>
                <td>${tag.tagId}</td>
                <td>${tag.tagName}</td>
            </tr>
            </c:forEach>
            <table/>
            <div style="height: 20px;">
                <h4>共有${tagNumber}条数据</h4>
            </div>
    </div>
</c:if>
</body>
</html>
