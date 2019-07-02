package com.rony.bufferimage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/CheckServlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收客户端浏览器提交上来的验证码
        String clientCheckcode = req.getParameter("validateCode");

        //从服务器端的session中取出验证码
        String serverCheckcode = (String) req.getSession().getAttribute("checkcode");

        if (clientCheckcode.equals(serverCheckcode)){
            System.out.println("success!");
        }else {
            System.out.println("faild....");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收客户端浏览器提交上来的验证码
        String clientCheckcode = req.getParameter("validateCode");

        //从服务器端的session中取出验证码
        String serverCheckcode = (String) req.getSession().getAttribute("checkcode");

        if (clientCheckcode.equals(serverCheckcode)) {
            resp.getWriter().printf("success");
            System.out.println("success!");
        } else {
            resp.getWriter().printf("faild...");
            System.out.println("faild....");
        }
    }
}
