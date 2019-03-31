<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	$(function () {
		$("#tid").keyup(function(){
            //清空操作
            $("#did").empty();
            $("#did").hide();
			//获取当前输入框值
			var value=$(this).val();

			//如果输入啥也没有
			if(value==""){
				//do nothing
			}else{

                //偷偷摸摸发请求
                $.ajax({
                    url:"/search",
                    data:"value="+value,
                    type:"post",
					dataType:"json",//表示告诉jquery 你帮我进行一次eval转换
                    success:function(data){
                        //干啥?
                        //var s="[{id:1,'name':'华为耳机'},{id:2,'name':'华为手机'}]"
                        //进行转换
						//如果返回的数据为空  不做遍历和显示
                        //var dataArr=eval("("+data+")");
                        if(data.length>0){
                            //进行遍历
                            $(data).each(function(index,ele){
                                //拼接div 标签
                                var div="<div onmouseover='m1(this)' onmouseout='m2(this)' onclick='m3(this)'>"+this.name+"</div>";

                                $("#did").append(div);
                            });
                            //将div显示出来
                            $("#did").show()
						}else{
							//do nothing
						}
                    }
                })
			}
		})
    })
	function  m1(obj) {
		$(obj).css("background-color","#ccc");
    }
    function  m2(obj) {
        $(obj).css("background-color","#fff");
    }

    function  m3(obj) {
       var text =$(obj).html();
       $("#tid").val(text);
       $("#did").hide();
    }
</script>
<title>Insert title here</title>
</head>
<body>
	<center>
		<div>
			<h1>黑马搜索</h1>
			<div>
				<input name="kw" id="tid"><input type="button" value="黑马一下">
			</div>
			<div id="did" style="border: 1px solid red;width: 171px;position:relative;left:-34px;display:none">


			</div>
		</div> 
	</center>
</body>
</html>