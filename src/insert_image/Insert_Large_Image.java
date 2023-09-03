package insert_image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import jdbc_connection.Connection_JDBC;

public class Insert_Large_Image {

	public static void largeImage() {
		Connection_JDBC.conSetup();
		String query = "insert into image(pic) values(?)";
		try {
			PreparedStatement ps = Connection_JDBC.con.prepareStatement(query);
			JFileChooser j = new JFileChooser();
			j.showOpenDialog(null);
		File file = 	j.getSelectedFile();
			//File f = new File("C:\\Users\\FARAZ\\Desktop\\Java Wallpaper.jpg");
			FileInputStream fis = new FileInputStream(file);
			ps.setBinaryStream(1, fis, fis.available());
			ps.executeUpdate();
		JOptionPane.showMessageDialog(null, " File added successfully");
		Connection_JDBC.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		 catch (IOException e2) {
				e2.printStackTrace();
			}
		
	}
	public static void main(String[] args) {
		largeImage();
	}
}
