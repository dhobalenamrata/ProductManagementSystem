package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.AdminBean;
import db_info.DBConnection;

public class AdminLoginDAO {
	AdminBean ab = null;
	
	public AdminBean login(String uName, String uPass) {
		Connection con = DBConnection.getCon();
		try {
			System.out.println(uName);
			System.out.println(uPass);
		
			PreparedStatement ps = con.prepareStatement("select * from PMS_Admin where USERNAME=? and PASSWORD=?");
			ps.setString(1, uName);
			ps.setString(2,uPass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ab = new AdminBean();
				ab.setId(rs.getString(1));
				ab.setUserName(rs.getString(2));
				ab.setFirstName(rs.getString(3));
				ab.setLastName(rs.getString(4));
				ab.setMail(rs.getString(5));
				ab.setPhone(rs.getLong(6));
				ab.setPassword(rs.getString(7));				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return ab;
	}
}
