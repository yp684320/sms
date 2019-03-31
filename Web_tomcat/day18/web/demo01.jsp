
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src = "js/jquery.js"></script>
    <script>

        $(function(){
            //为输入框绑定失去焦点事件
            $("[name='username']").blur(function(){
               // alert(1)测试事件是否绑定成功
                //获取当前输入框值
                var value = $(this).val();
                var params = "username="+value;
                $.ajax({
                        url:"/day18/user",
                        data:params ,
                         type :"get" ,
                         success:function(data){
                            //回调函数  不可用
                             if (data==1) {
                                 $("#usename_msg").html("该用户不可用").css("color","red")
                             }
                             else {
                                 $("#usename_msg").html("该用户可用").css("color","green")
                             }
                         }
                })
            })
        })
    </script>
</head>
<body>
<form method="post" action="#">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
            <td><span id="usename_msg"></span></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="text" name="password"></td>
            <td></td>
        </tr>
        <tr>
            <td colspan='3'><input type="submit" id="sub"></td>
        </tr>
    </table>
</form>
</body>
</html>
