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

import newpackage.bean.Feedback;
import newpackage.bean.User;

/**
 * Servlet implementation class ViewFeedback
 */
@WebServlet("/ViewFeedback")
public class ViewFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ArrayList<Feedback> feedbacks = new ArrayList<>();
	public void init() throws ServletException {
		
	       
		try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        
	        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","sys as sysdba","system"); 
	        //String sql = "select * from coursedetails";
			//PreparedStatement statement = con.prepareStatement(sql);
	        Statement stmt=con.createStatement();  
	        ResultSet rs=stmt.executeQuery("select * from feedback"); 
	              
	                //System.out.println("hello console");
	        while(rs.next()) {
	        	//System.out.println("inside loop");
	        	String s1=rs.getString(1);
	        	String s2=rs.getString(2);
	        	String s3=rs.getString(3);
	        	String s4=rs.getString(4);
	        	String s5=rs.getString(5);
	        	Feedback user = new Feedback(s1,s2,s3,s4,s5);
	        	
	            //System.out.println(s1+" "+s2+" "+s3+" "+s4);
	        	
				
	            
	            feedbacks.add(user);
	            
	        }
	         
	        
	        
	        
	        con.close(); 
	        
	        
	    } catch (ClassNotFoundException | SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } 
	       
	    }
	
    public ViewFeedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
request.setAttribute("result", feedbacks);
        
        request.getRequestDispatcher("adminfeedbackview.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
