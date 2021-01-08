package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 陈小哥cw
 * @date 2021/1/6 14:04
 * <p>
 * TODO 获取请求头信息
 */
@WebServlet("/servletDemo02")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.根据请求头名称获取头的值	一个消息头一个值
        String connectionValue = req.getHeader("Connection");
        System.out.println("connectionValue = " + connectionValue);

        System.out.println("-------------------------------------");

        //2.根据名称获取头的值	一个头多个值
        Enumeration<String> acceptValues = req.getHeaders("Accept-Encoding");
        while (acceptValues.hasMoreElements()) {
            String value = acceptValues.nextElement();
            System.out.println("Accept-Encoding:" + value);
        }

        System.out.println("-------------------------------------");

        //3.获取所有请求消息头的名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName + ":" + headerValue);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
