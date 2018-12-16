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
    <<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>搜索问题</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/community/questionIndex.css"/>
    <link rel="stylesheet" href="/css/community/layui.css">
    <link rel="stylesheet" href="/css/community/global.css">
    <script> var pagenum="${PageInfo.pageNum}"</script>
    <script type="text/javascript" src="https://unpkg.com/wangeditor@3.1.1/release/wangEditor.min.js"></script>
    <!--<script src="http://code.jquery.com/jquery-1.4.2.min.js"></script>-->
    <script src="/js/community/jquery-1.10.2.js"></script>
    <script src="/js/community/tag.js"></script>
</head>
<body>
<%@include file="header.jsp"%>
    <!--内容-->
    <div class="layui-container">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md8">
                    <div class="fly-panel" style="margin-bottom: 0;">

                        <div class="fly-panel-title fly-filter">
                            <a href="/searchUser?keyWord=${keyWord}"class="${statelist[0]}">搜索用户</a>
                            <span class="fly-mid"></span>
                            <a href="/searchQuiz?keyWord=${keyWord}"class="${statelist[1]}">搜索提问</a>
                            <span class="fly-mid"></span>
                            <a href="/searchAnswer?keyWord=${keyWord}"class="${statelist[1]}">搜索回答</a>
                            <span class="fly-mid"></span>
                        </div>
                        <c:if test="${url=='searchUser'}">
                        <ul class="list">
                            <c:forEach items="${object}" var="user">
                            <li>
                            <div class="detail-about">
                                <a class="fly-avatar" href="../user/home.html">
                                    <img src="${user.userHeadImg}" width="35px" height="35px">
                                </a>
                                <div class="fly-detail-user">
                                    <a href="../user/home.html" class="fly-link">
                                        <cite>${user.userNickName}</cite>
                                    </a>
                                    <span>积分&nbsp;
                                        ${user.userIntegral}
                                    </span>
                                </div>
                                <div class="detail-hits" id="LAY_jieAdmin" data-id="123">
                                    <span style="padding-right: 10px; color: #FF7200">考研年份：${user.examTime}</span>
                                    <span style="padding-right: 10px; color: #FF7200">所在院校：${user.userSchool}</span>
                                    <span style="padding-right: 10px; color: #FF7200">目标院校：${user.dreamSchool}</span>
                                </div>
                            </div>
                            </li>
                            </c:forEach>
                        </ul>

                        </c:if>
                        <c:if test="${url=='searchQuiz'}">
                        <ul class="fly-list">
                            <c:forEach items="${object}" var="obj">
                                <li>
                                    <a href="user/home.html" class="fly-avatar">
                                        <img src="${obj.quiz.user.userHeadImg}" alt="昵称">
                                    </a>
                                    <h2>
                                        <a href="displayQuizByQuizId?quizId=${obj.quiz.quizId}">${obj.quiz.quizTitle}</a>
                                    </h2>
                                    <!--<span class="question-description">${obj.quiz.quizContent}</span>-->
                                    <div class="fly-list-info">
                                        <a href="user/home.html" link>
                                                ${obj.quiz.user.userNickName}
                                            <!--
                                            <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                                            <i class="layui-badge fly-badge-vip">VIP3</i>
                                            -->
                                        </a>
                                        <span>
                                            <fmt:formatDate value="${obj.quiz.releaseTime}" type="both"/>
                                        </span>

                                        <span class="fly-list-kiss layui-hide-xs" title="点赞"><img src="images/community/praise.png"width="25px"height="20px" style="margin-top:-5px;">&nbsp;${obj.quiz.praiseCount}</span>
                                        <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                        <span class="fly-list-nums">
                                            <i class="iconfont icon-pinglun1" title="回答"></i> ${obj.quiz.answerCount}
                                        </span>
                                    </div>
                                    <div class="fly-list-badge">
                                        <c:forEach items="${obj.tagList}" var="taglist">
                                            <span class="layui-badge layui-bg-red"><a href="quiztag?by=releaseTime&tagName=${taglist.tagName}">${taglist.tagName}</a></span>
                                        </c:forEach>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
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
            </div>
            <div class="layui-col-md4">
                <div class="fly-panel">
                    <div class="fly-panel-main">
                        <a href="" target="_blank" class="fly-zanzhu" style="background-color: #393D49;">发表提问</a>
                    </div>
                </div>

                <dl class="fly-panel fly-list-one">
                    <!--选出10个评论数最高的问题-->
                    <dt class="fly-panel-title">本周热议</dt>
                    <c:forEach items="" var="q">
                        <dd>
                            <a href=""></a>
                            <span><i class="iconfont icon-pinglun1"></i></span>
                        </dd>
                    </c:forEach>

                </dl>



                <div class="fly-panel fly-link">
                    <h3 class="fly-panel-title">热门标签</h3>
                    <dl class="fly-panel-main">
                        <c:forEach items="${tag}" var="tags">
                            <dd><a href="quiztag?tagName=${tags[0].tagName}" target="_blank" class="tag">${tags[0].tagName}&nbsp;&nbsp;&nbsp;${tags[1]}</a></dd>
                        </c:forEach>
                    </dl>
                </div>
            </div>
        </div>
    </div>
<%@include file="footer.jsp"%>
</body>
</html>
