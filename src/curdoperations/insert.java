package curdoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insert {
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
			
			String sql="insert into new_table (name,email,branch) values (?,?,?)";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter name");
			pmst.setString(1, src.next());
			System.out.println("enter email");
			pmst.setString(2, src.next());
			System.out.println("enter branch");
			pmst.setString(3, src.next());
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("data is inserted");
			}
			else {
				System.out.println("data is not inserted");
			}
			conn.close();
			pmst.close();
			src.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
