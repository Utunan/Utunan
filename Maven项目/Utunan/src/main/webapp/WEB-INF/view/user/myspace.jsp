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
    <link rel="stylesheet" href="/css/userhome.css">
    <link rel="stylesheet" href="/css/usercommon.css">
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
</head>

<body>
<div class="header">
    <header>
        <div class="logo">
            <img src="/images/favicon.ico" alt="" srcset="">
        </div>
        <a class="loginname" href="">优图南</a>
        <div class="login">
            <span><a href="">登陆</a></span><span><a href="">注册</a></span>
        </div>
        <div class="search">
            <form action="aaa" method="get" onsubmit="return true">
                <div class="text">
                    <input type="text" name="keyword" placeholder="请输入内容" />
                    <button style="" type="submit"><img src="/images/search.png" /></button>
                </div>

            </form>
        </div>

        <nav class="banner">
            <li>
                <a href="">题库</a>
            </li>
            <li>
                <a href="">院校库</a>
            </li>
            <li>
                <a href="">社区</a>
            </li>
        </nav>

    </header>
</div>
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
            <li id="active">
                <img src="/images/favicon.ico" alt="" srcset="">
                <span>个人资料</span>
            </li>
            <li>
                <img src="/images/favicon.ico">
                <span>题库统计</span>
            </li>
            <li id="community">
                <img src="/images/favicon.ico">
                <span>社区记录</span>
                <img src="/images/favicon.ico">
            </li>
            <nav class="postinfo" id="postinfo" style="height:100px;">
                <li>发表的帖子</li>
                <li>发表的回复</li>
            </nav>
            <li id="mycollection">
                <img src="/images/favicon.ico">
                <span>我的收藏</span>
                <img src="/images/favicon.ico">
            </li>
            <nav class="collection" id="collection" style="height:150px;">
                <li>题目收藏夹</li>
                <li>院校收藏夹</li>
                <li>帖子收藏夹</li>
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
                            <input type="text" id="userNickName" name="userNickName" value="${User.userNickName}" placeholder="${User.userNickName}" />
                        </li>
                        <li>
                            <label for="dreamSchool">目标院校</label>
                            <input type="text" id="dreamSchool" name="dreamSchool" value="${User.dreamSchool}"  placeholder="${User.dreamSchool}" />
                        </li>
                        <li>
                            <label for="userSchool">本科院校</label>
                            <input type="text" id="userSchool" name="userSchool" value="${User.userSchool}" placeholder="${User.userSchool}" />
                        </li>
                        <li>
                            <label>绑定手机</label>
                            <input type="hidden" name="userTelephone" value="${User.userTelephone}"/>
                            <span style="line-height: 32px;">${User.userTelephone}<span/>
                        </li>
                        <li>
                            <label for="userEmail">绑定邮箱</label>
                            <input type="text" id="userEmail" name="userEmail" value="${User.userEmail}" placeholder="${User.userEmail}" />
                        </li>
                        <li>
                            <label for="examTime">考研年份</label>
                            <input type="text" id="examTime" name="examTime" value="${User.examTime}" placeholder="${User.examTime}" />
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
<div class="footer">
    <footer>
        <nav>
            <li><a href="">友情链接</a></li>
            <li><a href="">广告合作</a></li>
            <li><a href="">联系我们</a></li>
            <li><a href="">关于我们</a></li>
        </nav>
        <p>冀ICP备17013704号 design by 写BUG辛苦了</p>
    </footer>
</div>
</body>
<script src="/js/usercommon.js"></script>

</html>