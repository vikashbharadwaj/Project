package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Myconnection {

	private static final String MyConnection = null;
	public static Connection connection=null;
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection("jdbc:mysql:localhost:3306/filehider?useSSL=false","root","9572Vikas@#");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connection ho gya sab");
		return connection;
		}
	public static void closeConnection() {
		if(connection !=null) {
			try {
				connection.close();
			}catch(SQLException ex) {
				ex.fillInStackTrace();
			}
		}
		
	}
	public static void main(String[]args) {
		Myconnection.getConnection();
	}
	
	}

