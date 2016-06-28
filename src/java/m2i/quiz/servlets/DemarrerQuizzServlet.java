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
import m2i.quiz.services.QuestionsService;
import m2i.quiz.services.QuizzService;

/**
 *
 * @author Pro
 */
@WebServlet(name = "ValiderQuestionServlet", urlPatterns = {"/demarrer_quizz"})
public class DemarrerQuizzServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
                                                                //rechercher par id
        List<Quizz> mesQuizzs = new QuizzService().lister();
        req.setAttribute("quizzs", mesQuizzs);

          req.getRequestDispatcher("demarrer_quizz.jsp").forward(req, resp);
    }    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         //Récuperation Question Quizz actuel
        long quizzId = (long) req.getSession().getAttribute("idQuizActuel");
        List<Question> questions = new QuestionsService().listerQuestionsParIdQuizz(quizzId);
        
        req.setAttribute("questions", questions);
        
    }
    
    
}
