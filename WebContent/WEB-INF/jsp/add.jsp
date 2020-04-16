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
   <form action="gradeAdd" method="post" id="form">
         学生姓名:
    <select name="sno">
        <option v-for="u of users" :value="u.sno" v-text="u.username"></option>
    </select><br>
    课程:
    <select name="cno">
        <option v-for="c of courses" :value="c.cname" v-text="c.cname"></option>
    </select><br>
    分数:<input type="text" name="grade"/><br>
    <input type="submit" value="新增"/> <input type="reset" value="重置"/>
</form>
</body>
<script type="text/javascript">
var vm = new Vue({
    el: "#form",
    data: {
        users: [],
        courses: []
    }
});
$.ajax({
	 url:"showUser",
success:function(result){
			vm.users=result;
		},
		type:"post", 
		dataType:"json"
}); 
$.ajax({
	 url:"showCourse",
success:function(result){
			vm.courses=result;
		},
		type:"post", 
		dataType:"json"
}); 
</script>
</html>