<%--
  Created by IntelliJ IDEA.
  User: 王碧云
  Date: 2018/11/27/027
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List,com.utunan.pojo.*"%>

<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎来到Utunan</title>
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/school/schoolcommon.css">
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="header">
    <header>
        <div class="logo">
            <img src="../images/favicon.ico" alt="" srcset="">
        </div>
        <a class="loginname" href="">优图南</a>
        <div class="login">
            <span><a href="">登陆</a></span><span><a href="">注册</a></span>
        </div>
        <div class="search">
            <form action="aaa" method="get" onsubmit="return true">
                <div class="text">
                    <input type="text" name="keyword" placeholder="请输入内容" />
                    <button style="" type="submit"><img src="../images/search.png" /></button>
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

<div class="title">院校库</div>
<div class="container">
    <div class="bigwrapper">
        <div class="retrieval">
            <div class="conditiontype">
                <span id="cactive">按科目检索</span>
                <span>按搜索方向检索</span>
            </div>
            <form class="condition" action="/displaySchoolBySearch">
                <div class="schoolProvince">
                    <span>院校所在地 :</span>
                    <nav>
                        <li><input name="schoolProvince" type="checkbox" checked="checked" value="全部">全部</li>
                        <li><input name="schoolProvince" type="checkbox" value="北京">北京</li>
                        <li><input name="schoolProvince" type="checkbox" value="天津">天津</li>
                        <li><input name="schoolProvince" type="checkbox" value="上海">上海</li>
                        <li><input name="schoolProvince" type="checkbox" value="重庆">重庆</li>
                        <li><input name="schoolProvince" type="checkbox" value="河北">河北</li>
                        <li><input name="schoolProvince" type="checkbox" value="山西">山西</li>
                        <li><input name="schoolProvince" type="checkbox" value="辽宁">辽宁</li>
                        <li><input name="schoolProvince" type="checkbox" value="吉林">吉林</li>
                        <li><input name="schoolProvince" type="checkbox" value="黑龙江">黑龙江</li>
                        <li><input name="schoolProvince" type="checkbox" value="江苏">江苏</li>
                        <li><input name="schoolProvince" type="checkbox" value="浙江">浙江</li>
                        <li><input name="schoolProvince" type="checkbox" value="安徽">安徽</li>
                        <li><input name="schoolProvince" type="checkbox" value="福建">福建</li>
                        <li><input name="schoolProvince" type="checkbox" value="江西">江西</li>
                        <li><input name="schoolProvince" type="checkbox" value="山东">山东</li>
                        <li><input name="schoolProvince" type="checkbox" value="河南">河南</li>
                        <li><input name="schoolProvince" type="checkbox" value="湖北">湖北</li>
                        <li><input name="schoolProvince" type="checkbox" value="湖南">湖南</li>
                        <li><input name="schoolProvince" type="checkbox" value="广东">广东</li>
                        <li><input name="schoolProvince" type="checkbox" value="海南">海南</li>
                        <li><input name="schoolProvince" type="checkbox" value="四川">四川</li>
                        <li><input name="schoolProvince" type="checkbox" value="贵州">贵州</li>
                        <li><input name="schoolProvince" type="checkbox" value="云南">云南</li>
                        <li><input name="schoolProvince" type="checkbox" value="陕西">陕西</li>
                        <li><input name="schoolProvince" type="checkbox" value="甘肃">甘肃</li>
                        <li><input name="schoolProvince" type="checkbox" value="青海">青海</li>
                        <li><input name="schoolProvince" type="checkbox" value="台湾">台湾</li>
                        <li><input name="schoolProvince" type="checkbox" value="广西">广西</li>
                        <li><input name="schoolProvince" type="checkbox" value="西藏">西藏</li>
                        <li><input name="schoolProvince" type="checkbox" value="内蒙古">内蒙古</li>
                        <li><input name="schoolProvince" type="checkbox" value="宁夏">宁夏</li>
                        <li><input name="schoolProvince" type="checkbox" value="新疆">新疆</li>
                    </nav>
                </div>
                <div class="schoolType">
                    <span>院校特性 :</span>
                    <nav>
                        <li><input name="schoolType" type="checkbox" checked="checked" value="全部">全部</li>
                        <li><input name="schoolType" type="checkbox" value="985">985院校</li>
                        <li><input name="schoolType" type="checkbox" value="211">211院校</li>
                        <li><input name="schoolType" type="checkbox" value="自划线">自主划线</li>
                    </nav>

                </div>
                <div class="degreeType">
                    <span>学位类型 :</span>
                    <nav>
                        <li><input name="degreeType" type="checkbox" checked="checked" value="全部">全部</li>
                        <li><input name="degreeType" type="checkbox" value="学硕">学硕</li>
                        <li><input name="degreeType" type="checkbox" value="专硕">专硕</li>
                    </nav>
                </div>
                <div class="scope">
                    <span>涵盖考试科目 :</span>
                    <nav>
                        <li>
                            <nav>
                        <li><input name="math" type="checkbox" checked="checked" value="全部">全部</li>
                        <li><input name="math" type="checkbox" value="一">数学(一)</li>
                        <li><input name="math" type="checkbox" value="二">数学(二)</li>
                    </nav>
                    </li>
                    <li>
                        <nav>
                    <li><input name="english" type="checkbox" checked="checked" value="全部">全部</li>
                    <li><input name="english" type="checkbox" value="一">英语(一)</li>
                    <li><input name="english" type="checkbox" value="二">英语(二)</li>
                    </nav>
                    </li>
                    <li></li>
                    </nav>
                </div>
                <input type="submit" value="搜索！"/>
            </form>
        </div>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>招生单位</th>
                <th>院系名称</th>
                <th>学位类型</th>
                <th>专业</th>
                <th>研究方向</th>
                <th>考试范围</th>
                <th>收藏</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${schoolList}" var="school" >
                <c:forEach items="${school.direction}" var="direction" >
            <tr>
                <td>${direction.schoolName}</td>
                <td>${direction.collegeName}</td>
                <td>${direction.degreeType}</td>
                <td>${direction.majorlName}</td>
                <td>${direction.directionName}</td>
                <td><a href="#">详情</a> </td>
                <td><a><img src="../images/school/redheart.svg"  width="20px" height="20px" alt="" srcset="" ></a></td>

            </tr>
                </c:forEach>
            </c:forEach>
            </tbody>

        </table>
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
<script src="../js/usercommon.js"></script>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
