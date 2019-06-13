package com.rony.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContextDemo4 请求转发到 ServletContextDemo5
 */
@WebServlet(urlPatterns = "/ServletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getOutputStream().write("abce123".getBytes());

        //获取ServletContext对象
        ServletContext contetx = this.getServletContext();
        //获取请求转发对象(RequestDispatcher)
        RequestDispatcher rd = contetx.getRequestDispatcher("/ServletContextDemo5");
        //调用forward方法实现请求转发
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
