<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
    <header>
        <div class="logo">
            <img src="/images/common/favicon.ico" alt="" srcset="">
        </div>
        <a class="loginname" href="/homepage">优图南</a>
        <c:choose>
            <c:when test="${User==null}">
                <div class="login before">
                    <span><a href="/login" target="_blank">登陆</a></span><span><a href="/register" target="_blank">注册</a></span>
                </div>
            </c:when>
            <c:otherwise>
                <div class="login after">
                <span>
                    <a id="usermessage" href="/user/message">
                        <img src="/images/common/information.svg">
                        <div id="messagecount">${messagecount }</div>
                    </a>

                    <a href="/user/message" style="margin-left: 5px;">消息</a>
                </span>
                    <span>
                    <a id="userheadimg" href="/user/myspace">

                        <img src="${User.userHeadImg}" alt="" srcset="">
                    </a>
                    <div id="userheadop" class="userheadop">
                        <div id="optop" class="optop">
                            <span>${User.userNickName}</span>
                            <span><a href="/user">个人主页</a></span>
                        </div>
                        <div class="opmiddle">
                            <div class="opimg">
                                <a href="/user/statistics"><img src="/images/common/statistics.svg" alt=""
                                                                srcset=""></a>
                            </div>
                            <div class="opimg" style="margin: 0 5px;">
                                <a href="/user/publishquiz"><img src="/images/common/record.svg" alt="" srcset=""></a>
                            </div>
                            <div class="opimg">
                                <a href="/user/myspace"><img src="/images/common/myspace.svg" alt="" srcset=""></a>
                            </div>
                            <div id="oplistone" class="oplist">
                                <a href="/user/statistics">题库统计</a>
                                <a href="/user/publishquiz" style="margin:0 5px;">社区记录</a>
                                <a href="/user/myspace">个人资料</a>
                            </div>
                            <div class="opimg">
                                <a href="/user/directioncollector"><img src="/images/common/school.svg" alt=""
                                                                        srcset=""></a>
                            </div>
                            <div class="opimg" style="margin: 0 5px;">
                                <a href="/user/quizcollector"><img src="/images/common/quiz.svg" alt="" srcset=""></a>
                            </div>
                            <div class="opimg">
                                <a href="/user/questioncollector"><img src="/images/common/question.svg" alt=""
                                                                       srcset=""></a>
                            </div>
                            <div id="oplisttwo" class="oplist">
                                <a href="/user/directioncollector">院系收藏</a>
                                <a href="/user/quizcollector" style="margin:0 5px;">问答收藏</a>
                                <a href="/user/questioncollector">题目收藏</a>
                            </div>
                        </div>
                        <div class="opbottom" id="opbottom">
                            <span><img src="/images/common/setting.svg"/><a href="/user/settings">用户设置</a></span>
                            <span><img src="/images/common/out.svg"/><a href="/loginout">退出登陆</a></span>
                        </div>
                    </div>
                </span>
                </div>
            </c:otherwise>
        </c:choose>
        <div class="search">
            <form action="/search/user" method="post" onsubmit="return true">
                <div class="text">
                    <input type="text" name="wd" placeholder="请输入内容"/>
                    <button style="" type="submit"><img src="/images/common/search.png"/></button>
                </div>

            </form>
        </div>
        <nav class="banner">
            <li>
                <a href="/school/displaySchool">优院校</a>
            </li>
            <li>
                <a href="/searchquestion">优题库</a>
            </li>
            <li>
                <a href="/quizs/rt/1">优问答</a>
            </li>
            <li>
                <a href="/share">优共享</a>
            </li>
        </nav>
        <script src="/js/jquery-3.3.1.min.js"></script>
        <script>

            if ($('#messagecount').html() == "" || $('#messagecount').html() <= "0") {
                $('#messagecount').css('display', "none");
            } else {
                $('#messagecount').css('display', "block");
            }
            setInterval(function () {
                $.ajax({
                    type: "post",
                    url: "/user/usermessage",
                    data: {"request": "messagecount"},
                    success: function (data) {
                        if (data == "0") {
                            $('#messagecount').html(0);
                            $('#messagecount').css('display', "none");
                        } else {
                            $('#messagecount').css('display', "block");
                            $('#messagecount').html(data)
                        }
                    }
                });
            }, 500)
        </script>
    </header>
</div>