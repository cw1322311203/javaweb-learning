package com.cw.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/6 9:48
 * <p>
 * ServletContext演示
 * <p>
 * ServletContext对象，它是应用上下文对象。每一个应用有且只有一个ServletContext对象。它可以实现让应用中所有Servlet间的数据共享。
 * 在Servlet规范中，一共有4个域对象。ServletContext就是其中一个。它是web应用中最大的作用域，叫application域。
 * 每个应用只有一个application域。它可以实现整个应用间的数据共享功能。
 * <p>
 * 作用：可以获得应用的全局初始化参数和达到 Servlet 之间的数据共享。
 * 生命周期：应用一加载则创建，应用被停止则销毁。
 */
public class ServletContextDemo extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取ServletContext对象
        ServletContext context = getServletContext();

        // 2.常用方法的演示
        // 获取全局配置参数:getInitParameter(String key) 根据key获取value
        String globalEncodingValue = context.getInitParameter("globalEncoding");
        String globalDescValue = context.getInitParameter("globalDesc");
        System.out.println("globalEncoding:" + globalEncodingValue);
        System.out.println("globalDesc:" + globalDescValue);

        // 获取应用的虚拟目录:getContextPath()
        String contextPath = context.getContextPath();
        System.out.println(contextPath);

        // 根据虚拟目录获取绝对路径:getRealPath(String path)
        String realPath = context.getRealPath("/");
        System.out.println(realPath);//D:\ideaprojects\javaweb-learning\out\artifacts\servlet_demo2_war_exploded\

        String b = context.getRealPath("/b.txt");
        System.out.println(b);

        String c = context.getRealPath("/WEB-INF/c.txt");
        System.out.println(c);

        String a = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(a);//D:\ideaprojects\javaweb-learning\out\artifacts\servlet_demo2_war_exploded\WEB-INF\classes\a.txt

        // 设置共享数据
        context.setAttribute("username", "zhangsan");

        // 删除共享数据
        context.removeAttribute("username");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
