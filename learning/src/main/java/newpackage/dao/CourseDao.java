package newpackage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import newpackage.ConnectionPro;
import newpackage.bean.Courses;

//import com.sun.tools.javac.util.List;

public class CourseDao {

    private Connection conn;
    public CourseDao() {
    	conn = ConnectionPro.getConnection();
    }
    public CourseDao(Connection con) {
    	this.conn=con;
    }

    public void addCourse(Courses course) {
        try {
        	String sql = "INSERT INTO coursedetails(courseid,coursename,coursefee,coursedesc)" +
    		" VALUES (?, ?, ?,? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1,course.getCourseid());
            ps.setString(2,course.getCoursename());
            ps.setDouble(3,course.getCoursefee()); 
            ps.setString(4,course.getCoursedesc());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    
    
    public List getAllCourse() {
        List courses = new ArrayList();
        try {
        	String sql = "SELECT * FROM coursedetails";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Courses course = new Courses();
                course.setCourseid(rs.getString("courseid"));
                course.setCoursename(rs.getString("coursename"));
                course.setCoursefee(rs.getInt("coursefee"));
                course.setCoursedesc(rs.getString("coursedesc"));
                courses.add(course);
                
                System.out.println(course.getCoursename());
                System.out.println("in coursedao class");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public Courses getCourseById(int courseid) {
    	Courses course = new Courses();
        try {
        	String sql = "SELECT * FROM course WHERE courseid=?";
            PreparedStatement ps = conn.
                    prepareStatement(sql);
            ps.setInt(1, courseid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	course.setCourseid(rs.getString("courseid"));
                course.setCoursename(rs.getString("coursename"));
                course.setCoursefee(rs.getInt("coursefee"));
                course.setCoursedesc(rs.getString("coursedesc"));                          
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }
}