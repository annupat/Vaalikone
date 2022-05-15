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
    <h2> Kysymysten ylläpito</h2>
    <ol>
                        <!--  TÄMÄ EI TOIMI :/ -->
  <c:forEach var="kysymys" items="${requestScope.kysymyslist }">
	<li>${kysymys} <a href='/rest/kysymysservice/deleteadminquestion/${kysymykset.kysymysId}'>Delete</a> <a href='../readtoupdatefish?id=${kysymykset.kysymysId}'>Update</a>
</c:forEach>
 

 


    <c:forEach var = "kysymykset" items = "<%=readAllAdminQuestions() %>">
         <li>${kysymykset.kysymys} 
     </c:forEach>
    </ol>
    
    <form action='../questionservice/deleteadminquestion' method='post'>
        <input type = 'text' name = 'kysymysId' value = ''>
        <input class="button1" type="submit" value = "Poista kysymys"></form>
        
    <form action='../questionservice/readtoupdatekysymys' method='post'>
        <input class="button2" type="button" value = "Päivitä kysymystä"></form>
        
    <form action='rest/questionservice/addadminquestion'>
        <input class="button3" type="button" value = "Lisää kysymys"></form>
    
    
</body>
<style>
.button1 {
    position: fixed;
    left:30%;
    top:50%;
}
.button2 {
    position: fixed;
    left:50%;
    top:50%;
}
.button3 {
    position: fixed;
    left:70%;
    top:50%;
}
</style>
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