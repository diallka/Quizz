/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i.quiz.services;


import java.util.List;
import m2i.quiz.dao.QuestionDAO;
import m2i.quiz.entities.Question;

/**
 *
 * @author admin
 */
public class QuestionService {


    public void creer(Question q) {
        QuestionDAO dao = new QuestionDAO();
        dao.creerTableQuestions(q);
    }

   

    public List<Question> listerQuestionsParIdQuizz(long quizzId) {
        return new QuestionDAO().listerQuestionsParIdQuizz(quizzId);
    }

    public Question getQuestionSuivante(Long questionAct) {

            return new QuestionDAO().verifQuestion(questionAct);
    }

    public List<Question> listerToutesLesQuestions() {
        return new QuestionDAO().listerToutesLesQuestions();
    }
     
    
    
}
