<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action='../updatekysymys' method='post'>
<input type='text' name='id' value='${requestScope.kysymykset.kysymysId }'>
<input type='text' name='kysymys' value='${requestScope.kysymykset.kysymys }'>
<input type='submit' name='ok' value='OK'>
</form>

</body>
</html>