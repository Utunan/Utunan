<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <c:choose>
        <c:when test="${not empty object}">
            <div style="text-align: center;">
                <nav id="page" class="page">
                    <li class="home"><a href="${url}/1?wd=${keyWord}">首页</a></li>
                    <li class="next"><a href="${url}/${PageInfo.prePage}?wd=${keyWord}"><<</a></li>
                    <c:forEach var="i" begin="${PageInfo.navigateFirstPage}" end="${PageInfo.navigateLastPage}">
                        <li class="pagenum"><a name="${i}" href="${url}/${i}?wd=${keyWord}">${i}</a></li>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${PageInfo.nextPage==0}">
                            <li class="next"><a href="${url}/${PageInfo.pages}?wd=${keyWord}">>></a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="next"><a href="${url}/${PageInfo.nextPage}?wd=${keyWord}">>></a></li>
                        </c:otherwise>
                    </c:choose>
                    <li class="tail"><a href="${url}/${PageInfo.pages}?wd=${keyWord}">尾页</a></li>
                </nav>
            </div>
        </c:when>
        <c:otherwise>
            <div style="text-align: center; line-height: 40px;font-size: 16px;color: #28A47C;">
                <span>小优没有帮您找到数据，过一会儿再来看看吧</span>
            </div>
        </c:otherwise>
    </c:choose>