package com.rony.write;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 *
 * 使用OutputStream流输出中文注意问题：
 *
 * 　　在服务器端，数据是以哪个码表输出的，
 * 那么就要控制客户端浏览器以相应的码表打开，
 * 比如：outputStream.write("中国".getBytes("UTF-8"));
 * 使用OutputStream流向客户端浏览器输出中文，以UTF-8的编码进行输出，
 * 此时就要控制客户端浏览器以UTF-8的编码打开，
 * 否则显示的时候就会出现中文乱码，
 * 那么在服务器端如何控制客户端浏览器以以UTF-8的编码显示数据呢？
 * 可以通过设置响应头控制浏览器的行为，
 * 例如：response.setHeader("content-type", "text/html;charset=UTF-8");
 * 通过设置响应头控制浏览器以UTF-8的编码显示数据。
 *
 */

@WebServlet(urlPatterns = "/OutPutStreamDemo")
public class OutPutStreamDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        outputChineseByStream(resp);
    }

    public void outputChineseByStream(HttpServletResponse response) throws IOException {
        /**使用OutputStream输出中文注意问题：
         27          * 在服务器端，数据是以哪个码表输出的，那么就要控制客户端浏览器以相应的码表打开，
         28          * 比如：outputStream.write("中国".getBytes("UTF-8"));//使用OutputStream流向客户端浏览器输出中文，以UTF-8的编码进行输出
         29          * 此时就要控制客户端浏览器以UTF-8的编码打开，否则显示的时候就会出现中文乱码，那么在服务器端如何控制客户端浏览器以以UTF-8的编码显示数据呢？
         30          * 可以通过设置响应头控制浏览器的行为，例如：
         31          * response.setHeader("content-type", "text/html;charset=UTF-8");//通过设置响应头控制浏览器以UTF-8的编码显示数据
         32          */

        String data = "中国";

        OutputStream os = response.getOutputStream();

        response.setHeader("content-type", "text/html;charset=UTF-8");

        /**
         37          * data.getBytes()是一个将字符转换成字节数组的过程，这个过程中一定会去查码表，
         38          * 如果是中文的操作系统环境，默认就是查找查GB2312的码表，
         39          * 将字符转换成字节数组的过程就是将中文字符转换成GB2312的码表上对应的数字
         40          * 比如： "中"在GB2312的码表上对应的数字是98
         41          *         "国"在GB2312的码表上对应的数字是99
         42          */
                /**
         44          * getBytes()方法如果不带参数，那么就会根据操作系统的语言环境来选择转换码表，如果是中文操作系统，那么就使用GB2312的码表
         45          */

        byte[] dataByteArr = data.getBytes("UTF-8");
        response.getOutputStream().write(dataByteArr);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
