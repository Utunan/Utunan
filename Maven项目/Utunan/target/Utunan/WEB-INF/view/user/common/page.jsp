<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav id="page" class="page">
    <input id="currentpage" type="hidden" value="${PageInfo.pageNum}">
    <li class="home"><a href="/user/${plate}#userfunction">首页</a></li>
    <li class="next"><a href="?pageNum=${PageInfo.prePage}#userfunction">上一页</a></li>
    <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
        <li class="pagenum"><a name="${i}" href="#userfunction?pageNum=${i}#userfunction">${i}</a></li>
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
</nav>