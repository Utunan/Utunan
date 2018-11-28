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
<form action="/displaySchoolBySearch">
    院校所在地：
    <label><input name="schoolProvince" type="checkbox" value="null" />全部 </label>
    <label><input name="schoolProvince" type="checkbox" value="北京" />北京 </label>
    <label><input name="schoolProvince" type="checkbox" value="上海" />上海 </label>
    <label><input name="schoolProvince" type="checkbox" value="广东" />广东 </label>
    <label><input name="schoolProvince" type="checkbox" value="江苏" />江苏 </label>
    <br>
    <input type="submit" value="搜索"/>
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
    <c:forEach items="${directionList}" var="directionList" >
        <tr>
            <td>${directionList.schoolName}</td>
            <td>${directionList.collegeName}</td>
            <td>${directionList.degreeType}</td>
            <td>${directionList.majorName}</td>
            <td>${directionList.directionName}</td>
            <td><a href="#">详情</a> </td>
            <td>收藏</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
