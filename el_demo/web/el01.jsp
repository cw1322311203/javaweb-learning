<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式快速入门</title>
</head>
<body>
<%--EL表达式概念：
    它是Expression Language的缩写。它是一种替换jsp表达式的语言。
    EL表达式的语法：
        ${表达式}
        表达式的特点：有明确的返回值。
        EL表达式就是把内容输出到页面上
    EL表达式的注意事项：
        1.EL表达式没有空指针异常
        2.EL表达式没有数组下标越界
        3.EL表达式没有字符串拼接
    EL表达式的数据获取：
        它只能在四大域对象中获取数据，不在四大域对象中的数据它取不到。
        它的获取方式就是findAttribute(String name)，根据名称由小到大逐个域中查找，找到就返回，找不到就什么都不显示。
--%>
<%--1.向域对象中添加数据--%>
<% request.setAttribute("username", "zhangsan");%>

<%--2.获取数据--%>
Java代码块:<% out.println(request.getAttribute("username")); %><br/>
JSP表达式:<%=request.getAttribute("username")%><br/>
EL表达式:${username}
</body>
</html>