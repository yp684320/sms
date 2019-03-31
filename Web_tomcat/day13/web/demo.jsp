<%@ page import="domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--存储数据--%>
    <%--<%
        //向request域中存储数据
        request.setAttribute("name","张三");
        //向session域中存储数据
        request.getSession().setAttribute("name","李四");


    %>
    <h1>取出request域中的数据</h1>

    ${requestScope.name}
    <h1>取出session域中的值</h1>
    ${sessionScope.name}
--%>
    <%--存储user实体对象--%>
<<%--%
    User user = new User("张三",18);
    request.setAttribute("user",user);
%>
    <h1>取出user的数据</h1>
    ${user.name}==${user.age}
--%>


    <%--<%‐‐ 存储List<String>数据 ‐‐%>--%>
    <%
        List<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");
        strList.add("ccc");
        request.setAttribute("strList",strList);
    %>
    <h1>取出strList的数据</h1>
    ${strList[0]}==${strList[1]}


    <%

        User user = new User("tom", "18");
        request.setAttribute("user", user);
    %>
    <h1>取出User的数据</h1>
        ${user.name}

</body>
</html>
