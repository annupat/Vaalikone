<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>      
<%@ page import="data.Answer" %>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>

</head>
<body>
<h2>Vaalikone</h2>

<!-- <form action="/readanswer" method="post"> -->
<!-- 	<p> -->
<!-- 		Ehdokasnumerosi: <input type='text' name='ehdokas_id'> <br>  -->
<!-- 		Vastaus: <input type='text' name='vastaus' ><br> -->
<!-- 		<input type='submit' value='Poista'> -->
<!-- </form> -->



<%
ArrayList<Answer> answerList=(ArrayList<Answer>)request.getAttribute("answerlist");			

for (int i=0;answerList!=null && i<answerList.size();i++){
	Answer a=answerList.get(i);
 	out.println("Vastaus kysymykseen " + a.getKysymys_id()+": "+a.getVastaus()+ "    " +
	"<a href='/delete?kysymys_id="+a.getKysymys_id() + 
 	"'<button type='button'>Poista vastaus</button></a>" + 
	"<br>");
}


%>


 
		

</body>
</html>