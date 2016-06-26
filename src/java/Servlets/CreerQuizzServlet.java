/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entities.Quizz;
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
@WebServlet(name = "QuizzServlet", urlPatterns = {"/creer_quizz"})
public class CreerQuizzServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Quizz qz = new Quizz();
       qz.setNom(req.getParameter("nom"));
       //qz.setQuestions((List<Questions>) q);
       QuizzService quizzService = new QuizzService();
       new QuizzService().creer(qz);
       
       
       resp.sendRedirect("ajouter_question");
       
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("creer_quizz.jsp").forward(req, resp);
    }

    
    
}
