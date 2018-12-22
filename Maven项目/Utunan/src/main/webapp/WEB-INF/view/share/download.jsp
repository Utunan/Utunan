<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/12/13
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载</title>
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/community/layui.css">
    <link rel="stylesheet" href="/css/community/global.css">
    <link rel="stylesheet" href="/css/share/download.css">
    <link rel="stylesheet" href="/css/share/file.css">
    <link rel="stylesheet" href="/css/school/login.css">
    <link rel="stylesheet" href="/css/school/animate.css">
    <link rel="stylesheet" href="/css/school/dialog.css">
</head>
<script src="/js/community/jquery-1.10.2.js"></script>
<body>
<%@include file="../common/header.jsp"%>
<%--黑背景--%>
<div class="mask"></div>
<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">
            <div class="fly-panel" style="margin-bottom: 0;">
                <div class="download-file-detail">
                    <div class="fly-avatar">
                        <img src="${file.suffix.imgUrl}" alt="文件类型" >
                    </div>
                    <div class="detail-top">
                        ${file.fileTitle}
                        <span><a class="fileType" href="/searchfile?fileType=${file.fileType}&school=${file.fileSchool}&keyWord=">${file.fileType}</a></span>
                        <span><a class="fileSchool" href="/searchfile?fileType=全部&school=${file.fileSchool}&keyWord=">${file.fileSchool}</a></span>
                    </div>
                    <div class="detail">
                        所在院校：<span>${file.user.userSchool}</span>
                        目标院校：<span>${file.user.dreamSchool}</span>
                    </div>
                    <div class="from"><span>来自<a href="">${file.user.userNickName}</a></span></div>
                </div>
                <div class="download">
                    <form class="doenload-form" name="form1" action="/downloadfile/${file.fileId}" method="post" onsubmit="return false" ><%--check(this)--%>
                        <input type="hidden" name="operate" value="${operate}">
                        <input id="download" class="input" type="submit" value="点击下载"/>
                    </form>
                    <div class="rightdetail" style="margin-right: 15px">
                        <span ><img src="/images/share/credit.svg"  class="credit" width="20px" height="20px">${file.fileCredit}</span>
                        <span ><img src="/images/share/downNum.svg"  class="downNum" width="20px" height="20px">${file.downloadNumber}</span>
                    </div>
                </div>
            </div>
            <div class="fly-panel" style="margin-bottom: 0; margin-top:20px">
                <div class="top">
                    相关文件
                </div>
                <ul class="list">
                    <c:forEach items="${relatedFileList}" var="f">
                        <c:if test="${file.fileId != f.fileId}">
                            <li>
                                <div>
                                    <img src="${f.suffix.imgUrl}" alt="文件类型" class="siffix">
                                    <span class="tn"><a href="/file/${f.fileId}" style="color: black">${f.fileTitle}</a></span>
                                    <div class="topdetail">
                                        <span class="ft"> ${f.fileType}</span>
                                        <span class="fs">${f.fileSchool}</span>
                                    </div>
                                    <span class="un">${f.user.userNickName}&nbsp;于${f.fileTime}上传</span>
                                    <div class="rightdetail">
                                        <span class="fc"><img src="/images/share/credit.svg"  class="credit">${f.fileCredit}</span>
                                        <span class="dn"><a href="/file/${f.fileId}" style="color: black"><img src="/images/share/downNum.svg"  class="downNum"></a>${f.downloadNumber}</span>
                                    </div>
                                </div>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
                <div class="none">
                    没有与之相关的文件哦~
                </div>
            </div>
        </div>
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
                                    <a href="/file/${hotFile.fileId}" style="color: red">${hotFile.fileTitle}</a>
                                    <span><i class="iconfont icon-pinglun1"></i> ${hotFile.downloadNumber}</span>
                                </dd>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <dd>
                                <a href="/file/${hotFile.fileId}" style="color: red">${hotFile.fileTitle}</a>
                                <span><i class="iconfont icon-pinglun1"></i> ${hotFile.downloadNumber}</span>
                            </dd>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </dl>
        </div>
    </div>
</div>
<%--弹窗登录表单--%>
<div class="modalDialogcontent">
    <span class="close_modalDialogcontent">×</span>
    <div class="textcase">
        <div class="logintext">
            <a href="">登录</a>
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
            <button id="closeAll">不了</button>
            <button id="submitbutton" type="submit">登录</button>
        </div>
        <span><a id="register" href="/register">立即注册</a> </span>
        <span><a id="forpasswork" href="/forgetpasswork">忘记密码</a> </span> <%--还未实现该页面--%>
    </form>
</div>
<!--

    <div>
        <h3>相关文件</h3>
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
            <c:forEach items="${relatedFileList}" var="f">
                <c:if test="${file.fileId != f.fileId}">
                <tr>
                    <td><img src="${f.suffix.imgUrl}" alt="文件类型" style="width: 20px; height: 20px"></td>
                    <td><a href="/download?fileId=${f.fileId}" style="color: black">${f.fileTitle}</a></td>
                    <td>${f.user.userNickName}</td>
                    <td>${f.fileType}</td>
                    <td>${f.fileSchool}</td>
                    <td>${f.fileCredit}</td>
                    <td>${f.downloadNumber}</td>
                </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>
    <div>
        <h3>热门文件</h3>
        <table>
            <tr>
                <td>文件</td>
                <td>下载次数</td>
            </tr>
            <c:forEach items="${hotFileList}" var="hotFile">
                <tr>
                    <td><a href="/download?fileId=${hotFile.fileId}">${hotFile.fileTitle}</a></td>
                    <td>${hotFile.downloadNumber}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    -->
<%@include file="../common/footer.jsp"%>
</body>
<script>
    //没有相似文件时展示
    var list=document.getElementsByClassName("list")[0];
    var li=list.getElementsByTagName("li");
    var none=document.getElementsByClassName("none")[0];
    if(li.length==0){
        none.style.display="block";
    }
</script>
<script type="text/javascript">

    /*function check(form) {
        if (form.operate.value=="notLogin") {
            alert("请先登录！")
            return false;
        }
        if (form.operate.value=="lackOfIntegral") {
            alert("您的积分不足，快去发帖、评论赚积分吧！")
            return false;
        }
        document.form1.submit();
    }*/

    /*弹窗登录功能*/
    var ask=document.getElementById("download")
    var mask=document.getElementsByClassName("mask")[0];
    var modalDialogcontent=document.getElementsByClassName("modalDialogcontent")[0];
    /*获取提交按钮*/
    var submit = document.getElementById("submitbutton");
    /*获取关闭按钮*/
    var closeAll = document.getElementById("closeAll");
    /*判断是否是用户*/
    ask.onclick=function(){
        if (form1.operate.value=="notLogin") {
            //没有登录
            console.log("不是用户");
            mask.style.display="block";
            modalDialogcontent.style.display="block";
        }else {
            console.log("是用户");
            if (form1.operate.value=="lackOfIntegral") {
                //积分不足
                javascript:$('body').dialog({type:'success'});
            }else {
                //满足条件，可以下载
                console.log("可以下载");
                document.form1.submit();
            }
        }

    }
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
            type: "POST",//方法类型
            dataType: "json",//预期服务器返回的数据类型
            url: "/school/popsupLogin" ,//url
            data: $('#loginform').serialize(),
            success: function (result) {
               if (result==true){
                window.location.href="/file/${file.fileId}";
                }else{
                    document.getElementById("reply").innerHTML="通行证或密码错误";
                }
            },
            error : function() {
                document.getElementById("reply").innerHTML="网可能崩了，请您稍等一会~";
            }
        });
    };

</script>
<script charset="UTF-8" type="text/javascript"  src="/js/share/dialog.js"></script>
<script src="/js/common/login.js"></script>
</html>
