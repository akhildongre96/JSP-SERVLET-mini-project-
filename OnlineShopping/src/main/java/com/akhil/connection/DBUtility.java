package com.akhil.connection;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtility 
{
	public static Connection connectivity()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ospjsp","root","code");
	
			
		}
	
		catch(ClassNotFoundException n)
		{
			n.printStackTrace();
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
		
		
	}
	public static void main(String[] args)
	{
		Connection con=connectivity();
		if(con!=null)
		{
			System.out.println("Connected");
		}
		else
		{
			System.out.println("Not connected");
		}
		connectivity();
	}
}