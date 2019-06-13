package com.rony.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import static java.text.MessageFormat.*;

/**
 * 使用servletContext读取资源文件
 */
@WebServlet(urlPatterns = "/ServletContextDemo6")
public class ServletContextDemo6 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * response.setContentType("text/html;charset=UTF-8");目的是控制浏览器用UTF-8进行解码；
         * 这样就不会出现中文乱码了
         */
        response.setHeader("content-type","text/html;charset=UTF-8");
//        readSrcDirPropCfgFile(response);//读取src目录下的properties配置文件
        response.getWriter().println("<hr/>");
        readWebRootDirPropCfgFile(response);//读取WebRoot目录下的properties配置文件
        response.getWriter().println("<hr/>");
//        readPropCfgFile(response);//读取src目录下的db.config包中的db3.properties配置文件
        response.getWriter().println("<hr/>");
//        readPropCfgFile2(response);//读取src目录下的gacl.servlet.study包中的db4.properties配置文件
        test3(request, response);

    }

    /**
     * 读取src目录下的gacl.servlet.study包中的db4.properties配置文件
     * @param response
     * @throws IOException
     */
    private void readPropCfgFile2(HttpServletResponse response)
            throws IOException {
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/gacl/servlet/study/db4.properties");
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        response.getWriter().println("读取src目录下的gacl.servlet.study包中的db4.properties配置文件：");
        response.getWriter().println(
                format(
                        "driver={0},url={1},username={2},password={3}",
                        driver,url, username, password));
    }

    /**
     * 读取src目录下的db.config包中的db3.properties配置文件
     * @param response
     * @throws FileNotFoundException
     * @throws IOException
     */
    private void readPropCfgFile(HttpServletResponse response)
            throws FileNotFoundException, IOException {
        //通过ServletContext获取web资源的绝对路径
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/db/config/db3.properties");
        InputStream in = new FileInputStream(path);
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        response.getWriter().println("读取src目录下的db.config包中的db3.properties配置文件：");
        response.getWriter().println(
                format(
                        "driver={0},url={1},username={2},password={3}",
                        driver,url, username, password));
    }

    /**
     * 通过ServletContext对象读取WebRoot目录下的properties配置文件
     * @param response
     * @throws IOException
     */
    private void readWebRootDirPropCfgFile(HttpServletResponse response)
            throws IOException {
        /**
         * 通过ServletContext对象读取WebRoot目录下的properties配置文件
         * “/”代表的是项目根目录
         */
        InputStream in = this.getServletContext().getResourceAsStream("/db2.properties");
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        response.getWriter().println("读取WebRoot目录下的db2.properties配置文件：");
        response.getWriter().print(
                format(
                        "driver={0},url={1},username={2},password={3}",
                        driver,url, username, password));
    }

    /**
     * 通过ServletContext对象读取src目录下的properties配置文件
     * @param response
     * @throws IOException
     */
    private void readSrcDirPropCfgFile(HttpServletResponse response) throws IOException {
        /**
         * 通过ServletContext对象读取src目录下的db1.properties配置文件
         */
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db1.properties");
        Properties prop = new Properties();
        prop.load(in);
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        response.getWriter().println("读取src目录下的db1.properties配置文件：");
        response.getWriter().println(
                format(
                        "driver={0},url={1},username={2},password={3}",
                        driver,url, username, password));
    }

    public void test3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //如果是与代码同级目录则要路径加上  /WEB-INF/classes/
        InputStream inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/com/rony/servlet/db3.properties");
        Properties p = new Properties();
        p.load(inputStream);
        String driver = p.getProperty("driver");
        String url = p.getProperty("url");
        String username = p.getProperty("username");
        String password = p.getProperty("password");
        response.getWriter().println("读取src目录下的db3.properties配置文件：");
//        response.getOutputStream().write("读取src目录下的db3.properties配置文件：".getBytes());
        response.getWriter().println(
                format(
                        "driver={0},url={1},username={2},password={3}",
                        driver,url, username, password));


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}