package com.auctionplace.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.auctionplace.model.BidderDTO;
import com.auctionplace.model.ProductDTO;
import com.auctionplace.util.SQLConnectionUtility;

public class ItemsDAO {


	
	public int createProduct(ProductDTO product) throws ClassNotFoundException, SQLException {


		String Insert_Products_SQL = "insert into products (product_name,model,flag) values(?,?,?);";

		int result = 0;


try {

				PreparedStatement preparedStatement = SQLConnectionUtility.getConnection().prepareStatement(Insert_Products_SQL);

			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setString(2, product.getModel());
			preparedStatement.setString(3, "Y");

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	public String getProduct() throws ClassNotFoundException {
		
		String pname = null;
		try {

			String Product_Active = "select product_name from products where flag='Y'; ";
			PreparedStatement preparedStatement = SQLConnectionUtility.getConnection().prepareStatement(Product_Active);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				pname = rs.getString(1);

				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pname;
	}

	public String getProductId() throws ClassNotFoundException {
		
		String pname = null;
		try {

			String Product_Active = "select pid from products where flag='Y'; ";
			PreparedStatement preparedStatement = SQLConnectionUtility.getConnection().prepareStatement(Product_Active);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				pname = rs.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pname;
	}

	public List<BidderDTO> getbidders() throws ClassNotFoundException {
		List<BidderDTO> details=new ArrayList<>();
		try {

			String bidder_details = "select * from bid_details as b join products as p on b.product_id=p.pid where p.flag='Y';";
			
			PreparedStatement preparedStatement = SQLConnectionUtility.getConnection().prepareStatement(bidder_details);
			ResultSet rs = preparedStatement.executeQuery();
                   
			while (rs.next()) {
				
				BidderDTO bid= new BidderDTO();
				String user = rs.getString(2);
				String amount = rs.getString(3);
				String email = rs.getString(4);
				String phone = rs.getString(5);
				
			    
				bid.setUserName(user);
				bid.setAmount(amount);
				bid.setEmail(email);
				bid.setPhoneNumber(phone);
				bid.setPid(rs.getString(7));
				
				details.add(bid);
				
			
		}
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return details;

	}

	public void updateProductStatus() throws ClassNotFoundException {

		try {

			String Product_deactive = "update products set flag='N' where flag='Y' ;";
			PreparedStatement preparedStatement = SQLConnectionUtility.getConnection().prepareStatement(Product_deactive);
			ResultSet rs = preparedStatement.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getMaxBid() throws SQLException, ClassNotFoundException
	{
		
		String highest_bid="select * from bid_details where amount=(select max(amount) from bid_details b join products p on b.product_id=p.pid where p.flag='y');";
		
		PreparedStatement preparedStatement = SQLConnectionUtility.getConnection().prepareStatement(highest_bid);
		ResultSet rs = preparedStatement.executeQuery();
		String user="";
	//	updateProductStatus();
		    while(rs.next()) {
			user = rs.getString(2);
			user+=" "+ rs.getString(3);
			user+=" "+ rs.getString(4);
			user+=" "+ rs.getString(5); 
		    }
		return user;
	}


}
