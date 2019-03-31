<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="resource/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="resource/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="resource/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function delUser(uid){
            //弹出确认框
            if(confirm("您确认删除该用户吗?")){
                //alert(uid)
                //发请求
                //href属性指明就是 当前地址的那个字符串
                location.href="${ctx}/del?id="+uid;
            }else{
                //do nothing
                //
            }
        }

    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr>
            <td colspan="9">
                <form action="${ctx}/findByCondition">
                    性别:
                    <select name="sex">
                        <option value="">--请选择--</option>
                        <c:if test="${empty sex}">
                            <option value="男" >男</option>
                            <option value="女">女</option>
                        </c:if>
                        <c:if test="${sex=='男'}">
                            <option value="男" selected>男</option>
                            <option value="女">女</option>
                        </c:if>
                        <c:if test="${sex=='女'}">
                            <option value="男">男</option>
                            <option value="女" selected>女</option>
                        </c:if>

                    </select>
                    籍贯:<input type="text" name="address" value="${address}">
                    <input type="submit" value="查询用户">
                </form>
            </td>
        </tr>
        <tr class="success">
            <th>编号</th>
            <th>id</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.sex}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="javascript:;" onclick="delUser(${user.id})"  >删除</a></td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>

