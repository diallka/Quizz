<%-- 
    Document   : question_suivante
    Created on : 28 juin 2016, 13:53:03
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Quizz demmaré</h1>
        
        <form method="post">
            <c:forEach items="${questions}" var="q">
                ${q.ordre} <br/>
                ${q.titre}<br/>
                <input type="radio" name="rep" value="${q.rep1}"/>&nbsp ${q.rep1}<br/>
                <input type="radio" name="rep" value="${q.rep2}"/>&nbsp ${q.rep2}<br/>
                <input type="radio" name="rep" value="${q.rep3}"/>&nbsp ${q.rep3}<br/><br/>
                <input type="submit" value="Suivant"/>
            </c:forEach>
    </body>
</html>
