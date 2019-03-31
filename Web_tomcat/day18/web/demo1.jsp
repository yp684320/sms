<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
			//为用户名输入框绑定丢失焦点事件
		$("[name='username']").blur(function(){
			//获取当前输入框值
			var value=$(this).val();

			var params="username="+value;

			$.ajax({
				url:"/checkName",
				data:params,
				type:"get",
				success:function(data){
					//回调函数
					if(data==1){
						//不可用
						$("#usename_msg").html("该用户已经使用过了").css("color","red");

					}else{
                        $("#usename_msg").html("该用户可用").css("color","green");
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