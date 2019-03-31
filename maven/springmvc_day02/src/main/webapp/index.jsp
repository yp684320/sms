<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
 <form action="/springmvc_day02/user/params" method="post" enctype="application/x-www-form-urlencoded">
     id:<input type="text" name="id"><br>
     用户名:<input type="text" name="username"><br>
     密码:<input type="text" name="password"><br>
     <input type="submit" value="提交">
 </form>


<br>
<a href="/springmvc_day02/save">存</a><br>
<a href="/springmvc_day02/find">查</a><br>
<a href="/springmvc_day02/delete">删</a><br>


<input type="button" value="点击做ajax" id = "bt"><br>
<script src="js/jquery.min.js"></script>
<script>
    $(function(){
        $("#bt").click(function(){
            $.ajax({
                url:'/springmvc_day02/ajax',
                type:'post',
                dataType:'json',
                contentType:'application/json;charset=utf-8',
                data:'{"id":123,"username":"aaa","password":"1234"}',
                success:function(d){
                    // json
                    alert(d.username);
                }
            });
        })
    })
</script><br>
<%--上传文件--%>
<form action="/springmvc_day02/upload" method="post" enctype="multipart/form-data">
   上传: <input type="file" name="myFile">
    <br>
    <input type="submit" value="上传">
</form>
</body>
</html>
