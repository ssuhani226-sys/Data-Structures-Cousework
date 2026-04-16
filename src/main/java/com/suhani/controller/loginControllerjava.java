package com.suhani.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.suhani.config.database;

/**
 * Servlet implementation class loginControllerjava
 */
@WebServlet("/login")
public class loginControllerjava extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginControllerjava() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
		    Connection conn = database.getConnection();

		    if (conn == null) {
		       out.println("DB Connection Failed");
		        return;
		    }
		    

		    String query = "Select * from students";

		    PreparedStatement ps = conn.prepareStatement(query);
		    ResultSet rs = ps.executeQuery();

		    while (rs.next()) {
		        out.println("ID: " + rs.getInt("id") + "<br>");
		        out.println("Name: " + rs.getString("first_name") + "<br>");
		        out.println("----------------------<br>");
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		    out.println("error");
		}
		
	request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String email = request.getParameter("user_email");
	    String password = request.getParameter("user_password");

	    String errorMessage = null;

	    // Validation
	    if (email == null || email.trim().isEmpty()) {
	        errorMessage = "Email is required";
	    } 
	    else if (!email.contains("@")) {
	        errorMessage = "Invalid email format";
	    } 
	    else if (password == null || password.trim().isEmpty()) {
	        errorMessage = "Password is required";
	    } 
	    else if (password.length() < 6) {
	        errorMessage = "Password must be at least 6 characters";
	    }

	    // If error → send back to JSP
	    if (errorMessage != null) {
	        request.setAttribute("error", errorMessage);
	        request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
	    } 
	    else {
	        // SUCCESS (you can connect DB here)
	        response.getWriter().println("Login Successful!");
	    }
	}}
	
	


