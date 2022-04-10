<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
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
<h2>Vaalikone</h2>
<h3>Vastaa kysymyksiin:</h3>


	<!--  -----------------RADIO BUTTON  ------ -->
<% 
  		ArrayList<Question> questionList = (ArrayList<Question>) request.getAttribute("questionlist"); //jsp voi sis‰lt‰‰ java-koodia 

  	for (int i = 0; questionList != null && i < questionList.size(); i++) {  
  		Question q = questionList.get(i); 
  		out.println(q.getId() + ". " + q.getKysymys() +  
  				"<div>" + "<input type='radio' name='vastaus_"+i +"value='tem' id=1 checked='checked'>t‰ysin eri mielt‰</div>"
  		+ "   " + "<div><input type='radio' name='vastaus_"+i +"value='jem' id=2 checked='checked'>jokseenkin eri mielt‰" + "</div>"+ "   " + 
  				"<div><input type='radio' name='vastaus_"+i + "value='eos' id=3 checked='checked'>en osaa sanoa" + "</div>"+ "   " + 
  			"<div><input type='radio' name='vastaus_" +i +"value='jsm' id=4 checked='checked'>jokseenkin samaa mielt‰" + "</div>"+ "   " + 
  				"<div><input type='radio' name='vastaus_"+i +"value='tsm' id=5 checked='checked'>t‰ysin samaa mielt‰" + "</div>");
  	} 
 %>
 

	<!-- ------------------------- EI TOIMI! ------------------------->
<!-- 	<ol> -->
<%-- 		<c:forEach var="kysymys" items="${requestScope.questionlist}"> --%>
<%-- 			<li>${question.kysymys_id}:${question.kysymys}  --%>
<%-- 							 <c:out value="${kysymys}" />  --%>
<!-- 		<div><input type = "radio" id = "Vahvasti eri mielt‰" name = "vastaus" value = "Vahvasti eri mielt‰" -->
<!-- 			checked> -->
<!-- 		<label for = "Vahvasti eri mielt‰" >Vahvasti eri mielt‰</label></div> -->
<!-- 		<div><input type = "radio" id = "Jokseenkin eri mielt‰" name = "vastaus" value = "Jokseenkin eri mielt‰" -->
<!-- 			checked> -->
<!-- 		<label for = "Jokseenkin eri mielt‰" >Jokseenkin eri mielt‰</label></div> -->
<!-- 		<div><input type = "radio" id = "En osaa sanoa" name = "vastaus" value = "En osaa sanoa" -->
<!-- 			checked> -->
<!-- 		<label for = "En osaa sanoa" >En osaa sanoa</label></div> -->
<!-- 		<div><input type = "radio" id = "Jokseenkin samaa mielt‰" name = "vastaus" value = "Jokseenkin samaa mielt‰" -->
<!-- 			checked> -->
<!-- 		<label for = "Jokseenkin samaa mielt‰" >Jokseenkin samaa mielt‰</label></div> -->

<!-- 		<div><input type = "radio" id = "Vahvasti samaa mielt‰" name = "vastaus" value = "Vahvasti samaa mielt‰" -->
<!-- 			checked> -->
<!-- 		<label for = "Vahvasti samaa mielt‰" >Vahvasti samaa mielt‰</label></div> -->

<%-- 		</c:forEach> --%>
<!-- 	</ol> -->



	<!--  ---------TOMMIN ESIMERKKI RADIO BUTTONIIN ------------------------------------ -->

<%-- 	<% --%>
<!-- // 		ArrayList<String> questionList = new ArrayList<String>(); -->
<!-- // 	questionList.add("eka"); -->
<!-- // 	questionList.add("toka"); -->
<!-- // 	questionList.add("kolmas"); -->
<!-- // 	for (int i = 0; questionList != null && i < questionList.size(); i++) { -->
<!-- // 		String q = questionList.get(i); -->
<!-- // 		out.println(i + "." + q + "<div><input type='radio' name='vastaus_" + i -->
<!-- // 		+ "' value='tem' id=1 checked='checked'>t‰ysin eri mielt‰</div>" + "<div><input type='radio' name='vastaus_" -->
<!-- // 		+ i + "' value='jem' id=2 checked='checked'>jokseenkin eri mielt‰</div>" -->
<!-- // 		+ "<div><input type='radio' name='vastaus_" + i -->
<!-- // 		+ "' value='eos' id=3 checked='checked'>en osaa sanoa</div>"); -->
<!-- // 	} -->
<%-- 	%> --%>


</body>
</html>