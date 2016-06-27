/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i.quiz.dao;

import m2i.quiz.entities.Quizz;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author admin
 */
public class QuizzDAO {
    
    public void creerTableQuizz(Quizz qz){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
       
        //em.createQuery("SELECT qz FROM qz");
        
        em.getTransaction().begin();
        em.persist(qz);
        em.getTransaction().commit();

    }

    public Quizz rechercherQuizzParId(long quizzId) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Quizz.class, quizzId);
    }

    public List<Quizz> listerQuizz() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT qz FROM Quizz qz ORDER BY qz.nom").getResultList();
    }
    
}
