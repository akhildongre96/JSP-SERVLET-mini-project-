<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="com.akhil.connection.*"%>
<%@ page import="com.akhil.model.*"%>
<%@ page import="com.akhil.dao.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

ProductDao pd = new ProductDao(DBUtility.connectivity());
List<Product> products = pd.getAllProduct();
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Page</title>
<%@include file="includes/Header.jsp"%>
</head>
<body><%@include file="includes/Navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!products.isEmpty()) {
				for (Product p : products) {%>
					 
					 <div class="col-md-3">
				<div class="card" style="width: 18rem;">
					<img class="card-img-top" src="product-images/Canon-Eos"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<h6 class="price">Price: $452</h6>
						<h6 class="categary">Category:some category</h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="#" class="btn btn-primary">Add to Cart</a> <a href="#"
								class="btn btn-primary">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
				<%}
			}
			%>
			
		</div>
	</div>
	<%-- 	<%
	out.print(DBUtility.connectivity());
	%> --%>

	<%@include file="includes/Footer.jsp"%>
</body>
</html>