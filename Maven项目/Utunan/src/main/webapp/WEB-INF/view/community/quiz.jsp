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

<%--
<div class="content">
    <!--旧的-->
    <!--左半部分-->
    <!--初始界面-->
    <c:if test="${url=='quiz1' || url=='quiz2'}">
        <div class="left-content">
            <!--内容声明-->
            <div class="left-content-header">
                <p>针对计算机类专业的考研问答社区，欢迎你在这里提问与答疑<a class="subscribe"href="#">&nbsp;+订阅&nbsp;</a></p>
            </div>
            <!--主要内容-->
            <div class="left-content-main">
                <div class="content-main-menu">
                    <!--帖子显示原则选项-->
                    <div class="menu-description">排序：</div>
                    <div class="menu-optionSet">
                        <ul>
                            <a href="quiz1"class="${statelist[0]}">按时间排序</a>
                            <a href="quiz2"class="${statelist[1]}">按热度排序</a>
                            <!--<li class="option" ><a href="#" >智能化推荐</a></li>-->
                        </ul>
                    </div>
                    <div class="search">                        <form name="searchForm" action="/searchQuiz" method="post">
                            <!--搜索帖子-->
                            <div class="searchText">
                                <input type="text" style="width:140px; height:20px;border-radius:8px;border: none;margin-top: 10px;" name="searchValue"/>
                            </div>
                            <!--搜索图标-->
                            <button class="searchImg" type="submit">
                                <img src="/images/common/search.png" width="20px" height="20px" >
                            </button>
                        </form>
                    </div>
                </div>
                <!--帖子-->
                <c:forEach items="${object}" var="obj">
                    <div class="post">
                        <div class="post-content">
                            <div class="top">
                                <div class="post-information">
                                        ${obj.quiz.releaseTime} &nbsp;来自:<a href="#">${obj.quiz.user.userNickName}</a>
                                </div>
                                <div></div>
                                <div class="praise">赞:</div>
                                <div class="praise-value">${obj.quiz.praiseCount}</div>
                            </div>
                            <div class="question">
                                <a href="displayQuizByQuizId?quizId=${obj.quiz.quizId}"><p>${obj.quiz.quizTitle}</p></a>
                            </div>
                            <div class="post-description">
                                <p>${obj.quiz.quizContent}</p>
                            </div>
                            <!--帖子问题类型-->
                            <div class="post-tags">
                                <c:forEach items="${obj.tagList}" var="taglist">
                                    <a href="quiz3?tagName=${taglist.tagName}">&nbsp;${taglist.tagName}&nbsp;</a>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="answer_num " title="暂无满意答案" target="_blank" href="#">
                            <span>${obj.quiz.answerCount}</span>
                            <p>回答</p>
                        </div>
                    </div>
                </c:forEach>
                <nav id="page" class="page">
                    <li class="home"><a href="/${url }">首页</a></li>
                    <li class="next"><a href="/${url }?pageNum=${PageInfo.prePage}">上一页</a></li>
                    <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                        <li class="pagenum"><a name="${i}" href="/${url }?pageNum=${i}">${i}</a></li>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${PageInfo.nextPage==0}">
                            <li class="next"><a href="/${url }?pageNum=${PageInfo.pages}">下一页</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="next"><a href="/${url }?pageNum=${PageInfo.nextPage}">下一页</a></li>
                        </c:otherwise>
                    </c:choose>
                    <li class="tail"><a href="/${url }?pageNum=${PageInfo.pages}">尾页</a></li>
                </nav>
            </div>
        </div>
    </c:if>
    <!--选择标签后-->
    <c:if test="${url=='quiz3' || url=='quiz4'}">
        <div class="left-content">
            <!--内容声明-->
            <div class="left-content-header">
                <p>标签 “${tagName}”<a class="subscribe"href="#">&nbsp;+订阅&nbsp;</a></p>
            </div>
            <!--主要内容-->
            <div class="left-content-main">

                <div class="content-main-menu">
                    <!--帖子显示原则选项-->
                    <div class="menu-description">排序：</div>
                    <div class="menu-optionSet">
                        <a href="quiz3?tagName=${tagName}"class="${statelist[0]}">按时间排序</a>
                        <a href="quiz4?tagName=${tagName}"class="${statelist[1]}">按热度排序</a>
                        <!--<li class="option" ><a href="#" >智能化推荐</a></li>-->
                    </div>
                    <div class="search">
                        <form name="searchForm" action="/searchQuiz" method="post">
                            <!--搜索帖子-->
                            <div class="searchText">
                                <input type="text" style="width:140px; height:20px;border-radius:8px;border: none;margin-top: 10px;" name="searchValue"/>
                            </div>
                            <!--搜索图标-->
                            <button class="searchImg" type="submit">
                                <img src="images/search.png" width="20px" height="20px" >
                            </button>
                        </form>
                    </div>
                </div>
                <!--帖子-->
                <c:forEach items="${object}" var="obj">
                    <div class="post">
                        <div class="post-content">
                            <div class="top">
                                <div class="post-information">
                                        ${obj.quiz.releaseTime} &nbsp;来自:<a href="#">${obj.user.userNickName}</a>
                                </div>
                                <div></div>
                                <div class="praise">赞:</div>
                                <div class="praise-value">${obj.quiz.praiseCount}</div>
                            </div>
                            <div class="question">
                                <a href="displayQuizByQuizId?quizId=${obj.quiz.quizId}"><p>${obj.quiz.quizTitle}</p></a>
                            </div>
                            <div class="post-description">
                                <p>${obj.quiz.quizContent}</p>
                            </div>
                            <!--帖子问题类型-->
                            <div class="post-tags">
                                <c:forEach items="${obj.tagList}" var="taglist">
                                    <a href="quiz3?tagName=${taglist.tagName}">&nbsp;${taglist.tagName}&nbsp;</a>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="answer_num " title="暂无满意答案" target="_blank" href="#">
                            <span>${obj.quiz.answerCount}</span>
                            <p>回答</p>
                        </div>
                    </div>
                </c:forEach>
                <nav id="page" class="page">
                    <li class="home"><a href="/${url }?tagName=${tagName}">首页</a></li>
                    <li class="next"><a href="/${url }?tagName=${tagName}&pageNum=${PageInfo.prePage}">上一页</a></li>
                    <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                        <li class="pagenum"><a name="${i}" href="/${url }?tagName=${tagName}&pageNum=${i}">${i}</a></li>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${PageInfo.nextPage==0}">
                            <li class="next"><a href="/${url }?tagName=${tagName}&pageNum=${PageInfo.pages}">下一页</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="next"><a href="/${url }?tagName=${tagName}&pageNum=${PageInfo.nextPage}">下一页</a></li>
                        </c:otherwise>
                    </c:choose>
                    <li class="tail"><a href="/${url }?tagName=${tagName}&pageNum=${PageInfo.pages}">尾页</a></li>
                </nav>
            </div>
        </div>
    </c:if>
    <!--右半部分-->
    <div class="right-content">
        <div class="modalDialogcontent">
            <span class="close_modalDialogcontent">×</span>
            <form action="uiz3" method="post">
                <div class="ask-question">
                    <!--从数据库查出头像-->

                    <div class="headAppear"><img src="images/userheadimg/hand.jpg"/></div>
                    <textarea class="question-content" required="" rows="1"  autocomplete="off" role="combobox" aria-expanded="false" aria-autocomplete="list" aria-activedescendant="AutoComplete59--1"  aria-haspopup="true" aria-owns="Popover58-content"  placeholder="写下你的问题，准确地描述问题更容易得到解答" name="title"></textarea>
                </div>
                <div class="question-inspection">
                    <!--验证问题是否有问号，没有问号，显示-->
                    <p>你还没有给问题添加问号哦</p>
                </div>
                <!--富文本编辑器-->
                <div class="text">
                    <div id="div1" class="toolbar" ></div>
                    <textarea id="div2" style="height: 95px;width: 460px;font-size: 16px;" name="textarea"placeholder="输入问题背景、条件等详细信息"></textarea>
                    <script type="text/javascript">
                        var E = window.wangEditor;
                        var editor1 = new E('#div1', '#div2');  // 两个参数也可以传入 elem 对象，class 选择器
                        editor1.customConfig.menus = [
                            'list',  // 列表
                            'link',     //插入链接
                            'image',    //插入图片
                            'code'    //插入代码
                        ];
                        editor1.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
                        editor1.customConfig.uploadImgMaxSize = 1 * 1024 * 1024   //每张图片最大上传大小
                        editor1.customConfig.uploadImgMaxLength = 5              //每次最多上传5张
                        var $text1 = $('#text1')
                        editor1.customConfig.onchange = function (html) {
                            // 监控变化，同步更新到 textarea
                            $text1.val(html)
                        }

                        editor1.create();
                    </script>
                </div>


                <div class="addtags">
                    <div class="addtags-description">添加标签：</div>
                    <input type="text" id="tagValue" placeholder="用户名或邮件地址" name="tags"/>
                </div>
                <div class="add-buttom">
                    <div class="radio"><label for="checkbox"><input type="checkbox" id="checkbox">匿名提问</div>
                    <input type="submit" value="发布问题" class="submit"/>
                </div>
            </form>
        </div>
        <div class="ask">
            <a href="#">我要提问</a>
        </div>
        <div class="tags">
            <!--数据库获取-->
            <div class="tags-title">热门标签</div>
            <ul>
                <c:forEach items="${tag}" var="tags">
                    <li><a href="quiz3?tagName=${tags[0].tagName}">${tags[0].tagName}&nbsp;&nbsp;&nbsp;${tags[1]}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
--%>
<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">
        <c:if test="${url=='quiz1' || url=='quiz2'}">
            <div class="fly-panel" style="margin-bottom: 0;">

                <div class="fly-panel-title fly-filter">
                    <a href="quiz1"class="${statelist[0]}">最新问题</a>
                    <span class="fly-mid"></span>
                    <a href="quiz2"class="${statelist[1]}">热门问题</a>
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

                            <span class="fly-list-kiss layui-hide-xs" title="点赞"><a href="praise?quizId=${obj.quiz.quizId}"><img src="images/community/praise.png"width="25px"height="20px" style="margin-top:-5px;"></a>&nbsp;${obj.quiz.praiseCount}</span>
                            <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                            <span class="fly-list-nums">
                                <i class="iconfont icon-pinglun1" title="回答"></i> ${obj.quiz.answerCount}
                            </span>
                        </div>
                        <div class="fly-list-badge">
                            <c:forEach items="${obj.tagList}" var="taglist">
                                <span class="layui-badge layui-bg-red"><a href="quiz3?tagName=${taglist.tagName}">${taglist.tagName}</a></span>
                            </c:forEach>
                        </div>
                    </li>
                    </c:forEach>
                </ul>

                <!-- <div class="fly-none">没有相关数据</div> -->

                <div style="text-align: center">
                    <div class="laypage-main">
                        <%--<span class="laypage-curr">1</span>
                        <a href="/jie/page/2/">2</a>
                        <a href="/jie/page/3/">3</a>
                        <a href="/jie/page/4/">4</a>
                        <a href="/jie/page/5/">5</a>

                        <a href="/jie/page/148/" class="laypage-last" title="尾页">尾页</a>
                        <a href="/jie/page/2/" class="laypage-next">下一页</a>--%>

                        <a href="/${url }">首页</a>
                        <a href="/${url }?pageNum=${PageInfo.prePage}"><<</a>
                        <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                            <a name="${i}" href="/${url }?pageNum=${i}">${i}</a>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${PageInfo.nextPage==0}">
                                <a href="/${url }?pageNum=${PageInfo.pages}">>></a>
                            </c:when>
                            <c:otherwise>
                                <a href="/${url }?pageNum=${PageInfo.nextPage}">>></a>
                            </c:otherwise>
                        </c:choose>
                        <a href="/${url }?pageNum=${PageInfo.pages}">尾页</a>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${url=='quiz3' || url=='quiz4'}">
            <div class="fly-panel" style="margin-bottom: 0;">

                <div class="fly-panel-title fly-filter">
                    <a href="quiz3?tagName=${tagName}"class="${statelist[0]}">最新问题</a>
                    <span class="fly-mid"></span>
                    <a href="quiz4?tagName=${tagName}"class="${statelist[1]}">热门问题</a>
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
                                <span>${obj.quiz.releaseTime}</span>

                                <span class="fly-list-kiss layui-hide-xs" title="点赞"><a href="praise?quizId=${obj.quiz.quizId}"><img src="images/community/praise.png"width="25px"height="20px" style="margin-top:-5px;"></a>&nbsp;${obj.quiz.praiseCount}</span>
                                <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
                                <span class="fly-list-nums">
                            <i class="iconfont icon-pinglun1" title="回答"></i> ${obj.quiz.answerCount}
                        </span>
                            </div>
                            <div class="fly-list-badge">
                                <c:forEach items="${obj.tagList}" var="taglist">
                                    <span class="layui-badge layui-bg-red"><a href="quiz3?tagName=${taglist.tagName}">${taglist.tagName}</a></span>
                                </c:forEach>
                            </div>
                        </li>
                    </c:forEach>
                </ul>

                <!-- <div class="fly-none">没有相关数据</div> -->

                <div style="text-align: center">
                    <div class="laypage-main">
                            <%--<span class="laypage-curr">1</span>
                            <a href="/jie/page/2/">2</a>
                            <a href="/jie/page/3/">3</a>
                            <a href="/jie/page/4/">4</a>
                            <a href="/jie/page/5/">5</a>

                            <a href="/jie/page/148/" class="laypage-last" title="尾页">尾页</a>
                            <a href="/jie/page/2/" class="laypage-next">下一页</a>--%>

                        <a href="/${url }?tagName=${tagName}">首页</a>
                        <a href="/${url }?tagName=${tagName}&pageNum=${PageInfo.prePage}"><<</a>
                        <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                            <a name="${i}" href="/${url }?tagName=${tagName}&pageNum=${i}">${i}</a>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${PageInfo.nextPage==0}">
                                <a href="/${url }?tagName=${tagName}&pageNum=${PageInfo.pages}">>></a>
                            </c:when>
                            <c:otherwise>
                                <a href="/${url }?tagName=${tagName}&pageNum=${PageInfo.nextPage}">>></a>
                            </c:otherwise>
                        </c:choose>
                        <a href="/${url }?tagName=${tagName}&pageNum=${PageInfo.pages}">尾页</a>
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
                        <a href="">${q.quizTitle }</a>
                        <span><i class="iconfont icon-pinglun1"></i>${q.answerCount }</span>
                    </dd>
                </c:forEach>

            </dl>



            <div class="fly-panel fly-link">
                <h3 class="fly-panel-title">热门标签</h3>
                <dl class="fly-panel-main">
                    <c:forEach items="${tag}" var="tags">
                        <dd><a href="quiz3?tagName=${tags[0].tagName}" target="_blank" class="tag">${tags[0].tagName}&nbsp;&nbsp;&nbsp;${tags[1]}</a></dd>
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
