package com.cw.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/5 14:53
 * <p>
 * TODO 第三种方式:实现Servlet接口
 * 1.接口中的方法必须全部实现
 * 2.使用此种方式，表示接口中的所有方法在需求方面都有重写的必要。此种方式支持最大程度的自定义。
 */
public class ServletDemo03 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service running...[实现servlet]");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
