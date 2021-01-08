package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/6 17:09
 * <p>
 * TODO 字节流响应信息
 * 演示字节流输出的乱码问题
 */
@WebServlet("/servletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 问题：
         * 	  String str = "字节流中文乱码问题";
         * 	     使用字节流输出，会不会产生中文乱码？
         * 答案：
         * 	  会产生乱码
         * 原因：
         * 	String str = "字节流中文乱码问题"; 在保存时用的是IDEA创建文件使用的字符集UTF-8。
         * 	到浏览器上显示，chrome浏览器和ie浏览器默认的字符集是GB2312(其实就是GBK)，存和取用的不是同一个码表，就会产生乱码。
         *
         * 引申：
         *   如果产生了乱码，就是存和取用的不是同一个码表
         * 解决办法：
         *   把存和取的码表统一。
         */

        // 1.获取字节输出流对象
        ServletOutputStream os = resp.getOutputStream();

        // 2.定义一个消息
        String str = "你好";//UTF-8的字符集，此时浏览器显示也需要使用UTF-8的字符集。

        /**
         * 解决办法：
         * 	第一种解决办法：
         *      修改浏览器的编码，使用右键——编码——改成UTF-8。(不推荐使用，我们的应用尽量不要求用户取做什么事情)
         *      ie和火狐浏览器可以直接右键设置字符集。而chrome需要安装插件，很麻烦。
         * 	第二种解决办法： (不建议使用，因为不好记)
         *  	向页面上输出一个meta标签，内容如下： <meta http-equiv="content-type" content="text/html;charset=UTF-8">
         *      其实它就是指挥了浏览器，使用哪个编码进行显示。
         *  第三种解决办法：
         * 		设置响应消息头，告知浏览器响应正文的MIME类型和字符集
         * 		response.setHeader("Content-Type","text/html;charset=UTF-8");
         * 	第四种解决办法：我们推荐使用的办法
         * 	    它的本质就是设置了一个响应消息头
         *  	response.setContentType("text/html;charset=UTF-8");
         */
        //第二种解决办法：sos.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
        //第三种解决办法：response.setHeader("Content-Type","text/html;charset=UTF-8");
        //第四种解决办法：
        resp.setContentType("text/html;charset=UTF-8");
        // 3.通过字节流对象输出
        os.write(str.getBytes("UTF-8"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
