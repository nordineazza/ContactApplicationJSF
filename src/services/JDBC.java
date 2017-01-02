package services;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBC {
	
	private Connection conn;
	
	public JDBC()
	{
		try {
			try {
				loadDriver();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			this.conn = newConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void loadDriver() throws ClassNotFoundException {
	    Class.forName("com.mysql.jdbc.Driver");
	}

	public Connection newConnection() throws SQLException {
	    final String url = "jdbc:mysql://localhost/contact";
	    Connection conn = DriverManager.getConnection(url, "root", "root");
	    return conn;
	}
	
	public Connection getConnection() throws SQLException
	{
		return newConnection();
	}
}