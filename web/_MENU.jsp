<%-- 
    Document   : _MENU
    Created on : 26 juin 2016, 20:43:54
    Author     : Pro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--ajouter library jstl sinon fonctionne pas-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th><a href="">Lister questions</a>&nbsp;&nbsp;</th>
                <th><a href="">Démarrer quizz</a>&nbsp;&nbsp;</th>

                <c:choose>
                    <c:when test="${cookie.login.getValue() == ''}">
                        Vous etes connecté en tant qu'invité, vous n'aurez pas de score.
                        <div align="right"><a href="deconnexion_utilisateur">Quitter</a></div>
                    </c:when>

                    <c:otherwise>
                    <div align="right"><a href="deconnexion_utilisateur">Déconnexion</a></div>
                    <h1>Espace personnel</h1>
                    <div align="center"><h3>Bonjour <a style="color:red">${cookie.login.getValue()}</a></h3></div>
                        <c:if test="${cookie.login.getValue() == 'admin' && cookie.pswd.getValue() == 'admin'}">
                            
                            <th><a href="creer_quizz">Ajouter quizz</a>&nbsp;&nbsp;</th><br/>
                            <th><a href="ajouter_question">Ajouter question</a>&nbsp;&nbsp;</th>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
            </tr>
        </table>
        <hr>
    </body>
</html>
