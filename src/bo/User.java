package bo;

public class User {

    private int id;
    private String login;
    private String password;
    private int nbConnections;

    public User(){}

    public User(int id, String login, String password, int nbConnections) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nbConnections = nbConnections;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNbConnections() {
        return nbConnections;
    }

    public void setNbConnections(int nbConnections) {
        this.nbConnections = nbConnections;
    }
}
