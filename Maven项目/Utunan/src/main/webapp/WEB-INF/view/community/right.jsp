<%--
此为quiz、detail里引用的右侧边栏
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-col-md4" id="layui-col-md4">
    <div class="fly-panel">
        <div class="fly-panel-main">
            <a href="/toAddQuestion" target="_blank" class="fly-zanzhu" style="background-color: #393D49;">发表提问</a>
        </div>
    </div>

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