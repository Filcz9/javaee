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

  Title :<input type="text" name="title" value="${computergame.title}" /><br />
  Release Date :<input type="date"  name="releaseDate" value="${computergame.releaseDate}" /><br />
  Price :<input type="number" step="0.01"  name="price" value="${computergame.price}" /><br />
  Available :<input type="text"  name="available" value="${computergame.available}" /><br />
  <input type="submit" value=" Add ">
  
</form>

</body>
</html>