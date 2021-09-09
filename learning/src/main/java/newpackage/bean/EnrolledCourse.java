package newpackage.bean;

public class EnrolledCourse {
	String courseid;
	String coursename;
	String id;
	String name;
	
	public EnrolledCourse(String courseid, String coursename, String id, String name) {
		this.courseid = courseid;
		this.coursename = coursename;
		this.id = id;
		this.name = name;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
