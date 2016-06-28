/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i.quiz.dao;

import java.util.List;
import m2i.quiz.entities.Question;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author admin
 */
public class QuestionsDAO {
    
        public void creerTableQuestions(Question q){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        //em.createQuery("SELECT q FROM q");
        
        em.getTransaction().begin();
        em.persist(q);
        em.getTransaction().commit();

    }

    public  List<Question> lister(){
         EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT q FROM Questions q ORDER BY q.id").getResultList();
      
    }

    public List<Question> listerQuestionsParIdQuizz(long quizzId) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
                                                                                    //Rajouter ORDER BY Ordre des questions
        return em.createQuery("SELECT q FROM Questions q WHERE q.quizz.id=:idQuizz").setParameter("idQuizz", quizzId).getResultList();
    }
    
    
}
