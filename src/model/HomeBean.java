package model;

import bo.Score;
import dal.ScoreDAO;
import dal.DAOFactory;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class HomeBean implements Serializable {
    private List<Score> listScores;

    public List<Score> getListScores() {
        return listScores;
    }

    public void setUsers(List<Score> scores) {
        listScores = scores;
    }

    public HomeBean(){}

    public void getScores(){
        ScoreDAO dao = (ScoreDAO) DAOFactory.getScoreDAO();
        try {
            listScores = dao.findAll();
            System.out.println(listScores);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
