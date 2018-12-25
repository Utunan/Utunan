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
    <link rel="stylesheet" href="/css/share/file.css">
    <link rel="stylesheet" href="/css/school/login.css">
    <link rel="stylesheet" href="/css/search/search.css">
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
                        <a href="/search/file/1?wd=${keyWord}"class="${statelist[1]}">搜索文件</a>
                        <span class="fly-mid"></span>
                        <a href="/searchquestion"class="${statelist[1]}">搜索题库</a>
                        <span class="fly-mid"></span>
                        <a href="/school/displaySchool"class="${statelist[1]}">搜索院校</a>
                    </div>
                    <!--从这里开始是搜索用户结果-->
                    <c:if test="${url=='/search/user'}">
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
                        <c:if test="${empty object}">
                            <div style="text-align: center">
                                <span style="text-align: center">小优没有帮您找到数据，过一会儿再来看看吧</span>
                            </div>
                        </c:if>
                    </c:if>
                    <!--搜索用户到此止-->
                    <!--从这里开始是搜索提问结果-->
                    <c:if test="${url=='/search/quiz'}">
                        <ul class="fly-list">
                            <c:forEach items="${object}" var="obj">
                                <li>
                                    <a href="/member/${obj.quiz.user.userId}" class="fly-avatar">
                                        <img src="${obj.quiz.user.userHeadImg}" alt="昵称">
                                    </a>
                                    <h2>
                                        <a href="/quiz/${obj.quiz.quizId}">${obj.quiz.quizTitle}</a>
                                    </h2>
                                    <!--<span class="question-description">${obj.quiz.quizContent}</span>-->
                                    <div class="fly-list-info">
                                        <a href="/member/${obj.quiz.user.userId}" link>
                                                ${obj.quiz.user.userNickName}
                                        </a>
                                        <span>
                                                <fmt:formatDate value="${obj.quiz.releaseTime}" type="both"/>
                                            </span>

                                        <span class="fly-list-kiss layui-hide-xs" title="点赞"><img src="/images/community/praise.png" width="25px" height="20px" style="margin-top:-5px;">&nbsp;${obj.quiz.praiseCount}</span>
                                        <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                        <span class="fly-list-nums">
                                                <i class="iconfont icon-pinglun1" title="回答"></i> ${obj.quiz.answerCount}
                                            </span>
                                    </div>
                                    <div class="fly-list-badge">
                                        <c:forEach items="${obj.tagList}" var="taglist">
                                                <span class="layui-badge layui-bg-red">
                                                    <a href="/quiztag/${taglist.tagName}/rt/1">
                                                            ${taglist.tagName}
                                                    </a>
                                                </span>
                                        </c:forEach>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                        <!--分页-->
                        <%@include file="page.jsp"%>
                    </c:if>
                    <!--搜索提问到此止-->
                    <!--从这里开始是搜索回答结果-->
                    <c:if test="${url=='/search/answer'}">
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
                                    <td>用户昵称</td>
                                </tr>
                                <c:forEach items="${object}" var="answer">
                                    <tr>
                                        <td>${answer.answerId}</td>
                                        <td>${answer.quiz.quizId}</td>
                                        <td>回复：<a href="/quiz/${answer.quiz.quizId}" >${answer.quiz.quizTitle}</a></td>
                                        <td>${answer.answerContent}</td>
                                        <td>${answer.answerTime}</td>
                                        <td>${answer.praiseCount}</td>
                                        <td>${answer.parentAnswer}</td>
                                        <td>${answer.user.userNickName}</td>
                                    </tr>
                                </c:forEach>
                            <table/>
                        </div>
                        <!--分页-->
                        <%@include file="page.jsp"%>
                    </c:if>
                    <!--搜索回答到此止-->
                    <!--从这里开始是搜索文件结果-->
                    <c:if test="${url=='/search/file'}">
                        <ul class="list">
                            <c:forEach items="${object}" var="file" varStatus="stat">
                                <c:choose>
                                    <c:when test="${file.fileType == '招生简章' || file.fileType == '招生专业目录'}">
                                        <c:if test="${file.isExamine == 1}">
                                            <li>
                                                <div>
                                                    <img src="${file.suffix.imgUrl}" alt="文件类型" class="siffix">
                                                    <span class="tn"><a href="/file/${file.fileId}" >${file.fileTitle}</a></span>
                                                    <div class="topdetail">
                                                        <span class="ft"><a href="/searchfile?fileType=${file.fileType}&school=${file.fileSchool}&keyWord=">${file.fileType}</a></span>
                                                        <c:if test="${not empty file.fileSchool}">
                                                            <span class="fs"><a href="/searchfile?fileType=全部&school=${file.fileSchool}&keyWord=">${file.fileSchool}</a></span>
                                                        </c:if>
                                                    </div>
                                                    <span class="un">${file.user.userNickName}&nbsp;于${file.fileTime}上传</span>
                                                    <div class="rightdetail">
                                                        <span class="fc"><img src="/images/share/credit.svg"  class="credit">${file.fileCredit}</span>
                                                        <span class="dn"><a href="/file/${file.fileId}" ><img src="/images/share/downNum.svg"  class="downNum"></a>${file.downloadNumber}</span>
                                                    </div>
                                                </div>
                                            </li>
                                        </c:if>
                                    </c:when>
                                    <c:otherwise>
                                        <li>
                                            <div>
                                                <img src="${file.suffix.imgUrl}" alt="文件类型" class="siffix">
                                                <span class="tn"><a href="/file/${file.fileId}" >${file.fileTitle}</a></span>
                                                <div class="topdetail">
                                                    <span class="ft"><a href="/searchfile?fileType=${file.fileType}&school=${file.fileSchool}&keyWord=">${file.fileType}</a></span>
                                                    <c:if test="${not empty file.fileSchool}">
                                                        <span class="fs"><a href="/searchfile?fileType=全部&school=${file.fileSchool}&keyWord=">${file.fileSchool}</a></span>
                                                    </c:if>
                                                </div>
                                                <span class="un">${file.user.userNickName}&nbsp;于${file.fileTime}上传</span>
                                                <div class="rightdetail">
                                                    <span class="fc"><img src="/images/share/credit.svg"  class="credit">${file.fileCredit}</span>
                                                    <span class="dn"><a href="/file/${file.fileId}" ><img src="/images/share/downNum.svg"  class="downNum"></a>${file.downloadNumber}</span>
                                                </div>
                                            </div>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </ul>
                        <!--分页-->
                        <%@include file="page.jsp"%>
                    </c:if>
                    <!--搜索文件到此止-->
                 </div>
            </div>
            <div class="layui-col-md4">
                <img src="/images/common/firebird.png" width="400px" style="padding-left: 0px;padding-top:25px"/>
            </div>
        </div>
    </div>
<%@include file="footer.jsp"%>
</body>
</html>
