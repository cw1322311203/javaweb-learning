package com.cw.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/5 14:16
 * <p>
 * Servlet快速入门1
 * <p>
 * TODO 第一种方式:继承GenericServlet
 * 1.service方法必须重写，其他方可根据需求，选择性重写。
 * 2.使用此种方式，表示只在接收和响应客户端请求这方面有重写的需求，而其他方法可根据实际需求选择性重写，
 * 使我们的开发Servlet变得简单。但是，此种方式是和HTTP协议无关的。
 */
public class ServletDemo01 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service running...[继承GenericServlet]");
    }
}
