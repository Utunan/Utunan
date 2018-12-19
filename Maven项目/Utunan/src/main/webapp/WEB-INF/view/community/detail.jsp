<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page import="java.util.List,com.utunan.pojo.*" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>帖子详情</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/css/community/layui.css">
  <link rel="stylesheet" href="/css/community/global.css">
  <link rel="stylesheet" href="/css/community/detail.css">
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
    <script type="text/javascript" src="https://unpkg.com/wangeditor@3.1.1/release/wangEditor.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.4.2.min.js"></script>
    <script> var pagenum = "${PageInfo.pageNum}"</script>
    <script>
        function praise(quizId){
            $.ajax({
                url:'praise',//处理数据的地址
                type:'post',//数据提交形式
                data:{'quizId':quizId},//需要提交的数据
                success:function(data){//数据返回成功的执行放大
                    if(data=='ok'){//成功
                        //alert('点赞成功');
                        document.getElementById("i5").innerHTML=${quiz.praiseCount}+1;
                    }
                    if(data=='no'){//失败
                        //alert('取消点赞');
                       document.getElementById("i5").innerHTML=${quiz.praiseCount};
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    bootbox.alert("无法连接服务器:" + textStatus);
                }
            });
        }
    </script>

    <script>
        function apraise(answerId,praiseCount){
            $.ajax({
                url:'/aprise',//处理数据的地址
                type:'post',//数据提交形式
                data:{'answerId':answerId},//需要提交的数据
                success:function(d){//数据返回成功的执行放大
                    if(d=='ok'){//成功
                        //alert('点赞成功');
                        document.getElementById("answer"+answerId).innerHTML=praiseCount+1;
                    }
                    if(d=='no'){//失败
                        //alert('取消点赞');
                        document.getElementById("answer"+answerId).innerHTML=praiseCount;
                    }
                },
            });
        }
    </script>

</head>
<body style="overflow:scroll;overflow-y:hidden" >
<body>
<%@include file="../common/header.jsp" %>
<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md8 content detail">
      <div class="fly-panel detail-box">
          <div class="detail-about">
              <a class="fly-avatar" href="../user/home.html">
                  <img src="${quiz.user.userHeadImg}" width="35px" height="35px">
              </a>
              <div class="fly-detail-user">
                <a href="../user/home.html" class="fly-link">
                  <cite>${quiz.user.userNickName}</cite>
                </a>
                <span>发表于&nbsp;
                    <fmt:formatDate value="${quiz.releaseTime}" type="both"/>
                </span>
              </div>
              <div class="detail-hits" id="LAY_jieAdmin" data-id="123">
                <span style="padding-right: 10px; color: #FF7200">考研年份：${quiz.user.examTime}</span>
                <span style="padding-right: 10px; color: #FF7200">所在院校：${quiz.user.userSchool}</span>
                <span style="padding-right: 10px; color: #FF7200">目标院校：${quiz.user.dreamSchool}</span>
              </div>
            </div>
        <h1>${quiz.quizTitle}</h1>
        <div class="fly-detail-info">
            <c:forEach items="${quizTagList}" var="quiztag">
          <span class="layui-badge layui-bg-red"><a href="/quiztag?tagName=${quiztag.tag.tagName}">&nbsp;${quiztag.tag.tagName} &nbsp</a></span>
            </c:forEach>
        </div>
        <div class="quizcontent">
        <div class="detail-body photos">
          <p id="pcontent"> ${quiz.quizContent}</p>
          <div class="quiztoolbar">

            <div class="jieda-reply" id="good">
              <span class="jieda-zan zanok" type="zan">
                  <a href="javascript:void(0)" onclick="praise(${quiz.quizId})"><i class="iconfont icon-zan"></i></a>
                <em id="i5">${quiz.praiseCount}</em>
              </span>
            </div>
    
            <div class="re_num"> 
                <img src="images/community/zan.svg" width="24px"height="34px">
                <span class="write-reply">${answerCountByQuizId}</span>
            </div>
            <div class="collect">
                <a href="javascript:void(0)" onclick="window.location.href='/quizCollector?quizId=${quiz.quizId}'"><img src="/images/community/shoucang.svg" width="28px"
                                                             height="34px"></a>
                <span class="collection">收藏此问题</span>
            </div>
          </div><!--toolbar-->
          </div><!--quizcontent-->
        </div>
      </div>

      <div class="fly-panel detail-box" id="flyReply">
        <fieldset class="layui-elem-field layui-field-title" style="text-align: center;">
          <legend>回答</legend>
        </fieldset>
          <select class="sequencing-principle" name="" onchange="self.location.href=options[selectedIndex].value">
              <option value="/quiz/${quiz.quizId}" ${timeselect}>按时间顺序</option>
              <option value="/displayCommentByPraiseCount?quizId=${quiz.quizId}"  ${praiseselect}>按热度排序</option>
          </select>
        <ul class="jieda" id="jieda">
            <c:forEach items="${answer}" var="answer" varStatus="cou">
          <li data-id="111" class="jieda-daan">
            <a name="item-1111111111"></a>
            <div class="detail-about detail-about-reply">
              <a class="fly-avatar" href="">
                  <img src="${answer.user.userHeadImg}" width="55px" height="55px">
              </a>
              <div class="fly-detail-user">
                <a href="" class="fly-link">
                  <cite>${answer.user.userNickName}</cite>
                </a>
                <span>发表于
                    <fmt:formatDate value="${answer.answerTime}" type="both"/>
                </span>
              </div>
    
              <div class="detail-hits">
                <span>所在院校：${answer.user.userSchool}&nbsp;&nbsp;&nbsp;目标院校：${answer.user.dreamSchool}</span>
              </div>
            </div>
            <div class="detail-body jieda-body photos">
              <p>${answer.answerContent}</p>
            </div>
            <div class="jieda-reply">
              <span class="jieda-zan zanok" type="zan">
                  <a href="javascript:void(0)" onclick="apraise(${answer.answerId},${answer.praiseCount})"><i class="iconfont icon-zan"></i></a>
                <em id="answer${answer.answerId}">${answer.praiseCount}</em>
              </span>
              <span type="reply">
                <i class="iconfont icon-svgmoban53"></i>
                回复
              </span>
              <div class="jieda-admin">
                  <c:forEach items="${map0.keySet()}" var="b">
                  <c:if test="${b.answerId==answer.answerId}">
                <div class="view-comments">查看评论（${map0.get(b)}）</div>
                      <c:set var="commentNum" value="${map0.get(b)}"/>
                  </c:if>
                  </c:forEach>
              </div>
              <div class="comments" style="display:none">
              <blockquote class="layui-elem-quote" id="haha" style="background-color:#fafafa">
                        <select class="comments-sequencing-principle"name="" id="sq">
                            <option value="0">按时间顺序</option> 
                            <option value="1">按热度排序</option> 
                        </select> 
                        <div class="close">收起评论</div>
                  <c:if test="${commentNum==0}">
                      <div class="slogen">啊嘞！还没有评论~</div>
                  </c:if>
              </blockquote>
    
                 <c:if test="${commentNum!=0}">
                <ul class="commentlist" style="background-color:#fafafa">
                    <c:forEach items="${map.keySet()}" var="m1">
                        <c:if test="${m1.answerId==answer.answerId}">
                        <c:forEach items="${map.get(m1)}" var="m2">
                    <li>
                        <div class="fly-detail-user">
                          <a href="" class="fly-link">
                            <cite>${m2.user.userNickName}</cite>
                          </a>
                           <span>发表于
                               <fmt:formatDate value="${m2.getAnswerTime() }" pattern="yyyy-MM-dd "/>
                           </span>
                        </div>
                        <div class="detail-body jieda-body photos">
                          <p>${m2.answerContent}</p>
                        </div>
                         <div class="jieda-reply">
                          <span class="jieda-zan zanok" type="zan">
                          <i class="iconfont icon-zan"></i>
                          <em>${m2.praiseCount}</em>
                          </span>
                        </div>
                    </li>
                        </c:forEach>
                        </c:if>
                    </c:forEach><!--评论循环完毕-->
                </ul>
                </c:if>
            </div></div>
          </li>
                <!--a answer-->
            </c:forEach>
        </ul>
    
            <div class="write-answer" class="layui-form layui-form-pane">
                <div class="write-answer-top">
                    <img src="/images/community/write.svg" width="25px" height="25px">
                    <div class="write-answer-top">&nbsp;&nbsp;&nbsp;&nbsp;写回答</div>
                </div>
                <!--富文本编辑器-->
                <form action="/answer?quizId=${quiz.quizId}" method="post">
                    <div class="text">
    
                        <div id="div1" class="toolbar" style="height: 35px"></div>
                        <div id="div2" style="height: 130px"></div>
                        <textarea id="text1" style="display: none" name="textarea"></textarea>
    
                    </div>
                    <div class="write-answer-bottom">
                        <div class="write-answer-bottom-content">
                            <button  type="submit" class="layui-btn layui-btn-fluid">提交回答</button>
                        </div>
                    </div>
                </form>
            </div>
      </div>
    </div>
      <%@include file="right.jsp"%>
  </div>
</div>
</body>
<script>
    var viewComments=window.document.getElementsByClassName("view-comments");
    var index;
    for(var i=0;i<viewComments.length;i++){
        viewComments[i].index=i;
        viewComments[i].onclick = function(){
            var j=this.index;
            var comments=this.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("comments");
            comments[j].style.display="block"
        }
    }

    var close=window.document.getElementsByClassName("close");
    for(var i=0;i<close.length;i++){
        close[i].index=i;
        close[i].onclick = function(){
            var j=this.index;
            var comments=this.parentElement.parentElement.parentElement.parentElement.parentElement.getElementsByClassName("comments");
            comments[j].style.display="none";
        }
    }

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
<script src="/js/common/login.js"></script>
<script src="/js/common/common.js"></script>
</body>
</html>