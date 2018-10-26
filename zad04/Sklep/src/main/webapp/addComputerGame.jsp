<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="computergame" class="com.fczyz.sklep.game.ComputerGame" scope="session" />

<jsp:setProperty name="computergame" property="*" /> 

<jsp:useBean id="storage" class="com.fczyz.sklep.service.GameService" scope="application" />

<% 
  storage.add(computergame);
%>

<p>Following computer games has been added to storage: </p>
<p>Title: ${computergame.title} </p>
<p>Release Date: ${computergame.releaseDate}</p>
<p>Price: <jsp:getProperty name="computergame" property="price"></jsp:getProperty></p>
<p>Available: <jsp:getProperty name="computergame" property="available"></jsp:getProperty></p>
<p>
  <a href="showAllComputerGames.jsp">Show all computer games</a>
</p>
</body>
</html>