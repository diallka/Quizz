<%-- 
    Document   : valider_question
    Created on : 27 juin 2016, 23:24:28
    Author     : Pro
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
        
        <h1>Titre quizz: </h1> 
        ${quizzs.nom}
           
        
        <h3>Liste questions</h3>
                  
            <c:forEach items="${questions}" var="q">
                
                ${q.titre}<br/>
           </c:forEach>
           
    </body>
</html>
