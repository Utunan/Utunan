<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎来到Utunan</title>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/user/userhome.css">
    <link rel="stylesheet" href="/css/user/usercommon.css">
</head>

<body>
<%@include file="../common/header.jsp" %>
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
                <li id="active">
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
                <a href="/user/publishquiz">
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
                <a href="/user/directioncollector">
                    <li>院校收藏夹</li>
                </a>
                <a href="/user/quizcollector">
                    <li>帖子收藏夹</li>
                </a>
                <a href="/user/questioncollector">
                    <li>题目收藏夹</li>
                </a>
            </nav>
        </nav>
        <div class="content">
            <div class="title">
                <span>个人资料</span>
            </div>
            <div class="userinfoform">
                <form id="userinfoform" action="/user/changeInfo" method="post">
                    <nav>
                        <li>
                            <label for="userNickName">昵&emsp;&emsp;称</label>
                            <input type="text" id="userNickName" name="userNickName" value="${User.userNickName}"
                                   placeholder="${User.userNickName}"/>
                        </li>
                        <li>
                            <label for="dreamSchool">目标院校</label>
                            <input type="text" id="dreamSchool" name="dreamSchool" value="${User.dreamSchool}"
                                   placeholder="${User.dreamSchool}"/>
                        </li>
                        <li>
                            <label for="userSchool">本科院校</label>
                            <input type="text" id="userSchool" name="userSchool" value="${User.userSchool}"
                                   placeholder="${User.userSchool}"/>
                        </li>
                        <li>
                            <label>绑定手机</label>
                            <input type="hidden" name="userTelephone" value="${User.userTelephone}"/>
                            <span style="line-height: 32px;">${User.userTelephone}<span/>
                        </li>
                        <li>
                            <label for="userEmail">绑定邮箱</label>
                            <input type="text" id="userEmail" name="userEmail" value="${User.userEmail}"
                                   placeholder="${User.userEmail}"/>
                        </li>
                        <li>
                            <label for="examTime">考研年份</label>
                            <input type="text" id="examTime" name="examTime" value="${User.examTime}"
                                   placeholder="${User.examTime}"/>
                        </li>
                        <li>
                            <label>注册时间</label>
                            <span>${User.registerTime}</span>
                        </li>
                        <li class="userop">
                            <button type="submit">提交</button>
                            <button type="reset">撤销</button>
                        </li>

                    </nav>
                </form>
            </div>

            <div class="changeheadimg">
                <img src="${User.userHeadImg}" alt="" srcset="">
                <h4><a href="">更改头像</a></h4>
            </div>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>
</body>
<script src="/js/usercommon.js"></script>
<script src="/js/common.js"></script>
</html>