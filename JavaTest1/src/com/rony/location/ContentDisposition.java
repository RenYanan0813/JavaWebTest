package com.rony.location;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/ContentDisposition")
public class ContentDisposition extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         16          * 设置content-disposition响应头，让浏览器下载文件
         17          */

        resp.setHeader("content-disposition", "attachment;filename=xxx.png");
        InputStream in = this.getServletContext().getResourceAsStream("/resource/03.png");
        byte buffer[] = new byte[1024];
        int len = 0;
        OutputStream out = resp.getOutputStream();
        while ((len = in.read(buffer)) > 0){
            out.write(buffer, 0, len);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
