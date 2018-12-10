<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>院校详情</title>
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/school/schooldetails.css">
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">    
</head>

<body>
<%@include file="../common/header.jsp"%>
    <div class="schoolheader">
        <span class="collector"></span><a href="#">查看院校收藏夹</a></span>
        <span class="title">院校库</span>
    </div>
    <div class="main">
        <div class="direction">
            <div class="left">
                <img src="../images/school/beida.jpg" class="pic"/>
                <div class="blank"></div>
                <span class="collect"><img src="../images/school/redheart.svg" class="heart"/> 加入院校收藏夹</span>
            </div>
            <div class="right">
                <div class="diractiontitle">${publishDirection.schoolName} - ${publishDirection.majorlName}</div>
                <table>
                    <tr>
                        <td class="zsml-title">招生单位：</td>
                        <td class="zsml-summary" >${publishDirection.schoolName}</td>
                        <td class="ssss" style="color:white">11111</td>
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
        </div><!--direction-->
        <div class="zsml-result">
            <div class="resulttitle"> 考试范围</div>
          <table  cellpadding="10" cellspacing="0" width="100%">
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
                <td>${publishDirection.politics}
                <span class="sub-msg">见招生简章</span>
                </td>
                <td>${publishDirection.english}
                 <span class="sub-msg">见招生简章</span></td>
                <td>${publishDirection.math}
                 <span class="sub-msg">见招生简章</span></td>
                <td>${publishDirection.majorBasics}
                 <span class="sub-msg">见招生简章</span></td>
              </tr>
            </tbody>
          </table>
        </div><!--zsml-result-->
            <div class="commenttitle">讨论区</div>
        <div class="comments">
            <div class="infobar">
                <span class="num">一共有${directionCommentCount}条评论</span>
                <select class="sort"name="" onchange="self.location.href=options[selectedIndex].value">
                    <option value="/displayDirectionDetail?directionId=${publishDirection.directionId}&sort=时间">按时间顺序</option>
                    <option value="/displayDirectionDetail?directionId=${publishDirection.directionId}&sort=热度">按热度排序</option>
                </select>
            </div>
            <c:forEach items="${publishDirection.directionComments}" var="dcomment">
            <div class="comments-content">
                <div class="time"><fmt:formatDate value='${dcomment.directionCommentTime}' type='date' pattern='yyyy-MM-dd HH:mm:ss'/></div>
                <div class="nickname">${dcomment.user.userNickName}</div>
                <div class="comments-content-content">${dcomment.directionCommentContent}</div>
                <div class="b">
                    <div class="comments-content-praise">赞（${dcomment.directionCommentPraiseCount}）</div>
                    <img src="images/community/jia1.svg" width="22px"height="22px">
                    <div class="comments-content-give-praise"><a href="/updateDirectionCommentPraiseCount?directionCommentId=${dcomment.directionCommentId}&directionId=${publishDirection.directionId}">点赞</a></div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
            <form action="comment1?commentId=${answer.commentId}">
                <div class="comments-reply">
                    <input class="comments-reply-input"type="text" width="660px" height="30px" name="text">
                    <div class="comments-reply-report"><input type="submit" value="发表评论"/></div>
                </div>
            </form>
        </div>
    </div>
    浏览量：${viewCount}
</body>
<%--<script>
    if (localStorage.pagecount){
        localStorage.pagecount=Number(localStorage.pagecount)+1;
    }
    else{
        localStorage.pagecount=1;
    }
    document.getElementById("viewCount").innerHTML=localStorage.pagecount;
</script>--%>
</html>