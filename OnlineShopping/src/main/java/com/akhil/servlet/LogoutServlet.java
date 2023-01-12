package com.akhil.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/log-out")
public class LogoutServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 try( PrintWriter out=response.getWriter()) {
		 if(request.getSession().getAttribute("auth") !=null) {
			 request.getSession().removeAttribute("auth");
			 response.sendRedirect("login.jsp");
			 out.print("logout successfully");
		 }
		 else {
			 response.sendRedirect("index.jsp");
		 }
	 }
	}
 
}
