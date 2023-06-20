<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="database.JDBCUtil" %>  
    <head>
    	<title>Search page</title>
    </head>
<jsp:include page="header.jsp"></jsp:include>

<div class="container px-4 py-3">
  <h2 style="font-size: 50px;">Show all product</h2>
  <div class="row">
    <% 
      Connection connection = null;
      Statement statement = null;
      ResultSet resultSet = null;
      String search = request.getParameter("search");

      try {
        connection = JDBCUtil.getConnection();
        statement = connection.createStatement();
        String query;
        if(search.length()>0){
        	query = "SELECT * FROM product WHERE proName LIKE '%" + search + "%' ";
        }
        else{
        	query = "SELECT * FROM product ";
        }
        resultSet = statement.executeQuery(query);
        boolean productsFound = false;
        while (resultSet.next()) {
          String proId = resultSet.getString("proId");
          String proName = resultSet.getString("proName");
          float proPrice = resultSet.getFloat("proPrice");
          String image = resultSet.getString("image");
          productsFound = true;
    %>
    <div class="col-md-3 pb-3">
      <div class="card">
        <img src="./image/<%=image %>" class="card-img-top" alt="" style="margin: auto; width: 300px; height: 400px;" />
        <div class="card-body" style="text-align: center; height:120px;">
          <a href="detail.jsp?id=<%= proId %>" class="text-decoration-none">
            <hr>
            <h5 class="card-title text-dark">
              <%= proName %>
            </h5>
          </a>
          <h6 class="card-subtitle mb-2 text-muted bi bi-currency-dollar"><%= proPrice %></h6>
        </div>
      </div>
    </div>
     <%
        }

        // Check if no products were found
        if (!productsFound) {
    %>
    <div class="col-md-12">
      <p>No products found.</p>
    </div>
    
    
    <% }
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        JDBCUtil.closeConnection(connection);
        if (statement != null) statement.close();
        if (resultSet != null) resultSet.close();
      }
    %>
  </div>
</div>



<%@ include file="footer.jsp" %>