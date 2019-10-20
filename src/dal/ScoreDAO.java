package dal;

import bo.Score;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO extends  DataAccessObjectJDBC<Score>{

    private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM score ORDER BY value DESC LIMIT 10";


    @Override
    public List<Score> findAll() throws SQLException {
        List<Score> listScores = new ArrayList<>();
        Score score = null;
        try(Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(FIND_ALL_QUERY)){
                while(rs.next()){
                    score = new Score();
                    score.setValue(rs.getInt("value"));
                    score.setIdUser(rs.getInt("id_user"));
                    listScores.add(score);
                }
            }


        return listScores;
    }

    public Score authenticate(String login, String password) throws SQLException{
        Score score = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
             PreparedStatement ps = connection.prepareStatement(AUTHENT_QUERY)){
            ps.setString(1, login);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    System.out.println("lol");
                    score = new Score();
                }
            }
        }
        return score;
    }


    public ScoreDAO(String dbUrl, String dbLogin, String dbPwd) {
        super(dbUrl, dbLogin, dbPwd);
    }

    @Override
    public void create(Score object) {

    }


    @Override
    public Score findById() {
        return null;
    }
}
