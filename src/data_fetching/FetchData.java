package data_fetching;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc_connection.Connection_JDBC;

public class FetchData {
	
	public static void selectData() {
Connection_JDBC.conSetup();
String query = "select * from t1";

try {
	Statement st = (Statement) Connection_JDBC.con.createStatement();
	ResultSet rs = st.executeQuery(query);
	while(((ResultSet) rs).next()) {
		int id = rs.getInt(1);
		String name = rs.getString(2);
		String city = rs.getString(3);
		System.out.println("Id: "+ id + " Name: " + name + " City: "+ city);
		
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
finally {
	try {
	Connection_JDBC.con.close();
	}
	catch(SQLException e){
		e.printStackTrace();
		
	}
	System.out.println("Data Fetched properly");
}
	}
	public static void main(String[] args) {
		selectData();
	}
}
