<%-- 
    Document   : espace_personnel
    Created on : 26 juin 2016, 22:38:31
    Author     : Pro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Template Page</title>
        <c:import url="_STYLESHEET.jsp" />
        <c:import url="_HEADER.jsp" />
    </head>
    <body>
        <div class="titre">
            <c:import url="_TITLE.jsp" /> 
        </div>
        <div class="menu">
            <c:import url="_MENU.jsp" />
        </div>
        <div class="contenu">
            
            <c:choose>
                <c:when test="${cookie.login.getValue() == 'admin' && cookie.pswd.getValue() == 'admin' }">

                <h2>Créer un quizz</h2>
                <form method="post">
                    <input type="text" name="nom" placeholder="Nom du quizz"/>
                    <input type="submit" value="Valider"/>
                </form>
                
                <c:forEach items="${quizzs}" var="qz">

                    <ul>- <a href="mettre_session_quiz_act?id=${qz.id}">${qz.nom}</a></ul>
                    </c:forEach>
            </c:when>
                    <c:otherwise>
            <h3>Liste des quizz </h3> 
                <c:forEach items="${quizzs}" var="qz">

                    <ul>- <a href="mettre_session_quiz_act_demarre?id=${qz.id}">${qz.nom}</a></ul>
                    </c:forEach>
                    </c:otherwise>
                    </c:choose>
        </div>
        <div class="pied">
            <c:import url="_FOOTER.jsp" />
        </div>
    </body>
</html>
