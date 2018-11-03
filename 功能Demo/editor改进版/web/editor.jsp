
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>BBS</title>
  <script type ="text/JavaScript"src="ueditor/ueditor.config.js"  charset="utf-8"></script>
  <script type ="text/javascript"src="ueditor/ueditor.all.js"  charset="utf-8"></script>
  <!-- Bootstrap -->
  <link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel =stylesheet href="ueditor/themes/default/css/ueditor.css"  charset="utf-8">
  <script type="text/javascript" charset="utf-8" src=" lang/zh-cn/zh-cn.js"></script>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="bootstrap-3.3.5-dist/js/jquery-1.11.3.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>
<body>
        <div style="margin: 0 auto;width: 900px" >

          <form action="EditorServlet" method="post" >
            <!--  label标签为input表单定义标注  -->
            <label for="biaoti"> 帖子标题：</label>
            <!--  input标签用于收集用户信息  -->
             <input type="text" name="mainTitle" placeholder="最大长度80个汉字" style="width: 360px;" >
            <script id="editor" type="text/plain" style="height: 300px;width: 900px;" ></script>
            <p align="right" style="width:900px"><button type="submit" class="btn btn-primary btn-xs text-right">发表帖子</button></p>
          </form>
        </div>
      <script type="text/javascript">
      //实例化编辑器
      //使用工厂方法getEditor创建和引用编辑器示例，直接调用UE.getEditor('editor')就能拿到
      var ue=UE.getEditor('editor',{
          toolbars : [[

              'undo', //撤销
              'redo', //重做
              'bold', //加粗
              'italic', //斜体
              'underline', //下划线
              'strikethrough', //删除线
              'insertcode', //代码语言
              'simpleupload', //单图上传
              'link', //超链接
              'emotion', //表情
              'insertorderedlist', //有序列表
              'attachment', //附件
          ]]
          }
      )
    </script>
</body>
</html>
