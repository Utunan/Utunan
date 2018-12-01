<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav id="userfunction" class="userfunction">
    <input type="hidden" id="currentplate" value="${plate}">
    <a href="/user/myspace#userfunction">
        <li>
            <img src="/images/user/home.svg" alt="" srcset="">
            <span>个人资料</span>
        </li>
    </a>
    <a href="/user/information#userfunction">
        <li>
            <img src="/images/user/information.svg" alt="" srcset="">
            <span>消息通知</span>
        </li>
    </a>
    <a href="/user/follow#userfunction">
        <li>
            <img src="/images/user/follow.svg" alt="" srcset="">
            <span>关注用户</span>
        </li>
    </a>
    <a href="/user/statistics#userfunction">
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
    <nav class="postinfo" id="postinfo" style="height:100px;">
        <a href="/user/publishquiz#userfunction">
            <li>发表的问答</li>
        </a>
        <a href="/user/publishreply#userfunction">
            <li>发表的回复</li>
        </a>
    </nav>
    <li id="mycollection">
        <img src="/images/user/collection.svg">
        <span>我的收藏</span>
        <img src="/images/user/arrow.svg">
    </li>
    <nav class="collection" id="collection" style="height:150px;">
        <a href="/user/directioncollector#userfunction">
            <li>院校收藏夹</li>
        </a>
        <a href="/user/quizcollector#userfunction">
            <li>帖子收藏夹</li>
        </a>
        <a href="/user/questioncollector#userfunction">
            <li>题目收藏夹</li>
        </a>
    </nav>
    <a href="/user/settings#userfunction">
        <li>
            <img src="/images/user/settings.svg" alt="" srcset="">
            <span>用户设置</span>
        </li>
    </a>
</nav>
