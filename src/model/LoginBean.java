package model;

import bo.User;
import dal.DAOFactory;
import dal.UserDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.Serializable;
import java.sql.SQLException;

public class LoginBean implements Serializable {

    private static final String FORM_FIELD_LOGIN = "form-login";
    private static final String FORM_FIELD_PWD = "form-password";
    public static final String ATT_AUTH_SESSION = "isConnected";

    private String login;
    private String password;
    private String authResult;

    public LoginBean(){}

    public void authenticate(HttpServletRequest request){
        login = request.getParameter(FORM_FIELD_LOGIN);
        password = request.getParameter(FORM_FIELD_PWD);
        UserDAO dao = (UserDAO) DAOFactory.getUserDAO();
        User user = null;
        try {
            user = dao.authenticate(login, password);

            if(user != null){
                HttpSession session = request.getSession(true);
                session.setAttribute(ATT_AUTH_SESSION, user);
                authResult = "Authentification réussie, bienvenue " + login;
            } else {
                authResult = "Authentification échouée";
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Connexion à la base de données échouée");
        }
    }

    public boolean isConnected(HttpServletRequest request){
        HttpSession session =  request.getSession();
        User connectedUser = (User) session.getAttribute(ATT_AUTH_SESSION);
        return connectedUser != null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthResult() {
        return authResult;
    }

    public void setAuthResult(String authResult) {
        this.authResult = authResult;
    }

}
