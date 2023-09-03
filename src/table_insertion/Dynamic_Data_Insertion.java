package table_insertion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc_connection.Connection_JDBC;

public class Dynamic_Data_Insertion {

	public static void dynamic_Data() throws IOException {
		Connection_JDBC.conSetup();
		// String query
		String query = "Insert into jdbc.t1(tName , tcity) values (?,?)";
		try {
			PreparedStatement ps = Connection_JDBC.con.prepareStatement(query);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Plese enter your name: ");
String tName = br.readLine();
System.out.println("Please enter your city: ");
	String tCity = br.readLine();
			ps.setString(1, tName);
			ps.setString(2, tCity);
			ps.executeUpdate();
			System.out.println("Data Inserted......");
			Connection_JDBC.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		dynamic_Data();
	}
}
