<%--
此为quiz、detail里引用的右侧边栏
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/school/login.css">
<%--黑背景--%>
<%--<div class="mask"></div>--%>
<div class="layui-col-md4" id="layui-col-md4">
    <div class="fly-panel">
        <div class="fly-panel-main">
            <a href="javascript:void(0);" id="question" target="_blank" class="fly-zanzhu" style="background-color: #393D49;">发表提问</a>
        </div>
    </div>

    <dl class="fly-panel fly-list-one">
        <!--选出4个相似度最高的问题-->
        <dt class="fly-panel-title">相似问答推荐</dt>
        <c:forEach items="${quizListRecommand}" var="q">
            <dd>
                <a href="/quiz/${q.quizId}">${q.quizTitle }</a>
                <span><i class="iconfont icon-pinglun1"></i>${q.answerCount }</span>
            </dd>
        </c:forEach>
    </dl>

    <dl class="fly-panel fly-list-one">
        <!--选出10个评论数最高的问题-->
        <dt class="fly-panel-title">本周热议</dt>
        <c:forEach items="${quizListTop10}" var="q">
            <dd>
                <a href="/quiz/${q.quizId}">${q.quizTitle }</a>
                <span><i class="iconfont icon-pinglun1"></i>${q.answerCount }</span>
            </dd>
        </c:forEach>
    </dl>

    <div class="fly-panel fly-link">
        <h3 class="fly-panel-title">热门标签</h3>
        <div class="wrapper1">
            <div class="tagcloud fl">
                <c:forEach items="${tag}" var="tags">
                    <a href="/quiztag/${tags[0].tagName}/rt/1" target="_blank" class="tag">${tags[0].tagName}&nbsp;&nbsp;${tags[1]}</a>
                </c:forEach>
            </div>
        </div><!--wrapper-->
    </div>
</div>
<%--弹窗登录表单--%>
<%@include file="../common/login.jsp"%>

<script>
    /*弹窗登录功能*/
    var ask=document.getElementById("question");
    var mask=document.getElementsByClassName("mask")[0];
    var modalDialogcontent=document.getElementsByClassName("modalDialogcontent")[0];
    /*/!*获取提交按钮*!/
    var submitbutton = document.getElementById("submitbutton");*/
    /*获取密码框*/
    password = document.getElementById('password');
    textpassword=document.getElementById("login_showPwd");

    /*点击评论提交判断是否是用户，不是用户则弹出框*/
    ask.onclick=function(){
        if(${user==null}){
            mask.style.display="block";
            modalDialogcontent.style.display="block";
        }else{
            window.location.href="/toAddQuestion";
        }
    };

</script>
<script src="/js/common/login.js"></script>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>