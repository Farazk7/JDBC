package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_JDBC {
	public static Connection con;
	public static String url = "jdbc:mysql://localhost:3306/jdbc";
	public static String username = "root";
	public static String password = "polo@0783";

	public static void conSetup() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// creating a Connection
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (con.isClosed()) {
				System.out.println("Connection is not established");
			} else {
				System.out.println("Connection is established......");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
