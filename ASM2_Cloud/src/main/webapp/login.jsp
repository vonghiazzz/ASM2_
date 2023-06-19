<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login page</title>
  <link rel="icon" href="./image/logo.png" type="image/x-icon">
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
    integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous">
  </script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
    integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous">
  </script>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous">
  </script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
  
  	<% 
		String url = request.getScheme() + "://" + request.getServerName()+ ":" + request.getServerPort() + request.getContextPath();
	%>
    <link href="<%=url%>/css/index.css" rel="stylesheet">
    <style>
    .red {
	color: red;
	}
  	</style>
</head>

<body>
    <header class="navbar navbar-expand-md navbar-dark bg-white">
      <!--Nar là thẻ điều hướng, expand là mức độ mở rộng khi đạt kích thước midle -->
      <div class="container-fluid border-bottom">
        <img src="./image/logo.png" width="120px" height="100px">
        <a href="#" class="navbar-brand" id="Logo">ATN STORE</a>

        <form>

          <!-- <button onclick="confirmBox()" class="btn btn-outline-secondary"
                type="button">Welcome,<?=$_COOKIE['cc_username']?></button> -->
         
         <!--   <button onclick="window.location.href='logout.php'" class="btn btn-outline-secondary"
            type="button">Logout</button>-->
			<%
				Object obj =session.getAttribute("user");
				User user =null;
				if(obj!=null){
					user = (User)obj;					
				}
				if(user==null){
				%>
				 <button onclick="confirmBox()" class="btn btn-outline-secondary" type="button">Welcome!</button>
				<button onclick="window.location.href='login.jsp'" class="btn btn-outline-secondary"
            type="button">Login</button>
				
				<% }else{%>
				<div class="row d-flex justify-content-between">
				
				  <div class="col d-flex justify-content-end">
				    <button onclick="window.location.href='.jsp'" class="btn btn-outline-secondary w-100" type="button">Welcome, <%=user.getFullname()%></a>
				  </div>
				  <div class="col-auto">
				    <button onclick="window.location.href='logout'" class="btn btn-outline-secondary w-100" type="button">Logout</button>
				  </div>
			
				</div>
				<%}%>

          
          <!-- <button onclick="window.location.href='registration.php'" class="btn btn-outline-secondary"
            type="button">Sign-up</button> -->

        </form>
      </div>

    </header>
    <nav class="container navbar navbar-expand-md navbar-white bg-white px-1 ">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarMain">
        <!--data-bs-target để tên của thẻ cần sổ,toggler là sổ xuống, -->
        <span class="navbar-toggler-icon"></span> <!-- Hiện nút ba gạch cho việc sổ xuống -->
      </button>
      <div class="collapse navbar-collapse col-md-8" id="navbarMain">
        <div class="navbar-nav">
          <a class="nav-link active text-dark" onclick="window.location.href='homepage.php'" href="#">Home</a>
          <div class="dropdown">
            <a href="#" class="nav-link dropdown-toggle text-dark" data-bs-toggle="dropdown">Category</a>
            <!--dropdown để sổ r sổ tiếp -->
            <!-- <div class="dropdown-menu bg-black"> -->


            <!-- <a class="dropdown-item text-light" href="">54212345</a> -->


            <!-- </div> -->

          </div>
          <% 
      // Assuming 'user' is an object containing user details, including the role
	      	User u = (User) session.getAttribute("user");
	      if (u != null && u.getRole().equals("manager")) { %>
	        <a class="nav-link text-dark" href="manage.jsp">Manage</a>
	        <a class="nav-link text-dark" href="sale.jsp">Sale of stores</a>
      <% } %>
        </div>
      </div>


      <div class="col-md-3 search">
        <form class="d-flex example1" action="search.php">
          <input class="form-control me-2" name="search" type="search" placeholder="What do you looking for?"
            aria-label="Search">
          <button class="btn btn-outline-success" name="btnSearch" type="submit">Search</button>
        </form>
      </div>

    </nav>
    <div class="banner">
      <h2>Welcome to our Toy Store</h2>
    </div>

  
 


<div class="container pt-4 pb-5 pe-5 ps-5">
            <div class="row ps-5 pe-5">
                <h2>Login</h2>
            </div>
            <form action="login" method="post" 	>
              
                    <div class="row pb-3 ps-5 pe-5">
			            <%
							String error = request.getAttribute("error")+"";
							if(error.equals("null")){
								error = "";
							}
						%>
                    </div>
                    <div class="text-center pb-2"><span class="red"><%=error %></span></div>
                    <div class="row pb-3 ps-5 pe-5">
                        <label for="email" class="col-md-2 col-form-lable">Email:</label>
                        <div class="col-md-10">
                            <input type="text" name="email" id="email" required class="form-control"
                                placeholder="Enter your email" value="">
                            <!--id với for giống nhau để chuyển sang id được -->
                        </div>
                    </div>

                <div class="row pb-5 ps-5 pe-5">
                        <label for="pass" class="col-md-2 col-form-lable">Password:</label>
                        <div class="col-md-10">
                            <input type="password" name="pass" id="pass" required class="form-control"
                                placeholder="Enter your password" value="">
                          
                        </div>
                </div>
               
                <div class="row pb-3 ps-5 pe-5 d-flex justify-content-end">
				  <div class="col text-end">
				    <button class="btn btn-outline-primary py-2 me-2" onclick="window.location.href='register.jsp'">Register</button>
				    <button class="btn btn-primary py-2" type="submit">Login</button>
				  </div>
				</div>
            </form>
</div>


<%@include file="footer.jsp"%>
