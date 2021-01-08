<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
    1.这是注释
--%>
<%--
    2.java代码块
    System.out.println("Hello JSP"); 普通输出语句，输出在控制台
    out.println("Hello JSP");    out是JspWriter对象，输出在页面上
--%>
<%
    System.out.println("Hello JSP");
    out.println("Hello JSP<br>");
    String str = "hello<br>";
    out.println(str);
%>
<%--
    3.jsp表达式
    <%="Hello"%> 相当于out.println("Hello");
--%>
<%="Hello<br>"%>

<%--
    4.jsp声明(变量，方法)
    如果加！，代表声明的是成员变量
    不加！，代表的是声明的是局部变量
    声明方法时，必须加！,因为不能在方法里加方法
--%>
<%! String s = "abc";%>
<% String s = "def";%>
<%=s%>

<%! public void getSum(){}%>
</body>
</html>
