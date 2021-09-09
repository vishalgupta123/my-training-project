package newpackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newpackage.bean.Feedback;

/**
 * Servlet implementation class AddFeedback
 */
@WebServlet("/AddFeedback")
public class AddFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFeedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String feedbackid=request.getParameter("feedbackid");
		String userid=request.getParameter("userid");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String feedback=request.getParameter("feedback");
		
		Feedback fb=new Feedback(feedbackid,userid,name,email,feedback);
		
		FeedbackDatabase regFeed = new FeedbackDatabase(ConnectionPro.getConnection());
		
		if (regFeed.saveFeedback(fb)) {
			String errorMessage = "Thank You for Your Feedback !!!!";
		    HttpSession regSession = request.getSession();
		    regSession.setAttribute("RegFeedback", errorMessage);
		    response.sendRedirect("userfeedback.jsp");
			}
		
	}

}
