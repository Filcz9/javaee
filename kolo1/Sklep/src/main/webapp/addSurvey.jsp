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
<jsp:useBean id="survey" class="com.fczyz.sklep.game.Survey" scope="session" />
<jsp:useBean id="storage" class="com.fczyz.sklep.service.SurveyService" scope="application" />

<%
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
try {
	survey.setFrom(df.parse(request.getParameter("from")));
} catch (ParseException e) {
}
try {
	survey.setTo(df.parse(request.getParameter("to")));
} catch (ParseException e) {
}
if(request.getParameter("freq").equals("1"))
	survey.setFreq("Codziennie");
if(request.getParameter("freq").equals("2"))
	survey.setFreq("Raz w tygodniu");
else survey.setFreq("Rzadziej");
storage.add(survey);
%>
<body>
Dodano:
<%
out.println(survey.showAll());
%>
</body>
<a href='survey.jsp'>Dodaj kolejny</a></br>
<a href='index.jsp'>Menu</a></br>
</html>
