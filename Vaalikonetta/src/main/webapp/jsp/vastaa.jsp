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
<h2>Vaalikone</h2>

	<ol>
		<c:forEach var="kysymys" items="${requestScope.questionlist}" >			
			<li>${kysymykset.id}: ${kysymykset.kysymys} 
		</c:forEach>
	</ol>
	
<%
ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");			//jsp voi sisältää java-koodia

for (int i=0;questionList!=null && i<questionList.size();i++){
	Question q=questionList.get(i);
	out.println(q.getId()+": "+q.getKysymys()+"<a href='/delete?id="+q.getId()+"'>delete</a> <a href='/readtoupdate?id="+q.getId()+"'>update</a>");
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