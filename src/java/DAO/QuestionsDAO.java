/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Questions;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author admin
 */
public class QuestionsDAO {
    
        public void creerTableQuestions(Questions q){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        //em.createQuery("SELECT q FROM q");
        
        em.getTransaction().begin();
        em.persist(q);
        em.getTransaction().commit();

    }
    
}
