package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db_info.*;
import bean.ProductBean;

public class UpdateProductDAO {
	int k = 0;
	public int updateProduct(ProductBean pb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update productDetails set price=?, qty=? where pId=?");
			ps.setDouble(1, pb.getPrice());
			ps.setInt(2, pb.getQty());
			ps.setString(3, pb.getId());
			k = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
