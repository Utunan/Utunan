<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="plate" value="myspace"/>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>个人中心</title>
    <link rel="shortcut icon" href="/images/common/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/user/userhome.css">
    <link rel="stylesheet" href="/css/user/usercommon.css">
    <link rel="stylesheet" type="text/css" href="/css/user/font-awesome.4.6.0.css">
    <link rel="stylesheet" href="/css/user/amazeui.min.css">
    <link rel="stylesheet" href="/css/user/amazeui.cropper.css">
    <link rel="stylesheet" href="/css/user/custom_up_img.css">
    <style type="text/css">
        .up-img-cover {
            width: 100px;
            height: 100px;
        }

        .up-img-cover img {
            width: 100%;
        }
    </style>
</head>

<body>
<%@include file="../common/header.jsp" %>
<%@include file="common/usercard.jsp" %>
<div class="container" style="margin-top: 30px;">
    <div class="wrapper background">
        <%@include file="common/userfunction.jsp" %>
        <div class="content" id="content">
            <div class="title">
                <span>个人资料</span>
            </div>
            <div class="userinfoform">
                <form id="userinfoform" action="/user/changeInfo" method="post">
                    <nav>
                        <li>
                            <label for="userNickName">昵&emsp;&emsp;称</label>
                            <input type="text" id="userNickName" name="userNickName" value="${User.userNickName}"
                                   placeholder="${User.userNickName}"/>
                        </li>
                        <li>
                            <label for="dreamSchool">目标院校</label>
                            <input type="text" id="dreamSchool" name="dreamSchool" value="${User.dreamSchool}"
                                   placeholder="${User.dreamSchool}"/>
                        </li>
                        <li>
                            <label for="userSchool">本科院校</label>
                            <input type="text" id="userSchool" name="userSchool" value="${User.userSchool}"
                                   placeholder="${User.userSchool}"/>
                        </li>
                        <li>
                            <label for="userTelephone">绑定手机</label>
                            <input type="hidden" id="userTelephone" name="userTelephone" value="${User.userTelephone}"/>
                            <span style="line-height: 32px;">${User.userTelephone}</span>
                            <span><a href="/user/settings#userfunction"><img src="/images/user/edit.svg"></a></span>
                        </li>
                        <li>
                            <label for="userEmail">绑定邮箱</label>

                            <input type="hidden" id="userEmail" name="userEmail" value="${User.userEmail}"
                                   placeholder="${User.userEmail}"/>
                            <span style="line-height: 32px;">${User.userEmail==null?"用户未设置邮箱":User.userEmail}</span>
                            <span><a href="/user/settings#changeemail"><img src="/images/user/edit.svg"></a></span>
                        </li>
                        <li>
                            <label for="examTime">考研年份</label>
                            <select name="examTime" id="examTime" autofocus="autofocus">
                                <c:forEach begin="2020" end="2024" var="i">
                                    <c:choose>
                                        <c:when test="${User.examTime==i}">
                                            <option value="${i}" selected="true">${i}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${i}">${i}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </li>
                        <li>
                            <label>注册时间</label>
                            <span style="line-height: 32px;"><fmt:formatDate value="${User.registerTime }" type="date"
                                                                             pattern="yyyy-MM-dd HH:mm:ss"/></span>
                        </li>
                        <li class="userop">
                            <button type="submit">提交</button>
                            <button type="reset">撤销</button>
                        </li>

                    </nav>
                </form>
            </div>

            <div class="changeheadimg">
                <div class="up-img-cover" id="up-img-touch">
                    <img class="am-circle" alt="点击图片上传" src="${User.userHeadImg}"
                         data-am-popover="{content: '更改头像', trigger: 'hover focus'}">
                </div>
            </div>
        </div>
        <div><a style="text-align: center; display: block;" id="pic"></a></div>

        <!--图片上传框-->
        <div class="am-modal am-modal-no-btn up-frame-bj " tabindex="-1" id="doc-modal-1">
            <div class="am-modal-dialog up-frame-parent up-frame-radius">
                <div class="am-modal-hd up-frame-header">
                    <label>修改头像</label>
                    <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
                </div>
                <div class="am-modal-bd  up-frame-body">
                    <div class="am-g am-fl">
                        <div class="am-form-group am-form-file">
                            <div class="am-fl">
                                <button type="button" class="am-btn am-btn-default am-btn-sm">
                                    <i class="am-icon-cloud-upload"></i> 选择要上传的文件
                                </button>
                            </div>
                            <input type="file" id="inputImage">
                        </div>
                    </div>
                    <div class="am-g am-fl">
                        <div class="up-pre-before up-frame-radius">
                            <img alt="" src="" id="image">
                        </div>
                        <div class="up-pre-after up-frame-radius">
                        </div>
                    </div>
                    <div class="am-g am-fl">
                        <div class="up-control-btns">
                            <span class="am-icon-rotate-left" onclick="rotateimgleft()"></span>
                            <span class="am-icon-rotate-right" onclick="rotateimgright()"></span>
                            <span class="am-icon-check" id="up-btn-ok" url="admin/user/upload.action"></span>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <!--加载框-->
        <div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
            <div class="am-modal-dialog">
                <div class="am-modal-hd">正在上传...</div>
                <div class="am-modal-bd">
                    <span class="am-icon-spinner am-icon-spin"></span>
                </div>
            </div>
        </div>

        <!--警告框-->
        <div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
            <div class="am-modal-dialog">
                <div class="am-modal-hd">信息</div>
                <div class="am-modal-bd" id="alert_content">
                    成功了
                </div>
                <div class="am-modal-footer">
                    <span class="am-modal-btn">确定</span>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp" %>
</body>
<script src="/js/user/usercommon.js"></script>
<script src="/js/common/common.js"></script>
<script src="/js/jquery-1.8.3.min.js"></script>
<script src="/js/user/amazeui.min.js" charset="utf-8"></script>
<script src="/js/user/cropper.min.js" charset="utf-8"></script>
<script src="/js/user/custom_up_img.js" charset="utf-8"></script>
</html>