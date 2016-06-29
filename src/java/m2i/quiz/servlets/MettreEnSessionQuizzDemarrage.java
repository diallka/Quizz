/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i.quiz.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import m2i.quiz.entities.Question;
import m2i.quiz.services.QuestionService;

/**
 *
 * @author admin
 */
@WebServlet(name = "MettreEnSessionQuizzActuelDemarre", urlPatterns = {"/mettre_session_quiz_act_demarre"})
public class MettreEnSessionQuizzDemarrage extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
       
        
        resp.sendRedirect("demarrer_quizz");
    }
}
