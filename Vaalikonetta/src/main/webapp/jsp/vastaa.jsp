<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.ArrayList" %>      
<%@ page import="data.Question" %>    
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
<h3>Vastaa kysymyksiin:</h3>

<form action='Save' method= 'post'>
 Ehdokas id: <input type='text' name='ehdokas_id' value='${requestScope.answer.ehdokas_id}'><br>

<% 
  		ArrayList<Question> questionList = (ArrayList<Question>) request.getAttribute("questionlist"); 

  	for (int i = 0; questionList != null && i < questionList.size(); i++) {  
  		Question q = questionList.get(i); 
  		out.println(q.getId() + ". " + q.getKysymys() +  
  				"<div>" + "<input type='radio' name='vastaus_"+i +"'"+" value='1' id=1 >täysin eri mieltä</div>"
  		+ "   " + "<div><input type='radio' name='vastaus_"+i +"'"+" value='2' id=2 >jokseenkin eri mieltä" + "</div>"+ "   " + 
  				"<div><input type='radio' name='vastaus_"+i + "'"+" value='3' id=3 >en osaa sanoa" + "</div>"+ "   " + 
  			"<div><input type='radio' name='vastaus_" +i +"'"+" value='4' id=4 >jokseenkin samaa mieltä" + "</div>"+ "   " + 
  				"<div><input type='radio' name='vastaus_"+i +"'"+" value='5' id=5 >täysin samaa mieltä" + "</div>");
  	} 	

  		
 %> 
 
  <input type='submit' name='ok' value='Tallenna vastaukset'>
 </form> 
 
 



</body>
</html>