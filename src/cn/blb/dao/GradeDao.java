package cn.blb.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.blb.bean.Course;
import cn.blb.bean.Grade;
import cn.blb.bean.User;

public interface GradeDao {

	@Select("select * from tb_user where username=#{username}")
	public User Username(String username);

	@Select("select * from tb_user where username=#{username} and password=#{password}")
	public User login(@Param("username")String username, @Param("password")String password);

	@Select("select * from tb_score where sno=(select sno from tb_user where username=#{sno})")
	public List<Grade> showAll(String sno);
	
	@Select("select * from tb_user where sno=#{sno}")
	public User Usersno(String sno);

	@Select("select* from tb_score")
	@Results(  
			   value={	
				   @Result(column="usgradeername", property="grade"),
				   @Result(column="cno", property="cno"),
													//select 指定指定的sql，fetchType指定加载方式
				   @Result(column="sno", property="user",
							one=@One(select="cn.blb.dao.GradeDao.Usersno")
						),
					 //column是后续select执行过程的输入参数
			}
		)
	public List<Grade> adminShowAll();

	@Select("select* from tb_user")
	public List<User> showUser();

	@Select("select* from tb_course")
	public List<Course> showCourse();

	@Select("insert into tb_score values(#{sno},#{cno},#{grade})" )
	public void gradeAdd(@Param("sno")String sno, @Param("cno")String cno, @Param("grade")int grade);
	
}
