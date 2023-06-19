<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <head>
    	<title>Register page</title>
    </head>
	<jsp:include page="header.jsp"></jsp:include>

  <%
		String error = request.getAttribute("error")+"";
  		error = (error.equals("null"))?"":error;
	
		
		String fullname= request.getAttribute("fullname")+"";	
		fullname = (fullname.equals("null"))?"":fullname;
		
		String email= request.getAttribute("email")+"";
		email = (email.equals("null"))?"":email;
		
		String gender= request.getAttribute("gender")+"";
		gender = (gender.equals("null"))?"":gender;
		
		String birthday= request.getAttribute("birthday")+"";
		birthday = (birthday.equals("null"))?"":birthday;
		
		String address= request.getAttribute("address")+"";
		address = (address.equals("null"))?"":address;
		
		
		String phone= request.getAttribute("phone")+"";
		phone = (phone.equals("null"))?"":phone;
		
	
	%>

    <div class="container pt-4 ps-5 pe-5">
           <div class="row ps-5 pe-5 pb-4">
              <h2>Registration</h2>
            </div>
            <div class="pb-3 ps-5 pe-5 red text-center" id="error">
				<%=error %>
			</div>
				
            <form action="register" id="form1" name="form1" method="post" class="needs-validation">
  				
  				<div class="row pb-3 ps-5 pe-5"  id="myElement">
                    <span id="errorMatchPass" class="alert alert-danger"></span>             
                </div>
 				              
                <div class="row pb-3 ps-5 pe-5">
                    <label for="fullname" class="col-md-2 col-form-lable">Full name:</label>
                    <div class="col-md-10">
                        <input type="text" name="fullname" id="fullname" required class="form-control"
                            placeholder="Enter your full name" value="<%=fullname%>">
                        <!--id với for giống nhau để chuyển sang id được -->
                    </div>
                </div>
                <div class="row ps-5 pe-5 pb-3">
                    <label for="email" class="col-md-2 col-form-lable">Email:</label>
                    <div class="col-md-10">
                        <input type="text" name="email" id="email" required class="form-control"
                            placeholder="Enter your email" value="<%=email%>">
                        <!--id với for giống nhau để chuyển sang id được -->
                    </div>
                </div>
                <div class="row pb-3 ps-5 pe-5">
                    <label for="pass" class="col-md-2 col-form-lable">Password:</label>
                    <div class="col-md-10">
                        <input type="password" name="pass" id="pass" required onkeyup="checkPassword()" class="form-control"
                            placeholder="Enter your password" value="">
                        <!--id với for giống nhau để chuyển sang id được -->
                    </div>
                </div>
              	  <div class="row ps-5 pe-5 pb-3">
                    <label for="repass" class="col-md-2 col-form-lable">Confirm password:</label>
                    <div class="col-md-10">
                        <input type="password" name="repass" id="repass" required class="form-control"
                            placeholder="Enter your password again" value="" onkeyup="checkPassword()">
                        <!--id với for giống nhau để chuyển sang id được -->
                    </div>
                </div>
                <div class="row pb-3 ps-5 pe-5">
                    <label for="phone" class="col-md-2 col-form-lable">Phone:</label>
                    <div class="col-md-10">
                        <input type="text" name="phone" id="phone" required class="form-control"
                            placeholder="Enter your phone" value="<%=phone%>">
                        <!--id với for giống nhau để chuyển sang id được -->
                    </div>
                </div>
               
                <div class="row pb-3 ps-5 pe-5">
                    <label for="gender" class="col-md-2 col-form-lable">Gender:</label>
                    <div class="col-md-10 d-flex">
                        <div class="form-check pe-3 my-auto">
                            <input type="radio" name="gender" id="maleRd" class="form-check-input" value="Male"
                            	<%=(gender=="Male")?"checked":"" %>>
                        
                            <label for="maleRd" class="form-check-label">Male</label>
                        </div>

                        <div class="form-check my-auto">
                            <input type="radio" name="gender" id="femaleRd" class="form-check-input" value="Female"
                            	<%=(gender=="Female")?"checked":"" %>>
                             
                            <!--id với for giống nhau để chuyển sang id được -->
                            <label for="femaleRd" class="form-check-label">Female</label>
                        </div>

                    </div>

                </div>
                <!-- <div class="row pb-3">
                    <label for="country" class="col-md-2 col-form-lable">Country:</label>
                    <div class="col-md-10">
                        <select id="country" class="form-select" name="country"
                            value="<?php //echo isset($country)? $country:""?>">
                            <option selected>Choose your country</option>
                            <option>Viet Nam</option>
                            <option>American</option>
                        </select>
                    </div>
                </div> -->
                <?php
                    //$date = isset($_POST['txtBirth']);
                    //echo $date;
                    //$formatedDate = date('d-m-Y', strtotime($date));
                    //echo $formatedDate;
                ?>
                <div class="row pb-3 ps-5 pe-5">
                    <label for="birthday" class="col-md-2 col-form-lable">Birthday:</label>
                    <div class="col-md-10">
                        <input type="date" name="birthday" id="birthday" value="<%=birthday %>" required
                            class="form-control" value="">
                          
                    </div>
                </div>
                <div class="row pb-3 ps-5 pe-5">
                    <label for="address" class="col-md-2 col-form-lable">Address:</label>
                    <div class="col-md-10">
                        <input type="text" name="address" id="address" required class="form-control"
                            placeholder="Enter your address" value="<%=address %>">
                        <!--id với for giống nhau để chuyển sang id được -->
                    </div>
                </div>
                <!-- <div class="row pb-3">
                    <label for="favorite" class="col-md-2 col-form-lable">Favorite:</label>
                    <div class="col-md-10 d-flex">
                        <div class="form-check pe-3 my-auto">
                            <input type="checkbox" name="music" id="favorite" class="form-check-input">
                            <label for="maleRd" class="form-check-label">Music</label>
                        </div>

                        <div class="form-check my-auto">
                            <input type="checkbox" name="reading" id="favorite" class="form-check-input">
                            <label for="femaleRd" class="form-check-label">Reading</label>
                        </div>
                    </div>
                </div> -->
                <div class="row pb-3 ps-5 pe-5 ms-auto">
                    <div class="col-md-12 d-flex justify-content-end">
                        <input type="submit" value="Register" class="btn btn-primary" name="btnRegister" id="btnRegister">
                    </div>
                </div>
            </form>
        </div>
        <%@include file="footer.jsp"%>
  </body>
  <script>
  
  	function checkPassword(){
		pass = document.getElementById("pass").value;
		repass = document.getElementById("repass").value;
		element = document.getElementById('myElement');
		if(pass!=repass){
			document.getElementById("errorMatchPass").innerHTML="Error match password";
			element.style.display = 'flex';
			return false;
		}
		else{
			document.getElementById("errorMatchPass").innerHTML=null;
			element.style.display = 'none';
			return true;
		}
  	}
  	

  	
  </script>
</html>