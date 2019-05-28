package com.rony.location;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet(urlPatterns = "/ContentType")
public class ContentType extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         13          * 浏览器能接收(Accept)的数据类型有:
         14          * application/x-ms-application,
         15          * image/jpeg,
         16          * application/xaml+xml,
         17          * image/gif,
         18          * image/pjpeg,
         19          * application/x-ms-xbap,
         20          * application/vnd.ms-excel,
         21          * application/vnd.ms-powerpoint,
         22          * application/msword,
         23          */

        resp.setHeader("content-type", "application/x-png");
        InputStream in = this.getServletContext().getResourceAsStream("/resource/03.png");
        byte buffer[] = new byte[1024];
        int len = 0;
        OutputStream out = resp.getOutputStream();//得到输出流
        while ((len = in.read(buffer)) > 0){//读取输入流(in)里面的内容存储到缓冲区(buffer)
            out.write(buffer, 0, len); //将缓冲区里面的内容输出到浏览器
        }



    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
