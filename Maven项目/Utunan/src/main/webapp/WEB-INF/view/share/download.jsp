<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <script type="text/javascript">

        function check(form) {
            if (form.operate.value=="notLogin") {
                alert("请先登录！")
                return false;
            }
            if (form.operate.value=="lackOfIntegral") {
                alert("您的积分不足，快去发帖、评论赚积分吧！")
                return false;
            }
            document.form1.submit();
        }
    </script>
</head>
<body>
<%@include file="../common/header.jsp"%>
    <div>
        <h3>文件信息</h3>
        <img src="${file.suffix.imgUrl}" alt="文件类型" style="width: 20px; height: 20px">
        <a href="/download?fileId=${file.fileId}" style="color: red">${file.fileTitle}</a>
        <br>
        <a href="/searchfile?fileType=${file.fileType}&school=${file.fileSchool}&keyWord=">${file.fileType}</a>
        <a href="/searchfile?fileType=全部&school=${file.fileSchool}&keyWord=">${file.fileSchool}</a>
        <br>
        积分：${file.fileCredit}
        下载量：${file.downloadNumber}
        <br>
        <a href="/fileUp?fileId=${file.fileId}">求赞</a>&nbsp;${file.upNumber}
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/fileDown?fileId=${file.fileId}">别踩</a>&nbsp;${file.downNumber}
        <br>
        <span>${file.user.userNickName}</span>
        <span>${file.user.userSchool}</span>
        <span>${file.user.dreamSchool}</span>
        <br>
        <form name="form1" action="/downloadfile" method="post" onsubmit="return check(this)" >
            <input type="hidden" name="fileId" value="${file.fileId}">
            <input type="hidden" name="operate" value="${operate}">
            <input type="submit" value="点击下载"/>
        </form>
    </div>
    <div>
        <h3>相关文件</h3>
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
            <c:forEach items="${relatedFileList}" var="f">
                <c:if test="${file.fileId != f.fileId}">
                    <c:choose>
                        <c:when test="${f.fileType == '招生简章' || f.fileType == '招生专业目录'}">
                            <c:if test="${f.isExamine == 1}">
                                <tr>
                                    <td><img src="${f.suffix.imgUrl}" alt="文件类型" style="width: 20px; height: 20px"></td>
                                    <td><a href="/download?fileId=${f.fileId}" style="color: black">${f.fileTitle}</a></td>
                                    <td>${f.user.userNickName}</td>
                                    <td>${f.fileType}</td>
                                    <td>${f.fileSchool}</td>
                                    <td>${f.fileCredit}</td>
                                    <td>${f.downloadNumber}</td>
                                </tr>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td><img src="${f.suffix.imgUrl}" alt="文件类型" style="width: 20px; height: 20px"></td>
                                <td><a href="/download?fileId=${f.fileId}" style="color: black">${f.fileTitle}</a></td>
                                <td>${f.user.userNickName}</td>
                                <td>${f.fileType}</td>
                                <td>${f.fileSchool}</td>
                                <td>${f.fileCredit}</td>
                                <td>${f.downloadNumber}</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </c:forEach>
        </table>
    </div>
<dl class="fly-panel fly-list-one">
    <dt class="fly-panel-title">热门资源</dt>
    <c:forEach items="${hotFileList}" var="hotFile">
        <c:choose>
            <c:when test="${hotFile.fileType == '招生简章' || hotFile.fileType == '招生专业目录'}">
                <c:if test="${hotFile.isExamine == 1}">
                    <dd>
                        <a href="/download?fileId=${hotFile.fileId}">${hotFile.fileTitle}</a>
                        <span>下载 &nbsp;${hotFile.downloadNumber}</span>
                    </dd>
                </c:if>
            </c:when>
            <c:otherwise>
                <dd>
                    <a href="/download?fileId=${hotFile.fileId}" >${hotFile.fileTitle}</a>
                    <span>下载 &nbsp;${hotFile.downloadNumber}</span>
                </dd>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</dl>
<%@include file="../common/footer.jsp"%>
</body>
</html>
