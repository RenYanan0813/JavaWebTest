package com.rony.location;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/Refresh")
public class Refresh extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /**
         13          * 设置refresh响应头，让浏览器每隔3秒定时刷新
         14          */
                // response.setHeader("refresh", "3");
                /**
         17          * 设置refresh响应头，让浏览器3秒后跳转到http://www.baidu.com
         */
        resp.setHeader("Loacation", "1.jsp");
        resp.setHeader("refresh", "3;url='http://www.baidu.com'");
        resp.getWriter().write("rony");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
