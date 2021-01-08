package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 陈小哥cw
 * @date 2021/1/7 9:21
 * <p>
 * TODO 文件下载
 */
@WebServlet("/servletDemo09")
public class ServletDemo09 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 文件下载的思路：
         * 		1.获取文件路径
         * 		2.把文件读到字节输入流中
         * 		3.告知浏览器，以下载的方式打开（告知浏览器下载文件的MIME类型）
         * 		4.使用响应对象的字节输出流输出到浏览器上
         */
        // 1.创建字节输入流对象，关联读取的文件
        String realPath = getServletContext().getRealPath("/img/pic.jpg");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(realPath));

        // 2.设置响应头支持的类型
        /**
         *  Content-Type:消息头名称  支持的类型
         *  application/octet-stream：消息头参数  应用的类型为字节流
         */
        resp.setHeader("Content-Type", "application/octet-stream");

        // 3.设置响应头以下载的方式打开附件
        /**
         * Content-Disposition:消息头名称，处理的形式
         * attachment;filename=pic.jpg：消息头参数  附件形式进行处理
         */
        resp.setHeader("Content-Disposition", "attachment;filename=pic.jpg");

        // 4.获取字节输出流对象
        ServletOutputStream os = resp.getOutputStream();

        // 5.循环读写
        byte[] arr = new byte[1024];
        int len;
        while ((len = bis.read(arr)) != -1) {
            os.write(arr, 0, len);
        }

        // 6.释放资源
        bis.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
