package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import bean.ProductBean;
import dao.ViewAllProductsDAO;

@WebServlet("/view")
public class ViewAllProductsServlet extends HttpServlet {
	public ViewAllProductsDAO vap = null;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		vap = new ViewAllProductsDAO();
		HttpSession hs = req.getSession(); // Accessing existing session
		if(hs==null) {
			req.setAttribute("msg", "Session expired....");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			ArrayList<ProductBean> al = vap.retrieve();
			System.out.println(al);
			hs.setAttribute("pList", al);
			req.getRequestDispatcher("admin/Login/product/showAllProducts.jsp").forward(req, res);
		}
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
