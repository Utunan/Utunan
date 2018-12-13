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
    <script>
        schools = new Object();
        <c:forEach items="${provinceList}" var="province">
        schools['${province}']=new Array(
            <c:forEach items="${schoolList}" var="school" varStatus="status">
            <c:if test="${(province==school.schoolProvince) && !status.last}">
            '${school.schoolName}',
            </c:if>
            <c:if test="${(province==school.schoolProvince) && status.last}">
            '${school.schoolName}'
            </c:if>
            </c:forEach> )
        </c:forEach>
        function set_school(province, school)
        {
            var pv, cv;
            var i, ii;
            pv=province.value;
            cv=school.value;
            school.length=1;
            if(pv=='0') return;
            if(typeof(schools[pv])=='undefined') return;
            for(i=0; i<schools[pv].length; i++)
            {
                ii = i+1;
                school.options[ii] = new Option();
                school.options[ii].text = schools[pv][i];
                school.options[ii].value = schools[pv][i];
            }
        }
    </script>
</head>
<body>
    <div STYLE="float: right; width: 100px">
        <h2><a href="/share1">上传文件</a></h2>
    </div>
    <div STYLE="width: 1000px">
        <h2>上传文件的入口在那个并不是很遥远的地方 向右看---------> </h2>
        <form name="form1" action="/searchfile" method="post">
            <br>
            <input type="checkbox" name="fileType" value="全部" id="全部" checked="checked">全部
            <input type="checkbox" name="fileType" value="招生简章" id="招生简章">招生简章
            <input type="checkbox" name="fileType" value="招生专业目录" id="招生专业目录">招生专业目录
            <input type="checkbox" name="fileType" value="考研真题" id="考研真题">考研真题
            <input type="checkbox" name="fileType" value="备考习题" id="备考习题">备考习题
            <input type="checkbox" name="fileType" value="课件分享" id="课件分享">课件分享
            <input type="checkbox" name="fileType" value="参考书目" id="参考书目">参考书目
            <br>
            <br>
            <select name="province" onChange="set_school(this, this.form.school);">
                <option value="0">选择省份</option>
                <c:forEach items="${provinceList}" var="province">
                    <option value="${province}">${province}</option>
                </c:forEach>
            </select>
            <select name="school" id="schools">
                <option value="%">选择学校</option>
            </select>
            <br>
            <br>
            <input type="text" name="keyWord" placeholder="请输入关键字">
            <input type="submit" value="查找">
        </form>
    </div>
    <br>
    <c:if test="${url=='share'}">
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
            <c:forEach items="${fileList}" var="file" varStatus="stat">
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
        <div style="text-align: center">
            <div class="laypage-main">
                <a href="/${url }">首页</a>
                <a href="/${url }?pageNum=${PageInfo.prePage}"><<</a>
                <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                    <a name="${i}" href="/${url }?pageNum=${i}">${i}</a>
                </c:forEach>
                <c:choose>
                    <c:when test="${PageInfo.nextPage==0}">
                        <a href="/${url }?pageNum=${PageInfo.pages}">>></a>
                    </c:when>
                    <c:otherwise>
                        <a href="/${url }?pageNum=${PageInfo.nextPage}">>></a>
                    </c:otherwise>
                </c:choose>
                <a href="/${url }?pageNum=${PageInfo.pages}">尾页</a>
            </div>
        </div>
    </div>
    <br>
    </c:if>
    <c:if test="${url=='searchfile'}">
        <h3>筛选结果</h3>
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
        <div style="text-align: center">
            <div class="laypage-main">
                <a href="/${url }?fileType=${fileType}&school=${school}&keyWord=${keyWord}">首页</a>
                <a href="/${url }?fileType=${fileType}&school=${school}&keyWord=${keyWord}&pageNum=${PageInfo.prePage}"><<</a>
                <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                    <a name="${i}" href="/${url }?fileType=${fileType}school=${school}&keyWord=${keyWord}&pageNum=${i}">${i}</a>
                </c:forEach>
                <c:choose>
                    <c:when test="${PageInfo.nextPage==0}">
                        <a href="/${url }?fileType=${fileType}&school=${school}&keyWord=${keyWord}&pageNum=${PageInfo.pages}">>></a>
                    </c:when>
                    <c:otherwise>
                        <a href="/${url }?fileType=${fileType}&school=${school}&keyWord=${keyWord}&pageNum=${PageInfo.nextPage}">>></a>
                    </c:otherwise>
                </c:choose>
                <a href="/${url }?fileType=${fileType}&school=${school}&keyWord=${keyWord}&pageNum=${PageInfo.pages}">尾页</a>
            </div>
        </div>
    </c:if>
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
