<%--
  Created by IntelliJ IDEA.
  User: 陈小哥cw
  Date: 2021/1/7
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addStudentServlet" method="get" autocomplete="off">
    学生姓名：<input type="text" name="username"> <br>
    学生年龄：<input type="number" name="age"> <br>
    学生成绩：<input type="number" name="score"> <br>
    <button type="submit">保存</button>
</form>
</body>
</html>
