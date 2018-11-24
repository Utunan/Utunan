<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${User==null}">
    <c:redirect url="/login"/>
</c:if>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎来到Utunan</title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/user/publishpost.css">
    <link rel="stylesheet" href="/css/user/usercommon.css">
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
</head>

<body>
<%@include file="../common/header.jsp"%>
<div class="container">
    <div class="wrapper">
        <div class="usercard">
            <div class="userheadimg">
                <img src="${User.userHeadImg}" alt="" srcset="">
            </div>
            <div class="countdown">
                <h4>2018年11月13日</h4>
                <h5>距离考试还有<span>555</span>天</h5>
            </div>
            <div class="userinfo">
                <div class="nickname">${User.userNickName}</div>
                <div class="schoolinfo">
                    <span>本科院校:${User.userSchool}</span>
                    <span>目标院校:${User.dreamSchool}</span>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container" style="margin-top: 30px;">
    <div class="wrapper background">
        <nav class="userfunction">
            <a href="/user/myspace">
                <li>
                    <img src="../images/user/userinfo.svg" alt="" srcset="">
                    <span>个人资料</span>
                </li>
            </a>
            <a href="/user/statistics">
                <li>
                    <img src="../images/user/statistics.svg">
                    <span>题库统计</span>
                </li>
            </a>
            <li id="community">
                <img src="../images/user/record.svg">
                <span>社区记录</span>
                <img src="../images/user/arrow.svg">
            </li>
            <nav class="postinfo" id="postinfo" style="height:100px;">
                <a href="/user/publishpost">
                    <li>发表的帖子</li>
                </a>
                <a href="/user/publishreply">
                    <li>发表的回复</li>
                </a>
            </nav>
            <li id="mycollection">
                <img src="../images/user/collection.svg">
                <span>我的收藏</span>
                <img src="../images/user/arrow.svg">
            </li>
            <nav class="collection" id="collection" style="height:150px;">
                <a href="/user/collectmatter">
                    <li>题目收藏夹</li>
                </a>
                <a href="/user/collectschool">
                    <li>院校收藏夹</li>
                </a>
                <a href="/user/collectpost">
                    <li id="active">帖子收藏夹</li>
                </a>
            </nav>
        </nav>
        <div class="content">

        </div>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
<script src="/js/usercommon.js"></script>

</html>