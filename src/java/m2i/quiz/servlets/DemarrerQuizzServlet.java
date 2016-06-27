/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i.quiz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import m2i.quiz.entities.Questions;
import m2i.quiz.services.QuestionsService;

/**
 *
 * @author Pro
 */
@WebServlet(name = "ValiderQuestionServlet", urlPatterns = {"/demarrer_quizz"})
public class DemarrerQuizzServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        
//        long questionId = (long) req.getSession().getAttribute("idQuestionActuel");
//        Questions Questions = new QuestionsService().rechercherQuestionParId(questionId);
//        req.setAttribute("question", Questions);

          //On place un Quizz en session
          req.getSession().setAttribute("quizzId", Long.parseLong(req.getParameter("idQuizzActuel")));
          
          //On met le score à zero dans la session
          req.getSession().setAttribute("score", 0);
          
          //Rédirection  vers jsp question suivante
          resp.sendRedirect("question_suivante");
    }    
}
