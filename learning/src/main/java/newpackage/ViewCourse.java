package newpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newpackage.bean.Courses;

/**
 * Servlet implementation class ViewCourse
 */

@WebServlet("/ViewCourse")
public class ViewCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	String userid;
	 ArrayList<Courses> courses = new ArrayList<>();
		public void init() throws ServletException {
			
		       
			try {
		        Class.forName("oracle.jdbc.driver.OracleDriver");
		        
		        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","sys as sysdba","system"); 
		        Statement stmt=con.createStatement();  
		        ResultSet rs=stmt.executeQuery("select * from course"); 
		        while(rs.next()) {
		        	Courses course = new Courses();
		        	String s1=rs.getString(1);
		        	String s2=rs.getString(2);
		        	double s3=rs.getDouble(3);
		        	String s4=rs.getString(4);
		        	
					course.setCourseid(s1);
		            course.setCoursename(s2);
		            course.setCoursefee(s3);
		            course.setCoursedesc(s4);
		            
		            courses.add(course);
		            
		        } 
		        con.close(); 
		        
		        
		    } catch (ClassNotFoundException | SQLException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    } 
		       
		    }
	
    public ViewCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		userid=(String)request.getParameter("userid");
		request.setAttribute("result", courses);
        String action=(String)request.getParameter("action");
        if(action!=null){
        	request.getRequestDispatcher("admincourseview.jsp").forward(request, response);
        }
        else {
        	request.setAttribute("userid", userid);
        request.getRequestDispatcher("usercourse.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
