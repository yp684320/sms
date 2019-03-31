<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%--音译词--%>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <a href="${ctx}/findAll">查询所有</a><br>
  <a href="${ctx}/findByCondition">多条件查询</a><br>
  <a href="${ctx}/findByPage">分页查询</a><br>

  <a href="${ctx}/findByPage1">分页查询1</a><br>
  </body>
</html>
