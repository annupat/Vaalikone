<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"  %>
<%@ page import="data.Kysymykset"  %>
<%@ page import="javax.ws.rs.client.*"  %>
<%@ page import="javax.ws.rs.client.Invocation.Builder"  %>
<%@ page import="javax.ws.rs.core.*"  %>
<%@ page import="java.util.ArrayList"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Admin etusivu</title>
</head>
<body>
	<ol>
	<c:forEach var = "kysymys" items = "${requestScope.adminquestionlist }">
		<li>${kysymykset.kysymys}
	</c:forEach>


	<c:forEach var = "kysymys" items = "<%=readAllAdminQuestions() %>">
		<li>${kysymys}
	</c:forEach>
	</ol>
	
	<button type='button'>Poista kysymys</button><br>
	<button type='button'>Muokkaa kysymystä</button><br>
	<button type='button'>Lisää uusi kysymys</button><br>

</body>
</html>
	<%
		ArrayList<Kysymykset> questionList = (ArrayList<Kysymykset>) request.getAttribute("questionlist");

	for (int i = 0; questionList != null && i < questionList.size(); i++) {
		Kysymykset a = questionList.get(i);
		out.println("Vastaus kysymykseen " + a.getKysymysId() + ": " + a.getKysymys() + "    " + "<br>");
	}
	%>
	
	<%!
List<Kysymykset> readAllAdminQuestions() {
	String uri = "http://127.0.0.1:8080/rest/questionservice/readadminquestion";
	Client c = ClientBuilder.newClient();
	WebTarget wt = c.target(uri);
	Builder b = wt.request();
	GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {};
	
	List<Kysymykset> list = b.get(genericList);
	return list;
	
	}
%>