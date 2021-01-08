<%--
    1.page指令
        language:告知引擎，脚本使用的是java，默认是java，支持java。不写也行。
        extends：告知引擎，JSP对应的Servlet的父类是哪个，不需要写，也不需要改。
        import：告知引擎，导入哪些包（类）。
            注意：引擎会自动导入：java.lang.*,javax.servlet.*,javax.servlet.http.*,javax.servlet.jsp.*
            导入的形式：
            <%@page import="java.util.Date,java.util.UUID"%>
            <%@page import="java.util.Date"%>
            <%@page import="java.util.UUID"%>
        session：告知引擎是否产生HttpSession对象，即是否在代码中调用request.getSession()。默认是true。
        buffer：JspWriter用于输出JSP内容到页面上。告知引擎，设定他的缓存大小。默认8kb。
        errorPage：告知引擎，当前页面出现异常后，应该转发到哪个页面上（路径写法：/代表当前应用）
	        小贴士：当在errorpage上使用了isErrorPage=true之后，ie8有时候不能正常显示
	        配置全局错误页面：web.xml
                <error-page>
                    <exception-type>java.lang.Exception</exception-type>
                    <location>/error.jsp</location>
                </error-page>
                <error-page>
                    <error-code>404</error-code>
                    <location>/404.html</location>
                </error-page>
            当使用了全局错误页面，就无须再写errorPage来实现转到错误页面，而是由服务器负责跳转到错误页面。
        isErrorPage：告知引擎，是否抓住异常。如果该属性为true，页面中就可以使用exception对象，打印异常的详细信息。默认值是false。
        contentType：告知引擎，响应正文的MIME类型。contentType="text/html;charset=UTF-8"
	        相当于response.setContentType("text/html;charset=UTF-8");
        pageEncoding：告知引擎，翻译jsp时（从磁盘上读取jsp文件）所用的码表。pageEncoding="UTF-8"相当于告知引擎用UTF-8读取JSP
        isELIgnored：告知引擎，是否忽略EL表达式，默认值是false，不忽略。

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="/error.jsp" import="java.util.*" %>
<%--
    2.include指令
        <%@include file="" %>该指令是包含外部页面。
        属性：file，以/开头，就代表当前应用。
        静态包含，最后是合并成一个java文件，编译成一个.class
--%>
<%@include file="/include.jsp" %>
<%--
    3.taglib指令
    语法格式：<%taglib uri="" prefix=""%>
    作用：该指令用于引入外部标签库。html标签和jsp标签不用引入。
    属性：
        uri：外部标签的URI地址。
        prefix：使用标签时的前缀。
--%>
<html>
<head>
    <title>jsp指令</title>
</head>
<body>
<%--<% int res = 1 / 0;%>--%>
<% ArrayList list = new ArrayList();%>
<%=s%>
<%--
    TODO 九大隐式对象
    什么是隐式对象呢？它指的是在jsp中，可以不声明就直接使用的对象。它只存在于jsp中，因为java类中的变量必须要先声明再使用。
    其实jsp中的隐式对象也并非是未声明，只是它是在翻译成.java文件时声明的。所以我们在jsp中可以直接使用。
    request:javax.servlet.http.HttpServletRequest
    response:javax.servlet.http.HttpServletResponse
    session:javax.servlet.http.HttpSession
    application:javax.servlet.ServletContext
    page:Java.lang.Object 当前jsp对应的servlet引用实例
    config:javax.servlet.ServletConfig
    exception:java.lang.Throwable
    out:javax.servlet.jsp.JspWriter 字符输出流，相当于printwriter
    pageContext：javax.servlet.jsp.PageContext
--%>
<%
    out.println();
    request.getParameter("");
    response.getHeader("");
%>
<%--
    TODO pageContext对象
    pageContext：javax.servlet.jsp.PageContext
    1.它是JSP独有的对象，Servlet中没有这个对象。
    2.本身也是四大域对象中的一个页面域（作用范围）对象，还可以操作其他3个域对象中的属性。
    3.而且还可以获取其他8个隐式对象。
    4.它是一个局部变量，所以它的生命周期随着JSP的创建而诞生，随着JSP的结束而消失。每个JSP页面都有一个独立的PageContext。
--%>
<%
    pageContext.setAttribute("", "");
    pageContext.getException();
    pageContext.getRequest();
    pageContext.getResponse();
%>
<%--
    TODO 四大域对象复习
    | 域对象名称     | 范围     | 级别                     | 备注                                     |
    | -------------- | -------- | ------------------------ | ---------------------------------------- |
    | PageContext    | 页面范围 | 最小，只能在当前页面用   | 因范围太小，开发中用的很少               |
    | ServletRequest | 请求范围 | 一次请求或当期请求转发用 | 当请求转发之后，再次转发时请求域丢失     |
    | HttpSession    | 会话范围 | 多次请求数据共享时使用   | 多次请求共享数据，但不同的客户端不能共享 |
    | ServletContext | 应用范围 | 最大，整个应用都可以使用 | 尽量少用，如果对数据有修改需要做同步处理 |
--%>
</body>
</html>
