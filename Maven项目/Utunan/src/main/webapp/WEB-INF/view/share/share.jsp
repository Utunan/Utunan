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
        <table>
            <tr>
                <td>图标</td>
                <td>文件</td>
                <td>用户</td>
                <td>类型</td>
                <td>学校</td>
                <td>积分</td>
                <td>下载次数</td>
            </tr>
            <c:forEach items="${fileList}" var="file">
            <tr>
                <td><img src="${file.suffix.imgUrl}" alt="文件类型" style="width: 20px; height: 20px"></td>
                <td><a href="${file.fileUrl}" style="color: red">${file.fileTitle}</a></td>
                <td>${file.user.userNickName}</td>
                <td>${file.fileType}</td>
                <td>${file.fileSchool}</td>
                <td>${file.fileCredit}</td>
                <td>${file.downloadNumber}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div style="text-align: center">
        <div class="laypage-main">
            <a href="/${url }">首页</a>
            <a href="/${url }?pageNum=${PageInfo.prePage}">上一页</a>
            <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                <a name="${i}" href="/${url }?pageNum=${i}">${i}</a>
            </c:forEach>
            <c:choose>
                <c:when test="${PageInfo.nextPage==0}">
                    <a href="/${url }?pageNum=${PageInfo.pages}">下一页</a>
                </c:when>
                <c:otherwise>
                    <a href="/${url }?pageNum=${PageInfo.nextPage}">下一页</a>
                </c:otherwise>
            </c:choose>
            <a href="/${url }?pageNum=${PageInfo.pages}">尾页</a>
        </div>
    </div>
    <br>
    <table>
        <tr>
            <td>文件</td>
            <td>下载次数</td>
        </tr>
        <c:forEach items="${hotFileList}" var="hotFile">
            <tr>
                <td><a href="${hotFile.fileUrl}" style="color: red">${hotFile.fileTitle}</a></td>
                <td>${hotFile.downloadNumber}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
