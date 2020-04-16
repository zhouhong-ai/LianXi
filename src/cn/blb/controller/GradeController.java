package cn.blb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.blb.bean.Course;
import cn.blb.bean.Grade;
import cn.blb.bean.User;
import cn.blb.service.GradeService;

@Controller
public class GradeController {

	@Autowired
	private GradeService gradeService;
	
	@RequestMapping("/login")
	public String loginView2(){
		return "login";
	}
	
	@RequestMapping("/add")
	public String loginView1(){
		return "add";
	}
	
	@RequestMapping("/index")
	public String loginView(){
		return "index";
	}
	
	@RequestMapping(value="/Username",method = RequestMethod.POST)
	@ResponseBody
	public String Username(@RequestParam("username") String username){
		System.out.println(username);
		User user=gradeService.Username(username);
		System.out.println(user);
		if(user==null){
			return "-1";
		}else{
			return "1";
		}
	}
	
	@RequestMapping(value="/loginServlet",method = RequestMethod.POST)
	public String login(ModelMap map,String username,String password){
		System.out.println(username+""+password);
		User user=gradeService.login(username,password);
		System.out.println(user);
		if(user==null){
			return "login";
		}else if("admin".equals(user.getUsername())){
			map.put("username",user.getUsername());
			return "adminIndex";
		}else{
			map.put("username",user.getUsername());
			return "index";
		}
	}

	@RequestMapping(value="/showAll",method = RequestMethod.POST)
	@ResponseBody
	public List<Grade> showAll(@RequestParam("username") String username){
		List<Grade> list=gradeService.showAll(username);
		return list;
	}
	
	@RequestMapping(value="/adminShowAll",method = RequestMethod.POST)
	@ResponseBody
	public List<Grade> adminShowAll(){
		List<Grade> list=gradeService.adminShowAll();
		System.out.println(list);
		return list;
	}	
	
	@RequestMapping(value="/showUser",method = RequestMethod.POST)
	@ResponseBody
	public List<User> showUser(){
		return gradeService.showUser();
	}	
	
	@RequestMapping(value="/showCourse",method = RequestMethod.POST)
	@ResponseBody
	public List<Course> showCourse(){
		return gradeService.showCourse();
	}	
	
	@RequestMapping(value="/gradeAdd",method = RequestMethod.POST)
	public String gradeAdd(@RequestParam("sno") String sno,@RequestParam("cno") String cno,@RequestParam("grade") int grade){
		System.out.println(sno+""+cno+""+grade);
		gradeService.gradeAdd(sno,cno,grade);
		return "adminIndex";
	}
}
