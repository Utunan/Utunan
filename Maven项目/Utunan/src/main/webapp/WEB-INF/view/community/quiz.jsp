<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/11/19
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>问答列表</title>
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/community/questionIndex.css"/>
    <script> var pagenum="${PageInfo.pageNum}"</script>
</head>
<script type="text/javascript" src="https://unpkg.com/wangeditor@3.1.1/release/wangEditor.min.js"></script>
<script src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
<body>
<%@include file="../common/header.jsp"%>
<div class="mask"></div>
<!--内容-->
<div class="content">

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
                            <li class="${statelist[0]}" ><a href="quiz1">按时间排序</a></li>
                            <li class="${statelist[1]}" ><a href="quiz2">按热度排序</a></li>
                            <!--<li class="option" ><a href="#" >智能化推荐</a></li>-->
                        </ul>
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
                            <span>${obj.commentNumber}</span>
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
                        <ul>
                            <li class="${statelist[0]}" ><a href="quiz3?tagName=${tagName}">按时间排序</a></li>
                            <li class="${statelist[1]}" ><a href="quiz4?tagName=${tagName}">按热度排序</a></li>
                            <!--<li class="option" ><a href="#" >智能化推荐</a></li>-->
                        </ul>
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
                            <span>${obj.commentNumber}</span>
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
                    <%--@declare id="autocomplete59--1"--%><div class="headAppear"><img src="images/userheadimg/hand.jpg"/></div>
                    <textarea class="question-content" required="" rows="1"  autocomplete="off" role="combobox" aria-expanded="false" aria-autocomplete="list" aria-activedescendant="AutoComplete59--1"  aria-haspopup="true" aria-owns="Popover58-content"  placeholder="写下你的问题，准确地描述问题更容易得到解答" name="title"></textarea>
                </div>
                <div class="question-inspection">
                    <!--验证问题是否有问号，没有问号，显示-->
                    <p>你还没有给问题添加问号哦</p>
                </div>
                <div class="setReward">
                    设置悬赏金额
                    <input class="setReward-value" type="text" placeholder="0" name="j1"/>
                </div>
                <!--富文本编辑器-->
                <div class="text">
                    <div id="div1" class="toolbar" ></div>
                    <div id="div2" style="height: 100px">
                        <p>输入问题背景、条件等详细信息</p>
                    </div>
                    <textarea id="text1" style="display: none" name="textarea"></textarea>
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
                        editor1.customConfig.uploadImgMaxSize = 3 * 1024 * 1024   //每张图片最大上传大小
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
                    <c:forEach items="${tags}" var="tag1">
                        <div class="newtag">
                            &nbsp;
                            <div class="newtag-description">${tag1.tagName}</div>
                            <div class="cancel"><a >X</a></div>
                        </div>
                    </c:forEach>
                    <div class="add">+</div>
                    <div class="addword">添加话题</div>
                    <div style="display: none">
                        <c:forEach items="${alltag}" var="a">
                            <div class="newtag-description">${a.tagName}</div>
                            <div class="add"><a>+</a></div>
                        </c:forEach>
                    </div>
                </div>
                <input type="radio" name="radio" class="radio" style="float: left">匿名提问
                <input type="submit" value="发布问题" class="submit"/>
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
                    <li><a href="">${tags[0].tagName}&nbsp;&nbsp;&nbsp;${tags[1]}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
<script src="/js/questionMain.js"></script>
<script src="/js/common.js"></script>

</html>
