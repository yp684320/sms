<%@ page import="com.itheima.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");

%>
<table border="1px" align="center" style="width:60%;background-color: yellowgreen" cellspacing="0px">
    <tr>
        <td>id</td>
        <td>用户名</td>
        <td>密码</td>
        <td>姓名</td>
        <td>邮箱</td>
        <td>生日</td>
    </tr>
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.birthday}</td>
    </tr>
</table>
</body>
</html>