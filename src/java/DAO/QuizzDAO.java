/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Quizz;
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
    
}
