
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src = "${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript">
        //页面加载完成
        $(function(){
            //输入框绑定按键弹起事件
            $("#tid").keyup(function(){
                //清空操作
                $("#did").empty();
                $("#did").hide();
                //获取输入框的值
               var value =  $(this).val();
               //判断
                if(value==""){
                    //do nothing
                }else{
                    //发送请求
                    $.ajax({
                        url:"${pageContext.request.contextPath}/kw",
                        type:"post",
                        data:"value="+value,
                        dataType:"json",
                        success:function(data){
                            if(data.length>0){
                                //遍历集合
                                $(data).each(function(index,ele){
                                    //拼接div标签
                                    var div = "<div onmouseover='m1(this)' onmouseout='m2(this)' onclick='m3(this)'>"+this.name+"</div>";
                                    $("#did").append(div)

                                });
                                //将div显示出来
                                $("#did").show();
                            } else {
                                //do nothing
                            }
                        }
                    })

                }


            })

        });
        function m1(obj){
           $(obj).css("background-color","#ccc")
        }
        function  m2(obj) {
            $(obj).css("background-color","#fff");
        }
        function m3(obj){
            var text = $(obj).html();
            $("#tid").val(text);
            $("#did").hide()
        }
    </script>
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
