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
<html>
<head>
    <title>院校库首页</title>
</head>
<body>
<form>
    院校所在地：
    <label><input name="schoolProvince" type="checkbox" value="0" />全部 </label>
    <label><input name="schoolProvince" type="checkbox" value="1" />北京 </label>
    <label><input name="schoolProvince" type="checkbox" value="2" />上海 </label>
    <label><input name="schoolProvince" type="checkbox" value="3" />广东 </label>
    <label><input name="schoolProvince" type="checkbox" value="4" />江苏 </label>
    <br>
</form>
<table>
    <tr>
        <td>招生单位</td>
        <td>院系名称</td>
        <td>学位类型</td>
        <td>研究方向</td>
        <td>考试范围</td>
        <td>收藏</td>
    </tr>
    <c:forEach items="${schoollist}" var="schoollist" >
        <tr>
            <td>${schoollist.schoolName}</td>
                <%--<td>${childcomment.user.userNickName}</td>
                <td>${childcomment.commentContent}</td>
                <td>${childcomment.commentPraiseCount}</td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
