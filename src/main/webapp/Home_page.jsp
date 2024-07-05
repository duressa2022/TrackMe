<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DashBoard</title>
    <link rel="stylesheet" href="home.css">
</head>
<body>
     <%
     
     if(session.getAttribute("email") == null){
         response.sendRedirect("Login_page.jsp"); 
     }
     %>
    <div class="home">
	     <div class="welcome">
	        <h1 style="font-size:30px; font-family: 'Papyrus'">Welcome to TrackMe</h1>
	     </div>
	        <form action="Reader">
	            <input type="submit" value="Read Book" class="reader"><br>
	         </form>
	         <form action="Progress">
	            <input type="submit" value="Make Schedule" class="progress"><br>
	         </form>
	         <form action="LeaveTrackme">
	            <input type="submit" value="Leave TrackMe" class="logout">
	        </form>
	     <div class="welcome">
	        <h1 style="font-size:30px; font-family: 'Papyrus'"><%
	            Connection connection=null;
	            PreparedStatement preparedStatement=null;
	            ResultSet resultSet=null;
	            String urlString = "jdbc:mysql://localhost:3306/informationdb";
	            String userString = "root";
	            String passString = "root";
	            Class.forName("com.mysql.jdbc.Driver");
	            String emailString=(String)session.getAttribute("email");
	            if(emailString!=null){
	            	connection=DriverManager.getConnection(urlString,userString,passString);
	                String query="select firstname,lastname from informationdb.userinformation where email=?";
	                preparedStatement=connection.prepareStatement(query);
	                preparedStatement.setString(1,session.getAttribute("email").toString());
	                resultSet=preparedStatement.executeQuery();
	                if(resultSet.next()){
	                    String fullString=resultSet.getString("firstname")+ " "+ resultSet.getString("lastname");
	                    out.println("Name: " +fullString.toLowerCase());
	                }
	            }
	     
	        %></h1>
	     </div>
	    </div>
</body>
</html>
