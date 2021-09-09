package newpackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newpackage.bean.EnrolledCourse;

/**
 * Servlet implementation class EnrollCourse
 */
@WebServlet("/EnrollCourse")
public class EnrollCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private String userid,courseid;
	private  String name,coursename1;
    public EnrollCourse() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ArrayList<EnrolledCourse> ecourses = new ArrayList<>();
	public void init() throws ServletException {
		
	       
		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        
	        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","sys as sysdba","system"); 
	        //String sql = "select * from coursedetails";
			//PreparedStatement statement = con.prepareStatement(sql);
	        Statement stmt=con.createStatement();  
	        ResultSet rs=stmt.executeQuery("select distinct * from courseenroll order by courseid"); 
	              
	                //System.out.println("hello console");
	        while(rs.next()) {
	        	//System.out.println("inside loop");
	        	
	        	String s1=rs.getString(1);
	        	String s2=rs.getString(2);
	        	String s3=rs.getString(3);
	        	String s4=rs.getString(4);
	        	if(s1==null) {continue;}
		        	EnrolledCourse ecourse = new EnrolledCourse(s1,s2,s3,s4);
		        	ecourses.add(ecourse);
	            
	        }
	        con.close(); 
	        
	        
	    } catch (ClassNotFoundException | SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } 
	       
	    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.setAttribute("Message", "Enrolled SuccessFully");
		userid=(String)request.getParameter("userid");
		courseid=(String)request.getParameter("courseid");
				if(userid!=null && courseid!=null) {
						try {
					        Class.forName("oracle.jdbc.driver.OracleDriver");
					        
					        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","sys as sysdba","system"); 
					        //String sql = "select * from coursedetails";
							//PreparedStatement statement = con.prepareStatement(sql);
					        //Statement stmt=con.createStatement();  
					        String st1="select * from course where courseid=?";
					        String st2="select * from userdetails where id=?";
					        PreparedStatement pt1 = con.prepareStatement(st1);
					        PreparedStatement pt2 = con.prepareStatement(st2);
					        pt1.setString(1, courseid);
					        pt2.setString(1, userid);
					        ResultSet rs=pt1.executeQuery(); 
					        ResultSet rs1=pt2.executeQuery();
					        
					       
					        if(rs.next()&&rs1.next()) {
					        	 //userid=rs1.getString(1);
					        	 name=rs1.getString(2);
					        	 //courseid=rs.getString(1);
					        	 coursename1=rs.getString(2);}
					       //System.out.println(courseid+" "+coursename1+" "+userid+" "+name);
					        String query = "insert into courseenroll (courseid,coursename,id,name) values(?,?,?,?)";
					        PreparedStatement pt = con.prepareStatement(query);
					        pt.setString(1, courseid);
					        pt.setString(2, coursename1);
					        pt.setString(3, userid);
					        pt.setString(4,name);
					        pt.executeUpdate();
					        
					        
					        con.close(); 
					        
					        
					    } catch (ClassNotFoundException | SQLException e) {
					        // TODO Auto-generated catch block
					        e.printStackTrace();
					    }
				   
				request.getRequestDispatcher("ViewCourse").forward(request, response);
		}
				
		else {
			request.setAttribute("result", ecourses);
	        
	        request.getRequestDispatcher("adminenrollview.jsp").forward(request, response);
		}
		        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
