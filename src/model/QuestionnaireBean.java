package model;

import bo.Expression;
import bo.Score;

import java.io.Serializable;
import java.util.List;

public class QuestionnaireBean implements Serializable {

    private List<Expression> listeExpressions;
    private Score score;







    public QuestionnaireBean() {}

    public List<Expression> getListeExpressions() {
        return listeExpressions;
    }

    public void setListeExpressions(List<Expression> listeExpressions) {
        this.listeExpressions = listeExpressions;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
