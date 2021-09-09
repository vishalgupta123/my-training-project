package newpackage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import newpackage.bean.Admin;

public class AdminDAO {
	 public Admin checkLogin(String id, String password) throws SQLException,
	    ClassNotFoundException {
			String jdbcURL = "jdbc:oracle:thin:@//localhost:1521/orcl";
			String dbUser = "sys as sysdba";
			String dbPassword = "system";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
			String sql = "SELECT * FROM admindetails WHERE id = ? and password = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();
			
			
			Admin admin = null;
			
			if (result.next()) {
			    admin = new Admin();
			    admin.setName(result.getString("adminname"));
			    admin.setId(id);
			}
			
			connection.close();
			
			return admin;
		}
}