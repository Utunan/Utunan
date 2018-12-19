<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<li>
    <div>
        <img src="${file.suffix.imgUrl}" alt="文件类型" class="siffix">
        <span class="tn"><a href="/download?fileId=${file.fileId}" >${file.fileTitle}</a></span>
        <div class="topdetail">
            <c:if test="${not empty file.fileSchool}">
                <span class="ft"><a href="/searchfile?fileType=${file.fileType}&school=${file.fileSchool}&keyWord=">${file.fileType}</a></span>
            </c:if>
            <span class="fs"><a href="/searchfile?fileType=全部&school=${file.fileSchool}&keyWord=">${file.fileSchool}</a></span>
        </div>
        <span class="un">${file.user.userNickName}&nbsp;于${file.fileTime}上传</span>
        <div class="rightdetail">
            <span class="fc"><img src="/images/share/credit.svg"  class="credit">${file.fileCredit}</span>
            <span class="dn"><img src="/images/share/downNum.svg"  class="downNum">${file.downloadNumber}</span>
        </div>
    </div>
</li>
