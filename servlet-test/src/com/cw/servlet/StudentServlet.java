package com.cw.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 陈小哥cw
 * @date 2021/1/6 13:06
 */
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取表单数据并保存到文件中
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        String score = req.getParameter("score");

        // 采用字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\stu.txt", true));
        bw.write(username + "," + age + "," + score);
        bw.newLine();
        bw.close();

        // 响应客户端浏览器
        PrintWriter pw = resp.getWriter();
        pw.println("Save success...");
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
