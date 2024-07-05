<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Schedule</title>
	<link rel="styleSheet" href="Register.css">

</head>
<body>
	<div class="register">
		<h1>Schedule to Read!!<br></h1>
		<p>Already have on trackme? <a href="Home_page.jsp">Read From</a>   <br>and Enjoy from what trackme provide!</p>
	</div>
	
	<div class="registerForm">
		<form action="Schedule">
			<input type="text" name="title" class="firstName" placeholder="Book Title"><br>
			<input type="text" name="link" class="lastName" placeholder="Book Link"><br>
			<input type="date" name="startingDate" class="password" placeholder="Create Password"><br>
			<input type="date" name="endingDate" class="Repassword" placeholder="Description"><br>
			<input type="text" name="quote" class="email" placeholder="Description"><br>
			<input type="submit" value="Schedule" class="RegisterButton" ><br>
			
		</form>
	</div>

</body>
</html>
