<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList" %>      
<%@ page import="data.Question" %>    
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>

</head>
<body>
<h2>Muokkaa vastauksiasi</h2>

<!-- EI TOIMI!-->
	<div class="questions">
<%
ArrayList<Question> questionList = (ArrayList<Question>) request.getAttribute("questionlist"); //jsp voi sisältää java-koodia 
	for (int i = 0; questionList != null && i < questionList.size(); i++) {  
		Question q = questionList.get(i); 
		out.println(q.getId() + ". " + q.getKysymys() +  
				"<div>" + "<input type='radio' name='vastaus_"+i +"value='tem' id=1 checked='checked'>Täysin eri mieltä</div>"
		+ "   " + "<div><input type='radio' name='vastaus_"+i +"value='jem' id=2 checked='checked'>Jokseenkin eri mieltä" + "</div>"+ "   " + 
				"<div><input type='radio' name='vastaus_"+i + "value='eos' id=3 checked='checked'>En osaa sanoa" + "</div>"+ "   " + 
			"<div><input type='radio' name='vastaus_" +i +"value='jsm' id=4 checked='checked'>Jokseenkin samaa mieltä" + "</div>"+ "   " + 
				"<div><input type='radio' name='vastaus_"+i +"value='tsm' id=5 checked='checked'>Täysin samaa mieltä" + "</div>");
	} 
	
%>
</div>

<div class="btn">
<a href='/readtoupdate'>
      
      <button class="button" type=button> Tallenna uudet vastaukset</button></a>

		</div>


</body>
<style>
.btn .button {
position: relative;
}
h2 {
font-family: Helvetica;
}
body {
text-align: center;
}

</style>
</html>