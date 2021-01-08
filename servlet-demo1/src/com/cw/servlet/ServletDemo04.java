package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/5 15:15
 * <p>
 * Servlet的生命周期
 * <p>
 * 对象的生命周期，就是对象从生到死的过程，即：出生——活着——死亡。用更偏向 于开发的官方说法就是对象创建到销毁的过程。
 * - 出生：请求第一次到达Servlet时，对象就创建出来，并且初始化成功。只出生一次，就放到内存中。
 * - 活着：服务器提供服务的整个过程中，该对象一直存在，每次只是执行service方法。
 * - 死亡：当服务停止时，或者服务器宕机时，对象消亡。
 * <p>
 * 通过分析Servlet的生命周期我们发现，它的实例化和初始化只会在请求第一次到达Servlet时执行，而销毁只会在Tomcat服务器停止时执行，
 * 由此我们得出一个结论，Servlet对象只会创建一次，销毁一次。所以，Servlet对象只有一个实例。如果一个对象实例在应用中是唯一的存在，
 * 那么我们就说它是单实例的，即运用了单例模式。
 */
public class ServletDemo04 extends HttpServlet {

    /*
        对象出生的过程
     */
    @Override
    public void init() throws ServletException {
        System.out.println("对象创建并初始化成功...");
    }

    /*
        对象服务的过程
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到了客户端的请求...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /*
        对象销毁的过程
     */
    @Override
    public void destroy() {
        System.out.println("对象已经销毁...");
    }
}
