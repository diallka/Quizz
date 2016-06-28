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
import m2i.quiz.entities.Question;
import m2i.quiz.entities.Quizz;
import m2i.quiz.services.QuestionService;
import m2i.quiz.services.QuizzService;

/**
 *
 * @author Pro
 */
@WebServlet(name = "ValiderQuestionServlet", urlPatterns = {"/demarrer_quizz"})
public class DemarrerQuizzServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        //Placer quizz actuel en session
        req.getSession().setAttribute("quizzId", Long.parseLong(req.getParameter("idQuizActuel")));
        
        //Initialiser l'ordre à zero
        req.getSession().setAttribute("ordre", null);
        
        //Initialiser le score à zero
        req.getSession().setAttribute("score", 0);
        
        //On rédirige vers la question suivante
        resp.sendRedirect("question_suivante");
    }

}
