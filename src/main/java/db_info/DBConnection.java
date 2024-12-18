package db_info;
import java.sql.*;
public class DBConnection {
	private static Connection con = null;
	static {
			try {
				Class.forName(DBInfo.driver);
				con = DriverManager.getConnection(DBInfo.dbURL, DBInfo.dbUName, DBInfo.dbUPass);
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	public static Connection getCon() {
		return con;
	}
}
