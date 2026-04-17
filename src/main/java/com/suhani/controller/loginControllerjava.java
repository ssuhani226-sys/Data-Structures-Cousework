package com.suhani.controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import com.suhani.model.userservice;

@WebServlet("/login")
public class loginControllerjava extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        userservice us = new userservice();

        if (us.checkLogin(email, password)) {
        	request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
        } else {
        	request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
        }
    }
}