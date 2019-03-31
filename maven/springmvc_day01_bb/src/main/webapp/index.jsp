<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<%--只要访问服务器的资源 除了表单中的method=post是post提交 其余都是get提交--%>
<form action="/springmvc_day01/user/params1" method="post">
    用户名:<input type="text" name="username"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交">
</form>
<%--对象数据封装--%>
<form action="/springmvc_day01/user/params2" method="post">
    用户名:<input type="text" name="username"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
