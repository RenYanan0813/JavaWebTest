<%--
  Created by IntelliJ IDEA.
  User: Rony Ren
  Date: 2019/6/18
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>

<html>
<head>
    <title>在Form表单中使用验证码</title>
    <script type="text/javascript">
        //刷新验证码
        function changeImg(){
            document.getElementById("validateCodeImg").src="${pageContext.request.contextPath}/DrawImage?"+Math.random();
        }
    </script>
</head>

<body>
<form action="${pageContext.request.contextPath}/CheckServlet" method="post">
    验证码：<input type="text" name="validateCode"/>
    <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/DrawImage" id="validateCodeImg" onclick="changeImg()">
    <a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>
    <br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
