package table_creation;

import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import jdbc_connection.Connection_JDBC;

public class Table_JDBC {
	public static  java.sql.Statement st ;
	public static void main(String[] args) {
Connection_JDBC.conSetup();
String q = "create table t1(tId int(20) primary key auto_increment , tName varchar(255) not null , tcity varchar(100))";
try {
	 st =  Connection_JDBC.con.createStatement();
	 st.executeUpdate(q);
	 System.out.println("Table created in database....");
	 Connection_JDBC.con.close();
} catch (SQLException e) {
	e.printStackTrace();
}

}
}