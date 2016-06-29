/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i.quiz.services;

import m2i.quiz.dao.QuizzDAO;
import m2i.quiz.entities.Quizz;
import java.util.List;
import m2i.quiz.entities.Question;
/**
 *
 * @author admin
 */
public class QuizzService {

    public void creer(Quizz qz) {
       QuizzDAO  dao = new QuizzDAO();
       dao.creerTableQuizz(qz);
    }

    public Quizz rechercherParId(long quizzId) {
        QuizzDAO dao = new QuizzDAO();
        return dao.rechercherQuizzParId(quizzId);
    }

    public List<Quizz> lister() {
        
        return new QuizzDAO().listerQuizz();
        
    }

 
    public Quizz detailler(long quizzId) {
        return new QuizzDAO().detailler(quizzId);
    }
    
    public Question rechercherQuestionSuivante (long idQuizzActuel, int ordreQuestionPrecedente) {
        
        //Récuperer nombre de questions du quizz actuel
        long nbreQuestQuizz = new QuizzDAO().compteQuestionsParQuizzId(idQuizzActuel);
        
        //return new QuizzDAO().compteQuestionsParQuizzId( idQuizzActuel);
        
        //Si le Quizz est vide on renvoie une exception
        if (nbreQuestQuizz == 0){
            throw new RuntimeException("Le quizz est vide");
        }
        
        //Si le quizz n'est pas vide, on liste les questions suivantes
        List <Question> questOdreSupQuestRepondue = new QuizzDAO().listerQuestParIdQuizzEtParOrdreSuperieur(idQuizzActuel, ordreQuestionPrecedente);
        
        if(questOdreSupQuestRepondue.size() == 0) //pas besoin d'accolades quand il n'y a qu'une ligne
            return null;
        
        return questOdreSupQuestRepondue.get(0);
        
    } 
}
