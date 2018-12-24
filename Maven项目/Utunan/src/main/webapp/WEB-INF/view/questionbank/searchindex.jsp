<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/12/24
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>好题尽在优图南</title>
	<meta charset="UTF-8">
	<link href="/css/questionbank/searchindex.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/css/common.css">
</head>
<body>
<%@include file="../common/header.jsp"%>
<div class="search">
    <div class="search-logo">
        <img src="/images/questionbank/logo.png"/>
    </div>
	<div class="s-bar">
	   <form action="/search/question/1" method="post">
		<input type="text" name="wd" placeholder="在${totleQuestion}道题目中搜索">
		<input type="submit"  value="搜索"/>
	  </form>
	</div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>