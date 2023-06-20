<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="database.JDBCUtil" %>  
     <head>
    	<title>Sales statistics page</title>
    	<link rel="stylesheet" type="text/css" href="./css/sale.css">
    </head>
<jsp:include page="header.jsp"></jsp:include>

    <section class="sale-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-12">
                    <div class="heading">
                        <h2 class="title-sale-info">
                            Sale of store
                        </h2>
                        <a class="insert-link" href="#"><button class="btn btn-info">Insert</button></a>
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
							        String query = "SELECT * FROM shop";
							        resultSet = statement.executeQuery(query);
						
							        while (resultSet.next()) {
							            String shopId = resultSet.getString("shopId");
							            String shopName = resultSet.getString("shopName");
							            String shopAddress = resultSet.getString("shopAddress");
							            String shopSale = resultSet.getString("shopSale");
							%>
							<tr>
							    <th scope="row"><%= shopId %></th>
							    <td><%= shopName %></td>
							    <td><%= shopAddress %></td>
							    <td>$<%= shopSale %></td>
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