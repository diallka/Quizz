/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i.quiz.services;


import java.util.List;
import m2i.quiz.dao.QuestionsDAO;
import m2i.quiz.entities.Questions;

/**
 *
 * @author admin
 */
public class QuestionsService {


    public void creer(Questions q) {
        QuestionsDAO dao = new QuestionsDAO();
        dao.creerTableQuestions(q);
    }

    public List<Questions> lister() {
        
       return new QuestionsDAO().lister();
    }
    
}
