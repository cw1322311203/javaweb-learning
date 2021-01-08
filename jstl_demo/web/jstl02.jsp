<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入jstl标签库 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>循环</title>
</head>
<body>
<%--向域对象中添加集合--%>
<%
    ArrayList<String> list = new ArrayList<>();
    list.add("aa");
    list.add("bb");
    list.add("cc");
    list.add("dd");
    pageContext.setAttribute("list", list);
%>

<%-- c:forEach 它是用来遍历集合的
    	 属性：
    	 	items：要遍历的集合，它可以是EL表达式取出来的
    	 	var：把当前遍历的元素放入指定的page域中。 var的取值就是key,当前遍历的元素就是value
    	 		注意：它不能支持EL表达式，只能是字符串常量
    	 	begin:开始遍历的索引
    	 	end:结束遍历的索引
    	 	step：步长。i+=step
    	 	varStatus：它是一个计数器对象。里面有两个属性，一个是用于记录索引。一个是用于计数。
    	 			   索引是从0开始。计数是从1开始
--%>
<%--遍历集合--%>
<c:forEach items="${list}" var="str">
    ${str}<br/>
</c:forEach>

<hr/>

<c:forEach items="${list}" var="s" begin="1" end="7" step="2">
    ${s}<br/>
</c:forEach>

<hr/>

<c:forEach begin="1" end="9" var="num">
    <a href="#">${num}</a>
</c:forEach>

<hr/>
<table>
    <tr>
        <td>索引</td>
        <td>序号</td>
        <td>信息</td>
    </tr>
    <c:forEach items="${list}" var="s" varStatus="vs">
        <tr>
            <td>${vs.index}</td>
            <td>${vs.count}</td>
            <td>${s}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
