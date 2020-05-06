package com.auctionplace.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auctionplace.util.SQLConnectionUtility;

@WebServlet("/sellerLogin")
public class SellerLoginServlet extends  HttpServlet {
	private static final long versionserialUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");   
	    String password = request.getParameter("password");
		
	Statement st=null;
	try {
		st = SQLConnectionUtility.getConnection().createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    ResultSet rs=null;
    try {
		rs = st.executeQuery("select * from user where userName='" + userName + "' and password='" +password + "'");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    try {
		if (rs.next()) {
			request.getSession().setAttribute("userName", userName);
		    response.sendRedirect("success.jsp");
		} else {
			response.setContentType("text/html");
		    PrintWriter pw=response.getWriter();
		    pw.println("Invalid password <a href='index.jsp'>try again</a>");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
