package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

import bean.ProductBean;
import dao.UpdateProductDAO;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
	UpdateProductDAO upd = null;
	
	@Override
	public void init() throws ServletException{
			upd = new UpdateProductDAO();
	}
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		System.out.println("Session : "+hs);
		if(hs==null) {
			req.setAttribute("msg","Session expired......");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		} else {
			ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("pList");
			System.out.println("ArrayList :");
			System.out.println(al);
			String pCode = req.getParameter("pCode");
			Iterator it = al.iterator();
			while(it.hasNext()) {
				ProductBean pb = (ProductBean) it.next();
				System.out.println("ProductBean : "+pb);
				if(pCode.equals(pb.getId())) {
					pb.setPrice(Double.parseDouble(req.getParameter("price")));
					pb.setQty(Integer.parseInt(req.getParameter("qty")));
					int k = upd.updateProduct(pb);
					System.out.println(k);
					if(k>0) {
						req.setAttribute("msg", "Product upadated Successfully.....<br>");
						req.getRequestDispatcher("admin/Login/product/updateProduct.jsp").forward(req, res);
					}
				}
			}
			
		}
		
		
		
	}

	
	
	
	
	
}




















