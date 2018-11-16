<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:useBean id="rodo" class="com.fczyz.sklep.game.Rodo" scope="application" />
</head>
<%
if(request.getParameter("rodo")!=null && request.getParameter("license")!=null)
{
	rodo.setRodo(true);
	rodo.setLicense(true);
}
if(request.getParameter("newsletter")!=null)
{
	rodo.setNewsletter(true);
}
if(!rodo.getRodo() && !rodo.getLicense())
{
	response.sendRedirect("rodo.jsp");
}
%>
<body>
<h1>Sklep z Grami</h1>
<a href='showAllComputerGames.jsp'>Sklep</a>
<a href='allSurveys.jsp'>Wszystkie opinie</a>
<a href='survey.jsp'>Dodaj opinie</a>
<a href='getComputerGameData.jsp'>Dodaj Gre</a>
</body>
</html>
