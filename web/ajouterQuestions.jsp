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
        <h1>QUIZZ</h1>
        <form method="post">
            Selectionnez quizz:<select name="quizz_id">
                <c:forEach items="${quizzs}" var="qz">
                    <option value="${quizzId}">${qz.nom}</option>
                </c:forEach>
                
            </select>
            <br/><br/>
            
            <u>Question:</u> <input type="text" name="q"/><br/>
            Titre: <input type="text" name="titre"/><br/>
            Num rep correcte: <select name="nrc">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                                </select>  <br/>
            Ordre: <select name="ordre">
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
    </body>
</html>
