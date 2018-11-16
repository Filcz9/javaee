<%@page import="com.fczyz.sklep.game.ComputerGame"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="storage" class="com.fczyz.sklep.service.GameService" scope="application" />
<body>
<h3>Sklep</h3>
<form action="purchase.jsp">
<% for(ComputerGame game : storage.getAllComputerGames())
	{
		out.println(game.printAll()+"<button type='submit' name='purchase' value='"+game.getTitle()+"'>Dodaj do koszyka</button>");
	}%>
</form>
<a href='index.jsp'>Menu</a></br>
</body>
</html>
