package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/6 13:38
 * <p>
 * TODO 获取路径的相关方法
 */
@WebServlet("/servletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 访问路径 http://localhost:8080/request/servletDemo01?username=zhangsan&age=18

        // 1.获取虚拟目录名称 getContextPath()  /request
        String contextPath = req.getContextPath();
        System.out.println("contextPath = " + contextPath);

        // 2.获取Servlet映射路径 getServletPath()    /servletDemo01
        String servletPath = req.getServletPath();
        System.out.println("servletPath = " + servletPath);

        // 3. 获取访问者ip getRemoteAddr()
        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAddr = " + remoteAddr);

        // 4.获取请求消息的数据 getQueryString()   username=zhangsan&age=18
        String queryString = req.getQueryString();
        System.out.println("queryString = " + queryString);

        // 5.获取统一资源标识符 getRequestURI()  /request/servletDemo01
        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        // 6.获取统一资源定位符 getRequestURL()  http://localhost:8080/request/servletDemo01
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL = " + requestURL);

        //来访者主机
        String remoteHost = req.getRemoteHost();
        System.out.println("remoteHost = " + remoteHost);

        //来访者端口
        int remotePort = req.getRemotePort();
        System.out.println("remotePort = " + remotePort);

        //本机地址：服务器地址
        String localAddr = req.getLocalAddr();
        System.out.println("localAddr = " + localAddr);

        //本机名称：服务器名称
        String localName = req.getLocalName();
        System.out.println("localName = " + localName);

        //本机端口：服务器端口
        int localPort = req.getLocalPort();
        System.out.println("localPort = " + localPort);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
