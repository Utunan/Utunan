<%--
  Created by IntelliJ IDEA.
  User: zh
  Date: 2018/12/19
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>资源审核</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="/css/admin/font.css">
    <link rel="stylesheet" href="/css/admin/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/admin/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="layui-anim layui-anim-up">
<div class="x-body">
    <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <span class="x-right" style="line-height:40px">共有数据：<span>88</span>条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                        class="layui-icon">&#xe605;</i></div>
            </th>
            <th>昵称</th>
            <th>资源类型</th>
            <th>上传时间</th>
            <th>审核状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Schoolcomments}" var="S">
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${S.schoolcommentId }'><i
                        class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${S.direction.schoolName }</td>
            <td>${S.direction.directionName }</td>
            <td>${S.user.userNickName }</td>
            <td>${S.schoolcommentcontent }</td>
            <td class="td-manage">
                <a title="编辑" onclick="x_admin_show('编辑','/admin/memberedit',600,400)" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="member_del(this,'${S.schoolcommentId }')" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>

            </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <c:choose>
                <c:when test="${PageInfo.pages==1||PageInfo.pages==0}">

                </c:when>
                <c:otherwise>
                    <a class="num" href="/admin/directionlist">首页</a>
                    <a class="prev" href="?pageNum=${PageInfo.prePage}">&lt;&lt;</a>
                    <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                        <c:if test="${i==PageInfo.pageNum}">
                            <span class="current">${i}</span>
                        </c:if>
                        <c:if test="${i!=PageInfo.pageNum}">
                            <a name="${i}" class="num" href="?pageNum=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${PageInfo.nextPage==0}">
                            <a class="next" href="?pageNum=${PageInfo.pages}">&gt;&gt;</a></c:when>
                        <c:otherwise>
                            <a class="next" href="?pageNum=${PageInfo.nextPage}">&gt;&gt;</a>
                        </c:otherwise>
                    </c:choose>
                    <a class="num" href="?pageNum=${PageInfo.pages}">尾页</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

</div>
</body>
</html>
