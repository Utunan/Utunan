<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="text-align: center">
    <c:choose>
        <c:when test="${not empty fileList}">
            <div class="laypage-main">
                <a href="/${url }">首页</a>
                <a href="/${url }?pageNum=${PageInfo.prePage}"><<</a>
                <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                    <a name="${i}" href="/${url }?pageNum=${i}">${i}</a>
                </c:forEach>
                <c:choose>
                    <c:when test="${PageInfo.nextPage==0}">
                        <a href="/${url }?pageNum=${PageInfo.pages}">>></a>
                    </c:when>
                    <c:otherwise>
                        <a href="/${url }?pageNum=${PageInfo.nextPage}">>></a>
                    </c:otherwise>
                </c:choose>
                <a href="/${url }?pageNum=${PageInfo.pages}">尾页</a>
            </div>
        </c:when>
        <c:otherwise>
            <span style="text-align: center">小优没有帮您找到数据，过一会儿再来看看吧</span>
        </c:otherwise>
    </c:choose>
</div>