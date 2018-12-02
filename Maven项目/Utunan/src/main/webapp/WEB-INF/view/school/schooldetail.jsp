<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/12/1/001
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>院校详情</title>
</head>
<body>
    <%--按研究方向--%>
    招生单位：${publishDirection.schoolName}<br>
    专业名称：${publishDirection.majorlName}<br>
    学位类型：${publishDirection.degreeType}<br>
    所在地：${publishDirection.school.schoolProvince}<br>
    院系名称：${publishDirection.collegeName}<br>
    院校特性：${publishDirection.school.schoolType}<br>
    院校隶属：${publishDirection.school.schoolSubjection}<br>
    研究方向：${publishDirection.directionName}<br>
    ==========<br>
    考试范围：<br>
        政治：${publishDirection.politics}<br>
        外语：${publishDirection.english}<br>
        业务课一：${publishDirection.math}<br>
        业务课二：${publishDirection.majorBasics}<br>
    ==========<br>
    讨论区<br>
    共有条评论：
    <a href="/displayDirectionDetail?directionId=${publishDirection.directionId}&sort=时间">按时间排序</a> &nbsp;&nbsp;
    <a href="/displayDirectionDetail?directionId=${publishDirection.directionId}&sort=热度">按热度排序</a>
    <table>
        <tr>
            <td>时间</td>
            <td>评论人</td>
            <td>内容</td>
            <td>点赞数</td>
            <td>点赞</td>
            <td>评论</td>
        </tr>
        <c:forEach items="${publishDirection.directionComments}" var="directioncomment" >
            <tr>
                <td>${directioncomment.directionCommentTime}</td>
                <td>${directioncomment.user.userNickName}</td>
                <td>${directioncomment.directionCommentContent}</td>
                <td>${directioncomment.directionCommentPraiseCount}</td>
                <td>点赞</td>
                <td><a>查看评论</a></td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
