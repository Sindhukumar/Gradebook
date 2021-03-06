
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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextURL = "/Login.jsp";
		String useremail = request.getParameter("useremail");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		User user = null;
		if (DbUser.isValidUser(useremail, password)) {
			user = DbUser.getUserByEmail(useremail);
			session.setAttribute("user", user);
			session.setAttribute("gravatarURL", DbUtil.getGravatarURL(useremail, 50));
			session.setAttribute("gravatarURLsmall", new DbUtil());
			String role = user.getUserrole();
			nextURL = "/Home.jsp?role=" + role;
			
			List<Gradebook> gradebooks;
			gradebooks = user.getGradebooks();
			session.setAttribute("grades", gradebooks);

			List<Gradebook> Allgradebooks;
			Allgradebooks = DbGradebook.gradebook();
			session.setAttribute("Allgrades", Allgradebooks);
		}

		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		// response.sendRedirect(request.getContextPath() + nextURL);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
