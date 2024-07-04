package curdoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getall {
	private static final String Driver="com.mysql.cj.jdbc.Driver"; 
	private static final String user="root";
	private static final String password="robinhood";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		try {
			Scanner src=new Scanner(System.in);
			System.out.println("enter database name");
			String url="jdbc:mysql://localhost:3306/"+src.next();
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("enter table name");
			String sql="select * from "+src.next();
			pmst=conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				System.out.println("name :"+rs.getString("name"));
				System.out.println("email :"+rs.getString("email"));
				System.out.println("branch :"+rs.getString("branch"));
			}
			conn.close();
			pmst.close();
			src.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
