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
<h3>From request</h3>
<ol>
<c:forEach var="kysymykset" items="${requestScope.kysymyslist }">
	<li>${kysymykset}
</c:forEach>
</ol>

<h3>From method</h3>

<ol>
<c:forEach var="kysymykset" items="<%=readAll() %>">
	<li>${kysymykset}
</c:forEach>
</ol>
</body>
</html>

<%!
List<Kysymykset> readAll() {
	String uri = "http://127.0.0.1:8080/rest/questionservice/readquestion";
	Client c=ClientBuilder.newClient();
	WebTarget wt=c.target(uri);
	Builder b=wt.request();
	GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {};
	
	List<Kysymykset> list=b.get(genericList);
	return list;

 }
%>