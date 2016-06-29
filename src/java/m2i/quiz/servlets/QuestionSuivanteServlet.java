
package m2i.quiz.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import m2i.quiz.entities.Question;
import m2i.quiz.services.QuestionService;

/**
 *
 * @author admin
 */
@WebServlet(name = "QuestionSuivanteServlet", urlPatterns = {"/question_suivante"})
public class QuestionSuivanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        //Lister questions rattachés au quizz
        Long quizzId = (Long) req.getSession().getAttribute("idQuizzActuel");
        List <Question> question = new QuestionService().listerQuestionsParIdQuizz(quizzId);
        req.setAttribute("questions", question);
        
//        List <Question> questions = new QuestionService().listerToutesLesQuestions();
//        req.setAttribute("questions", questions);
        
        
//        Long questionAct = (Long) req.getSession().getAttribute("ordreQuestAct");
//        Question question = null;
//        
//        if(questionAct == null){
//            question = new QuestionService().getQuestionSuivante(questionAct);
//        } else {
//            
//        }
//   
//        if(question == null)
            
            
        req.getRequestDispatcher("question_suivante.jsp").forward(req, resp);
    }

}
