package curdoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class drop {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/";
	private static final String user="root";
	private static final String password="robinhood";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("enter database name");
			String sql="drop database " + src.next();
			
			pmst=conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i==0) {
				System.out.println("database is droped");
			}
			else {
				System.out.println("database is not droped");
			}
			conn.close();
			pmst.close();
			src.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}


