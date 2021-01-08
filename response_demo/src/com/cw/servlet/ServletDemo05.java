package com.cw.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author 陈小哥cw
 * @date 2021/1/7 8:45
 * <p>
 * TODO 设置缓存
 */
@WebServlet("/servletDemo05")
public class ServletDemo05 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String news = "这是一条火爆的新闻！";

        // 设置缓存 一个小时的缓存时间
        resp.setDateHeader("Expires", System.currentTimeMillis() + 1 * 60 * 60 * 1000);

        // 设置编码格式
        resp.setContentType("text/html;charset=UTF-8");

        // 写出数据
        resp.getWriter().write(news);

        System.out.println("aaa");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
