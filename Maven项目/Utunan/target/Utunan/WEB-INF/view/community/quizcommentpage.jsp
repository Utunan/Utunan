<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2018/11/24
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>问题页面</title>
</head>
<body>
    问题：${quiz.quizTitle}<br/>
    用户：${quiz.user.userNickName}<br/>
    发表时间：${quiz.releaseTime}<br/>
    标签：<br/>
    内容：${quiz.quizContent}<br/>
    点赞数：${quiz.praiseCount}<br/>
    评论数：<br/>
    评论有：
</body>
</html>
