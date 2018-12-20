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
    <link rel="stylesheet" href="/css/community/layui.css">
    <link rel="stylesheet" href="/css/community/global.css">
    <link rel="stylesheet" href="/css/share/download.css">
    <link rel="stylesheet" href="/css/share/file.css">
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
<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">
            <div class="fly-panel" style="margin-bottom: 0;">
                <div class="download-file-detail">
                    <div class="fly-avatar">
                        <img src="${file.suffix.imgUrl}" alt="文件类型" >
                    </div>
                    <div class="detail-top">
                        ${file.fileTitle}
                        <span><a class="fileType" href="/searchfile?fileType=${file.fileType}&school=${file.fileSchool}&keyWord=">${file.fileType}</a></span>
                        <span><a class="fileSchool" href="/searchfile?fileType=全部&school=${file.fileSchool}&keyWord=">${file.fileSchool}</a></span>
                    </div>
                    <div class="detail">
                        所在院校：<span>${file.user.userSchool}</span>
                        目标院校：<span>${file.user.dreamSchool}</span>
                    </div>
                    <div class="from"><span>来自<a href="">${file.user.userNickName}</a></span></div>
                </div>
                <div class="download">
                    <form class="doenload-form" name="form1" action="/downloadfile" method="post" onsubmit="return check(this)" >
                        <input type="hidden" name="operate" value="${operate}">
                        <input class="input" type="submit" value="点击下载"/>
                    </form>
                    <div class="rightdetail" style="margin-right: 15px">
                        <span ><img src="/images/share/credit.svg"  class="credit" width="20px" height="20px">${file.fileCredit}</span>
                        <span ><img src="/images/share/downNum.svg"  class="downNum" width="20px" height="20px">${file.downloadNumber}</span>
                    </div>
                </div>
            </div>
            <div class="fly-panel" style="margin-bottom: 0; margin-top:20px">
                <div class="top">
                    相关文件
                </div>
                <ul class="list">
                    <c:forEach items="${relatedFileList}" var="f">
                        <c:if test="${file.fileId != f.fileId}">
                            <li>
                                <div>
                                    <img src="${f.suffix.imgUrl}" alt="文件类型" class="siffix">
                                    <span class="tn"><a href="/download?fileId=${f.fileId}" style="color: black">${f.fileTitle}</a></span>
                                    <div class="topdetail">
                                        <span class="ft"> ${f.fileType}</span>
                                        <span class="fs">${f.fileSchool}</span>
                                    </div>
                                    <span class="un">${f.user.userNickName}&nbsp;于${f.fileTime}上传</span>
                                    <div class="rightdetail">
                                        <span class="fc"><img src="/images/share/credit.svg"  class="credit">${f.fileCredit}</span>
                                        <span class="dn"><img src="/images/share/downNum.svg"  class="downNum">${f.downloadNumber}</span>
                                    </div>
                                </div>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
                <div class="none">
                    没有与之相关的文件哦~
                </div>
            </div>
        </div>
        <div class="layui-col-md4">
            <div class="fly-panel">
                <div class="fly-panel-main">
                    <a href="/share1" target="_blank" class="fly-zanzhu" style="background-color: #393D49;">我要上传</a>
                </div>
            </div>
            <dl class="fly-panel fly-list-one">
                <dt class="fly-panel-title">热门资源</dt>
                <c:forEach items="${hotFileList}" var="hotFile">
                    <c:choose>
                        <c:when test="${hotFile.fileType == '招生简章' || hotFile.fileType == '招生专业目录'}">
                            <c:if test="${hotFile.isExamine == 1}">
                                <dd>
                                    <a href="/download?fileId=${hotFile.fileId}" style="color: red">${hotFile.fileTitle}</a>
                                    <span><i class="iconfont icon-pinglun1"></i> ${hotFile.downloadNumber}</span>
                                </dd>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <dd>
                                <a href="/download?fileId=${hotFile.fileId}" style="color: red">${hotFile.fileTitle}</a>
                                <span><i class="iconfont icon-pinglun1"></i> ${hotFile.downloadNumber}</span>
                            </dd>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </dl>
        </div>
    </div>
</div>
<!--

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
            </c:forEach>
        </table>
    </div>
    <div>
        <h3>热门文件</h3>
        <table>
            <tr>
                <td>文件</td>
                <td>下载次数</td>
            </tr>
            <c:forEach items="${hotFileList}" var="hotFile">
                <tr>
                    <td><a href="/download?fileId=${hotFile.fileId}">${hotFile.fileTitle}</a></td>
                    <td>${hotFile.downloadNumber}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    -->
<%@include file="../common/footer.jsp"%>
</body>
<script>
    //没有相似文件时展示
    var list=document.getElementsByClassName("list")[0];
    var li=list.getElementsByTagName("li");
    var none=document.getElementsByClassName("none")[0];
    if(li.length==0){
        none.style.display="block";
    }
</script>
</html>
