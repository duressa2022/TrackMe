<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register</title>
	<link rel="styleSheet" href="Register.css">

</head>
<body>
	<div class="register">
		<h1>Register to TrackMe<br></h1>
		<p>Already have an account? <a href="Login_page.jsp">Sign In</a> into   <br>and Enjoy from what trackme provide!</p>
	</div>
	
	<div class="registerForm">
		<form action="RegisterData">
			<input type="text" name="firstName" class="firstName" placeholder="First Name"><br>
			<input type="text" name="lastName" class="lastName" placeholder="Last Name"><br>
			<input type="email" name="email" class="email" placeholder="Your Email"><br>
			<input type="password" name="password" class="password" placeholder="Create Password"><br>
			<input type="password" name="Repassword" class="Repassword" placeholder="Password Again"><br>
			<input type="submit" value="Register" class="RegisterButton" action="register.java"><br>
			
		</form>
	</div>

</body>
</html>