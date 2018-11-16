<%@page import="com.fczyz.sklep.game.Survey"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="storage" class="com.fczyz.sklep.service.SurveyService" scope="application" />
<body>
<h3>Wszystkie opinie</h3>
<form action="purchase.jsp">
<% for(Survey survey : storage.getAllSurveys())
	{
		out.println(survey.showAll());
	}%>
</form>
<a href='index.jsp'>Menu</a></br>
</body>
</html>
