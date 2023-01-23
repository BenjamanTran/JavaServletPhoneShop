package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.Account;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String userNameString=request.getParameter("username");
		String password=request.getParameter("password");
		AccountDAO dao=new AccountDAO();
		Account account=dao.login(userNameString, password);
		if (account==null) {
			request.setAttribute("mess", "WRONG USERNAME OR PASSWORD");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else {
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("acc", account);
			response.sendRedirect("ListController");
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
