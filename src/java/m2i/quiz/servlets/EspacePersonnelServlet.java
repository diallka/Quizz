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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pro
 */
@WebServlet(name = "EspacePersonnelServlet", urlPatterns = {"/espace_personnel"})
public class EspacePersonnelServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Quizz qz = new Quizz();
        qz.setNom(req.getParameter("nom"));
        
        QuizzService quizzService = new QuizzService();
        new QuizzService().creer(qz);

        resp.sendRedirect("espace_personnel");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Quizz> mesQuizzs = new QuizzService().lister();
        req.setAttribute("quizzs", mesQuizzs);
        
        req.getRequestDispatcher("espace_personnel.jsp").forward(req, resp);
    }

}
