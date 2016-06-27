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
import m2i.quiz.entities.Quizz;
import m2i.quiz.services.QuestionsService;
import m2i.quiz.services.QuizzService;

/**
 *
 * @author admin
 */
@WebServlet(name = "ListerQuestionServlet", urlPatterns = {"/lister_questions"})
public class ListerQuestionsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //A gerer puis recuperer attributs
         //req.getSession().getAttribute("idQuizActuel", Long.parseLong( req.getParameter("id") ));
        
    }

    
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Lister questions
                                                            //rechercher par id
        List<Questions> mesQuestions = new QuestionsService().lister();
        req.setAttribute("questions", mesQuestions);
        
//        long idQuestion = Long.parseLong(req.getParameter("id"));
//        List<Questions> mesQuestions = new QuestionsService().listerQuestionParId(idQuestion);
//        req.setAttribute("questions", mesQuestions);
        
//        long questionId = (long) req.getSession().getAttribute("idQuestionActuel");
//        Questions Questions = new QuestionsService().rechercherQuestionParId(questionId);
//        req.setAttribute("question", Questions);
        
        
        req.getRequestDispatcher("lister_questions.jsp").forward(req, resp);
    }    
    
}
