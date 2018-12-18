<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>优共享</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/community/layui.css">
    <link rel="stylesheet" href="/css/community/global.css">
  <link rel="stylesheet" href="../css/share/file.css">
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
<%@include file="../common/header.jsp"%>
<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md8">
      <div class="fly-panel" style="margin-bottom: 0;">
          <form name="form1" action="/searchfile" method="post">
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
      <div class="fly-panel" style="margin-bottom: 0; margin-top:20px">

          <c:if test="${url=='share'}">
              <div>
                  <ul class="list">
                  <c:forEach items="${fileList}" var="file" varStatus="stat">
                      <li>
                          <div>
                          <img src="${file.suffix.imgUrl}" alt="文件类型" class="siffix">
                          <span class="tn"><a href="/download?fileId=${file.fileId}" >${file.fileTitle}</a></span>
                          <div class="topdetail">
                              <span class="ft"> ${file.fileType}</span>
                              <span class="fs">${file.fileSchool}</span>
                          </div>
                          <span class="un">${file.user.userNickName}&nbsp;于${file.fileTime}上传</span>
                          <div class="rightdetail">
                              <span class="fc"><img src="/images/share/credit.svg"  class="credit">${file.fileCredit}</span>
                              <span class="dn"><img src="/images/share/downNum.svg"  class="downNum">${file.downloadNumber}</span>
                          </div>
                          </div>
                      </li>
                  </c:forEach>
              </ul>
              </div>.
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
          </c:if>
          <c:if test="${url=='searchfile'}">
              <div>
                  <ul class="list">
                      <c:forEach items="${fileList}" var="file" varStatus="stat">
                          <li>
                              <div>
                                  <img src="${file.suffix.imgUrl}" alt="文件类型" class="siffix">
                                  <span class="tn"><a href="/download?fileId=${file.fileId}" >${file.fileTitle}</a></span>
                                  <div class="topdetail">
                                      <span class="ft"> ${file.fileType}</span>
                                      <span class="fs">${file.fileSchool}</span>
                                  </div>
                                  <span class="un">${file.user.userNickName}&nbsp;于${file.fileTime}上传</span>
                                  <div class="rightdetail">
                                      <span class="fc"><img src="/images/share/credit.svg"  class="credit">${file.fileCredit}</span>
                                      <span class="dn"><img src="/images/share/downNum.svg"  class="downNum">${file.downloadNumber}</span>
                                  </div>
                              </div>
                          </li>
                      </c:forEach>
                  </ul>
              </div>
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
          </c:if></div>
    </div><!--上边这-->
  <!--左边这-->
  <div class="layui-col-md4">
    <div class="fly-panel">
            <div class="fly-panel-main">
              <a href="/share1" target="_blank" class="fly-zanzhu" style="background-color: #393D49;">我要上传</a>
            </div>
        </div>

      <dl class="fly-panel fly-list-one">
        <dt class="fly-panel-title">热门资源</dt>
          <c:forEach items="${hotFileList}" var="hotFile">
        <dd>
            <a href="/download?fileId=${hotFile.fileId}" >${hotFile.fileTitle}</a>
            <span><span class="dn"><img src="/images/share/downNum2.svg"  class="downNum">${hotFile.downloadNumber}</span></span>
        </dd>
          </c:forEach>
      </dl>

    </div>
  </div>
</div>

<script>
layui.cache.page = 'jie';
layui.config({
  version: "3.0.0"
  ,base: '../layui/fly/res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>
<script src="/js/common/common.js"></script>
</body>
</html>