<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/school/login.css">
<div class="layui-col-md4">
    <div class="fly-panel">
        <div class="fly-panel-main">
            <%-- <a href="/share1" target="_blank" class="fly-zanzhu" style="background-color: #393D49;">我要上传</a>--%>
            <a href="javascript:void(0);" id="upload" target="_blank" class="fly-zanzhu" style="background-color: #393D49;">我要上传</a>
        </div>
    </div>
    <dl class="fly-panel fly-list-one">
        <dt class="fly-panel-title">热门资源</dt>
        <c:forEach items="${hotFileList}" var="hotFile">
            <c:choose>
                <c:when test="${hotFile.fileType == '招生简章' || hotFile.fileType == '招生专业目录'}">
                    <c:if test="${hotFile.isExamine == 1}">
                        <dd>
                            <a href="/file/${hotFile.fileId}">${hotFile.fileTitle}</a>
                            <span> <img src="/images/share/downNum2.svg" class="downNum">${hotFile.downloadNumber}</span>
                        </dd>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <dd>
                        <a href="/file/${hotFile.fileId}" >${hotFile.fileTitle}</a>
                        <span><img src="/images/share/downNum2.svg" class="downNum" > ${hotFile.downloadNumber}</span>
                    </dd>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </dl>
</div>

<%--弹窗登录表单--%>
<div class="modalDialogcontent">
    <div class="formcontent">
        <span class="close_modalDialogcontent">×</span>
        <div class="textcase">
            <div class="logintext">
                <img src="/images/common/logo.png" alt="" srcset="">
            </div>
            <div class="wenhou">
                <a href="">登录优图南，开启你的考研之旅</a>
            </div>
        </div>
        <div  class="reply"></div>
        <form class="loginform" id="loginform" onsubmit="return false" action="##" method="post">
            <div class="permit inputcase">
                <input type="text" name="permit" id="permit" value="${temppermit}" placeholder="手机号/邮箱">
            </div>
            <div class="loginpassword inputcase">
                <input type="password" name="userPassword" id="password" placeholder="密码（8-16位，由数字和字母组成）"/>
                <input type="text" id="login_showPwd" style="display: none"/>
            </div>
            <div class="loginbtn">
                <button id="submitbutton" type="submit">登录</button>
            </div>
            <span><a id="register" href="/register">立即注册</a> </span>
            <span><a id="forpasswork" href="/forgetpasework">忘记密码</a> </span> <%--还未实现该页面--%>
        </form>
    </div>
</div>
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
<script src="/js/common/login.js"></script>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>