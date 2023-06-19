<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="database.JDBCUtil" %>

<jsp:include page="header.jsp"></jsp:include>

<div class="container px-4 py-3">
  <h2 style="font-size: 50px;">New toy</h2>
  <div class="row">
    <%
    	  Connection connection = null;
          Statement statement = null;
          ResultSet resultSet = null;

          try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            String query = "SELECT * FROM product LIMIT 8";
    		resultSet = statement.executeQuery(query);

    		while (resultSet.next()) {
    	String proId = resultSet.getString("proId");
    	String proName = resultSet.getString("proName");
    	float proPrice = resultSet.getFloat("proPrice");
    	String image = resultSet.getString("image");
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