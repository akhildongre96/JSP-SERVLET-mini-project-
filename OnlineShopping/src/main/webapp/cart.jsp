<%@ page import = "com.akhil.model.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% User auth=(User)request.getSession().getAttribute("auth");
  if(auth!=null){
	/*   request.setAttribute("auth", auth); */
	response.sendRedirect("index.jsp");
  }
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
<%@include file="includes/Header.jsp" %>
</head>
<body><%@include file="includes/Navbar.jsp" %>
 
 
 
<%@include file="includes/Footer.jsp" %>
</body>
</html>