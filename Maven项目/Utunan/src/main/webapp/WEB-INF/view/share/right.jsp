<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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