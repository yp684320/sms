<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
</head>
<body>
<h3>用户列表</h3>
<table>
    <thead>
    <tr>
        <th>主键</th>
        <th>账户</th>
        <th>密码</th>
        <th>用户姓名</th>
        <th>用户头像</th>
    </tr>
    </thead>
    <tbody>
    <#list userlist as user>
         <tr>
             <td>${user.id}</td>
             <td>${user.username}</td>
             <td>${user.password}</td>
             <td>${user.name}</td>
             <td><img src="/images/123.jpg" width="30" height="30"></td>
         </tr>
    </#list>

    </tbody>
</table>
</body>
</html>