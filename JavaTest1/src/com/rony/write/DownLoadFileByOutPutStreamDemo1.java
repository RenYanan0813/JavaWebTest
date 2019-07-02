package com.rony.write;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 * 手写DownLoadFileByOutPutStream
 *
 * 下载文件
 *
 */

public class DownLoadFileByOutPutStreamDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        downloadFileByOutPutStream(resp);
    }

    public void downloadFileByOutPutStream(HttpServletResponse response) throws IOException {

        String realPath = this.getServletContext().getRealPath("/resource/03.png");
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);

        InputStream in = this.getServletContext().getResourceAsStream(realPath);

        OutputStream op = response.getOutputStream();

        byte[] buffer = new byte[1024];

        int len = 0;

        while ((len = in.read(buffer)) > 0){
            op.write(buffer, 0, len);
        }
        //获取服务器上的 资源文件

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
