package table_Updation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;

import jdbc_connection.Connection_JDBC;

public class Update_Table {

	public static void updateTable() {
		Connection_JDBC.conSetup();
		String query = "Update t1 set  tName= ? , tcity= ? where tId = ?";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter new name");
			String name = br.readLine();
			System.out.println("Enter new city");
			String city = br.readLine();
			System.out.println("Enter the tId where you want to update");
			int id = Integer.parseInt(br.readLine());
			PreparedStatement ps = Connection_JDBC.con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, city);
			ps.setInt(3, id);
			ps.executeUpdate();
			System.out.println("Data Inserted");
			Connection_JDBC.con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		updateTable();
	}
}
