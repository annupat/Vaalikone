<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Answer"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>

</head>
<body>
	<h2>Vaalikone</h2>


	<%
		ArrayList<Answer> answerList = (ArrayList<Answer>) request.getAttribute("answerlist");

	for (int i = 0; answerList != null && i < answerList.size(); i++) {
		Answer a = answerList.get(i);
		out.println(
		"Vastaus kysymykseen " + a.getKysymys_id() + ": " + a.getVastaus() + "    " + "<a href='/delete?kysymys_id="
				+ a.getKysymys_id() + "'< button type='button'>Poista vastaus</button></a>" + "<br>");
	}
	%>
	
	<a href='http://127.0.0.1:8080/index.html'>Takaisin etusivulle</a>





</body>
</html>