<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="text-align: center">
    <div style="text-align: center">
        <div class="laypage-main">
            <a href="/${url }?fileType=${fileType}&school=${school}&keyWord=${keyWord}">首页</a>
            <a href="/${url }?fileType=${fileType}&school=${school}&keyWord=${keyWord}&pageNum=${PageInfo.prePage}"><<</a>
            <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                <a name="${i}" href="/${url }?fileType=${fileType}school=${school}&keyWord=${keyWord}&pageNum=${i}">${i}</a>
            </c:forEach>
            <c:choose>
                <c:when test="${PageInfo.nextPage==0}">
                    <a href="/${url }?fileType=${fileType}&school=${school}&keyWord=${keyWord}&pageNum=${PageInfo.pages}">>></a>
                </c:when>
                <c:otherwise>
                    <a href="/${url }?fileType=${fileType}&school=${school}&keyWord=${keyWord}&pageNum=${PageInfo.nextPage}">>></a>
                </c:otherwise>
            </c:choose>
            <a href="/${url }?fileType=${fileType}&school=${school}&keyWord=${keyWord}&pageNum=${PageInfo.pages}">尾页</a>
        </div>
    </div>
</div>
