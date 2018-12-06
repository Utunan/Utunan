<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    info = document.getElementById("info")
    timer = 1;
    setInterval(function () {
        info.innerHTML = "请等待" + timer + "秒钟,谢谢~";
        timer--;
        if (timer < 0)
            timer = 0
    }, 1000)
    setTimeout(function () {
        window.location.href = "/login"
    }, 1000);
</script>