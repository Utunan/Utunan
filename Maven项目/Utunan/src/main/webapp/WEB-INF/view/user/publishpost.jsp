<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <li id="active">发表的帖子</li>
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
                    <li>帖子收藏夹</li>
                </a>
            </nav>
        </nav>
        <div class="content">
            <div class="title">
                <span>发表的帖子</span>
            </div>
            <nav id="publishpost" class="publishpost">
                <li>
                    <div>
                        <span class="publishtime">2018.11.23</span>
                        <span class="posttitle">女神涵天下第一美</span>
                        <span class="publishtype">经验分享</span>
                    </div>
                    <p class="postcontent">
                        同学，祝贺你喜提彩蛋~
                        或许你们还在犹豫是否加入，我会坦诚的告诉你我们超酷；
                        在这里大家都用无人车代步，AI音箱不仅播放还可以交互；
                        人工智能是发展的核心技术，做自己让未来不只领先几步；
                    </p>
                    <span><a href="">收到的回复(15)</a></span>
                    <span><a href="">>>详细</a></span>
                </li>
                <li>
                    <div>
                        <span class="publishtime">2018.11.23</span>
                        <span class="posttitle">女神涵天下第一美</span>
                        <span class="publishtype">经验分享</span>
                    </div>
                    <p class="postcontent">
                        同学，祝贺你喜提彩蛋~
                        或许你们还在犹豫是否加入，我会坦诚的告诉你我们超酷；
                        在这里大家都用无人车代步，AI音箱不仅播放还可以交互；
                        人工智能是发展的核心技术，做自己让未来不只领先几步；
                    </p>
                    <span><a href="">收到的回复(15)</a></span>
                    <span><a href="">>>详细</a></span>
                </li>
                <li>
                    <div>
                        <span class="publishtime">2018.11.23</span>
                        <span class="posttitle">女神涵天下第一美</span>
                        <span class="publishtype">经验分享</span>
                    </div>
                    <p class="postcontent">
                        同学，祝贺你喜提彩蛋~
                        或许你们还在犹豫是否加入，我会坦诚的告诉你我们超酷；
                        在这里大家都用无人车代步，AI音箱不仅播放还可以交互；
                        人工智能是发展的核心技术，做自己让未来不只领先几步；
                    </p>
                    <span><a href="">收到的回复(15)</a></span>
                    <span><a href="">>>详细</a></span>
                </li>
                <li>
                    <div>
                        <span class="publishtime">2018.11.23</span>
                        <span class="posttitle">女神涵天下第一美</span>
                        <span class="publishtype">经验分享</span>
                    </div>
                    <p class="postcontent">
                        同学，祝贺你喜提彩蛋~
                        或许你们还在犹豫是否加入，我会坦诚的告诉你我们超酷；
                        在这里大家都用无人车代步，AI音箱不仅播放还可以交互；
                        人工智能是发展的核心技术，做自己让未来不只领先几步；
                    </p>
                    <span><a href="">收到的回复(15)</a></span>
                    <span><a href="">>>详细</a></span>
                </li>
                <li>
                    <div>
                        <span class="publishtime">2018.11.23</span>
                        <span class="posttitle">女神涵天下第一美</span>
                        <span class="publishtype">经验分享</span>
                    </div>
                    <p class="postcontent">
                        同学，祝贺你喜提彩蛋~
                        或许你们还在犹豫是否加入，我会坦诚的告诉你我们超酷；
                        在这里大家都用无人车代步，AI音箱不仅播放还可以交互；
                        人工智能是发展的核心技术，做自己让未来不只领先几步；
                    </p>
                    <span><a href="">收到的回复(15)</a></span>
                    <span><a href="">>>详细</a></span>
                </li>
            </nav>
            <nav class="page">
                <li class="home" ><a href="">首页</a></li>
                <li class="prev"><a href="">上一页</a></li>
                <li><a href="?page=1">1</a></li>
                <li><a href="?page=2">2</a></li>
                <li><a href="?page=3">3</a></li>
                <li><a href="?page=4">4</a></li>
                <li><a href="?page=5">5</a></li>
                <li class="next"><a href="">下一页</a></li>
                <li class="tail"><a href="">尾页</a></li>
            </nav>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
<script src="/js/usercommon.js"></script>
<script src="/js/common.js"></script>
</html>