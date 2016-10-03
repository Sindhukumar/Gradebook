

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tool.DbGradebook;
import Tool.DbUser;
import Tool.DbUtil;
import model.Gradebook;
import model.User;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String nextURL = "/Update.jsp";
		int gradebookID = Integer.parseInt(request.getParameter("gradebookid"));

		HttpSession session = request.getSession();

		
		Gradebook gradebook = DbGradebook.gradebook(gradebookID);
		session.setAttribute("grade", gradebook);
		
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		// response.sendRedirect(request.getContextPath() + nextURL);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String assignment = request.getParameter("assignment");
		String assignmenttype = request.getParameter("assignmenttype");
		String grade = request.getParameter("grade");
		String subject = request.getParameter("subject");
		int gradebookid = Integer.parseInt(request.getParameter("gradebookid"));
		HttpSession session = request.getSession();
		Gradebook tmp=(Gradebook) session.getAttribute("grade");
		Gradebook gradebook = new Gradebook();
		gradebook.setAssignment(assignment);
		gradebook.setAssignmenttype(assignmenttype);
		gradebook.setGrade(grade);
		gradebook.setGradebookid(gradebookid);
		gradebook.setSubject(subject);
		gradebook.setUser(tmp.getUser());
		DbGradebook.update(gradebook);
		String nextURL = "/Home.jsp";
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		//doGet(request, response);
	}

}
