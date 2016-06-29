<%-- 
    Document   : TestJsp
    Created on : 25 juin 2016, 23:12:16
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
        <div align="right"><a href="espace_personnel">Retour espace personnel</a></div>
        <h1>Gestion du quizz</h1>
        <%-- A modifier pour afficher nom du quizz actuel
        <c:forEach items="${quizzs.id}" var="qz_id">   
            ${qz_id.nom}
         </c:forEach> --%>
        <h3>Listes des questions</h3>
        
            <c:forEach items="${questions}" var="q">
                
                - ${q.titre} <a href="">Modifier</a>&nbsp&nbsp<a href="">Supprimer</a><br/> 
                
            </c:forEach>
            <br/>
            
        


        <c:if test="${cookie.login.getValue() == 'admin' && cookie.pswd.getValue() == 'admin' }">

            <h3>Ajouter une question</h3>
            <form method="post">
                
                Titre: <input type="text" name="titre"/><br/>
                Ordre: <select name="ordre">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
                <br/>
                Num rep correcte: <select name="nrc">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                </select>
                <br/>
                Reponse 1: <input type="text" name="r1"/><br/>
                Reponse 2: <input type="text" name="r2"/><br/>
                Reponse 3: <input type="text" name="r3"/><br/><br/>


                <input type="submit" value="valider"/>

            </form>


        </c:if>

    </body>
</html>
