package com.akhil.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.akhil.model.User;

public class UserDao {
private Connection connectivity;
private String query;
private PreparedStatement pst;
private ResultSet rs;
public UserDao(Connection connectivity ) {
 this.connectivity = connectivity;
	 
}
 



public User userLogin(String email,String password) {
	User user=null;
	try {
		query="select * from users where email=? and password=?";
		pst=this.connectivity.prepareStatement(query);
		pst.setString(1, email);
		pst.setString(2, password);
		rs=pst.executeQuery();
		if(rs.next()) {
			user=new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getNString("name"));
			user.setEmail(rs.getNString("email"));
		}
	} catch (Exception e) {
		 e.printStackTrace();
		 System.out.println(e.getMessage());
	}
	
	
	return user;
}
}
