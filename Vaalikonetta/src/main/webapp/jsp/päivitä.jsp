<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
<h2>Muokkaa vastauksiasi</h2>


	<div class="questions">
<% 	
ArrayList<Answer> answerList=(ArrayList<Answer>)request.getAttribute("answerlist");			

for (int i=0;answerList!=null && i<answerList.size();i++){
	Answer a=answerList.get(i);
 	out.println("Vastaus kysymykseen " + a.getKysymys_id()+": "+a.getVastaus()+ "    " +
	"<a href='update?kysymys_id=" + a.getKysymys_id() + 
 	"'< button type='button'>Muokkaa vastausta</button></a>" + 
	"<br>");
}

%>
</div>

<div class="btn">
<a href='/readtoupdate'>
      
      <button class="button4" type=button> Tallenna uudet vastaukset</button></a>

		</div>


</body>
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