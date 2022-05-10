<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"  %>
<%@ page import="data.Kysymykset"  %>
<%@ page import="javax.ws.rs.client.*"  %>
<%@ page import="javax.ws.rs.client.Invocation.Builder"  %>
<%@ page import="javax.ws.rs.core.*"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ol>
	<c:forEach var = "kysymys" items = "${requestScope.adminquestionlist }">
		<li>${kysymys}
	</c:forEach>


	<c:forEach var = "kysymys" items = "<%=readAllAdminQuestions() %>">
		<li>${kysymys}
	</c:forEach>
	</ol>
</body>
</html>
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