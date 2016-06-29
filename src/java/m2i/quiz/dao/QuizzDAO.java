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
import javax.persistence.Query;
import m2i.quiz.entities.Question;

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

    public Quizz detailler(long quizzId) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        //return  em.createQuery("SELECT qz FROM Quizz qz WHERE qz.id=:id").setParameter("id", quizzId).getSingleResult();;
        return em.find(Quizz.class, quizzId);
       
    }

    
    //Recuperer nombre de questions du quizz en db
    public int compteQuestionsParQuizzId(long idQuizzActuel) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        Query query = em.createNamedQuery("SELECT COUNT (q) FROM Question q WHERE q.quizz.id=:id_quizz");
              query.setParameter("id_quizz", idQuizzActuel);
        return (int) query.getSingleResult();
              
    }
    
    //On liste les questions du quizz dont l'ordre est plus grand que l'ordre de la derniere question repondue et on trie par ordre croissant
    public List<Question> listerQuestParIdQuizzEtParOrdreSuperieur(long idQuizzActuel, int ordreQuestionPrecedente){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query = em.createNamedQuery("SELECT q FROM q WHERE q.quizz.id=:idQuizzActuel AND q.ordre>:ordre ORDER BY q.ordre");
                query.setParameter("idQuizzActuel", idQuizzActuel);
                query.setParameter("idQuizzActuel", idQuizzActuel);
        return query.getResultList();
    }
   
    
}
