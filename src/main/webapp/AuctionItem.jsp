<%@page import="java.util.List"%>
<%@page import="com.auctionplace.model.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Selling the product</title>
</head>
<script type="text/javascript">

    function ProductToBeUpdated()
    {    	
    	var myProduct= Java.type("com.sdet.training.util.productDao");
    	myClass.getMaxiumBidding();
    }
	function showAndHideDivElement(ele) {
		var elementSrc = document.getElementById(Srcele);
		if (elementSrc != null) {
			if (elementSrc.style.display == "block") {
				elementSrc.style.display = 'none';
			} else {
				elementSrc.style.display = 'block';
			}
			return false;
		}
	}
</script>

<body>
<div align="right" style="background-color: red; color: yellow;">
		<a href="Welcome.jsp">Home Page Backed</a>
	</div>
	<div>
	
			<%
			ProductDTO dao = new ProductDTO();
			String prod = dao.getProductName();
			
			String maxBid="dao.getMaxBid()";
			
		
		%>
		<table border="1">
			<tr>
				<td><label>Named Product</label></td>
			</tr>
			<tr>
				<td><input type="button" value="Product Created"
					onClick="showHideDiv('Creatediv')" /></td>
				<td><input type="button" value="Details Get"
					onClick="showHideDiv('Detailsdiv')" /></td>
			</tr>
		</table>
	</div>
	<div id="Creatediv"
		style="background-color: red; color: green; height: 150px; width: 350px; text-align: center; display: none">
		<form action="productServlet"
			method="post">
			<table style="with: 50%">
				<tr>
					<td> Product Id</td>
					<td><input type="text" name="ProductId" /></td>
				</tr>
				<tr>
					<td>Name of Product</td>
					<td><input type="text" name="Product" /></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="Price" /></td>
				</tr>
				<tr>
					<td>Enable</td>
					<td><input type="text" name="Enable" /></td>
				</tr>

			</table>
			<input type="submit" value="Create" />
		</form>
	</div>

	<div id="divDetails"
		style="background-color: red; color: green; height: 800px; width: 950px; text-align: center; display: none">
		<form action="<%=request.getContextPath()%>/productServlet"
			method="post">
			<table align="center" cellspacing="50">
				<tr>
					<td></td>
					<td><strong>NameProduct</strong></td>
					<td><strong>Amount To Be Bidded</strong></td>
					<td><strong>Email To be Bid</strong></td>
						<td><strong>Phone To be Bid</strong></td>

				</tr>
				<%-- 	<input type="hidden" name="id" value="<%=id%>" />
				<input type="hidden" name="name" value="<%=name%>" /> --%>
				
				<%-- <%! int i; %>
					<%for (i = 0; i < 3; i++){ %>					
					<tr>
					<td></td>
					<td><%=dao.getbidders().get(i).getUserName()%></td>
					<td><%=dao.getbidders().get(i).getAmount()%></td>
					<td><%=dao.getbidders().get(i).getEmail()%></td>
					<td><%=dao.getbidders().get(i).getPhoneNumber()%></td></tr>
					<%}%> --%>
			</table>

		</form>
		<tr>
			<td>
			<td><input type="button" value="Confirm" onClick="productStatusupdated()" /></td>
			<td><%=maxBid%></td>
			
		</tr>
		
	</div>

</body>
</html>