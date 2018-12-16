<!--这是院校库2.0-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>院校详情</title>
  <link rel="stylesheet" href="/layui/wyd/layui.css">
  <link rel="stylesheet" href="/layui/wyd/global.css">
  <link rel="stylesheet" href="/css/school/detail.css">
</head>
<script src="/js/community/jquery-1.10.2.js"></script>
<script src="/js/jquery-1.8.3.min.js"></script>
<body>
<style>
  .layui-layer-page{
    top:300px;
  }
</style>
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
                 <%-- <div class="layui-timeline-title">&nbsp;&nbsp;<a href="/download?fileId=${EGfile.fileId}">查看《${year}年${publishDirection.schoolName}硕士研究生招生简章》</a></div>--%>
                  <div class="layui-timeline-title">&nbsp;&nbsp;<a href="/school/displayEG?schoolName=${publishDirection.schoolName}&fileType=招生简章">查看《${year}年${publishDirection.schoolName}硕士研究生招生简章》</a></div>
                </c:when>
                <c:otherwise>
                  <div class="layui-timeline-title">《${year}年${publishDirection.schoolName}硕士研究生招生简章》暂缺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a>我要上传</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/searchfile?school=${publishDirection.schoolName}&fileType=招生简章&keyWord=">查看往年招生简章</a></div>
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
                  <div class="layui-timeline-title">《${year}年${publishDirection.schoolName}硕士研究生招生目录》暂缺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a>我要上传</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/searchfile?school=${publishDirection.schoolName}&fileType=招生专业目录&keyWord=">查看往年招生目录</a></div>
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
        <div class="layui-form layui-form-pane">
          <form action="/school/insertDirectionComment?directionId=${publishDirection.directionId}&schoolName=${publishDirection.schoolName}" method="post">
            <div class="layui-form-item layui-form-text">
              <a name="comment"></a>
              <div class="layui-input-block">
                <textarea id="L_content" name="content" required lay-verify="required" placeholder="请输入内容"  class="layui-textarea fly-editor" style="height: 150px;"></textarea>
              </div>
            </div>
            <div class="layui-form-item">
              <input type="hidden" name="jid" value="123"/>
              <button data-method="notice" class="layui-btn" lay-filter="*" lay-submit onclick="addlesson()">提交回复</button>
            </div>
          </form>

          <div class="site-demo-button" id="layerDemo" style="margin-bottom: 0;">
            <button data-method="notice" class="layui-btn" lay-filter="*" lay-submit onclick="addlesson()">测试</button>
            <%--<button data-method="setTop" class="layui-btn">多窗口模式，层叠置顶</button>
            <button data-method="confirmTrans" class="layui-btn">配置一个透明的询问框</button>
            <button data-method="notice" class="layui-btn">示范一个公告层</button>
            <button data-method="offset" data-type="t" class="layui-btn layui-btn-normal">上弹出</button>
            <button data-method="offset" data-type="r" class="layui-btn layui-btn-normal">右弹出</button>
            <button data-method="offset" data-type="b" class="layui-btn layui-btn-normal">下弹出</button>
            <button data-method="offset" data-type="l" class="layui-btn layui-btn-normal">左弹出</button>
            <button data-method="offset" data-type="lt" class="layui-btn layui-btn-normal">左上弹出</button>
            <button data-method="offset" data-type="lb" class="layui-btn layui-btn-normal">左下弹出</button>
            <button data-method="offset" data-type="rt" class="layui-btn layui-btn-normal">右上弹出</button>
            <button data-method="offset" data-type="rb" class="layui-btn layui-btn-normal">右下弹出</button>
            <button data-method="offset" data-type="auto" class="layui-btn layui-btn-normal">居中弹出</button>--%>
          </div>
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
<script src="/js/school/layer/layer.js"></script>
<script>
    function addlesson(){
        layui.use('layer', function() { //独立版的layer无需执行这一句
            var layer = layui.layer; //独立版的layer无需执行这一句$ = layui.jquery,
              layer.open({
                  type: 1
                  , title: '用户登录'//不显示标题栏
                  , closeBtn: false
                  , area: '200px;'
                  , shade: 0.8
                  , id: 'LAY_layuipro' //设定一个id，防止重复弹出
                  , btn: ['火速围观', '残忍拒绝']
                  , btnAlign: 'c'
                  , moveType: 1 //拖拽模式，0或者1
                  , content: '出现吧，皮卡丘！！！'
                  , success: function (layero) {
                      var btn = layero.find('.layui-layer-btn');
                      btn.find('.layui-layer-btn0').attr({
                          href: 'http://www.layui.com/'
                          , target: '_blank'
                      });
                  }
              })
        })
    }

    /*layui.use('layer', function(){ //独立版的layer无需执行这一句
        var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句

        //触发事件
        var active = {
            setTop: function(){
                var that = this;
                //多窗口模式，层叠置顶
                layer.open({
                    type: 2 //此处以iframe举例
                    ,title: '当你选择该窗体时，即会在最顶端'
                    ,area: ['390px', '260px']
                    ,shade: 0
                    ,maxmin: true
                    ,offset: [ //为了演示，随机坐标
                        Math.random()*($(window).height()-300)
                        ,Math.random()*($(window).width()-390)
                    ]
                    ,content: '//layer.layui.com/test/settop.html'
                    ,btn: ['继续弹出', '全部关闭'] //只是为了演示
                    ,yes: function(){
                        $(that).click();
                    }
                    ,btn2: function(){
                        layer.closeAll();
                    }

                    ,zIndex: layer.zIndex //重点1
                    ,success: function(layero){
                        layer.setTop(layero); //重点2
                    }
                });
            }
            ,confirmTrans: function(){
                //配置一个透明的询问框
                layer.msg('大部分参数都是可以公用的<br>合理搭配，展示不一样的风格', {
                    time: 20000, //20s后自动关闭
                    btn: ['明白了', '知道了', '哦']
                });
            }
            ,notice: function(){
                //示范一个公告层
                layer.open({
                    type: 1
                    ,title: false //不显示标题栏
                    ,closeBtn: false
                    ,area: '300px;'
                    ,shade: 0.8
                    ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                    ,btn: ['火速围观', '残忍拒绝']
                    ,btnAlign: 'c'
                    ,moveType: 1 //拖拽模式，0或者1
                    ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
                    ,success: function(layero){
                        var btn = layero.find('.layui-layer-btn');
                        btn.find('.layui-layer-btn0').attr({
                            href: 'http://www.layui.com/'
                            ,target: '_blank'
                        });
                    }
                });
            }
            ,offset: function(othis){
                var type = othis.data('type')
                    ,text = othis.text();

                layer.open({
                    type: 1
                    ,offset: type //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
                    ,id: 'layerDemo'+type //防止重复弹出
                    ,content: '<div style="padding: 20px 10px;">'+ text +'</div>'
                    ,btn: '关闭全部'
                    ,btnAlign: 'c' //按钮居中
                    ,shade: 0 //不显示遮罩
                    ,yes: function(){
                        layer.closeAll();
                    }
                });
            }
        };

        $('#layerDemo .layui-btn').on('click', function(){
            var othis = $(this), method = othis.data('method');
            active[method] ? active[method].call(this, othis) : '';
        });

    });
*/
</script>
</html>