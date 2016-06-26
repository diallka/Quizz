/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Questions;
import Entities.Quizz;
import Services.QuestionsService;
import Services.QuizzService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "QuestionsServlet", urlPatterns = {"/questionsServlet"})
public class QuestionsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        //Récuperation Quizz
        long quizzId = Long.parseLong(req.getParameter("quizz_id"));
        Quizz qz = new QuizzService().rechercherParId(quizzId);
    
       Questions q = new Questions();
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
       QuestionsService questionsService = new QuestionsService();
       new QuestionsService().creer(q);
       
       resp.sendRedirect("questionsServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("quizzs", new QuizzService().lister());
        
        req.getRequestDispatcher("ajouterQuestions.jsp").forward(req, resp);
    }

   
}
