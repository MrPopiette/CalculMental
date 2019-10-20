package bo;

import java.util.Date;

public class Score {

    private int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    private int value;
    private Date date;

    public Score(){};

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Score(int value, Date date) {
        this.value = value;
        this.date = date;
    }
}