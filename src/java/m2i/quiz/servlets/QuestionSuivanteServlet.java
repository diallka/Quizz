
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
import m2i.quiz.services.QuizzService;

/**
 *
 * @author admin
 */
@WebServlet(name = "QuestionSuivanteServlet", urlPatterns = {"/question_suivante"})
public class QuestionSuivanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
        //Lister questions rattachés au quizz
        //Long quizzId = (Long) req.getSession().getAttribute("idQuizzActuel");
        //List <Question> question = new QuestionService().listerQuestionsParIdQuizz(quizzId);
        //req.setAttribute("questions", question);
        
        //On récupère idQuizz et Ordre dernière question repondue en session
        long quizzId = (long) req.getSession().getAttribute("idQuizzActuel");
        int ordreDerniereQuestRepondue = (int) req.getSession().getAttribute("ordre");
        
        //On recupere question suivante via QuizzService
        Question questionSuivante = new QuizzService().rechercherQuestionSuivante(quizzId, ordreDerniereQuestRepondue);
        
        //On met à jour l'ordre de la dernière question
        req.getSession().setAttribute("ordre", questionSuivante.getOrdre());
        
        //Si le quizz est terminé on rédirige vers quizz_terminé
        if(questionSuivante == null)
            resp.sendRedirect("quizz_termine.jsp");
        
        //Si le quizz n'est pas terminé
        
        
        //On afiche la question suivante 
        req.setAttribute("question", questionSuivante);
        req.getRequestDispatcher("question_suivante.jsp").forward(req, resp);
        
        
        //On recherche le nombre de questions existant dans le quizz actuel
         //int quizzId_2 = (int) req.getSession().getAttribute("idQuizzActuel");
        //Question question = new QuestionService().trouverNbrQuestParId(quizzId_2);
        
//       Long questionAct = (Long) req.getSession().getAttribute("ordreQuestAct");
//       Question quest = new QuestionService().trouverNbrQuestParId(questionAct);
//       Question question = null;
 
//        Long questionAct = (Long) req.getSession().getAttribute("idQuizzActuel");
//        Question quest = new QuestionService().trouverNbrQuestParId(questionAct);
//        req.setAttribute("quest", quest);

//          Long nbrQuestion = (Long) req.getSession().getAttribute("idQuizzActuel");
//          int nbrQuest = new QuestionService().rechercherNbrQuestParIdQuizz(nbrQuestion);
//          req.setAttribute("nbrQuest", nbrQuest);
          
          
//        if(questionAct == null){
//            question = new QuestionService().getQuestionSuivante(questionAct);
//        } else {
//            
//        }
//   
//        if(question == null)
            
            
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
    }
    
    

}
