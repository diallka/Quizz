/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.QuizzDAO;
import Entities.Quizz;
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
    
}
