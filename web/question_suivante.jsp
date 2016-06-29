<%-- 
    Document   : question_suivante
    Created on : 28 juin 2016, 13:53:03
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Demarrage Quizz </h1>
        
          
        <s>Intitulé:</s> ${nomQuizzActuel} <%--recuperé depuis session quizzActDemarreServ --%>
          <br/><br/>
          Score: ${score}/3
          <br/><br/>
          Question:
          
        <form method="post">
          <c:forEach items="${questions}" var="q">
                ${q.ordre} <br/>
                ${q.titre}<br/>
                <input type="radio" name="rep" value="${q.rep1}"/>&nbsp ${q.rep1}<br/>
                <input type="radio" name="rep" value="${q.rep2}"/>&nbsp ${q.rep2}<br/>
                <input type="radio" name="rep" value="${q.rep3}"/>&nbsp ${q.rep3}<br/><br/>
        </c:forEach> 
                <br/>
                <input type="submit" value="Valider"/> 
        </form>
    </body>
</html>
