<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>

    <form action="loginServlet" method="post">
        账号<input type="text" id="username" name="username"/><span id="username2"></span><br>
        密码<input type="text" name="password"/><br>
        <input type="submit" value="登录"/>
    </form>
    
</body>
<script type="text/javascript">
 $("#username").blur(function(){
	 var username=$("#username").val();
	 if(username==null||username==""){
		 $("#username2").html("用户名不能为空");
		 return;
	 }else{
		 $("#username2").html("");
		 $.ajax({
			 url:"Username",
		 success:function(result){
					if(result>0){
					}else{
						$("#username2").html("用户不存在");
					}
				},
				type:"post",
				/* contentType:"application/json;charset=utf-8", */
				data:{"username":username}
		 });
	 }
 });
</script>
</html>