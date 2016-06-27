<%-- 
    Document   : demarrer_quizz
    Created on : 27 juin 2016, 14:13:04
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
        <div align="right"><a href="espace_personnel">Retour espace personnel</a></div>
        <h1>Répondre au quizz</h1>
        <%-- A modifier pour afficher nom du quizz actuel
        <c:forEach items="${quizzs.id}" var="qz_id">   
            ${qz_id.nom}
         </c:forEach> --%>
        <h3>Listes des questions</h3>
        <form method="post">
            <c:forEach items="${questions}" var="q">
                ${q.ordre} <br/>
                ${q.titre}<br/>
                <input type="radio" name="rep" value="${q.rep1}"/>&nbsp ${q.rep1}<br/>
                <input type="radio" name="rep" value="${q.rep2}"/>&nbsp ${q.rep2}<br/>
                <input type="radio" name="rep" value="${q.rep3}"/>&nbsp ${q.rep3}<br/>
            </c:forEach>
            <br/>
            <input type ="submit" value="valider"/>
        </form>

    </body>
</html>
