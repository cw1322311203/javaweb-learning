<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式11个隐式对象</title>
</head>
<body>
<%--
    | EL中的隐式对象   | 类型                          | 对应JSP隐式对象 | 备注                                    |
    | ---------------- | ----------------------------- | --------------- | --------------------------------------- |
    | PageContext      | Javax.serlvet.jsp.PageContext | PageContext     | 完全一样                                |
    | ApplicationScope | Java.util.Map                 | 没有            | 应用层范围                              |
    | SessionScope     | Java.util.Map                 | 没有            | 会话范围                                |
    | RequestScope     | Java.util.Map                 | 没有            | 请求范围                                |
    | PageScope        | Java.util.Map                 | 没有            | 页面层范围                              |
    | Header           | Java.util.Map                 | 没有            | 请求消息头key，值是value（一个）        |
    | HeaderValues     | Java.util.Map                 | 没有            | 请求消息头key，值是数组（一个头多个值） |
    | Param            | Java.util.Map                 | 没有            | 请求参数key，值是value（一个）          |
    | ParamValues      | Java.util.Map                 | 没有            | 请求参数key，值是数组（一个名称多个值） |
    | InitParam        | Java.util.Map                 | 没有            | 全局参数，key是参数名称，value是参数值  |
    | Cookie           | Java.util.Map                 | 没有            | Key是cookie的名称，value是cookie对象    |
--%>
<%--pageContext对象 可以获取其他三个域对象和JSP中八个隐式对象--%>
${pageContext.request.contextPath}<br>

<%--ApplicationScope SessionScope RequestScope PageScope操作四大域对象中的数据--%>
<% request.setAttribute("username", "zhangsan");%>
${username}<br>
${requestScope.username}<br>

<%--Header HeaderValues 获取请求头数据--%>
${header["connection"]}<br>
${headerValues["connection"][0]}<br>

<%--Param ParamValues 获取请求参数数据--%>
${param.username}<br>
${paramValues.hobby[0]}<br>
${paramValues.hobby[1]}<br>

<%--InitParam 获取全局配置参数--%>
${initParam["pname"]}<br>

<%--cookie 获取cookie信息--%>
${cookie}<br><%--获取map集合--%>
${cookie.JSESSIONID}<br><%--获取map集合中第二个元素--%>
${cookie.JSESSIONID.name}<br><%--获取cookie对象的名称--%>
${cookie.JSESSIONID.value}<%--获取cookie对象的数据值--%>
</body>
</html>
