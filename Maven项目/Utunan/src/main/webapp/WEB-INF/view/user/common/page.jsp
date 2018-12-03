<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav id="page" class="page">
    <c:choose>
        <c:when test="${PageInfo.pages==1}">

        </c:when>
        <c:when test="${PageInfo.pages==0}">
            <div class="noresult">
                <h2 style="text-align:left;padding-top:100px;padding-left: 50px;color:rgb(247, 184, 102);">您的收藏夹空了</h2>
                <h2 style="text-align:left;padding-top:0px;padding-left:90px;color:rgb(247, 184, 102);">还不赶紧去</h2>
                <h1 style="text-align:left;padding-left: 150px; color:rgb(243, 149, 149);">收藏?</h1>
            </div>
        </c:when>
        <c:otherwise>
            <input id="currentpage" type="hidden" value="${PageInfo.pageNum}">
            <li class="home"><a href="/user/${plate}#userfunction">首页</a></li>
            <li class="next"><a href="?pageNum=${PageInfo.prePage}#userfunction">上一页</a></li>
            <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                <li class="pagenum"><a name="${i}" href="?pageNum=${i}#userfunction">${i}</a></li>
            </c:forEach>
            <c:choose>
                <c:when test="${PageInfo.nextPage==0}">
                    <li class="next"><a href="?pageNum=${PageInfo.pages}#userfunction">下一页</a></li>
                </c:when>
                <c:otherwise>
                    <li class="next"><a href="?pageNum=${PageInfo.nextPage}#userfunction">下一页</a></li>
                </c:otherwise>
            </c:choose>
            <li class="tail"><a href="?pageNum=${PageInfo.pages}#userfunction">尾页</a></li>

        </c:otherwise>
    </c:choose>
</nav>