<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>客户录入页面</title>
</head>
<body>
<form action="${ctx}/add" method="post">
    客户名称：<input type="text" name="custName"/><br/>
    客户来源：<input type="text" name="custSource"/><br/>
    客户级别：<input type="text" name="custLevel"/><br/>
    客户行业：<input type="text" name="custIndustry"/><br/>
    客户地址：<input type="text" name="custAddress"/><br/>
    客户电话：<input type="text" name="custPhone"/><br/>
    <input type="submit" value="保存"/><br/>
</form>
</body>
</html>
