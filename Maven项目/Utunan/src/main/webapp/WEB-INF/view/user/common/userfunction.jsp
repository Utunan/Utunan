<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav id="userfunction" class="userfunction">
    <input type="hidden" id="currentplate" value="${plate}">
    <a href="/user/myspace#anchor">
        <li>
            <img src="/images/user/home.svg" alt="" srcset="">
            <span>个人资料</span>
        </li>
    </a>
    <a href="/user/information#anchor">
        <li>
            <img src="/images/user/information.svg" alt="" srcset="">
            <span>消息通知</span>
        </li>
    </a>
    <a href="/user/follow#anchor">
        <li>
            <img src="/images/user/follow.svg" alt="" srcset="">
            <span>关注用户</span>
        </li>
    </a>
    <a href="/user/statistics#anchor">
        <li>
            <img src="/images/user/statistics.svg">
            <span>题库统计</span>
        </li>
    </a>
    <li id="community">
        <img src="/images/user/record.svg">
        <span>社区记录</span>
        <img src="/images/user/arrow.svg">
    </li>
    <nav class="postinfo" id="postinfo" style="height:80px;">
        <a href="/user/publishquiz#anchor">
            <li>发表的问答</li>
        </a>
        <a href="/user/publishanswer#anchor">
            <li>发表的回复</li>
        </a>
    </nav>
    <li id="mycollection">
        <img src="/images/user/collection.svg">
        <span>我的收藏</span>
        <img src="/images/user/arrow.svg">
    </li>
    <nav class="collection" id="collection" style="height:120px;">
        <a href="/user/directioncollector#anchor">
            <li>院系收藏夹</li>
        </a>
        <a href="/user/quizcollector#anchor">
            <li>问答收藏夹</li>
        </a>
        <a href="/user/questioncollector#anchor">
            <li>题目收藏夹</li>
        </a>
    </nav>
    <a href="/user/settings#userfunction">
        <li>
            <img src="/images/user/settings.svg" alt="" srcset="">
            <span>用户设置</span>
        </li>
    </a>
    <c:choose>
        <c:when test="${User.userIdentity=='1'}">
            <a href="/admin">
                <li>
                    <img src="/images/user/backstage.svg" alt="" srcset="">
                    <span>后台管理</span>
                </li>
            </a>
        </c:when>
    </c:choose>
</nav>
