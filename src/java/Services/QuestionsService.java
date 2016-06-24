/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import DAO.QuestionsDAO;
import Entities.Questions;

/**
 *
 * @author admin
 */
public class QuestionsService {


    public void creer(Questions q) {
        QuestionsDAO dao = new QuestionsDAO();
        dao.creerTableQuestions(q);
    }
    
}
