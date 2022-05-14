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
<title>Insert title here</title>
</head>
<body>

    <c:forEach var = "kysymykset" items = "<%=readAllAdminQuestions() %>">
         <li>${kysymykset} 
     </c:forEach>

<c:forEach var="kysymys" items="${requestScope.kysymyslist }">
	<li>${kysymys} <a href='rest/questionservice/deleteadminquestion/${kysymykset.kysymysId}'>Delete</a> <a href='../readtoupdatekysymys?id=${kysymykset.kysymysId}'>Update</a>
</c:forEach>


<form action='../addkysymys' method='post'>
<input type='text' name='kysymys' value=''>
<input type='submit' name='ok' value='OK'>
</form>

    <form action='rest/questionservice/deleteadminquestion/${kysymysId}' method='post'>
        <input type = 'text' name = 'kysymysId' value = ''>
        <input class="button1" type="submit" value = "Poista kysymys"></form>
        
<form action='../updatekysymys' method='post'>
<input type='text' name='kysymysId' value='' placeholder=kysymysnumero>
<input type='text' name='kysymys' value='' placeholder=kysymys>
<input type='submit' name='ok' value='Päivitä kysymys'>
</form>


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
