package com.auctionplace.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auctionplace.dao.BidderDAO;
import com.auctionplace.model.BidderDTO;

@WebServlet("/servletBid")

public class BidderSeverlet extends HttpServlet {
	private static final long versionserialUID = 1L;
	
	private BidderDAO dao = new BidderDAO();
	
	public BidderSeverlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher= request.getRequestDispatcher("/WEB-INF/AuctionBidder.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= request.getParameter("userName");
		String amount= request.getParameter("amount");
		String email= request.getParameter("email");
		String phoneNumber= request.getParameter("phoneNumber");
		String address= request.getParameter("address");
		
		BidderDTO bidder = new BidderDTO();
		
		bidder.setUserName(userName);
		bidder.setAmount(amount);
		bidder.setEmail(email);
		bidder.setPhoneNumber(phoneNumber);
		bidder.setAddress(address);
		
		
		BidderDTO doabid = new BidderDTO();
		try {
			dao.bidCreated(bidder);
			
			response.setContentType("text/html");
		    PrintWriter pw=response.getWriter();
		    pw.println("Bid is succesful.  <a href='index.jsp'>go to home page</a>");
		}catch (Exception e) {
			response.setContentType("text/html");
		    PrintWriter pw=response.getWriter();
		    pw.println("Bid is Un-succesful.  <a href='index.jsp'>go to home page</a>");
			e.printStackTrace();
		}
	}
}
