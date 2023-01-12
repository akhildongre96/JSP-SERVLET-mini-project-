package com.akhil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.akhil.model.Product;

public class ProductDao {
	private Connection connectivity;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	public ProductDao(Connection connectivity) {
		super();
		this.connectivity = connectivity;
	}

 public List<Product> getAllProduct(){
	 
	 List<Product> products=new ArrayList<Product>();
	 
	 try {
		 String query="select * from products";
		 pst=this.connectivity.prepareStatement(query);
		 rs=pst.executeQuery();
		 
		 while(rs.next()) {
			 Product row=new Product();
			 row.setId(rs.getInt("id"));
			 row.setName(rs.getString("name"));
			 row.setCategory(rs.getString("category"));
			 row.setPrice(rs.getString("price"));
			 row.setImage(rs.getString("image"));
			 products.add(row);
		 }
	 }
	 catch (Exception e) {
		e.printStackTrace();
	}
	return products;
	 
 }
}
