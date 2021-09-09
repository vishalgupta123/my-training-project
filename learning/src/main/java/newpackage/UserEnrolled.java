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
import newpackage.bean.EnrolledCourse;

/**
 * Servlet implementation class UserEnrolled
 */
@WebServlet("/UserEnrolled")
public class UserEnrolled extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ArrayList<Courses> ecourses=new ArrayList<>();
    public UserEnrolled() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String userid=request.getParameter("userid");
		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        
	        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","sys as sysdba","system"); 
	        //String sql = "select * from coursedetails";
			//PreparedStatement statement = con.prepareStatement(sql);
	        Statement stmt=con.createStatement();  
	        ResultSet rs=stmt.executeQuery("select * from course where courseid=(select distinct(courseid) from courseenroll where id='"+userid+"')");
	              
	                //System.out.println("hello console");
	        while(rs.next()) {
	        	//System.out.println("inside loop");
	        	
	        	String s1=rs.getString(1);
	        	String s2=rs.getString(2);
	        	String s3=rs.getString(4);
	        	if(s1==null) {continue;}
		        	Courses ecourse = new Courses();
		        	ecourse.setCourseid(s1);
		        	ecourse.setCoursename(s2);
		        	ecourse.setCoursedesc(s3);
		        	ecourses.add(ecourse);
	            
	        }
	        con.close(); 
	        
	        
	    } catch (ClassNotFoundException | SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } 
	       
	    request.setAttribute("result", ecourses);
	    request.getRequestDispatcher("userenrolledview.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
