<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="computergame" class="com.fczyz.sklep.game.ComputerGame" scope="session" />
<jsp:useBean id="storage" class="com.fczyz.sklep.service.GameService" scope="application" />
<jsp:setProperty property="title" param="title" name="computergame"/>
<jsp:setProperty property="price" param="price" name="computergame"/>

<%
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
try {
	computergame.setReleaseDate(df.parse(request.getParameter("releaseDate")));
} catch (ParseException e) {
}
if(request.getParameter("available").equals("true"))
	computergame.setAvailable(true);
else computergame.setAvailable(false);
storage.add(computergame);
%>
<body>
Dodano:
<%
out.println(computergame.printAll());
%>
</body>
<a href='getComputerGameData.jsp'>Dodaj kolejny</a></br>
<a href='index.jsp'>Menu</a></br>
</html>
