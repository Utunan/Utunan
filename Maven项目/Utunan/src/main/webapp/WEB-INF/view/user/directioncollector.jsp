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
    <link rel="stylesheet" href="/css/user/schoolcollector.css">
    <link rel="stylesheet" href="/css/user/usercommon.css">
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon">
    <script> var pagenum="${PageInfo.pageNum}"</script>
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
                <a href="/user/publishquiz">
                    <li>发表的问答</li>
                </a>
                <a href="/user/publishreply">
                    <li>发表的回复</li>
                </a>
            </nav>
            <li id="mycollection">
                <img src="/images/user/collection.svg">
                <span>我的收藏</span>
                <img src="/images/user/arrow.svg">
            </li>
            <nav class="collection" id="collection" style="height:150px;">
                <a href="/user/directioncollector">
                    <li>院校收藏夹</li>
                </a>
                <a href="/user/quizcollector">
                    <li id="active">帖子收藏夹</li>
                </a>
                <a href="/user/questioncollector">
                    <li>题目收藏夹</li>
                </a>
            </nav>
        </nav>
        <div class="content">
            <div class="title">
                <span>院校收藏</span>
            </div>
            <table border="0" cellpadding="6" cellspacing="0">
                <tr style="background-color: rgba(209, 231, 250,0.5 );">
                    <th style="width:150px;height: 50px;">招生单位</th>
                    <th style="width:120px;">院系名称</th>
                    <th style="width:80px;">学位类型</th>
                    <th style="width:160px;">专业</th>
                    <th style="width:80px">其他</th>
                    <th style="width:40px;"></th>
                </tr>
                <c:forEach items="${Directions}" var="D">
                    <tr>
                        <td style="height: 50px;">${D.schoolName}</td>
                        <td>${D.collegeName}</td>
                        <td>${D.degreeType}</td>
                        <td>${D.directionName}</td>
                        <td><a href="">详情</a></td>
                        <td><img src="/images/user/delete.svg"></td>
                    </tr>
                </c:forEach>
            </table>
            <nav id="page" class="page">
                <li class="home"><a href="/user/schoolcollector">首页</a></li>
                <li class="next"><a href="?pageNum=${PageInfo.prePage}">上一页</a></li>
                <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                    <li class="pagenum"><a name="${i}" href="?pageNum=${i}">${i}</a></li>
                </c:forEach>
                <c:choose>
                    <c:when test="${PageInfo.nextPage==0}">
                        <li class="next"><a href="?pageNum=${PageInfo.pages}">下一页</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="next"><a href="?pageNum=${PageInfo.nextPage}">下一页</a></li>
                    </c:otherwise>
                </c:choose>
                <li class="tail"><a href="?pageNum=${PageInfo.pages}">尾页</a></li>
            </nav>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>
</body>
<script src="/js/usercommon.js"></script>
<script src="/js/common.js"></script>
</html>