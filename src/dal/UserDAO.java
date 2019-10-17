package dal;

import bo.User;
import java.sql.*;
import java.util.List;

public class UserDAO extends  DataAccessObjectJDBC<User>{

    private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";

    public User authenticate(String login, String password) throws SQLException{
        System.out.println(login);
        System.out.println(password);
        User user = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
        PreparedStatement ps = connection.prepareStatement(AUTHENT_QUERY)){
            ps.setString(1, login);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    System.out.println("lol");
                    user = new User();
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setNbConnections(rs.getInt("connections") + 1);
                    user.setId(rs.getInt("id"));
                }
            }
        }
        return user;
    }


    public UserDAO(String dbUrl, String dbLogin, String dbPwd) {
        super(dbUrl, dbLogin, dbPwd);
    }

    @Override
    public void create(User object) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById() {
        return null;
    }
}
