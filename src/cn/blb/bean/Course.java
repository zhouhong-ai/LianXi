package cn.blb.bean;

public class Course {

	private String cname;
	private String ctype;
	private String count;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String cname, String ctype, String count) {
		super();
		this.cname = cname;
		this.ctype = ctype;
		this.count = count;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Course [cname=" + cname + ", ctype=" + ctype + ", count=" + count + "]";
	}
	
}
