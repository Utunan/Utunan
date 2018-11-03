<%--
  Created by IntelliJ IDEA.
  User: 孙程程
  Date: 2018/10/28
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List,com.entity.Post"%>
<html>
  <head>
      <title>优图南社区</title>
      <style type="text/css">
          body{
              background-color: rgb(246,246,246);
          }
          .tag{
              margin: 20px auto;
              width: 800px;
              padding: 30px;
              background-color: white;
          }
          .post{
              margin: 20px auto;
              width: 800px;
              padding-right: 30px;
              padding-left: 30px;
              padding-bottom: 30px;
              padding-top: 20px;
              background-color: white;
          }
          .title{
              text-align: center;
              border-bottom: 5px solid rgb(204,204,204);
          }
          .text {
              border: 0 solid #ccc;
              min-height: auto;
              padding-top: 10px;
          }
          blockquote{
              font: 14px/22px normal helvetica, sans-serif;
              margin-top: 10px;
              margin-bottom: 10px;
              margin-left: 50px;
              padding-left: 15px;
              padding-top: 10px;
              padding-bottom: 10px;
              padding-right: 10px;
              border-left: 8px solid #ccc;
              background-color:#f1f1f1
          }
          pre{
              margin: 10px;
              padding-left: 20px;
              padding-top: 10px;
              padding-bottom: 10px;
              padding-right: 10px;
              border:1px solid #ccc;
              background-color:#f1f1f1;
          }
          code{
              margin-top: 2px;
          }
          table{
              width: 80%;
              margin: auto;
              border: 2px solid rgb(204,204,204);
              text-align: center;
          }
          th,td{
              border: 1px solid rgb(204,204,204);
          }
      </style>
  </head>
  <body>
      <div class="tag">
          <h1>优图南社区</h1>
      </div>
      <c:forEach items="${listPost}" var="posts">
          <div class="post">
              <div class="title">
                  <h2>${posts.getTitle()}</h2>
              </div>
              <div class="text" >
                      ${posts.text}
              </div>
          </div>
      </c:forEach>

  </body>
</html>
