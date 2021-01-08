<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式运算符</title>
</head>
<body>
<%--
    TODO empty
    它会判断：对象是否为null，字符串是否为空字符串，集合中元素是否是0个
--%>
<%
    String str1 = null;
    String str2 = "";
    int[] arr = {};
%>
${empty str1}============当对象为null返回true<br/>
${empty str2}==========当字符串为空字符串是返回true(注意：它不会调用trim()方法)<br>
${empty arr}==========当集合中的元素是0个时，是true<br>


<%--
    三元运算符
    条件?真:假
--%>
<% pageContext.setAttribute("gender", "women");%>
<input type="radio" name="gender" value="men" ${gender=="men"?"checked":""}>男
<input type="radio" name="gender" value="women" ${gender=="women"?"checked":""}>女
</body>
</html>
