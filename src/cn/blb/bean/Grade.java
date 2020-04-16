package cn.blb.bean;

public class Grade {

	private User user;
	private String sno;
	private String cno;
	private int grade;
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	public Grade(String sno, String cno, int grade) {
		super();
		this.sno = sno;
		this.cno = cno;
		this.grade = grade;
	}
	public Grade(User user, String cno, int grade) {
		super();
		this.user = user;
		this.cno = cno;
		this.grade = grade;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Grade [user=" + user + ", sno=" + sno + ", cno=" + cno + ", grade=" + grade + "]";
	}
	
	
}
