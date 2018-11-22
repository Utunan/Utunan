<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <header>
        <div class="logo">
            <img src="images/favicon.ico" alt="" srcset="">
        </div>
        <a class="loginname" href="">优图南</a>
        <div class="login">
            <span><a href="/login" target="_blank">登陆</a></span><span><a href="/register" target="_blank">注册</a></span>
        </div>
        <div class="search">
            <form action="/search" method="get" onsubmit="return true">
                <div class="text">
                    <input type="text" name="keyword" placeholder="请输入内容"/>
                    <button style="" type="submit"><img src="images/search.png"/></button>
                </div>

            </form>
        </div>

        <nav class="banner">
            <li>
                <a href="">题库</a>
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