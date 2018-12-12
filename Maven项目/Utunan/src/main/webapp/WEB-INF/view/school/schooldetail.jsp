<!--这是院校库2.0-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>院校详情</title>
  <link rel="stylesheet" href="../layui/wyd/layui.css">
  <link rel="stylesheet" href="../layui/wyd/global.css">
  <link rel="stylesheet" href="../css/school/detail.css">
</head>
<body>
<!--提醒tx加上 1.加入院校收藏夹 2.浏览次数3.评论总数4.评论点赞5.写评论-->

<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md8">
      <div class="fly-panel" style="margin-bottom: 0;">
        <div class="blank"></div>
        <fieldset class="layui-elem-field">
          <legend>${publishDirection.schoolName} - ${publishDirection.majorlName}</legend>
          <div class="layui-field-box">
            <table>
              <tr>
                  <td class="zsml-title">招生单位：</td>
                  <td class="zsml-summary" >${publishDirection.schoolName}</td>
                  <td class="ssss"></td>
                  <td class="zsml-title">学位类型：</td>
                  <td class="zsml-summary">${publishDirection.degreeType}</td>
              </tr>
              <tr>
                  <td class="zsml-title">所在地：</td>
                  <td class="zsml-summary" >${publishDirection.school.schoolProvince}</td>
                  <td class="ssss"></td>
                  <td class="zsml-title">院系名称：</td>
                  <td class="zsml-summary">${publishDirection.collegeName}</td>
              </tr>
              <tr>
                  <td class="zsml-title">院校特性：</td>
                  <td class="zsml-summary">${publishDirection.school.schoolType}</td>
                  <td class="ssss"></td>
                  <td class="zsml-title">专业名称：</td>
                  <td class="zsml-summary">${publishDirection.degreeType}</td>
              </tr>
              <tr>
                  <td class="zsml-title">院校隶属：</td>
                  <td class="zsml-summary">${publishDirection.school.schoolSubjection}</td>
                  <td class="ssss"></td>
                  <td class="zsml-title">研究方向：</td>
                  <td class="zsml-summary">${publishDirection.directionName}</td>
              </tr>
          </table>
          </div>
        </fieldset>
        <blockquote class="layui-elem-quote layui-quote-nm">考试范围</blockquote>
        <div class="zsml-result">
        <table  cellpadding="10" cellspacing="0" class="scope">
        <colgroup>
          <col width="25%">
          <col width="25%">
          <col width="25%">
          <col width="25%">
        </colgroup>
          <thead>
            <tr>
              <th>政治</th>
              <th>外语</th>
              <th>业务课一</th>
              <th>业务课二</th>
             </tr>    
          </thead>
          <tbody class="zsml-res-items">
            <tr>
              <td>
                  ${publishDirection.politics}
              </td>
              <td>${publishDirection.english}</td>
              <td>${publishDirection.math}</td>
              <td>${publishDirection.majorBasics}</td>
            </tr>
          </tbody>
        </table>
        <blockquote class="layui-elem-quote layui-quote-nm">官方公告</blockquote>
        <ul class="layui-timeline">
          <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
              <%--判断是否有今年的招生简章--%>
              <c:choose>
                <c:when test="${not empty EGfile}">
                  <div class="layui-timeline-title">&nbsp;&nbsp;<a href="/school/displayEG?schoolName=${publishDirection.schoolName}&fileType=招生简章">查看《${year}年${publishDirection.schoolName}硕士研究生招生简章》</a></div>
                </c:when>
                <c:otherwise>
                  <div class="layui-timeline-title">《${year}年${publishDirection.schoolName}硕士研究生招生简章》暂缺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a>我要上传</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/school/displayEGFormerYears?schoolName=${publishDirection.schoolName}&fileType=招生简章">查看往年招生简章</a></div>
                </c:otherwise>
              </c:choose>
            </div>
          </li>
          <li class="layui-timeline-item">
            <i class="layui-icon layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
              <%--判断是否有今年的招生目录--%>
              <c:choose>
                <c:when test="${not empty AGfile}">
                  <div class="layui-timeline-title">&nbsp;&nbsp;<a href="/school/displayEG?schoolName=${publishDirection.schoolName}&fileType=招生专业目录">查看《${year}年${publishDirection.schoolName}硕士研究生招生目录》</a></div>
                </c:when>
                <c:otherwise>
                  <div class="layui-timeline-title">《${year}年${publishDirection.schoolName}硕士研究生招生目录》暂缺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a>我要上传</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/school/displayEGFormerYears?schoolName=${publishDirection.schoolName}&fileType=招生专业目录">查看往年招生目录</a></div>
                </c:otherwise>
              </c:choose>
            </div>
          </li>
        </ul>
        <blockquote class="layui-elem-quote layui-quote-nm">评论区</blockquote>
        <ul class="jieda" id="jieda">
          <c:forEach items="${publishDirection.directionComments}" var="dcomment">
          <li data-id="111" class="jieda-daan">
            <a name="item-1111111111"></a>
            <div class="detail-about detail-about-reply">
              
              <div class="fly-detail-user">
                <a href="" class="fly-link">
                  <cite>${dcomment.user.userNickName}</cite>
                </a>
                
                <span> 发表于<fmt:formatDate value='${dcomment.directionCommentTime}' type='date' pattern='yyyy-MM-dd HH:mm:ss'/></span>
              </div>

            </div>
            <div class="detail-body jieda-body photos">
              <p>${dcomment.directionCommentContent}</p>
            </div>
            <div class="jieda-reply">
              <span class="jieda-zan zanok" type="zan">
                <i class="iconfont icon-zan"></i>
                <em>${dcomment.directionCommentPraiseCount}</em>
              </span>
              <span type="reply">
                <i class="iconfont icon-svgmoban53"></i>
                回复
              </span>
            </div>
          </li>
          </c:forEach>
          <!-- 无数据时 -->
          <!-- <li class="fly-none">消灭零回复</li> -->
        </ul>
        <div class="layui-form layui-form-pane">
          <form action="/jie/reply/" method="post">
            <div class="layui-form-item layui-form-text">
              <a name="comment"></a>
              <div class="layui-input-block">
                <textarea id="L_content" name="content" required lay-verify="required" placeholder="请输入内容"  class="layui-textarea fly-editor" style="height: 150px;"></textarea>
              </div>
            </div>
            <div class="layui-form-item">
              <input type="hidden" name="jid" value="123">
              <button class="layui-btn" lay-filter="*" lay-submit>提交回复</button>
            </div>
          </form>
        </div>
      </div><!--zsml-result-->
        

      </div>
    </div>
    <div class="layui-col-md4">
        <div class="fly-panel">
            <div class="fly-panel-main">
              <a href="" target="_blank" class="fly-zanzhu" style="background-color: #393D49;">搜索 [${publishDirection.schoolName}] 考研资料</a>
            </div>
        </div>
      <dl class="fly-panel fly-list-one">
        <dt class="fly-panel-title">[${publishDirection.schoolName}]热门资料</dt>
        <c:forEach items="${top9file}" var="file">
        <dd>
          <a href="">${file.fileTitle}</a>
          <span><i class="iconfont icon-pinglun1"></i>${file.downloadNumber}</span>
        </dd>
        </c:forEach>
      </dl>
    </div>
  </div>
</div>

<div class="fly-footer">
  <p><a href="http://fly.layui.com/" target="_blank">Fly社区</a> 2017 &copy; <a href="http://www.layui.com/" target="_blank">layui.com 出品</a></p>
  <p>
    <a href="http://fly.layui.com/jie/3147/" target="_blank">付费计划</a>
    <a href="http://www.layui.com/template/fly/" target="_blank">获取Fly社区模版</a>
    <a href="http://fly.layui.com/jie/2461/" target="_blank">微信公众号</a>
  </p>
</div>

<script src="/layui/layui.js"></script>
<script>
layui.cache.page = 'jie';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../../res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '../../res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>

</body>
</html>