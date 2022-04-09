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

<!-- EI TOIMI!-->
<ol>
		<c:forEach var="kysymys" items="${requestScope.questionlist}" >			
			<li>${question.kysymys_id}: ${question.kysymys} 
			<input type="radio" name="1">1 
			<input type="radio" name="2">2 
			<input type="radio" name="3">3 
			<input type="radio" name="4">4 
			<input type="radio" name="5">5 	
		</c:forEach>
	</ol>
	
<%
ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");			//jsp voi sis‰lt‰‰ java-koodia

for (int i=0;questionList!=null && i<questionList.size();i++){
	Question q=questionList.get(i);
	out.println(q.getId()+". "+q.getKysymys() + "<br>" + "<button type=radio name=1>t‰ysin eri mielt‰ </button>" + "   " +
			"<button type=radio name=1>t‰ysin samaa mielt‰ </button>" + "<br>"		
			);
}
%>
		
<form>
<input type="radio" name="1">1 
<input type="radio" name="2">2 
<input type="radio" name="3">3 
<input type="radio" name="4">4 
<input type="radio" name="5">5 

</form>

</body>
</html>