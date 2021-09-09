package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;

import newpackage.bean.Feedback;

public class FeedbackDatabase {
	Connection con ;

    public FeedbackDatabase(Connection con) {
        this.con = con;
    }
    
    //for register user 
    public boolean saveFeedback(Feedback fb){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into feedback (feedbackid,userid,name,email,feedback) values(?,?,?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, fb.getFeedbackid());
           pt.setString(2, fb.getUserid());
           pt.setString(3, fb.getName());
           pt.setString(4,fb.getEmail());
           pt.setString(5, fb.getFeedback());
           
           
           
           pt.executeUpdate();
           set = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
   
}

