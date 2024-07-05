<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="Login.css">
</head>
<body>
    <div class="introduction">
        <h1>Welcome to Trackme!</h1>
        <p>Where you track your reading and also<br>Enjoy Reading with different Rewards.</p>     
    </div>
    <div class="loginForm">
        <form action="Login">
            <input type="email" class="myEmail" name="email" placeholder="Email"><br>
            <input type="password" class="mypassword" name="password" placeholder="Password"><br>
            <input type="submit" class="mysubmit" value="Sign In"><br>
        </form>
         <a href="/home_page.jsp" class="myforgetpassword">Forget password?</a><br>
         <form action="CreateAccount">
            <input type="submit" class="mycreate" value="Create Account">
         </form>
    </div>
</body>
</html>
