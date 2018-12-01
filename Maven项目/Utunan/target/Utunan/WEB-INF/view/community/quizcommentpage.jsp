<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2018/11/24
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List,com.utunan.pojo.*"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" type="text/css" href="/css/community/question.css"/>
    <script type="text/javascript" src="https://unpkg.com/wangeditor@3.1.1/release/wangEditor.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
    <title>问题页面</title>
</head>
<body>
<%@include file="../common/header.jsp"%>
    <!--
    问题：${quiz.quizTitle}<br/>
    用户：${quiz.user.userNickName}<br/>
    发表时间：${quiz.releaseTime}<br/>
    标签：
    <c:forEach items="${quizTagList}" var="quiztag">
        ${quiztag.tag.tagName} &nbsp;
    </c:forEach>
    <br/>
    内容：${quiz.quizContent}<br/>
    点赞数：${quiz.praiseCount}<br/>
    评论数：${commentCountByQuizId}<br/>
    评论有：

    <table>
        <tr>
            <td>评论楼层</td>
            <td>评论人</td>
            <td>评论时间</td>
            <td>考研年份</td>
            <td>所在院校</td>
            <td>目标院校</td>
            <td>评论内容</td>
            <td>点赞数</td>
            <td>子评论</td>
        </tr>
    <c:forEach items="${answerListByQuizId}" var="answer" varStatus="cou">
        <tr>
        <td>${cou.count}</td>
        <td>${answer.user.userNickName}</td>
        <td>${answer.commentTime}</td>
        <td>${answer.user.examTime}</td>
        <td>${answer.user.userSchool}</td>
        <td>${answer.user.dreamSchool}</td>
        <td>${answer.commentContent}</td>
        <td>${answer.commentPraiseCount}</td>
        <td>
        <%--<c:forEach items="${obj.tagList}" var="taglist">
            ${taglist.tagName}&nbsp;&nbsp;&nbsp;
        </c:forEach>--%>
            <a href="#">查看子评论</a>
        </td>
        </tr>
    </c:forEach>
    </table>
    -->

<div class="content">
    <div class="question">
        <div class="post-top">
            <div class="question-title">
                ${quiz.quizTitle}
            </div>

            <!--包括发帖用户的头像，昵称，发表时间-->
            <div class="post-information">
                <img src="${quiz.user.userHeadImg}" width="35px"height="35px">
                <a href="#">${quiz.user.userNickName}</a><div class="informationwords">发表于&nbsp;2${quiz.releaseTime}</div>
            </div>
        </div>
        <div class="post-tags">
            <c:forEach items="${quizTagList}" var="quiztag">
                <a href="#">&nbsp;${quiztag.tag.tagName} &nbsp</a>
            </c:forEach>
        </div>
        <div class="question-content">
            ${quiz.quizContent}
            <!--
            typedef struct book<br>
            {<br>
            int number;<br>
            char name[20];<br>
            int jaige;<br>
            }stumes;<br>
            这里插入的是头结点吗？
            -->
        </div>
        <div class="post-bottom">
            <!--数据库获取-->
            <div class="praise">赞（${quiz.praiseCount}）</div>
            <a href="praise?quizId=${quiz.quizId}"><img src="/images/community/jia1.svg" width="34px"height="34px"></a>
            <div class="give-praise">点赞</div>
            <img src="/images/community/shoucang.svg" width="34px"height="34px">
            <div class="collection">收藏此问题</div>
            <img src="/images/community/zan.svg" width="34px"height="34px">
            <div class="write-reply">写回答</div>
        </div>
    </div>
    <div class="answers">
        <div class="answers-num">一共有${commentCountByQuizId}条评论</div>
        <select class="sequencing-principle"name="" onchange="self.location.href=options[selectedIndex].value">
            <option value="/displayQuizByQuizId?quizId=${quiz.quizId}" ${timeselect}>按时间顺序</option>
            <option value="/displayCommentByPraiseCount?quizId=${quiz.quizId}"  ${praiseselect}>按热度排序</option>
        </select>
    </div>
    <div class="answers-content">
        <c:forEach items="${answerListByQuizId}" var="answer" varStatus="cou">
        <div class="reply">
            <div class="reply-top">
                <img src="${answer.user.userHeadImg}"width="55px"height="55px">
                <div class="reply-top-center">
                    <a href="#">${answer.user.userNickName}</a>
                    <div class="description">
                        <div class="year">考研年份：${answer.user.examTime}</div>
                        <div class="school">所在院校：${answer.user.userSchool}</div>
                        <div class="dream-school">目标院校：${answer.user.dreamSchool}</div>
                    </div>
                </div>
                <div class="reply-right">发表于&nbsp;${answer.commentTime}&nbsp;</div>
            </div>
            <div class="reply-content">
                <p>${answer.commentContent}</p>
            </div>
            <div class="reply-evaluation">
                <div class="a">
                    <div class="reply-praise">赞（${answer.commentPraiseCount}）</div>
                    <a href="praise?quizId=${quiz.quizId}"><img src="/images/community/jia1.svg" width="34px"height="34px"></a>
                    <div class="reply-give-praise">点赞</div>
                    <img src="/images/community/zan.svg" width="34px"height="34px">
                    <div class="view-comments">查看评论</div>
                </div>
            </div>
        </div>
        <div class="comments">
            <div class="comments-number">
                <div class="answers-num">一共有15条评论</div>
                <div class="right">
                    <select class="comments-sequencing-principle"name="">
                        <option value="0">按时间顺序</option>
                        <option value="1">按热度排序</option>
                    </select>
                    <div class="close">收起评论</div>
                </div>
            </div>
            <div class="comments-content">
                <div class="time">2018.11.25</div>
                <div class="nickname">这是一个昵称</div>
                <div class="comments-content-content">吧啦吧啦吧啦吧啦吧啦吧</div>
                <div class="b">
                    <div class="comments-content-praise">赞（528）</div>
                    <img src="images/community/jia1.svg" width="22px"height="22px">
                    <div class="comments-content-give-praise">点赞</div>
                </div>
            </div>
            <form action="comment1?commentId=${answer.commentId}" method="post">
                <div class="comments-reply">
                    <input class="comments-reply-input"type="text" width="660px" height="30px" name="text">
                    <div class="comments-reply-report"><input type="submit" value="发表评论"/></div>
                </div>
            </form>
        </div>
        </c:forEach>
        <div class="page">
            <a href="/${url }?quizId=${quiz.quizId}&pageNum=1">第一页</a>
            <a href="/${url }?quizId=${quiz.quizId}&pageNum=${page.prePageNum }">上一页</a>
            <a href="/${url }?quizId=${quiz.quizId}&pageNum=${page.nextPageNum }">下一页</a>
            <a href="/${url }?quizId=${quiz.quizId}&pageNum=${page.totalPageNum }">末页</a>
        </div>
    </div>
    <div class="write-answer">
        <div class="write-answer-top">
            <img src="/images/community/write.svg" width="25px"height="25px">
            <div class="write-answer-top">写回答</div>
        </div>
        <!--富文本编辑器-->
        <form action="answer?quizId=${quiz.quizId}" method="post">
        <div class="text" >

               <div id="div1" class="toolbar" style="height: 35px"></div>
               <div id="div2"  style="height: 130px"></div>
               <textarea id="text1" style="display: none" name="textarea"></textarea>

        </div>
        <div class="write-answer-bottom">
            <div class="write-answer-bottom-content">                    <div class="identifying-code">验证码：<input type="text"></div>
                <button type="submit">提交回答</button>
            </div>
        </div>
        </form>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
<script src="/js/common/common.js"></script>
<script>
var viewComments=window.document.getElementsByClassName("view-comments");
var index;
for(var i=0;i<viewComments.length;i++){
    viewComments[i].index=i;
    viewComments[i].onclick = function(){
        var j=this.index;
        var comments=this.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("comments");
        comments[j].style.display="block"
    }
}

var close=window.document.getElementsByClassName("close");
for(var i=0;i<close.length;i++){
    close[i].index=i;
    close[i].onclick = function(){
        var j=this.index;
        var comments=this.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("comments");
        comments[j].style.display="none"
    }
}
<!--footer-->
</script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#div1','#div2')
    editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
    editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024   //每张图片最大上传大小
    editor.customConfig.uploadImgMaxLength = 5              //每次最多上传5张
    var $text1 = $('#text1')
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $text1.val(html)
    }
    //自定义菜单
    editor.customConfig.menus=[
        'head',  // 标题
        'bold',  // 粗体
        'fontSize',  // 字号
        'fontName',  // 字体
        'italic',  // 斜体
        'underline',  // 下划线
        'strikeThrough',  // 删除线
        'foreColor',  // 文字颜色
        'backColor',  // 背景颜色
        'link',  // 插入链接
        'list',  // 列表
        'quote',  // 引用
        'emoticon',  // 表情
        'image',  // 插入图片
        'table',  // 表格
        'code'  // 插入代码
    ]
    editor.create()
</script>
</html>
