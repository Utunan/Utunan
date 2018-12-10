<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/12/10
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <c:forEach items="${fileList}" var="file">
            <img src="${file.suffix.imgUrl}" alt="文件类型"><br>
            ${file.user.userNickName}<br>
            <a href="${file.fileUrl}">${file.fileTitle}</a><br>
            ${file.fileType}<br>
            ${file.fileSchool}<br>
            ${file.fileCredit}<br>
            ${file.suffix.suffixName}
        </c:forEach>
    </div>
</body>
</html>
