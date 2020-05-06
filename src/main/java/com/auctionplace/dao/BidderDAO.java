package com.auctionplace.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.auctionplace.model.BidderDTO;
import com.auctionplace.util.SQLConnectionUtility;

public class BidderDAO {

	public int bidCreated(BidderDTO bidder) throws SQLException,ClassNotFoundException
	{

		String Insert_Products_SQL="insert into bid_details (user_name,amount,email,phone,address) values(?,?,?,?,?);";
		
		int result=0;
			
		
				try {
			PreparedStatement preparedStatement = SQLConnectionUtility.getConnection().prepareStatement(Insert_Products_SQL);
	          
				preparedStatement.setString(1, bidder.getUserName());
				preparedStatement.setString(2, bidder.getAmount());
				preparedStatement.setString(3, bidder.getEmail());
				preparedStatement.setString(4, bidder.getPhoneNumber());
				preparedStatement.setString(5, bidder.getAddress());
		        result= preparedStatement.executeUpdate();
	          } 

	          catch(Exception e) {
	        	  e.printStackTrace();
	          }
		
		
		
		return result;
	}

}
