<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="database.JDBCUtil" %>  
     <head>
    	<title>Manage page</title>
    	<link rel="stylesheet" type="text/css" href="./css/manage.css">
    </head>

	<jsp:include page="header.jsp"></jsp:include>

           <section class="sale-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-12">
                    <div class="heading">
                        <h1 class="title-sale-info">
                            Manage Product
                        </h1>
                        <a class="insert-link" href="insertProduct.jsp"><button class="btn btn-info">Insert</button></a>
                    </div>
                    <table class="table">
                        <thead>
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
							            String proName = resultSet.getString("proName");
							            String proCategory = resultSet.getString("proCategory");
							            String proPrice = resultSet.getString("proPrice");
							            String proQuantity = resultSet.getString("proQuantity");
							            String shopId = resultSet.getString("shopId");
							            String image = resultSet.getString("image");
							%>
							<tr>
							    <th scope="row"><%= proId %></th>
							    <td><%= proName %></td>
							    <td><%= proCategory %></td>
							    <td>$<%= proPrice %></td>
							     <td><%= proQuantity %></td>
							    <td><%= shopId %></td>
							    <td><img src="./image/<%= image %>" width="80px" height="100px"></td>
							    <td>
							        <a href="#">Edit</a>
							        <a href="#">Delete</a>
							    </td>
							</tr>
							<%
							        }
							
							    } catch (Exception e) {
							        e.printStackTrace();
							    } finally {
							        JDBCUtil.closeConnection(connection);
							        if (resultSet != null) {
							            try {
							                resultSet.close();
							            } catch (SQLException e) {
							                e.printStackTrace();
							            }
							        }
							    }
							%>
                     
                        </tbody>
                      </table>
                </div>
            </div>
        </div>
    </section>

        
<%@include file="footer.jsp"%>