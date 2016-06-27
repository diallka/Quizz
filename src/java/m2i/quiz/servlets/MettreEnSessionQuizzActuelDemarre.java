/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i.quiz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "MettreEnSessionQuizzActuelDemarre", urlPatterns = {"/mettre_session_quiz_act_demarre"})
public class MettreEnSessionQuizzActuelDemarre extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getSession().setAttribute("idQuizActuel", Long.parseLong( req.getParameter("id") ));
        
        resp.sendRedirect("demarrer_quizz");
    }
}
