package com.rony.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletConfigDemo extends HttpServlet {
    /**
     14      * 定义ServletConfig对象来接收配置的初始化参数
     15      */

    private ServletConfig config;
    /**
     19      * 当servlet配置了初始化参数后，web容器在创建servlet实例对象时，
     20      * 会自动将这些初始化参数封装到ServletConfig对象中，并在调用servlet的init方法时，
     21      * 将ServletConfig对象传递给servlet。进而，程序员通过ServletConfig对象就可以
     22      * 得到当前servlet的初始化参数信息。
     23      */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取在web.xml中配置的初始化参数,
        String parname = this.config.getInitParameter("name"); //获取指定的初始化参数
        resp.getWriter().printf(parname);
        resp.getWriter().print("<hr/>");

        Enumeration<String> e = this.config.getInitParameterNames();
        while (e.hasMoreElements()){
            String name = e.nextElement();
            String value = config.getInitParameter(name);
            resp.getWriter().print(name + "=" + value + "<br/>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
}
