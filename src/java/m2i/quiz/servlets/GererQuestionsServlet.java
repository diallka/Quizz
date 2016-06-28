/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i.quiz.servlets;

import m2i.quiz.entities.Question;
import m2i.quiz.entities.Quizz;
import m2i.quiz.services.QuestionService;
import m2i.quiz.services.QuizzService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "QuestionsServlet", urlPatterns = {"/gerer_questions"})
public class GererQuestionsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Récuperation Quizz
        long quizzId = (long) req.getSession().getAttribute("idQuizActuel");
        Quizz qz = new QuizzService().rechercherParId(quizzId);

        Question q = new Question();
        q.setTitre(req.getParameter("titre"));
        int numRepCorrecte = Integer.parseInt(req.getParameter("nrc"));
        q.setNumRepCorrecte(numRepCorrecte);
        int ordre = Integer.parseInt(req.getParameter("ordre"));
        q.setOrdre(ordre);
        q.setRep1(req.getParameter("r1"));
        q.setRep2(req.getParameter("r2"));
        q.setRep3(req.getParameter("r3"));

        qz.getQuestions().add(q);
        q.setQuizz(qz);
        QuestionService questionsService = new QuestionService();
        new QuestionService().creer(q);

        resp.sendRedirect("gerer_questions ");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Quizz> mesQuizzs = new QuizzService().lister();
        req.setAttribute("quizzs", mesQuizzs);
        //req.getSession().setAttribute("idQuizActuel", Long.parseLong( req.getParameter("id") ));
        //*************************************************************
                                                            //rechercher par id
        List<Question> mesQuestions = new QuestionService().lister();
        req.setAttribute("questions", mesQuestions);
        req.getRequestDispatcher("gerer_questions.jsp").forward(req, resp);
        
//        long questionId = (long) req.getSession().getAttribute("idQuestionActuel");
//        Questions mesQuestions = new QuestionsService().rechercherQuestionParId(questionId);

//        req.setAttribute("questions", mesQuestions);
    }

}
