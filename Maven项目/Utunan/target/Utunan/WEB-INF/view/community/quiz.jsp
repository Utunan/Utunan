<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/11/19
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List,com.utunan.pojo.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>问答列表</title>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="css/questionIndex.css"/>
    <script type="text/javascript" src="https://unpkg.com/wangeditor@3.1.1/release/wangEditor.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
</head>
<body>
    <!--
    <div >
        <div>
            <h1><a href="quiz1">时间</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="quiz2">热度</a></h1>
        </div>
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
            <a href="/${url }?pageNum=1">首页</a>&nbsp;&nbsp;
            <a href="/${url }?pageNum=${page.prePageNum }">上一页</a>&nbsp;&nbsp;
            <a href="/${url }?pageNum=${page.nextPageNum }">下一页</a>&nbsp;&nbsp;
            <a href="/${url }?pageNum=${page.totalPageNum }">末页</a>&nbsp;&nbsp;
        </div>
    </div>
    <br><br><br>
    <div>
        <table style="font-size: 2.5ex">
            <tr><td style="font-size: 3ex">热门标签</td><td></td></tr>
            <c:forEach items="${tag}" var="tags">
                <tr><td>${tags[0].tagName}</td><td>${tags[1]}</td></tr>
            </c:forEach>
        </table>
    </div>
    -->
    <div class="mask"></div>
    <!--内容-->
    <div class="content">
        <!--左半部分-->
        <div class="left-content">
            <!--内容声明-->
            <div class="left-content-header">
                <p>U问答是一个针对计算机专业学生的问答社区，欢迎你在这里提问与答疑<a class="subscribe"href="#">&nbsp;+订阅&nbsp;</a></p>

            </div>

            <!--主要内容-->
            <div class="left-content-main">

                <div class="content-main-menu">
                    <!--帖子显示原则选项-->
                    <div class="menu-description">排序：</div>
                    <div class="menu-optionSet">
                        <ul>
                            <li class="active" ><a href="quiz1">按时间排序</a></li>
                            <li class="option" ><a href="quiz2">按热度排序</a></li>
                            <li class="option" ><a href="#" >智能化推荐</a></li>
                        </ul>
                    </div>
                    <div class="search">
                        <!--搜索帖子-->
                        <div class="searchText">
                            <input type="text" style="width:140px; height:20px;border-radius:8px;border: none;margin-top: 10px;"/>
                        </div>
                        <!--搜索图标-->
                        <div class="searchImg">
                            <img src="images/search.png" width="20px" height="20px">
                        </div>
                    </div>
                </div>
                <!--帖子-->
                <c:forEach items="${page.list}" var="obj">
                <div class="post">
                    <div class="post-content">
                        <div class="top">
                            <div class="post-information">
                                    ${obj.quiz.releaseTime} &nbsp;来自:<a href="#">${obj.quiz.user.userNickName}</a>
                            </div>
                            <div class="reward">悬赏:</div>
                            <div class="reward-value">10</div>
                            <div></div>
                            <div class="praise">赞:</div>
                            <div class="praise-value">${obj.quiz.praiseCount}</div>
                        </div>
                        <div class="question">
                            <p>${obj.quiz.quizTitle}</p>
                        </div>
                        <div class="post-description">
                            <p>${obj.quiz.quizContent}</p>
                        </div>
                        <!--帖子问题类型-->
                        <div class="post-tags">
                            <c:forEach items="${obj.tagList}" var="taglist">
                                <a href="#">&nbsp;${taglist.tagName}&nbsp;</a>
                            </c:forEach>
                        </div>
                    </div>
                    <a class="answer_num " title="暂无满意答案" target="_blank" href="#">
                        <span>${obj.commentNumber}</span>
                        <p>回答</p>
                    </a>
                </div>
                </c:forEach>
                <div class="bottom">
                    <div class="page">
                        <a href="/${url }?pageNum=1">首页</a>
                        <a href="/${url }?pageNum=${page.prePageNum }">上一页</a>
                        <a href="/${url }?pageNum=${page.nextPageNum }">下一页</a>
                        <a href="/${url }?pageNum=${page.totalPageNum }">末页</a>
                    </div>
                </div>
            </div>
        </div>

        <!--右半部分-->
        <div class="right-content">
            <div class="modalDialogcontent">
                <span class="close_modalDialogcontent">×</span>
                <form action="quiz3" method="post">
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
                    <!--<div class="text">-->
                        <div id="div1" class="toolbar" style="width: 100px;float: right" ></div>
                        <div id="div2" class="question-content">
                             <p>输入问题背景、条件等详细信息</p>
                        </div>
                        <textarea id="text1"  name="textarea"></textarea>
                        <textarea id="text" style="width:100%; height:200px;display: none;" name="textarea"></textarea>
                        <!--<div class="toolbar" unselectable="on">
                            <img src="images/community/text1.svg" width="20px"height="20px">
                            <img src="images/community/text2.svg" width="20px"height="20px">
                            <img src="images/community/text3.svg" width="20px"height="20px">
                            <img src="images/community/text4.svg" width="20px"height="20px">
                            <img src="images/community/text5.svg" width="20px"height="20px">
                            <img src="images/community/text6.svg" width="20px"height="20px">
                            <img src="images/community/text7.svg" width="20px"height="20px">
                            <img src="images/community/text8.svg" width="20px"height="20px">
                            <img src="images/community/text9.svg" width="20px"height="20px">
                            <div class="more"><img src="images/community/text10.svg" width="20px"height="20px"></div>
                        </div>
                        <textarea class="question-content" required="" rows="1"  autocomplete="off" role="combobox" aria-expanded="false" aria-autocomplete="list" aria-activedescendant="AutoComplete59--1"  aria-haspopup="true" aria-owns="Popover58-content"  placeholder="输入问题背景、条件等详细信息（选填）"></textarea>-->
                        <script type="text/javascript">
                            var E = window.wangEditor;
                            var editor1 = new E('#div1', '#div2');  // 两个参数也可以传入 elem 对象，class 选择器
                            editor1.customConfig.menus = [
                                'link',     //插入链接
                                'image',    //插入图片
                                'code'    //插入代码
                            ];
                            editor1.customConfig.uploadImgShowBase64 = true           //使用base64存储图片
                            editor1.customConfig.uploadImgMaxSize = 3 * 1024 * 1024   //每张图片最大上传大小
                            editor1.customConfig.uploadImgMaxLength = 5              //每次最多上传5张
                            var $text1 = $('#text1')
                            editor1.customConfig.onchange = function (html) {
                                // 监控变化，同步更新到 textarea
                                $text1.val(html)
                            }

                            editor1.create();
                        </script>
                    <!--</div>-->


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
                        <div></div>
                        <c:forEach items="${alltag}" var="a">
                            <div class="newtag-description">${a.tagName}</div>
                            <div class="add"><a>+</a></div>
                        </c:forEach>
                    </div>
                    <input type="radio" name="radio" class="radio">匿名提问
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
                    <li><a href="">${tags[0].tagName}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</body>
<script src="/js/questionMain.js"></script>

<script src="/js/common.js"></script>
</html>
