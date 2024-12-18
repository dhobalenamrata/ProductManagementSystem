package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import db_info.*;
import bean.ProductBean;

public class ViewAllProductsDAO {
	public ArrayList<ProductBean> al = new ArrayList<ProductBean>();
	
	public ArrayList<ProductBean> retrieve(){
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from productDetails");
			ResultSet rs = ps.executeQuery(); 
			while(rs.next()) {
				ProductBean pb = new ProductBean();
				pb.setId(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getDouble(3));
				pb.setQty(rs.getInt(4));
				al.add(pb);
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return al;		
	}
}
