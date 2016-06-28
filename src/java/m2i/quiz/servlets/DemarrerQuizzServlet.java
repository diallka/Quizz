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
 * @author Pro
 */
@WebServlet(name = "ValiderQuestionServlet", urlPatterns = {"/demarrer_quizz"})
public class DemarrerQuizzServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
                                                                //rechercher par id
        List<Quizz> mesQuizzs = new QuizzService().lister();
        req.setAttribute("quizzs", mesQuizzs);
        //req.getSession().setAttribute("idQuizActuel", Long.parseLong( req.getParameter("id") ));
        //*************************************************************
                                                            //rechercher par id
                                                            
//        List<Questions> mesQuestions = new QuestionsService().lister();
//        req.setAttribute("questions", mesQuestions);
        
//        long idQuestion = Long.parseLong(req.getParameter("id"));
//        List<Questions> mesQuestions = new QuestionsService().listerQuestionParId(idQuestion);
//        req.setAttribute("questions", mesQuestions);
        
          
          
          req.getRequestDispatcher("demarrer_quizz.jsp").forward(req, resp);
    }    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         //Récuperation Quizz
        long quizzId = (long) req.getSession().getAttribute("idQuizActuel");
        Quizz qz = new QuizzService().rechercherParId(quizzId);
        
        //Rechercher question selon le quizz dans leqquel on se trouve
        long questionId = (long) req.getSession().getAttribute("idQuizActuel");
        Questions mesQuestions = new QuestionsService().rechercherQuestionParId(questionId);
    }
    
    
}
