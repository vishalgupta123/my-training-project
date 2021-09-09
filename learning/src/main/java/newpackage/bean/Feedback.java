package newpackage.bean;

public class Feedback {
	String feedbackid;
	String userid;
	String name;
	String email;
	String feedback;
	public Feedback(String feedbackid, String userid, String name, String email, String feedback) {
		this.feedbackid = feedbackid;
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.feedback = feedback;
	}
	public String getFeedbackid() {
		return feedbackid;
	}
	public void setFeedbackid(String feedbackid) {
		this.feedbackid = feedbackid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	

}
