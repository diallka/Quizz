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
public class QuestionDAO {
    
        public void creerTableQuestions(Question q){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        //em.createQuery("SELECT q FROM q");
        
        em.getTransaction().begin();
        em.persist(q);
        em.getTransaction().commit();

    }

    public  List<Question> listerToutesLesQuestions(){
         EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT q FROM Question q ").getResultList();
      
    }

    public List<Question> listerQuestionsParIdQuizz(long quizzId) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
                                                                                    //Rajouter ORDER BY Ordre des questions
        return em.createQuery("SELECT q FROM Question q WHERE q.quizz.id=:id_quizz").setParameter("id_quizz", quizzId).getResultList();
    }

    
//    public Question verifQuestion(Long questionAct) {
//        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
//       return em.find(Question.class, questionAct);
//    }

    public Question trouverNbrQuestParId(Long questionAct) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
       return (Question) em.createQuery("SELECT q FROM Question q WHERE q.quizz.id=:id_quizz").setParameter("id_quizz", questionAct).getSingleResult();
    }

//    public int rechercherNbrQuestParIdQuizz(long nbrQuestion) {
//        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
//       return (int) em.createQuery("SELECT COUNT (q) FROM Question q WHERE q.quizz.id=:id_quizz").setParameter("id_quizz", nbrQuestion).getSingleResult();
//    }

    
    
    
}
