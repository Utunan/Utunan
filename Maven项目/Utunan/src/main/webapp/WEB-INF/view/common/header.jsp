<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
    <header>
        <div class="logo">
            <img src="/images/favicon.ico" alt="" srcset="">
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
                    <a href="/login">
                        <img src="/images/information.svg">
                    </a>
                    <a href="/information" style="margin-left: 5px;">消息</a>
                </span>
                    <span>
                    <a id="userheadimg" href="/register">
                        <img src="/images/userheadimg//default.png" alt="" srcset="">
                    </a>
                    <div id="userheadop" class="userheadop">
                        <div id="optop" class="optop">
                            <span>徐思涵天下第一美</span>
                            <span><a href="/user">个人主页</a></span>
                        </div>
                        <div class="opmiddle">
                            <div class="opimg">
                                <a href="/user/statistics"><img src="/images/statistics.svg" alt="" srcset=""></a>
                            </div>
                            <div class="opimg" style="margin: 0 5px;">
                                <a href="/user/publishpost"><img src="/images/record.svg" alt="" srcset=""></a>
                            </div>
                            <div class="opimg">
                                <a href="/user/collectmatter"><img src="/images/collection.svg" alt="" srcset=""></a>
                            </div>
                            <div id="oplist" class="oplist">
                                <a href="/user/statistics">题库统计</a>
                                <a href="/user/publishpost" style="margin:0 5px;">社区记录</a>
                                <a href="/user/collectmatter">我的收藏</a>
                            </div>
                        </div>
                        <div class="opbottom" id="opbottom">
                            <span><img src="/images/setting.svg"/><a href="/settings">用户设置</a></span>
                            <span><img src="/images/out.svg"/><a href="/loginout">退出登陆</a></span>
                        </div>
                    </div>
                </span>
                </div>
            </c:otherwise>
        </c:choose>

        <div class="search">
            <form action="/search" method="get" onsubmit="return true">
                <div class="text">
                    <input type="text" name="keyword" placeholder="请输入内容"/>
                    <button style="" type="submit"><img src="/images/search.png"/></button>
                </div>

            </form>
        </div>

        <nav class="banner">
            <li>
                <a href="/questionbank">题库</a>
            </li>
            <li>
                <a href="/school">院校库</a>
            </li>
            <li>
                <a href="/community">社区</a>
            </li>
        </nav>

    </header>
</div>