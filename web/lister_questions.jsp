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
        <h3>Question </h3>
        
            
        <c:forEach items="${questions}" var="q">
              <br/>${q.ordre} 
            <a href="mettre_en_session_ques_act?id=${q.id}">${q.titre}</a>
        </c:forEach>   
        

    </body>
</html>
