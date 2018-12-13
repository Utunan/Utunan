<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/12/13
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载</title>
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
    <span><img src="${file.suffix.imgUrl}" alt="文件类型" style="width: 20px; height: 20px"></span>
    <span><a href="/download?fileId=${file.fileId}" style="color: red">${file.fileTitle}</a></span>
    <span>${file.user.userNickName}</span>
    <span>${file.fileType}</span>
    <span>${file.fileSchool}</span>
    <span>${file.fileCredit}</span>
    <span>${file.downloadNumber}</span>
    <br>
    <span><a href="" download="${file.fileTitle}">点击下载</a></span>
<%@include file="../common/footer.jsp"%>
</body>
</html>
