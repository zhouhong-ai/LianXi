package cn.blb.service;

import java.util.List;

import cn.blb.bean.Course;
import cn.blb.bean.Grade;
import cn.blb.bean.User;

public interface GradeService {

	public User Username(String username);

	public User login(String username, String password);

	public List<Grade> showAll(String sno);

	public List<Grade> adminShowAll();

	public List<User> showUser();

	public List<Course> showCourse();

	public void gradeAdd(String sno, String cno, int grade);
}
