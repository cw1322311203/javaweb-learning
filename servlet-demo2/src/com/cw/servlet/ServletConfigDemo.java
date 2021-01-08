package com.cw.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 陈小哥cw
 * @date 2021/1/6 9:10
 * <p>
 * ServletConfig的演示
 * <p>
 * 由于它是在初始化阶段读取了web.xml中为Servlet准备的初始化配置，并把配置信息传递给Servlet，所以生命周期与Servlet相同。
 * 这里需要注意的是，如果Servlet配置了<load-on-startup>1</load-on-startup>，那么ServletConfig也会在应用加载时创建。
 */
public class ServletConfigDemo extends HttpServlet {

    // 1.声明ServletConfig
    private ServletConfig config;

    // 2.通过init方法，来对ServletConfig对象进行赋值
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 3.演示ServletConfig常用方法
        // 根据key获取value
        String encodingValue = config.getInitParameter("encoding");
        System.out.println("key:encoding" + ",value:" + encodingValue);
        String descValue = config.getInitParameter("desc");
        System.out.println("key:desc" + ",value:" + descValue);

        // 获取所有的key
        Enumeration<String> keys = config.getInitParameterNames();
        while (keys.hasMoreElements()) {
            // 获取每一个key
            String key = keys.nextElement();
            // 根据key获取value
            String value = config.getInitParameter(key);
            System.out.println(key + ":" + value);
        }

        // 获取Servlet的名称
        String servletName = config.getServletName();
        System.out.println("ServletName:" + servletName);

        // 获取ServletContext对象
        ServletContext servletContext = config.getServletContext();
        System.out.println(servletContext);

        // 获取共享数据
        Object username = servletContext.getAttribute("username");
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
