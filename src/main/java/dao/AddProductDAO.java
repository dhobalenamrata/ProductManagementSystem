package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.ProductBean;
import db_info.*;

public class AddProductDAO {
	int k = 0;
	public int addProduct(ProductBean pb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("insert into productDetails values(?,?,?,?)");
			ps.setString(1, pb.getId());
			ps.setString(2, pb.getName());
			ps.setDouble(3, pb.getPrice());
			ps.setInt(4, pb.getQty());
			k = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k;
	}
	
}
