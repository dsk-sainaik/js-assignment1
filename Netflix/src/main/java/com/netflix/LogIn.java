package com.netflix;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/log")
public class LogIn  extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
//	super.doPost(req, resp);
	    String email=req.getParameter("myemail");
		String password=req.getParameter("mypass");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/netflix","root","root");
	PreparedStatement preparedStatement	=connection.prepareStatement("Select * from registation where email=? and password=?");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		
	 boolean rs=preparedStatement.execute();
		if(rs)
		{
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("./home.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("./login.html");
			requestDispatcher.forward(req, resp);
		}
		connection.close();
		}catch (Exception e) {
			
		}
		
		
		
		
		
		
	
		
		
		
}
	
}
