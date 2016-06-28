/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i.quiz.services;

import m2i.quiz.dao.QuizzDAO;
import m2i.quiz.entities.Quizz;
import java.util.List;
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
    
}
