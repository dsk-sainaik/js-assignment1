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

@WebServlet("/register")
public class Register extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
//		super.doPost(req, resp);
		String fullName=req.getParameter("fullName");
		String phno=req.getParameter("phno");
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		System.out.println(fullName);
		System.out.println(phno);
		System.out.println(email);
		System.out.println(password);
//		System.out.println("sucess");
		//
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            String jdbcUrl = "jdbc:mysql://localhost:3306/netflix";
	            String dbUser = "root";
	            String dbPassword = "root";

	            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword) ;
	                String insertQuery = "INSERT INTO registation (fullName, phoneNumber, email, password) VALUES (?, ?, ?, ?)";
	               PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
	                    preparedStatement.setString(1, fullName);
	                    preparedStatement.setString(2, phno);
	                    preparedStatement.setString(3, email);
	                    preparedStatement.setString(4, password); 
	                    preparedStatement.executeUpdate();
	                
	                connection.close();
	                System.out.println("insert sucess");
	                RequestDispatcher rd=req.getRequestDispatcher("/login.html");
	               rd.forward(req, resp);
	            }
		  catch (Exception e) {
	            e.printStackTrace();
	        }
		

		
		
		
		
	}

}
