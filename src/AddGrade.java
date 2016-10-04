
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tool.DbGradebook;
import Tool.DbUser;
import model.Gradebook;
import model.User;

/**
 * Servlet implementation class Update
 */
@WebServlet("/AddGrade")
public class AddGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGrade() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nextURL="/AddGrade.jsp";
		String assignment = request.getParameter("assignment");
		String assignmenttype = request.getParameter("assignmenttype");
		String grade = request.getParameter("grade");
		String subject = request.getParameter("subject");
		int userid = Integer.parseInt(request.getParameter("userid"));
		User usertoadd = DbUser.getUser(userid);
		if(null==usertoadd){
			nextURL="/AddGrade.jsp?isvaliduserid=false";
		}
		else{
		HttpSession session = request.getSession();
		Gradebook gradebook = new Gradebook();
		gradebook.setAssignment(assignment);
		gradebook.setAssignmenttype(assignmenttype);
		gradebook.setGrade(grade);
		
		
		gradebook.setUser(usertoadd);
		gradebook.setSubject(subject);
		DbGradebook.insert(gradebook);
		User user = (User) session.getAttribute("user");
		nextURL = "/Login?useremail=" + user.getUseremail() + "&password=" + user.getUserpassword();
		}
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		// doGet(request, response);
	}

}
