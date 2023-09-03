package insert_image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc_connection.Connection_JDBC;

public class Image_Insertion {

	public static void image_Insertion() {
		Connection_JDBC.conSetup();
		String query = "insert into image(pic) values (?)";
		try {
			PreparedStatement ps = Connection_JDBC.con.prepareStatement(query);
			File image = new File("C:\\Users\\FARAZ\\Pictures\\Java.png");
			FileInputStream fis = new FileInputStream(image);
			ps.setBinaryStream(1, fis, fis.available());
			ps.executeUpdate();
			System.out.println("file Uploaded Successfully");
			Connection_JDBC.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	public static void main(String[] args) {
		image_Insertion();
	}
}
