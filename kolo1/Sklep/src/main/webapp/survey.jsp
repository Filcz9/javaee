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

<jsp:useBean id="storage" class="com.fczyz.sklep.service.SurveyService" scope="application" />
<jsp:useBean id="survey" class="com.fczyz.sklep.game.Survey" scope="session" />

<form action="addSurvey.jsp">

	Od: <input type='text' name='from' value='${survey.from}'/></br>
	Do: <input type='text' name='to' value='${survey.to}'/></br>
	Czestotliwosc:</br>codziennie:<input type='radio' name='freq' value="1" checked/></br>
	Raz w tygodniu: <input type='radio' name='freq' value="2" /></br>
	Rzadziej: <input type='radio' name='freq' value="3" /></br>
	<input type='submit' value='Dodaj'/></form></br>
<a href='index.jsp'>Menu</a></br>
  
</form>

</body>
</html>
