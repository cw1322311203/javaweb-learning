package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/5 14:50
 * <p>
 * TODO 第二种方式:继承HttpServlet(此方式用得更多)
 * 1.它是javax.servlet.http包下的一个抽象类，是GenericServlet的子类。如果我们选择继承HttpServlet时，
 * 只需要重写doGet和doPost方法，不要覆盖service方法。
 * 2.使用此种方式，表示我们的请求和响应需要和HTTP协议相关。也就是说，我们是通过HTTP协议来访问的。
 * 那么每次请求和响应都符合HTTP协议的规范。请求的方式就是HTTP协议所支持的方式
 * （目前我们只知道GET和POST，而实际HTTP协议支持7种请求方式，GET POST PUT DELETE TRACE OPTIONS HEAD )。
 */
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet running...[继承HttpServlet]");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
