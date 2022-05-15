<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Kysymykset"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
<%@ page import="java.util.List"  %>
<%@ page import="javax.ws.rs.client.*"  %>
<%@ page import="javax.ws.rs.client.Invocation.Builder"  %>
<%@ page import="javax.ws.rs.core.*"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin näkymä kysymyksille</title>
</head>
<body>
<h2> Kysymysten ylläpito</h2>

<h3>Kysymykset:</h3>
<c:forEach var="kysymys" items="<%=readAllAdminQuestions() %>">
	<li>${kysymys} <a href='/rest/questionservice/deleteadminquestion/${kysymys.kysymysId}'>Delete</a> 
 	<a href='/rest/questionservice/readtoupdatekysymys/${kysymys.kysymysId}'>Update</a> 
</c:forEach>

<h3>Uusien kysymysten lisääminen</h3>
<form action='/addkysymys' method='post'>
<input type='text' name='kysymys' value=''>
<input type='submit' name='ok' value='Lisää uusi kysymys'>
</form>

<br><a href='http://127.0.0.1:8080/index.html'>Takaisin etusivulle</a>
</body>
</html>
<%!
List<Kysymykset> readAllAdminQuestions() {
    String uri = "http://127.0.0.1:8080/rest/questionservice/readadminquestion";
    Client c = ClientBuilder.newClient();
    WebTarget wt = c.target(uri);
    Builder b = wt.request();
//    b.header("Authorization", request.getHeader("Authorization"));
    GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>() {};
    
    List<Kysymykset> list = b.get(genericList);
    return list;
    
    }
%>
