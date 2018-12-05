<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List,com.utunan.pojo.*"%>
<%@ taglib uri="/intel" prefix="ya" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>欢迎来到Utunan</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/school/school.css">
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
    <script>
        var pagenum="${PageInfo.pageNum}"
    </script>
</head>

<body>
    <%--<%@include file="../common/header.jsp"%>--%>
    <!--<div class="title">院校库</div>-->
    <form class="condition" action="/displaySchoolBySearch">
        <div class="bigwrapper">
            <div  class="RadioStyle">
                <div class="options">
                    <span class="optionName">院校所在地 ></span>
                    <div class="option">
                        <input name="schoolProvince" type="checkbox" value="全部" id="所在地全部" checked><label for="所在地全部">全部</label>
                        <input name="schoolProvince" type="checkbox" value="北京" id="北京"><label for="北京">北京</label>
                        <input name="schoolProvince" type="checkbox" value="天津" id="天津"><label for="天津">天津</label>
                        <input name="schoolProvince" type="checkbox" value="上海" id="上海"><label for="上海">上海</label>
                        <input name="schoolProvince" type="checkbox" value="重庆" id="重庆"><label for="重庆">重庆</label>
                        <input name="schoolProvince" type="checkbox" value="河北" id="河北"><label for="河北">河北</label>
                        <input name="schoolProvince" type="checkbox" value="山西" id="山西"><label for="山西">山西</label>
                        <input name="schoolProvince" type="checkbox" value="辽宁" id="辽宁"><label for="辽宁">辽宁</label>
                        <input name="schoolProvince" type="checkbox" value="吉林" id="吉林"><label for="吉林">吉林</label>
                        <input name="schoolProvince" type="checkbox" value="黑龙江" id="黑龙江"><label for="黑龙江">黑龙江</label>
                        <input name="schoolProvince" type="checkbox" value="江苏" id="江苏"><label for="江苏">江苏</label>
                        <input name="schoolProvince" type="checkbox" value="浙江" id="浙江"><label for="浙江">浙江</label>
                        <input name="schoolProvince" type="checkbox" value="安徽" id="安徽"><label for="安徽">安徽</label>
                        <input name="schoolProvince" type="checkbox" value="福建" id="福建"><label for="福建">福建</label>
                        <input name="schoolProvince" type="checkbox" value="江西" id="江西"><label for="江西">江西</label>                                <input name="schoolProvince" type="checkbox" value="山东" id="山东"><label for="山东">山东</label>
                        <input name="schoolProvince" type="checkbox" value="河南" id="河南"><label for="河南">河南</label>
                        <input name="schoolProvince" type="checkbox" value="湖北" id="湖北"><label for="湖北">湖北</label>
                        <input name="schoolProvince" type="checkbox" value="湖南" id="湖南"><label for="湖南">湖南</label>
                        <input name="schoolProvince" type="checkbox" value="广东" id="广东"><label for="广东">广东</label>
                        <input name="schoolProvince" type="checkbox" value="海南" id="海南"><label for="海南">海南</label>
                        <input name="schoolProvince" type="checkbox" value="四川" id="四川"><label for="四川">四川</label>                                <input name="schoolProvince" type="checkbox" value="贵州" id="贵州"><label for="贵州">贵州</label>
                        <input name="schoolProvince" type="checkbox" value="云南" id="云南"><label for="云南">云南</label>
                        <input name="schoolProvince" type="checkbox" value="陕西" id="陕西"><label for="陕西">陕西</label>                                <input name="schoolProvince" type="checkbox" value="甘肃" id="甘肃"><label for="甘肃">甘肃</label>
                        <input name="schoolProvince" type="checkbox" value="青海" id="青海"><label for="青海">青海</label>
                        <input name="schoolProvince" type="checkbox" value="广西" id="广西"><label for="广西">广西</label>
                        <input name="schoolProvince" type="checkbox" value="西藏" id="西藏"><label for="西藏">西藏</label>
                        <input name="schoolProvince" type="checkbox" value="内蒙古" id="内蒙古"><label for="内蒙古">内蒙古</label>
                        <input name="schoolProvince" type="checkbox" value="宁夏" id="宁夏"><label for="宁夏">宁夏</label>
                        <input name="schoolProvince" type="checkbox" value="新疆" id="新疆"><label for="新疆">新疆</label>
                    </div>
                </div>
                <div class="options">
                    <span class="optionName">院校特性 ></span>
                    <div class="option">
                        <input name="schoolType" type="checkbox" value="全部"  id="院校特性全部" checked><label for="院校特性全部">全部</label>
                        <input name="schoolType" type="checkbox" value="985" id="985院校"><label for="985院校">985院校</label>
                        <input name="schoolType" type="checkbox" value="211" id="211院校"><label for="211院校">211院校</label>
                        <input name="schoolType" type="checkbox" value="自划线" id="自划线"><label for="自划线">自主划线</label>
                    </div>
                </div>
                <div class="options">
                    <span class="optionName">学位类型 ></span>
                    <div class="option">
                        <input name="degreeType" type="checkbox" value="全部" id="学位全部" checked><label for="学位全部">全部</label>
                        <input name="degreeType" type="checkbox" value="学硕" id="学硕"><label for="学硕">学硕</label>
                        <input name="degreeType" type="checkbox" value="专硕" id="专硕"><label for="专硕">专硕</label>
                    </div>
                </div>
                <div class="options">
                    <span class="optionName">考试科目 ></span>
                    <div class="subjectoption">
                    <div class="option">
                        <input name="math" type="checkbox" value="全部" id="数学全部" checked><label for="数学全部">全部</label>
                        <input name="math" type="checkbox" value="一" id="数学(一)"><label for="数学(一)">数学(一)</label>
                        <input name="math" type="checkbox" value="二" id="数学(二)"><label for="数学(二)">数学(二)</label>
                    </div>
                    <div class="option">
                        <input name="english" type="checkbox" value="全部" id="英语全部" checked><label for="英语全部">全部</label>
                        <input name="english" type="checkbox" value="一" id="英语(一)"><label for="英语(一)">英语(一)</label>
                        <input name="english" type="checkbox" value="二" id="英语(二)"><label for="英语(二)">英语(二)</label>
                    </div>
                    </div>
                </div>
            </div>
            <div class="options">
                <span class="optionName">研究方向 ></span>
                <input name="directionName" type="text" value="" placeholder="（选填）如：大数据" id="direction"/>
                <input type="submit" value="搜索！" id="search"/>
            </div>
        </div>
    </form>

    <div id="blank"></div>

    <div class="show">
    <table class="table table-striped table-bordered">
            <thead>
              <tr>
                <th>招生单位</th>
                <th>院系名称</th>
                <th>学位类型</th>
                <th>专业</th>
                <th>研究方向</th>
                <th>考试范围</th>
                <th>收藏</th>
              </tr>
            </thead>
            <tbody>
            <c:set var="sum" value="0"></c:set>
            <c:forEach items="${schoolList}" var="school" >
                <c:forEach items="${school.direction}" var="direction" >
                  <tr>
                    <td>${direction.schoolName}</td>
                    <td>${direction.collegeName}</td>
                    <td><label for="${direction.degreeType}">${direction.degreeType}</label></td>
                    <td>${direction.majorlName}</td>
                    <td>${direction.directionName}</td>
                    <td><a href="/displayDirectionDetail?directionId=${direction.directionId}">详情</a></td>
                    <c:choose>
                        <%--<c:when test="${directionIds[num]==direction.directionId}">--%>
                        <c:when test="${ya:judge(directionIds,direction.directionId)}">
                            <td><a href="#"><img src="../images/school/redheart.svg"  width="20px" height="20px" alt="" srcset="" ></a></td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="/addDirectionCollector?directionId=${direction.directionId}"><img src="../images/school/whiteheart.svg"  width="20px" height="20px" alt="" srcset="" ></a></td>
                        </c:otherwise>
                    </c:choose>
                  </tr>
                </c:forEach>
            </c:forEach>
            </tbody>
          </table>
    </div>
    <%--分页--%>
    <nav id="page" class="page">
        <li class="home"><a href="/${url}?schoolProvince=${schoolProvince}&schoolType=${schoolType}&degreeType=${degreeType}&math=${math}&english=${english}&directionName=${directionName}">首页</a></li>
        <li class="next"><a href="/${url}?schoolProvince=${schoolProvince}&schoolType=${schoolType}&degreeType=${degreeType}&math=${math}&english=${english}&directionName=${directionName}&pageNum=${PageInfo.prePage}">上一页</a></li>
        <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
            <li class="pagenum"><a name="${i}" href="/${url }?schoolProvince=${schoolProvince}&schoolType=${schoolType}&degreeType=${degreeType}&math=${math}&english=${english}&directionName=${directionName}&pageNum=${i}">${i}</a></li>
        </c:forEach>
        <c:choose>
            <c:when test="${PageInfo.nextPage==0}">
                <li class="next"><a href="/${url}?schoolProvince=${schoolProvince}&schoolType=${schoolType}&degreeType=${degreeType}&math=${math}&english=${english}&directionName=${directionName}&pageNum=${PageInfo.pages}">下一页</a></li>
            </c:when>
            <c:otherwise>
                <li class="next"><a href="/${url}?schoolProvince=${schoolProvince}&schoolType=${schoolType}&degreeType=${degreeType}&math=${math}&english=${english}&directionName=${directionName}&pageNum=${PageInfo.nextPage}">下一页</a></li>
            </c:otherwise>
        </c:choose>
        <li class="tail"><a href="/${url}?schoolProvince=${schoolProvince}&schoolType=${schoolType}&degreeType=${degreeType}&math=${math}&english=${english}&directionName=${directionName}&pageNum=${PageInfo.pages}">尾页</a></li>
    </nav>
    <%@include file="../common/footer.jsp"%>
</body>
<script src="../js/usercommon.js"></script>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>