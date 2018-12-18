<!--这是院校库2.0-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>院校详情</title>
  <link rel="stylesheet" href="../css/common.css">
  <link rel="stylesheet" href="/layui/css/layui.css">
  <link rel="stylesheet" href="/layui/wyd/global.css">
  <link rel="stylesheet" href="/css/school/detail.css">
  <link rel="stylesheet" href="/css/community/detail.css">
  <link rel="stylesheet" href="/css/school/login.css">
  <script type="text/javascript" src="https://unpkg.com/wangeditor@3.1.1/release/wangEditor.min.js"></script>
</head>
<script src="/js/community/jquery-1.10.2.js"></script>
<script src="/js/jquery-1.8.3.min.js"></script>
<body>
<!--提醒tx加上 1.加入院校收藏夹 2.浏览次数3.评论总数4.评论点赞5.写评论-->
<%@include file="../common/header.jsp"%>
<%--黑背景--%>
<div class="mask"></div>

<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md8">
      <div class="fly-panel detail-box" style="margin-bottom: 0;">
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
                  <%--<div class="layui-timeline-title">&nbsp;&nbsp;<a href="/school/displayEG?schoolName=${publishDirection.schoolName}&fileType=招生简章">查看《${year}年${publishDirection.schoolName}硕士研究生招生简章》</a></div>--%>
                  <div class="layui-timeline-title">&nbsp;&nbsp;<a href="/download?fileId=${EGfile.fileId}">查看《${year}年${publishDirection.schoolName}硕士研究生招生简章》</a></div>
                </c:when>
                <c:otherwise>
                  <div class="layui-timeline-title">《${year}年${publishDirection.schoolName}硕士研究生招生简章》暂缺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/share1">我要上传</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/searchfile?school=${publishDirection.schoolName}&fileType=招生简章&keyWord=">查看往年招生简章</a></div>
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
                  <div class="layui-timeline-title">&nbsp;&nbsp;<a href="/download?fileId=${AGfile.fileId}">查看《${year}年${publishDirection.schoolName}硕士研究生招生目录》</a></div>
                </c:when>
                <c:otherwise>
                  <div class="layui-timeline-title">《${year}年${publishDirection.schoolName}硕士研究生招生目录》暂缺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/share1">我要上传</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/searchfile?school=${publishDirection.schoolName}&fileType=招生专业目录&keyWord=">查看往年招生目录</a></div>
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
              <%--判断是否是管理员或者是用户本人--%>
              <c:if test="${user.userIdentity==1 || (user.userIdentity==3 && user.userId==dcomment.user.userId)}">
              <span type="reply">
                <i class="iconfont icon-svgmoban53"></i>
                <a href="/school/deleteDirectionComment?directionCommentId=${dcomment.directionCommentId}&directionId=${publishDirection.directionId}&schoolName=${publishDirection.schoolName}">删除</a>
              </span>
              </c:if>
            </div>
          </li>
          </c:forEach>
          <!-- 无数据时 -->
          <!-- <li class="fly-none">消灭零回复</li> -->
        </ul>
          <div class="write-answer" class="layui-form layui-form-pane">
             <div class="write-answer-top">
               <img src="/images/community/write.svg" width="25px" height="25px">
               <div class="write-answer-top">&nbsp;&nbsp;&nbsp;&nbsp;写回答</div>
             </div>
             <!--富文本编辑器-->
             <form name="fuform" onsubmit="return false" action="/school/insertDirectionComment?directionId=${publishDirection.directionId}&schoolName=${publishDirection.schoolName}" method="post">
               <div class="text">
                 <div id="div1" class="toolbar" style="height: 35px"></div>
                 <div id="div2" style="height: 130px"></div>
                 <textarea id="text1" style="display: none" name="content"></textarea>
               </div>
               <div class="write-answer-bottom">
                 <div class="write-answer-bottom-content">
                   <button  type="submit" class="layui-btn layui-btn-fluid" id="comsub" width="50px">提交回答</button>
                 </div>
               </div>
             </form>
        </div>
      </div><!--zsml-result-->
        

      </div>
    </div>
    <div class="layui-col-md4">
        <div class="fly-panel">
            <div class="fly-panel-main">
              <a href="/searchfile?school=${publishDirection.schoolName}&fileType=全部&keyWord=" target="_blank" class="fly-zanzhu" style="background-color: #393D49;">搜索 [${publishDirection.schoolName}] 考研资料</a>
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

<%--弹窗登录表单--%>
<div class="modalDialogcontent">
  <span class="close_modalDialogcontent">×</span>
  <div class="textcase">
    <div class="logintext">
      <a href="">登录吧您！</a> <%--<img src="/images/common/logo.png" alt="" srcset="">--%>
    </div>
  </div>
  <div  class="reply" id="reply"></div>
  <form class="loginform" id="loginform" onsubmit="return false" action="##" method="post">
    <div class="permit inputcase">
      <input type="text" name="permit" id="permit" value="${temppermit}" placeholder="您的手机/邮箱">
    </div>
    <div class="loginpassword inputcase">
      <input type="password" name="userPassword" id="password" placeholder="请输入密码">
    </div>
    <div class="loginbtn">
      <button id="submitbutton" type="submit">登录</button>
      <button id="closeAll">我不要</button>
    </div>
    <span><a href="/forgetpasework">忘记密码</a> </span> <%--还未实现该页面--%>
    <span><a href="/register">立即注册</a> </span>
  </form>
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
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#div1', '#div2')
    editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
    editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024   //每张图片最大上传大小
    editor.customConfig.uploadImgMaxLength = 5              //每次最多上传5张
    var $text1 = $('#text1')
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $text1.val(html)
    }
    //自定义菜单
    editor.customConfig.menus = [
        'head',  // 标题
        'bold',  // 粗体
        'fontSize',  // 字号
        'fontName',  // 字体
        'italic',  // 斜体
        'underline',  // 下划线
        'strikeThrough',  // 删除线
        'foreColor',  // 文字颜色
        'backColor',  // 背景颜色
        'link',  // 插入链接
        'list',  // 列表
        'quote',  // 引用
        'emoticon',  // 表情
        'image',  // 插入图片
        'table',  // 表格
        'code'  // 插入代码
    ]
    editor.create()
</script>

<script>
    var layer = parent.layer === undefined ? layui.layer : parent.layer;
    var ask=document.getElementById("comsub");
    var mask=document.getElementsByClassName("mask")[0];
    var modalDialogcontent=document.getElementsByClassName("modalDialogcontent")[0];
    /*获取提交按钮*/
    var submit = document.getElementById("submitbutton");
    /*获取关闭按钮*/
    var closeAll = document.getElementById("closeAll");

    /*判断是否是用户，不是用户则弹出框*/
    ask.onclick=function(){
        if(${user==null}){
            mask.style.display="block";
            modalDialogcontent.style.display="block";
        }else{
            document.fuform.submit();
        }
    };
    /*点击小叉号然后关闭*/
    var close_modalDialogcontent=document.getElementsByClassName("close_modalDialogcontent")[0];
    close_modalDialogcontent.onclick=function(){
        mask.style.display="none";
        modalDialogcontent.style.display="none";
    };
    closeAll.onclick=function(){
        mask.style.display="none";
        modalDialogcontent.style.display="none";
    };

    //判断用户名和密码
    submit.onclick=function(){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/school/popsupLogin" ,//url
            data: $('#loginform').serialize(),
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if(result==true){
                    window.location.href="/school/displayDirectionDetail?directionId=${publishDirection.directionId}&schoolName=${publishDirection.schoolName}";
                }else{
                    document.getElementById("reply").innerHTML="通行证或密码错误";
                }
            },
            error : function() {
                document.getElementById("reply").innerHTML="通行证或密码错误";
            }
        });
    };


</script>
<script src="/js/common/login.js"></script>
</html>