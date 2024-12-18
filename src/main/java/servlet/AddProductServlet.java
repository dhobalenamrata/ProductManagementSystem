package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import bean.ProductBean;
import dao.AddProductDAO;

@SuppressWarnings("serial")
@WebServlet("/addProduct")

public class AddProductServlet extends HttpServlet {
	AddProductDAO ad;
	ProductBean pb;
	
	@Override
	public void init() throws ServletException {
		ad = new AddProductDAO(); 
		pb = new ProductBean();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false); // Accessing existing Session
		
		if(hs==null) {
			req.setAttribute("msg", "Session Expired.....");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else {
			pb.setId(req.getParameter("id"));
			pb.setName(req.getParameter("name"));
			pb.setPrice(Double.parseDouble(req.getParameter("price")));
			pb.setQty(Integer.parseInt(req.getParameter("qty")));
			int result = ad.addProduct(pb);
			if(result>0) {
				System.out.println("Data added");
				
				req.setAttribute("msg", "Product Added Successfully....");
				req.getRequestDispatcher("admin/Login/product/productAdded.jsp").forward(req, res);
			}
		}
		
		
	}

}
