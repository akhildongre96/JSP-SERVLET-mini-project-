package com.akhil.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.akhil.connection.DBUtility;
import com.akhil.dao.UserDao;
import com.akhil.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.sendRedirect("login.jsp");
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 try(PrintWriter out=response.getWriter()){
		 String email= request.getParameter("login-email");
		 String password= request.getParameter("login-Password");
         UserDao ud=new UserDao(DBUtility.connectivity());
		 User user=ud.userLogin(email, password);
		 if(user!=null) {
			 request.getSession().setAttribute("auth", user);
			 response.sendRedirect("index.jsp");
			 out.print("user login");
		 }
		 else {
			 out.print("user login failed");
		 }
		 
	 }
	 catch (Exception e) {
		System.out.println("exception from loginservle dopost method");
	}
	}

}
