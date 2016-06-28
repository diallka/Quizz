
package m2i.quiz.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import m2i.quiz.entities.Question;
import m2i.quiz.services.QuestionsService;

/**
 *
 * @author admin
 */
@WebServlet(name = "QuestionSuivanteServlet", urlPatterns = {"/question_suivante"})
public class QuestionSuivanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        
        //Récuperation question actuel
       
        //List<Question> questions = new QuestionsService().listerQuestionsParIdQuizz(quizzId);

        //req.setAttribute("questions", questions);

        req.getRequestDispatcher("demarrer_quizz.jsp").forward(req, resp);
    }

}
