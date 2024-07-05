
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Book</title>
    <link rel="styleSheet" href="Register.css">
</head>
<body>
    <%
        System.out.println(session.getAttribute("email"));
    %>
    <div class="register">
        <h1>Search Your Book<br></h1>
        <form action="Search">
            <input class="search" type="text" name="searchValue" placeholder="Search By Title" style="width:80%; height:40px; padding:10px; margin:10px auto; border:1px solid #400000; background-color:#f0f2f5; border:1px solid #dddfe2; border-radius:5px;">
            <input type="submit" value="Search" class="RegisterButton" ><br>
        </form>
        <form action="LeaveSearch">
            <input type="submit" value="Leave" class="RegisterButton" ><br>
        </form>
    </div>
    
    <div class="registerForm">
        <form action="Progress">
            <input type="text" name="title" class="firstName" placeholder="${titleHolder}" disabled><br>
            <input type="text" name="link" class="lastName" placeholder="${linkHolder}" disabled><br>
            <input type="text" name="startingDate" class="password" placeholder="${startHolder }" disabled><br>
            <input type="text" name="endingDate" class="Repassword" placeholder="${endHolder }" disabled><br>
            <input type="text" name="quote" class="email" placeholder="${quoteHolder }" disabled><br>
         </form>
         <form class="ReaderLink">
			    <a href="${Holder}">
			        ${ReadHolder}
			    </a>
			   
		</form>

          
    </div>

</body>
</html>

