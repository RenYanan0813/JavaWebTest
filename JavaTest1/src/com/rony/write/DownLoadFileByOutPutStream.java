package com.rony.write;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *
 * 文件下载功能是web开发中经常使用到的功能，使用HttpServletResponse对象就可以实现文件的下载
 *
 * 文件下载功能的实现思路：
 *
 * 　　1.获取要下载的文件的绝对路径
 *
 * 　　2.获取要下载的文件名
 *
 * 　　3.设置content-disposition响应头控制浏览器以下载的形式打开文件
 *
 * 　　4.获取要下载的文件输入流
 *
 * 　　5.创建数据缓冲区
 *
 * 　　6.通过response对象获取OutputStream流
 *
 * 　　7.将FileInputStream流写入到buffer缓冲区
 *
 * 　　8.使用OutputStream将缓冲区的数据输出到客户端浏览器
 *
 *
 * 文件下载注意事项：编写文件下载功能时推荐使用OutputStream流，
 * 避免使用PrintWriter流，因为OutputStream流是字节流，可以处理任意类型的数据，
 * 而PrintWriter流是字符流，只能处理字符数据，如果用字符流处理字节数据，会导致数据丢失。
 *
 */
@WebServlet(urlPatterns = "/DownLoadFileByOutPutStream")
public class DownLoadFileByOutPutStream extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        downloadFileByOutputStream(resp);
    }

    /**
     * 下载文件，通过OutputStream流
     * @param response
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void downloadFileByOutputStream(HttpServletResponse response)
            throws FileNotFoundException, IOException {
        //1.获取要下载的文件的绝对路径
        String realPath = this.getServletContext().getRealPath("/resource/03.png");
        //2.获取要下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);
        //3.设置content-disposition响应头控制浏览器以下载的形式打开文件

        //设置content-disposition响应头控制浏览器以下载的形式打开文件，中文文件名要使用URLEncoder.encode方法进行编码，否则会出现文件名乱码
//        response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
        response.setHeader("content-disposition", "attachment;filename="+fileName);
        //4.获取要下载的文件输入流
        InputStream in = new FileInputStream(realPath);
        int len = 0;
        //5.创建数据缓冲区
        byte[] buffer = new byte[1024];
        //6.通过response对象获取OutputStream流
        OutputStream out = response.getOutputStream();
        //7.将FileInputStream流写入到buffer缓冲区
        while ((len = in.read(buffer)) > 0) {
            //8.使用OutputStream将缓冲区的数据输出到客户端浏览器
            out.write(buffer,0,len);
        }
        in.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
