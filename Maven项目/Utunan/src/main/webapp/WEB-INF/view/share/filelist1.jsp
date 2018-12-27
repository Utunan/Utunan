<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<li>
    <div>
        <img src="${f.suffix.imgUrl}" alt="文件类型" class="siffix">
        <span class="tn"><a href="/file/${f.fileId}" style="color: black">${f.fileTitle}</a></span>
        <div class="topdetail">
            <span class="ft"><a href="/searchfile?fileType=${f.fileType}&school=${f.fileSchool}&keyWord=">${f.fileType}</a></span>
            <c:if test="${not empty f.fileSchool}">
                <span class="fs"><a href="/searchfile?fileType=全部&school=${f.fileSchool}&keyWord=">${f.fileSchool}</a></span>
            </c:if>
        </div>
        <span class="un">${f.user.userNickName}&nbsp;于${f.fileTime}上传</span>
        <div class="rightdetail">
            <span class="fc"><img src="/images/share/credit.svg"  class="credit">${f.fileCredit}</span>
            <span class="dn"><a href="/file/${f.fileId}" style="color: black"><img src="/images/share/downNum.svg"  class="downNum"></a>${f.downloadNumber}</span>
        </div>
    </div>
</li>
