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
              <div class="threeops">
                <div class="op">
                    <span class="st">资源类型 >></span>
                    <div class="RadioStyle"><div class="Block PaddingL">
                        <input type="checkbox" name="fileType" value="全部" id="全部" checked="checked"><label for="全部">全部</label>
                        <input type="checkbox" name="fileType" value="招生简章" id="招生简章"><label for="招生简章">招生简章</label>
                        <input type="checkbox" name="fileType" value="招生专业目录" id="招生专业目录"><label for="招生专业目录">招生专业目录</label>
                        <input type="checkbox" name="fileType" value="考研真题" id="考研真题"><label for="考研真题">考研真题</label>
                        <input type="checkbox" name="fileType" value="备考习题" id="备考习题"><label for="备考习题">备考习题</label>
                        <input type="checkbox" name="fileType" value="课件分享" id="课件分享"><label for="课件分享">课件分享</label>
                        <input type="checkbox" name="fileType" value="参考书目" id="参考书目"><label for="参考书目">参考书目</label>
                    </div></div>
                </div>
                <div class="op">
                    <span class="st">针对院校 >></span>
                    <select name="province" onChange="set_school(this, this.form.school);" class="tc">
                        <option value="0">选择省份</option>
                        <c:forEach items="${provinceList}" var="province">
                            <option value="${province}">${province}</option>
                        </c:forEach>
                    </select>
                    <select name="school" id="schools"class="tc">
                            <option value="%">选择学校</option>
                    </select>
                </div>
                <div class="op">
                    <span   class="st">关键词搜索 >></span>
                    <input name="directionName" type="text" id="direction"  value="" placeholder="（选填）如：大数据"  class="layui-input">
                    <input type="submit" value="搜索" id="search" class="layui-btn layui-btn-normal"/>
                </div>
              </div>
          </form>
      </div>
      <div class="fly-panel" style="margin-bottom: 0; margin-top:20px">

          <c:if test="${url=='share'}">
              <div>
                  <ul class="list">
                  <c:forEach items="${fileList}" var="file" varStatus="stat">
                      <c:choose>
                          <c:when test="${file.fileType == '招生简章' || file.fileType == '招生专业目录'}">
                              <c:if test="${file.isExamine == 1}">
                                  <%@include file="filelist.jsp"%>
                              </c:if>
                          </c:when>
                          <c:otherwise>
                              <%@include file="filelist.jsp"%>
                          </c:otherwise>
                      </c:choose>
                  </c:forEach>
              </ul>
              </div>
              <%@include file="page.jsp"%>
          </c:if>
          <c:if test="${url=='searchfile'}">
              <div>
                  <ul class="list">
                      <c:forEach items="${fileList}" var="file" varStatus="stat">
                          <c:choose>
                              <c:when test="${file.fileType == '招生简章' || file.fileType == '招生专业目录'}">
                                  <c:if test="${file.isExamine == 1}">
                                      <%@include file="filelist.jsp"%>
                                  </c:if>
                              </c:when>
                              <c:otherwise>
                                  <%@include file="filelist.jsp"%>
                              </c:otherwise>
                          </c:choose>
                      </c:forEach>
                  </ul>
              </div>
              </table>
              <%@include file="page.jsp"%>
          </c:if>
        </div>
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
              <c:choose>
                  <c:when test="${hotFile.fileType == '招生简章' || hotFile.fileType == '招生专业目录'}">
                      <c:if test="${hotFile.isExamine == 1}">
                          <dd>
                              <a href="/download?fileId=${hotFile.fileId}">${hotFile.fileTitle}</a>
                              <span> <img src="/images/share/downNum2.svg" class="downNum">${hotFile.downloadNumber}</span>
                          </dd>
                      </c:if>
                  </c:when>
                  <c:otherwise>
                      <dd>
                          <a href="/download?fileId=${hotFile.fileId}" >${hotFile.fileTitle}</a>
                          <span><img src="/images/share/downNum2.svg" class="downNum" > ${hotFile.downloadNumber}</span>
                      </dd>
                  </c:otherwise>
              </c:choose>
          </c:forEach>
      </dl>
    </div>
  </div>
</div>

<!--<script>
layui.cache.page = 'jie';
layui.config({
  version: "3.0.0"
  ,base: '../layui/fly/res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>-->
<script src="/js/common/common.js"></script>
</body>
</html>