<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav id="page" class="page">
    <input id="currentpage" type="hidden" value="${PageInfo.pageNum}">
    <li class="home"><a href="/user/${plate}">首页</a></li>
    <li class="next"><a href="?pageNum=${PageInfo.prePage}">上一页</a></li>
    <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
        <li class="pagenum"><a name="${i}" href="?pageNum=${i}">${i}</a></li>
    </c:forEach>
    <c:choose>
        <c:when test="${PageInfo.nextPage==0}">
            <li class="next"><a href="?pageNum=${PageInfo.pages}">下一页</a></li>
        </c:when>
        <c:otherwise>
            <li class="next"><a href="?pageNum=${PageInfo.nextPage}">下一页</a></li>
        </c:otherwise>
    </c:choose>
    <li class="tail"><a href="?pageNum=${PageInfo.pages}">尾页</a></li>
</nav>