package com.cw.servlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

/**
 * @author 陈小哥cw
 * @date 2021/1/6 10:38
 * <p>
 * 注册并配置Servlet的功能类
 */
public class MyRegister implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        // 完成Servlet的创建和配置
        // 1.创建ServletDemo02的对象
        ServletDemo02 servletDemo02 = new ServletDemo02();

        // 2.在ServletContext对象中添加Servlet，并得到Servlet的动态配置对象
        ServletRegistration.Dynamic registration = servletContext.addServlet("servletDemo02", servletDemo02);

        // 3.配置Servlet
        registration.setLoadOnStartup(1);// 设置Servlet创建时机
        registration.addMapping("/servletDemo02");// 映射访问资源的路径
        registration.setAsyncSupported(false);
    }
}
