package bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Expression {

    private double[] membreCalcul;
    private Operateur operateur;
    private String expression;
    private double resultat;


    public double[] getMembreCalcul() {
        return membreCalcul;
    }

    public void setMembreCalcul(double[] membreCalcul) {
        this.membreCalcul = membreCalcul;
    }

    public Operateur getOperateur() {
        return operateur;
    }

    public void setOperateur(Operateur operateur) {
        this.operateur = operateur;
    }

    public double getRandomMembreCalcul() {
        int min = -100;
        int max = 100;
        double x = (Math.random() * ((max - min) + 1)) + min;
        return x;
    }

    public double[] getSomeRandomMembreCalcul() {
        int min = 3;
        int max = 5;
        Random r = new Random();
        int nombreMembres = r.nextInt((max - min) + 1) + min;
        double[] tableauMembres = new double[nombreMembres];
        for (int i = 0; i < nombreMembres; i++) {
            tableauMembres[i] = getRandomMembreCalcul();
        }
        return tableauMembres;
    }

    // TODO Utiliser une pile pour obtenir le resultat

    public Expression() {

        List<String> expr = new ArrayList<>();
        List<Double> result = new ArrayList<>();
        int min = 0;
        int max = 1;
        Random r = new Random();
        int opeHasard = 0;

        this.membreCalcul = getSomeRandomMembreCalcul();

        int nbreMembre = this.membreCalcul.length;

        for (double membre : this.membreCalcul) {
            switch (expr.size()) {
                case 1:
                    min = 0;
                    max = 1;
                    opeHasard = r.nextInt((max - min) + 1) + min;
                    if (opeHasard == 0) {
                        // Ajout nombre
                        expr.add(Double.toString(membre));
                        result.add(membre);
                    } else if (opeHasard == 1) {
                        // Ajout operateur unaire puis nombre
                        Operateur ope = new Operateur(false);
                        expr.add(ope.getAffichageOperateur());
                        while ((ope.getAffichageOperateur() == "inv" && result.lastIndexOf(result) == 0) || (ope.getAffichageOperateur() == "rac" && result.lastIndexOf(result) < 0)) {
                            membre = getRandomMembreCalcul();
                        }
                        result.add(ope.OperationUnaire(result.lastIndexOf(result)));
                        result.remove(result.size() - 2);
                    }
                    result.add(membre);
                    expr.add(Double.toString(membre));
                    break;

                case 2:
                    // ajout operateur binaire ou unaire puis nombre
                    min = 0;
                    max = 1;
                    opeHasard = r.nextInt((max - min) + 1) + min;
                    if (opeHasard == 0) {
                        // Ajout operateur binaire
                        Operateur ope = new Operateur(true);
                        expr.add(ope.getAffichageOperateur());
                        while (ope.getAffichageOperateur() == "/" && membre == 0) {
                            membre = getRandomMembreCalcul();
                        }
                        result.add(ope.OperationBinaire(result.lastIndexOf(result), membre));
                        result.remove(result.size() - 2);
                    } else {
                        // Ajout operateur unaire
                        Operateur ope = new Operateur(false);
                        expr.add(ope.getAffichageOperateur());
                        while ((ope.getAffichageOperateur() == "inv" && result.lastIndexOf(result) == 0) || (ope.getAffichageOperateur() == "rac" && result.lastIndexOf(result) < 0)) {
                            membre = getRandomMembreCalcul();
                        }
                        result.add(ope.OperationUnaire(result.lastIndexOf(result)));
                        result.remove(result.size() - 2);
                    }
                    result.add(membre);
                    expr.add(Double.toString(membre));
                    break;
                case 3:
                    // ajout operateur binaire puis nombre
                    Operateur ope = new Operateur(true);
                    expr.add(ope.getAffichageOperateur());

                    while (ope.getAffichageOperateur() == "/" && membre == 0) {
                        membre = getRandomMembreCalcul();
                    }

                    result.add(ope.OperationBinaire(result.lastIndexOf(result), membre));
                    result.remove(result.size() - 2);
                    result.add(membre);
                    expr.add(Double.toString(membre));
                    break;
                default:
                    // ajout nombre
                    result.add(membre);
                    expr.add(Double.toString(membre));
                    break;
            }
        }

        while (expr.size() != 1) {
            // check pour reduire la taille avec des ajouts d'opérateurs
            Operateur ope = new Operateur(true);
            expr.add(ope.getAffichageOperateur());
            if (!(ope.getAffichageOperateur() == "/" && ope.OperationUnaire(result.lastIndexOf(result)) == 0)) {

                /*
                157  <=
                101 ( size - 1 )
                56  ( size - 1 )
                 */

                result.add(ope.OperationBinaire(result.lastIndexOf(result), result.get(result.size()-2)));
                result.remove(result.size() - 1);
                result.remove(result.size() - 1);
            }
        }
        this.resultat = result.get(0);
    }
}

