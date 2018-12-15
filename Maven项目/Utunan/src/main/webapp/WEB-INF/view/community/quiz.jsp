<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/11/19
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page import="java.util.List,com.utunan.pojo.*" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>问答列表</title>
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
<script>
    //禁用Enter键表单自动提交
    document.onkeydown = function(event) {
        var target, code, tag;
        if (!event) {
            event = window.event; //针对ie浏览器
            target = event.srcElement;
            code = event.keyCode;
            if (code == 13) {
                tag = target.tagName;
                if (tag == "TEXTAREA") { return true; }
                else { return false; }
            }
        }
        else {
            target = event.target; //针对遵循w3c标准的浏览器，如Firefox
            code = event.keyCode;
            if (code == 13) {
                tag = target.tagName;
                if (tag == "INPUT") { return false; }
                else { return true; }
            }
        }
    };

</script>
<script>
    var options = document.getElementsByClassName("fly-panel-title fly-filter")[0].getElementsByTagName("a");
    for (var i = 0; i < options.length; i++) {
        options[i].onclick = function () {
            for (var n = 0; n < options.length; n++) {
                options[n].className ="option";
            }
            this.className ="active";
        }
    }
</script>
<body>
<%@include file="../common/header.jsp"%>
<!--<div class="mask"></div>-->
<!--内容-->
<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">
        <c:if test="${url=='quiz'}">
            <div class="fly-panel" style="margin-bottom: 0;">

                <div class="fly-panel-title fly-filter">
                    <a href="quiz?by=releaseTime"class="${statelist[0]}">最新问题</a>
                    <span class="fly-mid"></span>
                    <a href="quiz?by=praiseCount"class="${statelist[1]}">热门问题</a>
                    <span class="fly-mid"></span>
                    <a href="">智能推荐</a>
                    <span class="fly-mid"></span>
                    <!--<span>TX：这里要加一个靠右的搜索框</span>-->
                    <div class="searchindex">
                        <form action="/searchQuiz" method="post">
                            <input type="text" class="" placeholder="请输入搜索条件..." name="keyWord">
                            <button class="layui-btn" type="submit">Go!</button>
                        </form>
                    </div>
                </div>
                <ul class="fly-list">
                    <c:forEach items="${object}" var="obj">
                    <li>
                        <a href="user/home.html" class="fly-avatar">
    
                           <img src="${obj.user.userHeadImg}" alt="昵称">
                        </a>
                        <h2>
                            <a href="displayQuizByQuizId?quizId=${obj.quiz.quizId}">${obj.quiz.quizTitle}</a>
                        </h2>
                        <!--<span class="question-description">${obj.quiz.quizContent}</span>-->
                        <div class="fly-list-info">
                            <a href="user/home.html" link>
                                ${obj.user.userNickName}
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
                <div style="text-align: center">
                    <div class="laypage-main">
                        <a href="/${url }?by=${orderBy}">首页</a>
                        <a href="/${url }?by=${orderBy}&pageNum=${PageInfo.prePage}"><<</a>
                        <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                            <a name="${i}" href="/${url }?by=${orderBy}&pageNum=${i}">${i}</a>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${PageInfo.nextPage==0}">
                                <a href="/${url }?by=${orderBy}&pageNum=${PageInfo.pages}">>></a>
                            </c:when>
                            <c:otherwise>
                                <a href="/${url }?by=${orderBy}&pageNum=${PageInfo.nextPage}">>></a>
                            </c:otherwise>
                        </c:choose>
                        <a href="/${url }?by=${orderBy}&pageNum=${PageInfo.pages}">尾页</a>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${url=='quiztag'}">
            <div class="fly-panel" style="margin-bottom: 0;">
    
                <div class="fly-panel-title fly-filter">
                    <a href="quiztag?by=releaseTime&tagName=${tagName}"class="${statelist[0]}">最新问题</a>
                    <span class="fly-mid"></span>
                    <a href="quiztag?by=praiseCount&tagName=${tagName}"class="${statelist[1]}">热门问题</a>
                    <span class="fly-mid"></span>
                    <a href="">智能推荐</a>
                    <span class="fly-mid"></span>
                    <!--<span>TX：这里要加一个靠右的搜索框</span>-->
                    <div class="searchindex">
                        <form action="/searchQuiz" method="post">
                            <input type="text" class="" placeholder="请输入搜索条件..." name="keyWord">
                            <button class="layui-btn" type="submit">Go!</button>
                        </form>
                    </div>
                </div>
                <ul class="fly-list">
                    <c:forEach items="${object}" var="obj">
                        <li>
                            <a href="user/home.html" class="fly-avatar">
                                <img src="${obj.user.userHeadImg}" alt="昵称">
                            </a>
                            <h2>
                                <a href="displayQuizByQuizId?quizId=${obj.quiz.quizId}">${obj.quiz.quizTitle}</a>
                            </h2>
                            <!--<span class="question-description">${obj.quiz.quizContent}</span>-->
                            <div class="fly-list-info">
                                <a href="user/home.html" link>
                                        ${obj.user.userNickName}
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
                                    <span class="layui-badge layui-bg-red">
                                        <a href="quiztag?by=releaseTime&tagName=${taglist.tagName}">
                                            <c:if test="${taglist.tagName == tagName}">
                                                <p STYLE="color: orange">${taglist.tagName}</p>
                                            </c:if>
                                            <c:if test="${taglist.tagName != tagName}">
                                                <p>${taglist.tagName}</p>
                                            </c:if>
                                        </a>
                                    </span>
                                </c:forEach>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <div style="text-align: center">
                    <div class="laypage-main">
                        <a href="/${url }?by=${orderBy}&tagName=${tagName}">首页</a>
                        <a href="/${url }?by=${orderBy}&tagName=${tagName}&pageNum=${PageInfo.prePage}"><<</a>
                        <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                            <a name="${i}" href="/${url }?by=${orderBy}&tagName=${tagName}&pageNum=${i}">${i}</a>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${PageInfo.nextPage==0}">
                                <a href="/${url }?by=${orderBy}&tagName=${tagName}&pageNum=${PageInfo.pages}">>></a>
                            </c:when>
                            <c:otherwise>
                                <a href="/${url }?by=${orderBy}&tagName=${tagName}&pageNum=${PageInfo.nextPage}">>></a>
                            </c:otherwise>
                        </c:choose>
                        <a href="/${url }?by=${orderBy}&tagName=${tagName}&pageNum=${PageInfo.pages}">尾页</a>
                    </div>
                </div>
            </div>
        </c:if>
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
                <c:forEach items="${quizListTop10}" var="q">
                    <dd>
                        <a href="displayQuizByQuizId?quizId=${q.quizId}">${q.quizTitle }</a>
                        <span><i class="iconfont icon-pinglun1"></i>${q.answerCount }</span>
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


<%@include file="../common/footer.jsp"%>
</body>
<script src="/js/community/questionMain.js"></script>
<script src="/js/common/common.js"></script>
<script >
    //添加标签
    var tag = new Tag("tagValue");
    tag.initView();
</script>

</html>
