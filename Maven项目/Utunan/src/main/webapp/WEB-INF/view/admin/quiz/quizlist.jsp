<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <title>admin</title>
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
        <span class="x-right" style="line-height:40px">共有数据：88 条</span>
    </xblock>
    <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i
                        class="layui-icon">&#xe605;</i></div>
            </th>
            <th>发表用户</th>
            <th>发表标题</th>
            <th>发表内容</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${quizlist}" var="q">
            <tr>
                <td>
                    <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${q.quizId}'><i class="layui-icon">&#xe605;</i></div>
                </td>
                <td>${q.user.userNickName}</td>
                <td>${q.quizTitle}</td>
                <td>${q.quizContent}</td>
                <td class="td-manage">
                    <a title="删除" onclick="member_del(this,'${q.quizId}')" href="javascript:;">
                        <i class="layui-icon">&#xe640;</i>
                    </a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="page">
        <div>
            <c:choose>
                <c:when test="${PageInfo.pages==1||PageInfo.pages==0}">

                </c:when>
                <c:otherwise>
                    <a class="num" href="/admin/adminlist">首页</a>
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
<script>
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });
    });

    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!', {icon: 1, time: 1000});
        });
    }

    function delAll(argument) {
        var data = tableCheck.getData();
        layer.confirm('确认要删除吗？' + data, function (index) {
            $.ajax({
                url:"/delallquiz",
                type:"get",
                dataType:"String",
                traditional:true,
                data:{"d":data},
                success:function(response){

                },
                error:function() {
                }
            });
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }

</script>

</body>

</html>
