<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/12/1/001
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    讨论区<<br>
    共有条评论：
    <a>按时间排序</a> &nbsp;&nbsp;<a>按热度排序</a>
    <table>
        <tr>
            <td>时间</td>
            <td>评论人</td>
            <td>内容</td>
            <td>点赞数</td>
            <td>点赞</td>
        </tr>
        <%--<c:forEach items="${childAnswerList}" var="childcomment" >
            <tr>
                <td>${childcomment.commentTime}</td>
                <td>${childcomment.user.userNickName}</td>
                <td>${childcomment.commentContent}</td>
                <td>${childcomment.commentPraiseCount}</td>
            </tr>
        </c:forEach>--%>
    </table>


</body>
</html>
