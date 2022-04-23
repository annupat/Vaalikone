<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Answer"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Poistettu</title>
</head>
<body>

	Vastauksesi on poistettu
	<br>
	<br>
	<%
		ArrayList<Answer> answerList = (ArrayList<Answer>) request.getAttribute("answerlist");

	for (int i = 0; answerList != null && i < answerList.size(); i++) {
		Answer a = answerList.get(i);
		out.println("Vastaus kysymykseen " + a.getKysymys_id() + ": " + a.getVastaus() + "    " + "<br>");
	}
	%>

	<a href='/index.html'><button type="button">Etusivulle</button></a>
</body>
</html>