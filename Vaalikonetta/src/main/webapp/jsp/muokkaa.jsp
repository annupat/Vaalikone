<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%@ page import="java.util.ArrayList" %>      
<%@ page import="data.Answer" %>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>
</head>
<body>
<h2>Muokkaa vastauksia</h2>
<div>
<% 	
ArrayList<Answer> answerList=(ArrayList<Answer>)request.getAttribute("answerlist");			

for (int i=0;answerList!=null && i<answerList.size();i++){
	Answer a=answerList.get(i);
 	out.println("Vastaus kysymykseen " + a.getKysymys_id()+": "+a.getVastaus()+ "    " + 
	"<br>");
}

%>
</div>

<form action='update' method='post'>
Kysymys id: <input type='text' name='kysymys_id' value='${requestScope.answer.kysymys_id}'><br> 
Uusi vastaus: <input type='text' name='vastaus' value='${requestScope.answer.vastaus}'><br>
<input type='submit' name='ok' value='Send'> 
</form>
</body>

<a href='http://127.0.0.1:8080/index.html'>Takaisin etusivulle</a>
<style>
.btn .button {
position: relative;
top: 70%;
}
h2 {
font-family: Helvetica;
}
body {
text-align: center;
row-gap: 1ch;
}
.questions {
row-gap: 1ch;
}

</style>
</html>