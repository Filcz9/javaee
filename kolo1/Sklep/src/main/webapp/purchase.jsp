<%@page import="com.fczyz.sklep.game.ComputerGame"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="storagePurchase" class="com.fczyz.sklep.service.PurchaseService" scope="session" />
<jsp:useBean id="storage" class="com.fczyz.sklep.service.GameService" scope="application" />
<jsp:useBean id="rodo" class="com.fczyz.sklep.game.Rodo" scope="application" />
<%
if(request.getParameter("purchase")!=null){
ComputerGame game = storage.findByTitle((request.getParameter("purchase")).toString());
if(game!=null){
storagePurchase.add(game);
out.println("<h3>Dodano:</h3>"+game.printAll());
}
else
	out.print("Nie ma takiej gry");
}
%>
<title>Insert title here</title>
</head>
<body>
<h3>Koszyk</h3>
<%
for(ComputerGame g : storagePurchase.getAllComputerGames())
{
	out.println(g.printAll());
	out.println("_________________________________________________");
}%>

Potwierdz przetwarzanie danych osobowych<input type="checkbox" name="rodo" required <%if(rodo.isRodo()) out.print("checked"); %>/></br>
Potwierdz regulamin sklepu<input type="checkbox" name="rodo2" required <%if(rodo.isRodo2()) out.print("checked"); %>/></br>
Newsletter<input type="checkbox" name="newsletter" <%if(rodo.isNewsletter()) out.print("checked"); %>/></br>
</form>
<a href='index.jsp'>Menu</a></br>
</body>
</html>
