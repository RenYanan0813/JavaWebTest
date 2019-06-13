package com.rony.write;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 手写DownLoadFileByOutPutStream
 *
 * 下载文件
 *
 */

public class DownLoadFileByOutPutStreamDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    public void downloadFileByOutPutStream(HttpServletResponse response){

        String realPath ;
        //获取服务器上的 资源文件

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
