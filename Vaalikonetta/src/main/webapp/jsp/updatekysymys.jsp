<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kysymyksen päivittäminen</title>
</head>
<body>

	<h2>Päivitä kysymystä</h2>


	<form action='/updatekysymys' method='post'>
		<input type='text' name='kysymysId'
			value='${requestScope.kysymykset.kysymysId}' readonly> <input
			type='text' name='kysymys' value='${requestScope.kysymykset.kysymys}'
			size="60" required> <input type='submit' name='ok'
			value='Päivitä'>
	</form>

	<br>
	<a href='http://127.0.0.1:8080/jsp/kysymysform.jsp'>Takaisin
		kysymysten selaukseen</a>
	<br>
	<a href='http://127.0.0.1:8080/index.html'>Takaisin etusivulle</a>
</body>
</html>