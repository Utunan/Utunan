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
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>搜索结果</title>
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
                        <a href="/search/user?wd=${keyWord}"class="${statelist[0]}">搜索用户</a>
                        <span class="fly-mid"></span>
                        <a href="/search/quiz/1?wd=${keyWord}"class="${statelist[1]}">搜索提问</a>
                        <span class="fly-mid"></span>
                        <a href="/search/answer/1?wd=${keyWord}"class="${statelist[1]}">搜索回答</a>
                        <span class="fly-mid"></span>
                    </div>
                    <ul class="list">
                        <c:forEach items="${object}" var="user">
                        <li>
                        <div class="detail-about">
                            <a class="fly-avatar" href="/member/${user.userId}">
                                <img src="${user.userHeadImg}" width="35px" height="35px">
                            </a>
                            <div class="fly-detail-user">
                                <a href="/member/${user.userId}" class="fly-link">
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
                    <div style="text-align: center">
                        <span style="text-align: center">小优没有帮您找到数据，过一会儿再来看看吧</span>
                    </div>
                 </div>
            </div>
            <div class="layui-col-md4">
                <div class="fly-panel">
                    <div class="fly-panel-main">
                        <a href="/quiz" target="_blank" class="fly-zanzhu" style="background-color: #393D49;">发表提问</a>
                    </div>
                </div>
                <dl class="fly-panel fly-list-one">
                    <!--选出10个评论数最高的问题-->
                    <dt class="fly-panel-title">本周热议</dt>
                    <c:forEach items="${quizListTop10}" var="q">
                        <dd>
                            <a href="quiz/${q.quizId}">${q.quizTitle }</a>
                            <span><i class="iconfont icon-pinglun1"></i>${q.answerCount }</span>
                        </dd>
                    </c:forEach>
                </dl>
                <div class="fly-panel fly-link">
                    <h3 class="fly-panel-title">热门标签</h3>
                    <dl class="fly-panel-main">
                        <c:forEach items="${tag}" var="tags">
                            <dd><a href="quiztag/${tags[0].tagName}/rt/1" target="_blank" class="tag">${tags[0].tagName}&nbsp;&nbsp;&nbsp;${tags[1]}</a></dd>
                        </c:forEach>
                    </dl>
                </div>
            </div>
        </div>
    </div>
<%@include file="footer.jsp"%>
</body>
</html>
