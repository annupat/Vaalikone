<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Kysymykset"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='../addkysymys' method='post'>
<input type='text' name='kysymys' value=''>
<input type='submit' name='ok' value='OK'>
</form>

    <form action='rest/questionservice/deleteadminquestion' method='post'>
        <input type = 'text' name = 'kysymysId' value = ''>
        <input class="button1" type="submit" value = "Poista kysymys"></form>
        
<ol>
<c:forEach var="kysymys" items="${requestScope.kysymyslist }">
	<li>${kysymys} <a href='/rest/kysymysservice/deleteadminquestion/${kysymykset.kysymysId}'>Delete</a> <a href='../readtoupdatefish?id=${kysymykset.kysymysId}'>Update</a>
</c:forEach>
</ol>


</body>
</html>
