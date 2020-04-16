package cn.blb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.blb.bean.Course;
import cn.blb.bean.Grade;
import cn.blb.bean.User;
import cn.blb.dao.GradeDao;
import cn.blb.service.GradeService;

@Service("gradeService")
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDao gradelDao;
	
	@Override
	public User Username(String username) {
		// TODO Auto-generated method stub
		return gradelDao.Username(username);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return gradelDao.login(username,password);
	}

	@Override
	public List<Grade> showAll(String sno) {
		// TODO Auto-generated method stub
		return gradelDao.showAll(sno);
	}

	@Override
	public List<Grade> adminShowAll() {
		// TODO Auto-generated method stub
		return gradelDao.adminShowAll();
	}

	@Override
	public List<User> showUser() {
		// TODO Auto-generated method stub
		return gradelDao.showUser();
	}

	@Override
	public List<Course> showCourse() {
		// TODO Auto-generated method stub
		return gradelDao.showCourse();
	}

	@Override
	public void gradeAdd(String sno, String cno, int grade) {
		// TODO Auto-generated method stub
		gradelDao.gradeAdd(sno,cno,grade);
	}

}
