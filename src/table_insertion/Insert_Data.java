package table_insertion;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc_connection.Connection_JDBC;

public class Insert_Data {

	public static void insertData() {
		Connection_JDBC.conSetup();
// Prepare the query 
		String q = "Insert into t1(tName , tCity) values (? ,?)";
//for insertion we need to use prepare statement
		try {
			PreparedStatement p = Connection_JDBC.con.prepareStatement(q);
			// set the values in query
			p.setString(1, "Faraz khan");
			p.setString(2, "Delhi");
			p.executeUpdate();
			System.out.println("Data Inserted");
			Connection_JDBC.con.close();
		} catch (SQLException e) {
					e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Insert_Data.insertData();
	}
}
