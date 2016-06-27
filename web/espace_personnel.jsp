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
            Contenu de l'espace personnel
            <c:if test="${cookie.login.getValue() == 'admin' && cookie.pswd.getValue() == 'admin' }">
               <h4>Liste des quizz deja créés</h4> 
            </c:if>
            
        </div>
        <div class="pied">
            <c:import url="_FOOTER.jsp" />
        </div>
    </body>
</html>
