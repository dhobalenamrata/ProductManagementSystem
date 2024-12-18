package servlet;

import java.io.IOException;

import bean.AdminBean;
import dao.AdminLoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	AdminLoginDAO ald = null;
	
	
	
	@Override
	public void init() throws ServletException {
		ald = new AdminLoginDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		AdminBean ab = ald.login(req.getParameter("uName"), req.getParameter("pass"));
//		System.out.println("Bean = "+ab);
		if(ab==null) {
			req.setAttribute("msg", "Incorrect UserId or Password.....");
			req.getRequestDispatcher("admin/Login/Msg.jsp").forward(req, res);
//			System.out.println("Login failed");
		}
		else {
			HttpSession hs = req.getSession(); // Creating new Session object
			hs.setAttribute("bean", ab);
			req.getRequestDispatcher("admin/Login/AdminLoginSuccess.jsp").forward(req, res);
//			System.out.println("Login success");
		}
	}

}
