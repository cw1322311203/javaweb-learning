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
import java.io.PrintWriter;

/**
 * @author 陈小哥cw
 * @date 2021/1/6 17:42
 * <p>
 * TODO 响应图片
 */
@WebServlet("/servletDemo03")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 通过文件的相对路径获取绝对路径
        String realPath = getServletContext().getRealPath("//img/pic.jpg");
        System.out.println("realPath = " + realPath);

        // 1.创建字节输入流对象，关联图片路径
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(realPath));

        // 2.通过响应对象获取字节输出流对象
        ServletOutputStream os = resp.getOutputStream();

        // 3.循环读写
        byte[] arr = new byte[1024];
        int len;
        while ((len = bis.read(arr)) != -1) {
            os.write(arr, 0, len);
        }

        // 4.释放对象
        bis.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
