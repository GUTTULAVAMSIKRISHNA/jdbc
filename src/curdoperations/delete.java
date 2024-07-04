package curdoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class delete {
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
			String sql="delete from "+src.next()+" "
					+ "where branch =?";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter branch");
			pmst.setString(1, src.next());
			
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("data is deleted");
			}
			else {
				System.out.println("data is not deleted");
			}
			conn.close();
			pmst.close();
			src.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
