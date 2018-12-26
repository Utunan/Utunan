<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="/intel" prefix="ya" %>
<%@ page import="java.util.List,com.utunan.pojo.*" %>

<html>
<head>
    <meta charset="utf-8">
    <title>帖子详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/css/community/layui.css">
    <link rel="stylesheet" href="/css/community/global.css">
    <link rel="stylesheet" href="/css/community/detail.css">
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/school/login.css">
    <link rel="stylesheet" href="/css/school/new.css">
    <link rel="stylesheet" href="/css/community/tagCloud.css">
    <link rel="stylesheet" href="/css/school/animate.css">
    <link rel="stylesheet" href="/css/school/dialog.css">
    <script type="text/javascript" src="/js/community/tagcloud.js"></script>
    <script type="text/javascript" src="https://unpkg.com/wangeditor@3.1.1/release/wangEditor.min.js"></script>
   <script src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
    <script> var pagenum = "${PageInfo.pageNum}"</script>
    <script>
        /*问题点赞*/
        function praise(quizId) {
            if(${user==null}){
                mask.style.display="block";
                modalDialogcontent.style.display="block";
            }else{
                $.ajax({
                    url: '/praise',//处理数据的地址
                    type: 'post',//数据提交形式
                    data: {'quizId': quizId},//需要提交的数据
                    dataType: "json",
                    success: function (data) {//数据返回成功的执行放大
                        var res = data.res;
                        var praiseCount = data.qPraise;
                        if (res=='ok') {//成功
                            document.getElementById("i"+quizId).innerHTML=praiseCount;
                            document.getElementById("zan"+quizId).style.color="#ff5722";
                            console.log("成功点赞")
                        }
                        if (res=='no') {//失败
                            document.getElementById("i"+quizId).innerHTML=praiseCount;
                            document.getElementById("zan"+quizId).style.color="#333";
                            console.log("取消点赞")
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        bootbox.alert("无法连接服务器:" + textStatus);
                    }
                });
            }
        }
    </script>

    <script>
        /*评论点赞*/
        function apraise(answerId) {
            if(${user==null}){
                mask.style.display="block";
                modalDialogcontent.style.display="block";
            }else{
                $.ajax({
                    url: '/aprise',//处理数据的地址
                    type: 'post',//数据提交形式
                    data: {'answerId': answerId},//需要提交的数据
                    dataType: "json",
                    success: function (d) {//数据返回成功的执行放大
                        var res = d.res;
                        var praiseCount = d.answerPraiseCount;
                        if (res == 'ok') {//成功点赞
                            document.getElementById("answerZan"+answerId).style.color="#ff5722";
                            document.getElementById("answer"+answerId).innerHTML=praiseCount;
                            console.log("成功点赞")
                        }
                        if (res == 'no') {//取消点赞
                            document.getElementById("answerZan"+answerId).style.color="#333";
                            document.getElementById("answer"+answerId).innerHTML=praiseCount;
                            console.log("取消点赞")
                        }
                    },
                });
            }
        }
    </script>
</head>
<body style="overflow:scroll;overflow-y:hidden">
<body>
<%@include file="../common/header.jsp" %>
<%--黑背景--%>
<div class="mask"></div>
<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8 content detail">
            <div class="fly-panel detail-box">
                <div class="detail-about">
                    <a class="fly-avatar" href="/member/${quiz.user.userId}">
                        <img src="${quiz.user.userHeadImg}" width="35px" height="35px">
                    </a>
                    <div class="fly-detail-user">
                        <a href="/member/${quiz.user.userId}" class="fly-link">
                            <cite>${quiz.user.userNickName}</cite>
                        </a>
                        <span>发表于&nbsp;
                    <fmt:formatDate value="${quiz.releaseTime}" type="both"/>
                </span>
                    </div>
                    <div class="detail-hits" id="LAY_jieAdmin" data-id="123">
                        <span style="padding-right: 10px; color: #FF7200">考研年份：${quiz.user.examTime}</span>
                        <span style="padding-right: 10px; color: #FF7200">所在院校：${quiz.user.userSchool}</span>
                        <span style="padding-right: 10px; color: #FF7200">目标院校：${quiz.user.dreamSchool}</span>
                    </div>
                </div>
                <h1>${quiz.quizTitle}</h1>
                <div class="fly-detail-info">
                    <c:forEach items="${quizTagList}" var="quiztag">
                        <span class="layui-badge layui-bg-red"><a
                                href="/quiztag/${quiztag.tag.tagName}/rt/1">&nbsp;${quiztag.tag.tagName} &nbsp</a></span>
                    </c:forEach>
                </div>
                <div class="quizcontent">
                    <div class="detail-body photos">
                        <p id="pcontent"> ${quiz.quizContent}</p>
                        <div class="quiztoolbar">

                            <div class="jieda-reply" id="good">
                              <span class="jieda-zan zanok" type="zan">
                                  <c:choose>
                                      <c:when test="${not empty quizGreat}">  <%--如果用户已经点赞，显示红赞--%>
                                          <a style="color: #ff5722;" id="zan${quiz.quizId}" href="javascript:void(0)" onclick="praise(${quiz.quizId})"><i class="iconfont icon-zan"></i></a>
                                          <em ><span id="i${quiz.quizId}">${quiz.praiseCount}</span></em>
                                      </c:when>
                                      <c:otherwise>  <%--没有点赞，显示灰色--%>
                                          <a style="color: #333;" id="zan${quiz.quizId}" href="javascript:void(0)" onclick="praise(${quiz.quizId})"><i class="iconfont icon-zan"></i></a>
                                          <em ><span id="i${quiz.quizId}">${quiz.praiseCount}</span></em>
                                      </c:otherwise>
                                  </c:choose>
                              </span>
                            </div>
    
                            <div class="re_num">
                                <img src="/images/community/zan.svg" width="24px" height="34px">
                                <span class="write-reply">${answerCountByQuizId}</span>
                            </div>
                            <div class="collect">
                                <c:choose>
                                    <c:when test="${ya:judge(quizIds,quiz.quizId)}">
                                        <a href="javascript:void(0);" onclick="collector(${quiz.quizId})"><img
                                                id="collect${quiz.quizId}" src="/images/school/redheart.svg"
                                                width="20px" height="20px" alt="" srcset=""></a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="javascript:void(0);" onclick="collector(${quiz.quizId})"><img
                                                id="collect${quiz.quizId}" src="/images/school/whiteheart.svg"
                                                width="20px" height="20px" alt="" srcset=""></a>
                                    </c:otherwise>
                                </c:choose>
                                <span class="collection">收藏此问题</span>
                                <%--判断是否是用户本人--%>
                                <c:if test="${user.userIdentity==3 && user.userId==quiz.user.userId}">
                                  <span type="reply">
                                    <i class="iconfont icon-svgmoban53"></i>
                                    <a href="/delquiz/${quiz.quizId}">删除</a>
                                  </span>
                                </c:if>
                            </div>
                        </div><!--toolbar-->
                    </div><!--quizcontent-->
                </div>
            </div>
    
            <div class="fly-panel detail-box" id="flyReply">
                <fieldset class="layui-elem-field layui-field-title" style="text-align: center;">
                    <legend>回答</legend>
                </fieldset>
                <select class="sequencing-principle" name="" onchange="self.location.href=options[selectedIndex].value">
                    <option value="/quiz/${quiz.quizId}" ${timeselect}>按时间顺序</option>
                    <option value="/displayCommentByPraiseCount?quizId=${quiz.quizId}"  ${praiseselect}>按热度排序</option>
                </select>
                <ul class="jieda" id="jieda">
                    <c:forEach items="${answer}" var="answer" varStatus="cou">
                        <li data-id="111" class="jieda-daan" id="an${answer.answerId }">
                            <a name="item-1111111111"></a>
                            <div class="detail-about detail-about-reply">
                                <a class="fly-avatar" href="">
                                    <img src="${answer.user.userHeadImg}" width="55px" height="55px">
                                </a>
                                <div class="fly-detail-user">
                                    <a href="" class="fly-link">
                                        <cite>${answer.user.userNickName}</cite>
                                    </a>
                                    <span>发表于
                                        <fmt:formatDate value="${answer.answerTime}" type="both"/>
                                    </span>
                                </div>
    
                                <div class="detail-hits">
                                    <span>所在院校：${answer.user.userSchool}&nbsp;&nbsp;&nbsp;目标院校：${answer.user.dreamSchool}</span>
                                </div>
                            </div>
                            <div class="detail-body jieda-body photos">
                                <p>${answer.answerContent}</p>
                            </div>
                            <div class="jieda-reply">
                                <%--评论点赞--%>
                                <span class="jieda-zan zanok" type="zan">
                                    <c:choose>
                                        <c:when test="${ya:judge(answerGreatList,answer.answerId)}">
                                            <a style="color: #ff5722;" id="answerZan${answer.answerId}" href="javascript:void(0)" onclick="apraise(${answer.answerId})"><i class="iconfont icon-zan"></i></a>
                                            <em id="answer${answer.answerId}">${answer.praiseCount}</em>
                                        </c:when>
                                        <c:otherwise>
                                            <a style="color: #333;" id="answerZan${answer.answerId}" href="javascript:void(0)" onclick="apraise(${answer.answerId})"><i class="iconfont icon-zan"></i></a>
                                            <em id="answer${answer.answerId}">${answer.praiseCount}</em>
                                        </c:otherwise>
                                    </c:choose>
                                </span>
                                <span type="reply" class="write-reply">
                                    <i class="iconfont icon-svgmoban53"></i>
                                    回复
                                </span>
                                <%--判断是否是用户本人--%>
                                <c:if test="${user.userIdentity==3 && user.userId==answer.user.userId}">
                                      <span>
                                        <i class="iconfont icon-svgmoban53"></i>
                                        <a href="javascript:void(0)" onclick="delanswer(${answer.answerId})">删除</a>
                                      </span>
                                </c:if>
                                <div class="jieda-admin">
                                    <c:forEach items="${map0.keySet()}" var="b">
                                        <c:if test="${b.answerId==answer.answerId}">
                                            <div class="view-comments">查看评论（<span id="f1${answer.answerId }">${map0.get(b)}</span>）</div>
                                            <c:set var="commentNum" value="${map0.get(b)}"/>
                                        </c:if>
                                    </c:forEach>
                                </div>
                                <div class="comments" style="display:none" id="ddt${answer.answerId}">
                                    <blockquote class="layui-elem-quote" id="haha" style="background-color:#fafafa">
                                        <select class="comments-sequencing-principle" name="" id="sq">
                                            <option value="0">按时间顺序</option>
                                            <option value="1">按热度排序</option>
                                        </select>
                                        <div class="close">收起评论</div>
                                        <c:if test="${commentNum==0}">
                                            <div class="slogen" id="slogen${answer.answerId}">啊嘞！还没有评论~</div>
                                        </c:if>

                                    <c:if test="${commentNum!=0}">
                                        <ul class="commentlist" style="background-color:#fafafa" id="can${answer.answerId}">
                                            <c:forEach items="${map.keySet()}" var="m1">
                                                <c:if test="${m1.answerId==answer.answerId}">
                                                    <c:forEach items="${map.get(m1)}" var="m2">
                                                        <li id="co${m2.answerId }">
                                                            <div class="fly-detail-user">
                                                                <a href="" class="fly-link">
                                                                    <cite>${m2.user.userNickName}</cite>
                                                                </a>
                                                                <span>发表于<fmt:formatDate value="${m2.getAnswerTime() }" type="both"/></span>
                                                            </div>
                                                            <div class="detail-body jieda-body photos">
                                                                <p>${m2.answerContent}</p>
                                                            </div>
                                                            <div class="jieda-reply">
                                                              <span class="jieda-zan zanok" type="zan">
                                                              <i class="iconfont icon-zan"></i>
                                                              <em>${m2.praiseCount}</em>
                                                              </span>
                                                              <%--判断是否是用户本人--%>
                                                                <c:if test="${user.userIdentity==3 && user.userId==answer.user.userId}">
                                                                      <span type="reply">
                                                                        <i class="iconfont icon-svgmoban53"></i>
                                                                        <a href="javascript:void(0)" onclick="delcomment(${m2.answerId },${answer.answerId})">删除</a>
                                                                      </span>
                                                                </c:if>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </c:if>
                                            </c:forEach><!--评论循环完毕-->
                                        </ul>
                                    </c:if>
                                        <div class="reply" style="display: none;">
                                            <form name="smallform" action="" method="post" onsubmit="return false" id="commenta${answer.answerId}">
                                                <input type="text" name="comment" id="comment${answer.answerId}">
                                                <button type="submit"  onclick="comments(${answer.answerId},${quiz.quizId})">回复</button>
                                            </form>
                                        </div>
                                  </blockquote>
                                </div>
                            </div>
                        </li>
                        <!--a answer-->
                    </c:forEach>
                </ul>
    
                <div class="write-answer" class="layui-form layui-form-pane">
                    <div class="write-answer-top">
                        <img src="/images/community/write.svg" width="25px" height="25px">
                        <div class="write-answer-top">&nbsp;&nbsp;&nbsp;&nbsp;写回答</div>
                    </div>
                    <!--富文本编辑器-->
                    <form name="fuform" onsubmit="return false" action="/answer?quizId=${quiz.quizId}" method="post">
                        <div class="text">
    
                            <div id="div1" class="toolbar" style="height: 35px"></div>
                            <div id="div2" style="height: 130px"></div>
                            <textarea id="text1" style="display: none" name="textarea"></textarea>
    
                        </div>
                        <div class="write-answer-bottom">
                            <div class="write-answer-bottom-content">
                                <button id="comsub" type="submit" class="layui-btn layui-btn-fluid">提交回答</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="right.jsp" %>
    </div>
</div>
</body>
<script type="text/javascript">
    /*3D标签云*/
    var radius = document.getElementById("layui-col-md4").offsetWidth;
    console.log(radius);
    tagcloud({
        selector: ".tagcloud",  //元素选择器
        fontsize: 16,       //基本字体大小, 单位px
        radius: radius * 0.2,         //滚动半径, 单位px
        mspeed: "normal",   //滚动最大速度, 取值: slow, normal(默认), fast
        ispeed: "normal",   //滚动初速度, 取值: slow, normal(默认), fast
        direction: 0,     //初始滚动方向, 取值角度(顺时针360): 0对应top, 90对应left, 135对应right-bottom(默认)...
        keep: false          //鼠标移出组件后是否继续随鼠标滚动, 取值: false, true(默认) 对应 减速至初速度滚动, 随鼠标滚动
    });
</script>
<script>
    //展开评论
    var viewComments = window.document.getElementsByClassName("view-comments");
    var index;
    for (var i = 0; i < viewComments.length; i++) {
        viewComments[i].index = i;
        viewComments[i].onclick = function () {
            var j = this.index;
            var comments = this.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("comments");
            comments[j].style.display = "block"
        }
    }

    //收起评论
    var close = window.document.getElementsByClassName("close");
    for (var i = 0; i < close.length; i++) {
        close[i].index = i;
        close[i].onclick = function () {
            var j = this.index;
            var comments = this.parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("comments");
            comments[j].style.display = "none";
            var replyContent=comments[j].getElementsByClassName("reply")[0];
            replyContent.style.display = "block";
        }
    }
    //回复评论的评论
    var reply=document.getElementsByClassName("write-reply");
    for (var i = 0; i < reply.length; i++) {
        reply[i].index = i;
        reply[i].onclick = function () {
            var j = this.index-1;
            var comments = this.parentElement.parentElement.parentElement.getElementsByClassName("comments");
            comments[j].style.display = "block";
            var replyContent=comments[j].getElementsByClassName("reply")[0];
            replyContent.style.display = "block";
    
        }
    }


    //富文本
    var E = window.wangEditor
    var editor = new E('#div1', '#div2')
    editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
    editor.customConfig.uploadImgMaxSize = 1 * 1024 * 1024   //每张图片最大上传大小
    editor.customConfig.uploadImgMaxLength = 5              //每次最多上传5张
    var $text1 = $('#text1')
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $text1.val(html)
    }
    //自定义菜单
    editor.customConfig.menus = [
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
<script src="/js/common/login.js"></script>
<script src="/js/common/common.js"></script>
<script src="/js/community/tag.js"></script>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script>
    /*获取提交按钮*/
    var submitbutton = document.getElementById("submitbutton");
    /*点击评论提交判断是否是用户，不是用户则弹出框*/
    var ask=document.getElementById("comsub");
    /*获取文本框*/
    var text1 = document.getElementById("text1");

    ask.onclick = function (){
        if(${user==null}){
            mask.style.display="block";
            modalDialogcontent.style.display="block";
        }else{
            //判断文本框是否为空
            var str1 = text1.value.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
            if(str1 == '' || str1 == undefined || str1 == null){
                //文本框为空
                javascript:$('body').dialog({type:'success'});
            }else{
                //满足条件，可以提交
                document.fuform.submit();
            }
        }
    };
    //判断用户名和密码
    submitbutton.onclick=function(){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/school/popsupLogin" ,//url
            data: $('#loginform').serialize(),
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if(result==true){
                    console.log("登录成功");
                    window.location.href="/quiz/${quiz.quizId}";
                }else{
                    textpassword.style.display="block";
                    password.style.display="none";
                    textpassword.parentNode.style.border = '1px solid red';
                    textpassword.style.color="red";
                    textpassword.value="密码错误";
                }
            },
            error : function() {
                console.log("网崩了！")
            }
        });
    };
</script>
<script src="/js/common/login.js"></script>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>

<%--ajax异步提交表单--%>
<script>
    function comments(answerId,quizId) {
        if(${user==null}){
            mask.style.display="block";
            modalDialogcontent.style.display="block";
        }else{
            //判断文本框是否为空
            var str2 = document.getElementById("comment"+answerId).value.replace(/(^\s*)|(\s*$)/g, '');//去除空格;
            if(str2 == '' || str2 == undefined || str2 == null){
                //文本框为空
                javascript:$('body').dialog({type:'success'});
            }else{
                //满足条件，可以提交
                $.ajax({
                    url: '/answer1/'+answerId+'/'+quizId,//处理数据的地址
                    dataType: "json",//预期服务器返回的数据类型
                    type: 'post',//数据提交形式
                    data: {"text":$('#comment'+answerId).val()},//需要提交的数据
                    success: function (data) {//数据返回成功的执行放大
                        console.log(data);
                        // 清空文本框内容
                        document.getElementById("commenta"+answerId).reset();
                        // 对json日期对象进行格式化
                        var date=new Date();
                        date.setTime(data['reb']['answerTime']['time']);
                        var y = date.getFullYear();
                        var m = date.getMonth()+1;
                        m = m<10?'0'+m:m;
                        var d = date.getDate();
                        d = d<10?("0"+d):d;
                        var h = date.getHours();
                        h = h<10?("0"+h):h;
                        var M = date.getMinutes();
                        M = M<10?("0"+M):M;
                        var S = date.getSeconds();
                        S = S<10?("0"+S):S;
                        var str = y+"-"+m+"-"+d+" "+h+":"+M+":"+S;
                        if(${commentNum!=0}) {
                            node = '<li><div class="fly-detail-user"><a href="" class="fly-link"><cite>' + data['reb']['user']['userNickName'] + '</cite></a><span>发表于' + str + '</span></div><div class="detail-body jieda-body photos"><p>'+data['reb']['answerContent']+'</p></div><div class="jieda-reply"><span class="jieda-zan zanok" type="zan"><i class="iconfont icon-zan"></i><em>'+data['reb']['praiseCount']+'</em></span><span type="reply"><i class="iconfont icon-svgmoban53"></i><a href="javascript:void(0)" onclick="delcomment('+data['reb']['answerId']+','+data['reb']['parentAnswer']+')">删除</a></span></div></li>'
                            $('#can' + answerId).append(node);
                        }
                        else{
                            $("#slogen"+answerId).css("display","none");
                            snode = '<ul class="commentlist" style="background-color:#fafafa" id="can'+answerId+'"><li><div class="fly-detail-user"><a href="" class="fly-link"><cite>' + data['reb']['user']['userNickName'] + '</cite></a><span>发表于' + str + '</span></div><div class="detail-body jieda-body photos"><p>'+data['reb']['answerContent']+'</p></div><div class="jieda-reply"><span class="jieda-zan zanok" type="zan"><i class="iconfont icon-zan"></i><em>'+data['reb']['praiseCount']+'</em></span><span type="reply"><i class="iconfont icon-svgmoban53"></i><a href="javascript:void(0)" onclick="delcomment('+data['reb']['answerId']+','+data['reb']['parentAnswer']+')">删除</a></span></div></li></ul>';
                            $('#ddt'+answerId).append(snode);
                        }

                        document.getElementById("f1"+answerId).innerHTML=parseInt(document.getElementById("f1"+answerId).innerHTML)+1;
                    }
                });

            }
        };
    };
    
    // 登录用户对回答进行删除
    function delanswer(answerId) {
        $.ajax({
            type: "get",//发送方式
            url: "/delanswer/"+answerId,//url地址
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if (result == "ok") {
    
                    $('#an'+answerId).css("display","none");
                }
            }
        });
    };
    // 登录用户对评论进行删除
    function delcomment(answerId,parentanswerId) {
        $.ajax({
            type: "get",//发送方式
            url: "/delcomment/"+answerId+"/"+parentanswerId,//url地址
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if (result == "ok") {
                    document.getElementById("f1"+answerId).innerHTML=parseInt(document.getElementById("f1"+answerId).innerHTML)-1;
                    if(parseInt(document.getElementById("f1"+answerId).innerHTML)!=0){
                        $("#slogen"+answerId).css("display","block");
                    }
                    $('#co'+answerId).css("display","none");
                }
            }
        });
    };
</script>
<script charset="UTF-8" type="text/javascript"  src="/js/school/dialog.js"></script>
</body>
</html>