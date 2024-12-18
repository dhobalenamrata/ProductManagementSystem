package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import bean.ProductBean;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditProductDetails extends HttpServlet {
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		HttpSession hs = req.getSession(false);// Accessing existing session
		
		if(hs==null) {
			req.setAttribute("msg", "Session expired....");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			ArrayList<ProductBean> al = (ArrayList<ProductBean>) hs.getAttribute("pList");
			String pCode = req.getParameter("pCode");
			Iterator<ProductBean> i = al.iterator();
			
			while(i.hasNext()) {
				ProductBean pb = (ProductBean)i.next();
				if(pCode.equals(pb.getId()))
				{
					req.setAttribute("pBean", pb);
					req.getRequestDispatcher("admin/Login/product/editProduct.jsp").forward(req, res);
					break;
				}
				
			}
					
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
