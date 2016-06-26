/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pro
 */
@WebServlet(name = "DeconnexionUtilisateur", urlPatterns = {"/deconnexion_utilisateur"})
public class DeconnexionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Cookie cookie;
       
       cookie = new Cookie("login", "test");
       cookie.setMaxAge(0);
       resp.addCookie(cookie);
       
       cookie = new Cookie("psw", null);
       cookie.setMaxAge(0);
       resp.addCookie(cookie);
        
        resp.sendRedirect("connection_utilisateur");
    }
     
}
