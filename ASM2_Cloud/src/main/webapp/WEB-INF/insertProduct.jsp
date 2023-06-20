<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="database.JDBCUtil" %>
  <head>
    	<title>Manage page</title>
    	<link rel="stylesheet" type="text/css" href="./css/manage.css">
     <style>
    .red {
	color: red;
	}
  	</style>
    </head>
<jsp:include page="header.jsp"></jsp:include>
	
  <div class="container pt-4">
    <form action="insertProduct" method="post" class="form-edit">
       <h2 class="title-sale-info pb-2">
             Insert Product
      </h2>
      <div class="row pb-3 ps-5 pe-5">
      
			            <%
							String error = request.getAttribute("error")+"";
			            	
							if(error.equals("null")){
								error = "";
							}
						%>
                    </div>
                     <div class="text-center pb-2"><span class="red"><%=error %></span></div>
      <div class="mb-2">
        <label for="product-name" class="form-label">Product id</label>
        <input type="text" class="form-control" id="proId" name="proId">
      </div>
      <div class="mb-2">
        <label for="product-price" class="form-label">Product name</label>
        <input type="text" class="form-control" id="proName" name="proName">
      </div>
      <div class="mb-2">
		  <label for="catId" class="form-label">Category</label>
		  <select class="form-select" id="proCategory" name="proCategory">
		    <option value="">Select Category</option>
		    <% 
		      Connection connection = null;
		      Statement statement = null;
		      ResultSet resultSet = null;
		
		      try {
		        connection = JDBCUtil.getConnection();
		        statement = connection.createStatement();
		        String query = "SELECT * FROM product";
		        resultSet = statement.executeQuery(query);
		
		        while (resultSet.next()) {
		        	String proId = resultSet.getString("proId");
		          
		          String proCategory = resultSet.getString("proCategory");
		    
		    %>
		  
		      <option value="<%=proId%>"><%=proCategory %></option>
		    <% 
		        }
		      } catch (Exception e) {
		        e.printStackTrace();
		      } finally {
		        JDBCUtil.closeConnection(connection);
		        if (statement != null) statement.close();
		        if (resultSet != null) resultSet.close();
		      }
		    %>
		  </select>
		</div>
     <div class="mb-2">
        <label for="created" class="form-label">Price</label>
        <input type="text" class="form-control" id="proPrice" name="proPrice">
      </div>
      <div class="mb-2">
        <label for="cat-id" class="form-label">Quantity</label>
        <input type="text" class="form-control" id="proQuantity" name="proQuantity">
      </div>
      <div class="mb-2">
		  <label for="shopId" class="form-label">Shop ID</label>
		  <select class="form-select" id="shopId" name="shopId">
		    <option value="">Select Shop</option>
		   <% 
		 
		   try {
		        connection = JDBCUtil.getConnection();
		        statement = connection.createStatement();
		        String query = "SELECT * FROM product";
		        resultSet = statement.executeQuery(query);
		
		        while (resultSet.next()) {
		          String shopId = resultSet.getString("shopId");
		          
		    
		    %>
		      <option value="<%=shopId%>"><%=shopId %></option>
		    <% 
		        }
		      } catch (Exception e) {
		        e.printStackTrace();
		      } finally {
		        JDBCUtil.closeConnection(connection);
		        if (statement != null) statement.close();
		        if (resultSet != null) resultSet.close();
		      }
		    %>
		  </select>
		</div>
      <div class="mb-2">
        <label for="formFile" class="form-label">Image</label>
        <input class="form-control" type="file" id="formFile" name="image" >
      </div>
      <div class="mb-2 pt-3 d-flex justify-content-end">
      <input type="submit" value="Confirm" class="btn btn-primary" name="Confirm" id="Confirm">
  	  </div>
    </form>
  </div>


        
 <%@ include file="footer.jsp" %>