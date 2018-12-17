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
<body style="overflow:scroll;overflow-y:hidden" >
<body>
<%@include file="../common/header.jsp"%>
<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md8">
      <div class="fly-panel" style="margin-bottom: 0;">
        <form class="layui-form"action="/searchfile" method="post">
            <div class="layui-form-item">
              <label class="layui-form-label">资料类型 >></label>
              <div class="layui-input-block">
                <input type="checkbox" name="all" title="全部"checked="checked" value="全部">
                <input type="checkbox" name="zsjz" title="招生简章" value="招生简章">
                <input type="checkbox" name="zszyml" title="招生专业目录" value="招生专业目录">
                <input type="checkbox" name="kyzt" title="考研真题" value="考研真题">
                <input type="checkbox" name="bkxt" title="备考习题" value="备考习题">
                <input type="checkbox" name="kjfx" title="课件分享" value="课件分享">
                <input type="checkbox" name="cksm" title="参考书目" value="参考书目">
              </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">针对院校 >></label>
                <div class="layui-input-block" class="twoselect">
                    <select name="province" onChange="set_school(this, this.form.school);">
                        <option value="0">选择省份</option>
                        <c:forEach items="${provinceList}" var="province">
                            <option value="${province}">${province}</option>
                        </c:forEach>
                    </select>
                    <select name="school" id="schools">
                        <option value="%">选择学校</option>
                    </select>
                </div>
            </div>
            <div class="options">
                <span class="optionName">搜索 >></span>
                <input type="text" id="filesearch"   placeholder="" class="layui-input" name="keyWord">
                <input type="submit" value="搜索" id="search" class="layui-btn layui-btn-normal"/>
            </div>
        </form>
      </div>
      <div class="fly-panel" style="margin-bottom: 0; margin-top:20px">
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
                              <td><a href="/download?fileId=${file.fileId}" style="color: red">${file.fileTitle}</a></td>
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
                          <td><a href="/download?fileId=${file.fileId}" style="color: red">${file.fileTitle}</a></td>
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
        <dd>
            <a href="/download?fileId=${hotFile.fileId}" style="color: red">${hotFile.fileTitle}</a>
          <span><i class="iconfont icon-pinglun1"></i> ${hotFile.downloadNumber}</span>
        </dd>
          </c:forEach>
      </dl>

    </div>
  </div>
</div>

<script src="../layui/layui.js"></script>
<script>
layui.cache.page = 'jie';
layui.config({
  version: "3.0.0"
  ,base: '../layui/fly/res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>

</body>
</html>