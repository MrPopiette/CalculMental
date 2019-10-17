package dal;

import bo.User;

import javax.servlet.ServletContext;

public class DAOFactory {

    private static String mode;
    private static String dbUrl;
    private static String dbLogin;
    private static String dbPwd;


    public static void init(ServletContext context) throws ClassNotFoundException {
        System.out.println("1");
        mode = context.getInitParameter("DS_MODE");
        switch (mode) {
            case "JDBC":
                Class.forName(context.getInitParameter("DB_DRIVER"));
                dbUrl = context.getInitParameter("DB_URL");
                dbLogin = context.getInitParameter("DB_LOGIN");
                dbPwd = context.getInitParameter("DB_PWD");
                break;
            case "JPA":
            default:
                //TODO
        }
    }

    public static IDAO<User> getUserDAO() {
        IDAO<User> dao;
        System.out.println(dbUrl);
        switch (mode) {
            case "JDBC":
                dao = new UserDAO(dbUrl, dbLogin, dbPwd);
                break;
            default:
                //TODO
                dao = null;
        }
        return dao;
    }

}