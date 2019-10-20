package bo;

import java.util.ArrayList;
import java.util.List;

public class Questionnaire {

    private List<Expression> listeExpressions;
    private Score score;

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

    public Questionnaire() {
        listeExpressions = new ArrayList<>();
        this.score = new Score();
        this.score.setValue(0);
        for (int i = 0; i < 10; i++){
            listeExpressions.add(new Expression());
        }
    }
}
