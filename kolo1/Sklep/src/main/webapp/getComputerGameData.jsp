<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="storage" class="com.fczyz.sklep.service.GameService" scope="application" />
<jsp:useBean id="computergame" class="com.fczyz.sklep.game.ComputerGame" scope="session" />

<form action="addComputerGame.jsp">

	Title: <input type='text' name='title' value='${computergame.title}'/></br>
	Price: <input type='text' name='price' value='${computergame.price}'/></br>
	Data wydania: <input type='date' name='releaseDate' value='<%
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	if(computergame.getReleaseDate()!=null){
		out.print(df.format(computergame.getReleaseDate()).toString());}
	else
		out.print(df.format(new java.util.Date()));%>'/></br>
	State:</br>unavailable:<input type='radio' name='available' value='false' checked/></br>
	available: <input type='radio' name='available' value='true' /></br>
	<input type='submit' value='Dodaj'/></form></br>
<a href='index.jsp'>Menu</a></br>
  
</form>

</body>
</html>



