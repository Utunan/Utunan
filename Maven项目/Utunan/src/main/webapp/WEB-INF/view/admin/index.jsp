<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>Utunan后台管理</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/admin/font.css">
    <link rel="stylesheet" href="/css/admin/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/admin/xadmin.js"></script>
</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="/admin">Utunan后台管理</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav left fast-add" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">功能区</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('院校','school/displaySchool')"><i class="iconfont">&#xe6b8;</i>院校</a></dd>
                <dd><a onclick="x_admin_show('题库','questionbank')"><i class="iconfont">&#xe6a2;</i>题库</a></dd>
                <dd><a onclick="x_admin_show('问答','quiz')"><i class="iconfont">&#xe6a8;</i>问答</a></dd>
                <dd><a onclick="x_admin_show('分享','share')"><i class="iconfont">&#xe6b8;</i>分享</a></dd>
            </dl>
        </li>
    </ul>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;">${User.userNickName}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('个人信息','/user/')">个人信息</a></dd>
                <dd><a href="/login.html">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a href="/homepage">前台首页</a></li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>会员管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/admin/memberlist">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>普通会员</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/admin/adminlist">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>超级会员</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>院校管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/admin/directioncommentlist">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>院校评论</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>题库管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/admin/DSQuestion">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>数据结构</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/admin/CQuestion">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>C语言程序设计</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/admin/OSQuestion">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>操作系统</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/admin/ConstituteQuestion">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>组成原理</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/admin/NetworkQuestion">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>网络原理</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/admin/SEQuestion">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>软件工程</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>问答管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/admin/quizlist">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>问答列表</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/admin/answerlist">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>评论列表</cite>
                        </a>
                    </li>
                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>资源管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="order-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>资源列表</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="order-list.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>资源审核</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>系统通知</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="cate.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>发表通知</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="cate.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>已发通知</cite>
                        </a>
                    </li>

                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='/admin/welcome' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">Copyright ©2017 冀ICP备17013704号 Utunan</div>
</div>
<!-- 底部结束 -->

</body>
</html>
