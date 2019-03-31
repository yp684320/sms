<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%--简单数据封装--%>
<form action="/springmvc_day01/user/params1" method="post">
    用户名:<input type="text" name="username"/><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交">
</form>

<%--对象数据封装--%>
<form action="/springmvc_day01/user/params2" method="post">
    用户名:<input type="text" name="username"/><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交">
</form>
<%--对象list数据封装--%>
<form action="/springmvc_day01/user/params3" method="post">
    用户名:<input type="text" name="username"><br>
    年龄:<input type="text" name="age"><br>
    第一个账户名:<input type="text" name="accounts[0].name"><br>
    第一个账户金额:<input type="text" name="accounts[0].money"><br>
    第二个账户名:<input type="text" name="accounts[1].name"><br>
    第二个账户金额:<input type="text" name="accounts[1].money"><br>
    <input type="submit" value="提交">
</form>
<%--对象map集合数据封装--%>
<form action="/springmvc_day01/user/params4" method="post">
    用户名:<input type="text" name="username"><br>
    年龄:<input type="text" name="age"><br>
    第一个账户名:<input type="text" name="maps[11].name"><br>
    第一个账户金额:<input type="text" name="maps[11].money"><br>
    第二个账户名:<input type="text" name="maps[22].name"><br>
    第二个账户金额:<input type="text" name="maps[22].money"><br>
    <input type="submit" value="提交">

</form>

<%--date数据--%>
<form action="/springmvc_day01/user/params5" method="post">
    日期:<input type="text" name="date"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>
