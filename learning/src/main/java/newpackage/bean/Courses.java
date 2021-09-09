package newpackage.bean;

public class Courses {
	String courseid;
	String coursename;
	double coursefee;
	String coursedesc;
	
	
	
	public Courses() {
	}
	public Courses(String courseid, String coursename, double coursefee, String coursedesc) {
	
		this.courseid = courseid;
		this.coursename = coursename;
		this.coursefee = coursefee;
		this.coursedesc = coursedesc;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public double getCoursefee() {
		return coursefee;
	}
	public void setCoursefee(double coursefee) {
		this.coursefee = coursefee;
	}
	public String getCoursedesc() {
		return coursedesc;
	}
	public void setCoursedesc(String coursedesc) {
		this.coursedesc = coursedesc;
	}
	

}
