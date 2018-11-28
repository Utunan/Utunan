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
    <link rel="stylesheet" href="/css/user/collectpost.css">
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
                    <li id="active">题目收藏夹</li>
                </a>
            </nav>
        </nav>
        <div class="content">
            <div class="title">
                <span>收藏的题目(666)</span>
            </div>
            <nav class="postlist">
                <li>
                    <div class="posttop">
                        <a href=""><img src="../images/userheadimg/default.png" alt="" srcset=""></a>
                        <span><a href="">徐思涵天下第一美</a></span>
                        <span><a href="">急！！！谁知道英语四级考题？重金悬赏！！！</a></span>
                    </div>
                    <div class="postmiddle">
                        <p>
                            Shadowsocks与Shadowsocksr区别：
                            SS是原版，SSR是原版基础上衍生出来的第三方版本，兼容原版协议，比原版多​​了一些伪装功能（协议和混淆）.SSR
                            主要特点是增加了一些人性化功能，比如服务器连接统计，连接管理，协议转换，多重代理等。
                        </p>
                    </div>
                    <div class="postbottom">
                        <div class="delete"><img src=""><a href="">取消收藏</a></div>
                        <div class="details"><a href="">>>详情</a></div>
                    </div>
                </li>
                <li>
                    <div class="posttop">
                        <a href=""><img src="../images/userheadimg/default.png" alt="" srcset=""></a>
                        <span><a href="">徐思涵天下第一美</a></span>
                        <span><a href="">急！！！谁知道英语四级考题？重金悬赏！！！</a></span>
                    </div>
                    <div class="postmiddle">
                        <p>
                            Shadowsocks与Shadowsocksr区别：
                            SS是原版，SSR是原版基础上衍生出来的第三方版本，兼容原版协议，比原版多​​了一些伪装功能（协议和混淆）.SSR
                            主要特点是增加了一些人性化功能，比如服务器连接统计，连接管理，协议转换，多重代理等。
                        </p>
                    </div>
                    <div class="postbottom">
                        <div class="delete"><img src=""><a href="">取消收藏</a></div>
                        <div class="details"><a href="">>>详情</a></div>
                    </div>
                </li>
                <li>
                    <div class="posttop">
                        <a href=""><img src="../images/userheadimg/default.png" alt="" srcset=""></a>
                        <span><a href="">徐思涵天下第一美</a></span>
                        <span><a href="">急！！！谁知道英语四级考题？重金悬赏！！！</a></span>
                    </div>
                    <div class="postmiddle">
                        <p>
                            Shadowsocks与Shadowsocksr区别：
                            SS是原版，SSR是原版基础上衍生出来的第三方版本，兼容原版协议，比原版多​​了一些伪装功能（协议和混淆）.SSR
                            主要特点是增加了一些人性化功能，比如服务器连接统计，连接管理，协议转换，多重代理等。
                        </p>
                    </div>
                    <div class="postbottom">
                        <div class="delete"><img src=""><a href="">取消收藏</a></div>
                        <div class="details"><a href="">>>详情</a></div>
                    </div>
                </li>
                <li>
                    <div class="posttop">
                        <a href=""><img src="../images/userheadimg/default.png" alt="" srcset=""></a>
                        <span><a href="">徐思涵天下第一美</a></span>
                        <span><a href="">急！！！谁知道英语四级考题？重金悬赏！！！</a></span>
                    </div>
                    <div class="postmiddle">
                        <p>
                            Shadowsocks与Shadowsocksr区别：
                            SS是原版，SSR是原版基础上衍生出来的第三方版本，兼容原版协议，比原版多​​了一些伪装功能（协议和混淆）.SSR
                            主要特点是增加了一些人性化功能，比如服务器连接统计，连接管理，协议转换，多重代理等。
                        </p>
                    </div>
                    <div class="postbottom">
                        <div class="delete"><img src=""><a href="">取消收藏</a></div>
                        <div class="details"><a href="">>>详情</a></div>
                    </div>
                </li>
                <li>
                    <div class="posttop">
                        <a href=""><img src="../images/userheadimg/default.png" alt="" srcset=""></a>
                        <span><a href="">徐思涵天下第一美</a></span>
                        <span><a href="">急！！！谁知道英语四级考题？重金悬赏！！！</a></span>
                    </div>
                    <div class="postmiddle">
                        <p>
                            Shadowsocks与Shadowsocksr区别：
                            SS是原版，SSR是原版基础上衍生出来的第三方版本，兼容原版协议，比原版多​​了一些伪装功能（协议和混淆）.SSR
                            主要特点是增加了一些人性化功能，比如服务器连接统计，连接管理，协议转换，多重代理等。
                        </p>
                    </div>
                    <div class="postbottom">
                        <div class="delete"><img src=""><a href="">取消收藏</a></div>
                        <div class="details"><a href="">>>详情</a></div>
                    </div>
                </li>
                <li>
                    <div class="posttop">
                        <a href=""><img src="../images/userheadimg/default.png" alt="" srcset=""></a>
                        <span><a href="">徐思涵天下第一美</a></span>
                        <span><a href="">急！！！谁知道英语四级考题？重金悬赏！！！</a></span>
                    </div>
                    <div class="postmiddle">
                        <p>
                            Shadowsocks与Shadowsocksr区别：
                            SS是原版，SSR是原版基础上衍生出来的第三方版本，兼容原版协议，比原版多​​了一些伪装功能（协议和混淆）.SSR
                            主要特点是增加了一些人性化功能，比如服务器连接统计，连接管理，协议转换，多重代理等。
                        </p>
                    </div>
                    <div class="postbottom">
                        <div class="delete"><img src=""><a href="">取消收藏</a></div>
                        <div class="details"><a href="">>>详情</a></div>
                    </div>
                </li>
            </nav>
            <nav class="page">
                <li class="home"><a href="">首页</a></li>
                <li class="prev"><a href="">上一页</a></li>
                <li><a href="?page=1">1</a></li>
                <li><a href="">2</a></li>
                <li><a href="">3</a></li>
                <li><a href="">4</a></li>
                <li><a href="">55</a></li>
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