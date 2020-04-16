<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/vue.js"></script>
</head>
<body>
  欢迎<span id="username">${username }</span>.....<a href="#">退出</a><br>
      <table id="tb" border="1px" width="500px">
		<tr><th>序号</th><th>姓名</th><th>课程</th><th>成绩</th></tr>
			<tr v-for="(grade,index) of grades">
				<td>{{index+1}}</td>
				<td>${username}</td>
				<td>{{grade.cno}}</td>
				<td>{{grade.grade}}</td>
			</tr>
	</table> 
</body>
<script type="text/javascript">
var username=$("#username").html();
alert(username)
 var vm=new Vue({
	el:"#tb",
	data:{
		grades:[]
	}
});
$.ajax({
	 url:"showAll",
success:function(result){
			alert(result)
			vm.grades=result;
		},
		type:"post", 
		dataType:"json",
		/* contentType:"application/json;charset=utf-8", */
		data:{"username":username}
}); 
</script>
</html>