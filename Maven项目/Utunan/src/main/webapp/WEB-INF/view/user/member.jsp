<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="plate" value="myspace"/>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎来到Utunan</title>
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/user/userhome.css">
    <link rel="stylesheet" href="/css/user/member.css">
</head>

<body>
<%@include file="../common/header.jsp" %>
<div class="container" id="anchor">
    <div class="wrapper">
        <div class="usercard" id="usercard">
            <div class="userheadimg">
                <img src="${Member.user.userHeadImg}" alt="" srcset="">
            </div>
            <div class="countdown">
                <h4>2018年11月13日</h4>
                <h5>考研年份<span style="color:#ff5f2c;font-size: 25px;">${Member.user.examTime}</span>年</h5>
            </div>
            <div class="userinfo">
                <div class="nickname">${Member.user.userNickName}</div>
                <div class="isfollow"><a href="">未关注</a></div>
                <div class="schoolinfo">
                    <span>本科院校 : <span>${Member.user.userSchool}</span></span>
                    <span>目标院校 : <span>${Member.user.dreamSchool}</span></span>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container" style="margin-top: 30px;">
    <div class="wrapper background">
        <div class="content" id="content">
            <nav>
                <li>
                    <div class="mintitle">TA的问答</div>
                    <ul class="userquiz">
                        <c:forEach items="${Member.quizzes}" var="quiz">
                            <li class="quiz">
                                <a href="">${quiz.quizTitle}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
                <li>
                    <div class="mintitle" style="color: rgb(255, 155, 38);">TA的关注</div>
                    <ul class="userlist">
                        <c:forEach items="${Member.users}" var="user">
                            <li class="user">
                                <a href=""><img src="${user.userHeadImg}"></a>
                                <a href=""><span>${user.userNickName}</span></a>
                            </li>
                        </c:forEach>
                        <li class="usernotice">
                            仅能查看五个呦~
                        </li>
                    </ul>
                </li>
                <li>
                    <div class="mintitle">TA的题目</div>
                    <ul class="userquestion">
                        <c:forEach items="${Member.questions }" var="question">
                            <li class="question">
                                <a href="">${question.questionContent}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </nav>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>
</body>
<script src="/js/user/usercommon.js"></script>
<script src="/js/common/common.js"></script>
<script src="/js/jquery-1.8.3.min.js"></script>
<script src="/js/user/amazeui.min.js" charset="utf-8"></script>
<script src="/js/user/cropper.min.js" charset="utf-8"></script>
<script src="/js/user/custom_up_img.js" charset="utf-8"></script>
</html>