package com.auctionplace.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnectionUtility {
	public static Connection getConnection() {
		
		
		 String URL = "jdbc:mysql://localhost/OnlineAuction?serverTimezone=UTC";
		   String USER = "root";
		   String PASS = "root";
		   
		   Connection conn = null;
		   Driver myDriver = null;
		   try {
			   
		   myDriver= new com.mysql.jdbc.Driver();
		   //new org.h2.Driver();
		   DriverManager.registerDriver( myDriver );
		
			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("connection is creating");
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return conn;
		   
	 }
}
