<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>发表问题 编辑问题 公用</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
  <link rel="stylesheet" href="..\layui\wyd\layui.css">
  <link rel="stylesheet" href="..\layui\wyd\global.css">
</head>
<body>

<div class="layui-container fly-marginTop">
  <div class="fly-panel" pad20 style="padding-top: 5px;">
    <!--<div class="fly-none">没有权限</div>-->
    <div class="layui-form layui-form-pane">
      <div class="layui-tab layui-tab-brief" lay-filter="user">
        <ul class="layui-tab-title">
          <li class="layui-this">发表新帖<!-- 编辑帖子 --></li>
        </ul>
        <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
          <div class="layui-tab-item layui-show">
            <form action="" method="post">
              <div class="layui-row layui-col-space15 layui-form-item">
                <div class="layui-col-md3">
                  <label class="layui-form-label">资源类型</label>
                  <div class="layui-input-block">
                    <select lay-verify="required" name="class" lay-filter="column" onchange="func()">
                      <option value="0">招生简章</option> 
                      <option value="0">招生专业目录</option> 
                      <option value="11">考研真题</option> 
                      <option value="12">备考习题</option> 
                      <option value="13">课件分享</option> 
                      <option value="14">参考书目</option> 
                    </select>
                  </div>
                </div>
                <div class="layui-col-md9">
                  <label for="L_title" class="layui-form-label">标题</label>
                  <div class="layui-input-block">
                    <input type="text" id="L_title" name="title" required lay-verify="required" autocomplete="off" class="layui-input">
                    <!-- <input type="hidden" name="id" value="{{d.edit.id}}"> -->
                  </div>
                </div>
              </div>
              <div class="layui-row layui-col-space15 layui-form-item layui-hide" id="LAY_quiz">
                <div class="layui-col-md3">
                  <label class="layui-form-label">所属年份</label>
                  <div class="layui-input-block">
                    <select name="project">
                      <option value="2019">2019</option>
                      <option value="2018">2018</option>
                      <option value="2017">2017</option>
                      <option value="2016">2016</option>
                      <option value="2015">2015</option>
                      <option value="2014">2014</option>
                      <option value="2013">2013</option>
                      <option value="2012">2012</option>
                      <option value="2011">2011</option>
                      <option value="2010">2010</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="layui-upload-drag" id="test10">
                <i class="layui-icon"></i>
                <p>点击上传，或将文件拖拽到此处</p>
              </div>
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">悬赏积分</label>
                  <div class="layui-input-block">
                    <input type="text"  name="title" required lay-verify="required" autocomplete="off" class="layui-input">
                    <!-- <input type="hidden" name="id" value="{{d.edit.id}}"> -->
                  </div>
                  <div class="layui-form-mid layui-word-aux">发表后无法更改积分</div>
                </div>
              </div>
              <div class="layui-col-md3">
                <label class="layui-form-label">文件类型</label>
                <div class="layui-input-block">
                  <select lay-verify="required" name="class" lay-filter="column">
                    <option value="pic">图片</option> 
                    <option value="txt">txt文件</option>
                    <option value="doc">doc文件</option>
                    <option value="pdf">pdf文件</option> 
                    <option value="ziprar">压缩文件</option> 
                    <option value="ppt">ppt文件</option>
                    <option value="other">其他</option>
                  </select>
                </div>
              </div>
              <!--针对院校在jsp里弄得-->
              <div class="layui-col-md3">
              <select lay-verify="" name="province" onChange="set_school(this, this.form.school);">
                <option value="0">选择省份</option>
                <c:forEach items="${provinceList}" var="province">
                  <option value="${province}">${province}</option>
                </c:forEach>
              </select>
              <select name="school" id="schools">
                <option value="%">选择学校</option>0
              </select>
              </div>
              <div class="layui-form-item">
                <label for="L_vercode" class="layui-form-label">人类验证</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_vercode" name="vercode" required lay-verify="required" placeholder="请回答后面的问题" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid">
                  <span style="color: #c00;">1+1=?</span>
                </div>
              </div>
              <div class="layui-form-item">
                <button class="layui-btn" lay-filter="*" lay-submit>立即发布</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


<script src="../layui/layui.js"></script>
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
  ,base: '../layui/fly/res/mods/'
}).extend({
  fly: 'index'
}).use('fly');

layui.use('upload', function(){
  var $ = layui.jquery
  ,upload = layui.upload;
  
  
  //设定文件大小限制
  upload.render({
    elem: '#test7'
    ,url: '/upload/'
    ,size: 60 //限制文件大小，单位 KB
    ,done: function(res){
      console.log(res)
    }
  });
  

  //拖拽上传
  upload.render({
    elem: '#test10'
    ,url: '/upload/'
    ,done: function(res){
      console.log(res)
    }
  });
    
});
//tx瞎写的js，可以删
function func(){
 //获取被选中的option标签
 var vs = $('select  option:selected').val();
}
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

</body>
</html>