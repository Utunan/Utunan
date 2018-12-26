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
    <link rel="stylesheet" href="/css/share/file.css">
    <link rel="stylesheet" href="/css/school/login.css">
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
<%--黑背景--%>
<div class="mask"></div>
<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md8">
      <div class="fly-panel" style="margin-bottom: 0;">
          <form name="form1" action="/searchfile" method="post">
              <div class="threeops">
                <div class="op">
                    <span class="st">资源类型 >></span>
                    <div class="RadioStyle">
                        <div class="Block PaddingL" id="type">
                            <input class="all" type="checkbox" name="fileType" value="全部" id="全部" checked="checked"><label for="全部">全部</label>
                            <input class="part" type="checkbox" name="fileType" value="招生简章" id="招生简章"><label for="招生简章">招生简章</label>
                            <input class="part" type="checkbox" name="fileType" value="招生专业目录" id="招生专业目录"><label for="招生专业目录">招生专业目录</label>
                            <input class="part" type="checkbox" name="fileType" value="考研真题" id="考研真题"><label for="考研真题">考研真题</label>
                            <input class="part" type="checkbox" name="fileType" value="备考习题" id="备考习题"><label for="备考习题">备考习题</label>
                            <input class="part" type="checkbox" name="fileType" value="课件分享" id="课件分享"><label for="课件分享">课件分享</label>
                            <input class="part" type="checkbox" name="fileType" value="参考书目" id="参考书目"><label for="参考书目">参考书目</label>
                        </div>
                    </div>
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
                    <span  class="st">关键词搜索 ></span>
                    <input name="keyWord" type="text" id="direction" placeholder="（选填）如：一心跟着组长走"  class="layui-input">
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
              <%@include file="page1.jsp"%>
          </c:if>
        </div>
    </div><!--上边这-->
  <!--右边这-->
  <%@include file="right.jsp"%>
</div>
</div>
<%--弹窗登录表单--%>
<%@include file="login.jsp"%>
<%@include file="../common/footer.jsp"%>
</body>
<script>
    //刷新分页或搜索后复选框选中状态保持
    var type=document.getElementById("type");
    var inputs=type.getElementsByTagName("input");

    if("${fileType}"=="全部"||"${fileType}"==""){
        inputs[0].checked=true;
    }else{
        inputs[0].checked=false;
        for(var j=1;j<inputs.length;j++){
            <c:forEach items="${fileType}" varStatus="status" var="fileType">
            if("${fileType}"==inputs[j].value){
                inputs[j].checked=true;
            }
            </c:forEach>
        }
    }
    //复选框全部与部分选中切换
    $(".part").click(function(){
        if($(".all").is(":checked")){//如果点击的时候，当前为选中状态
            $(".all").attr("checked",false);//那么就改为未选中
        }else{
            $(".all").attr("checked",true)//否则就改为选中
        }
    })
    $(".all").click(function(){
        $(".part").attr("checked",false);
    })

    //搜索框文字保持
    var direction=document.getElementById("direction");
    if("${keyWord}"!=""){
        direction.value="${keyWord}";
    }
</script>
<script>
    /*弹窗登录功能*/
    var ask=document.getElementById("upload");
    var mask=document.getElementsByClassName("mask")[0];
    var modalDialogcontent=document.getElementsByClassName("modalDialogcontent")[0];
    /*获取提交按钮*/
    var submitbutton = document.getElementById("submitbutton");
    /*获取密码框*/
    password = document.getElementById('password');
    textpassword=document.getElementById("login_showPwd");

    /*点击评论提交判断是否是用户，不是用户则弹出框*/
    ask.onclick=function(){
        if(${user==null}){
            mask.style.display="block";
            modalDialogcontent.style.display="block";
        }else{
            window.location.href="/share1";
        }
    };
    /*点击小叉号然后关闭*/
    var close_modalDialogcontent=document.getElementsByClassName("close_modalDialogcontent")[0];
    close_modalDialogcontent.onclick=function(){
        mask.style.display="none";
        modalDialogcontent.style.display="none";
    };

    //判断用户名和密码
    submitbutton.onclick=function(){
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/school/popsupLogin" ,//url
            data: $('#loginform').serialize(),
            success: function (result) {
                console.log(result);//打印服务端返回的数据(调试用)
                if(result==true){
                    console.log("登录成功");
                    window.location.href="/share1";
                }else{
                    textpassword.style.display="block";
                    password.style.display="none";
                    textpassword.parentNode.style.border = '1px solid red';
                    textpassword.style.color="red";
                    textpassword.value="密码错误";
                }
            },
            error : function() {
                console.log("网崩了！")
            }
        });
    };
</script>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="/js/common/common.js"></script>
<script src="/js/common/login.js"></script>
<script>
    //分页页码选中刷新后样式
    var page=document.getElementById("page");
    var pages=page.getElementsByTagName("a");
    console.log(${PageInfo.pageNum});
    console.log(pages);
    if(${PageInfo.pageNum==Null}){
        pages[0].style.backgroundColor="#009E94";
        pages[0].style.color="#ffffff";
    }else{
        pages[0].style.backgroundColor="";
        for(var i=0;i<pages.length;i++){
            console.log(pages[i].innerHTML);
            if(pages[i].innerHTML=="${PageInfo.pageNum}") {
                pages[i].style.backgroundColor="#009E94";
                pages[i].style.color="#ffffff";
            }
        }
    }
</script>
</html>