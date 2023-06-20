<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Successful Registration</title>
 <style>
        .dialog {
            width: 400px;
            margin: 100px auto;
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 5px;
            text-align: center;
        }

        .back-button {
            margin-top: 20px;
        }
    </style>
</head>
<body>
 <div class="container">
        <div class="dialog">
            <h2>Congratulations!</h2>
            <p>Your registration was successful.</p>
            <button class="btn btn-primary back-button" onclick="window.location.href='index.jsp'">Back to Home</button>
        </div>
    </div>

    <script>
        setTimeout(function(){
            window.location.href = 'index.jsp';
         }, 5000);
    </script>
</body>
</html>