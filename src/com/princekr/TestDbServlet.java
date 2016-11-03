package com.princekr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// set up connection variables
		String user = "student";
		String pass = "student";
		String jdbcUrl = "jdbc:mysql://localhost:3306/studentdemo?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		//get a connection to database
		try {
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database: " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			
			out.println("Connection successfull");
			
			myConn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
		
	}

}
