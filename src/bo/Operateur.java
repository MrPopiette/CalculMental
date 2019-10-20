package bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Operateur implements Serializable {

    private String operateur;
    private String affichageOperateur;
    /**
     * @True = Binaire
     * @False = Unaire
     */
    private boolean typeOperateur;


    public Operateur() {
    }

    public Operateur(boolean typeOperateur){
        List<String> opeSigne = new ArrayList<>();
        if (typeOperateur) {
            opeSigne.add("/");
            opeSigne.add("+");
            opeSigne.add("*");
            opeSigne.add("-");
            this.typeOperateur = true;
        } else {
            opeSigne.add("inv");
            opeSigne.add("rac");
            this.typeOperateur = false;
        }
        int min = 0;
        int max = opeSigne.size();
        Random r = new Random();
        int operateurChoisi = r.nextInt((max - min)) + min;
        this.operateur = opeSigne.get(operateurChoisi);
        this.affichageOperateur = opeSigne.get(operateurChoisi);
    }


    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public String getAffichageOperateur() {
        return affichageOperateur;
    }

    public void setAffichageOperateur(String affichageOperateur) {
        this.affichageOperateur = affichageOperateur;
    }

    public boolean isTypeOperateur() {
        return typeOperateur;
    }

    public void setTypeOperateur(boolean typeOperateur) {
        this.typeOperateur = typeOperateur;
    }


    /**
     *
     * @param typeOperateur
     * if typeOperateur est true (Binaire) => il faut le changer en unaire car il n'y a qu'un membre a calculer
     * if typeOperateur est false (Unaire) => il faut le changer en binaire car il y a plusieurs membres à calculer
     */
    public void setNewOperateurBinaire(boolean typeOperateur){
        if (typeOperateur){
            List<String> opeSigne = new ArrayList<>();
            opeSigne.add("/");
            opeSigne.add("+");
            opeSigne.add("*");
            opeSigne.add("-");
            int min = 0;
            int max = opeSigne.size();
            Random r = new Random();
            int operateurChoisi = r.nextInt((max - min)) + min;
            this.operateur = opeSigne.get(operateurChoisi);
            this.typeOperateur = true;
            this.affichageOperateur = opeSigne.get(operateurChoisi);
        } else {

        }
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public double additionner(double x, double y){
        x = x + y;
        return x;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public double soustraire(double x, double y){
        x = x - y;
        return x;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public double multiplier(double x, double y){
        x = x * y;
        return x;
    }


    /**
     *
     * @param x
     * @param y
     * @return
     */
    public double diviser(double x, double y){
        if(y == 0){
            return 0;
        } else {
            x = x/y;
        }
        return x;
    }

    /**
     *
     * @param x
     * @return
     */
    public double inverser(double x){
        x = 1/x;
        return x;
    }

    /**
     *
     * @param x
     * @return
     */
    public double racineCarre(double x){
        Math.sqrt(x);
        return x;
    }

    /**
     *
     * @param x
     * @return
     */
    public double OperationUnaire(double x){
        switch (this.affichageOperateur){
            case "rac":
                // Normalement les exceptions sont déja gérées
                x = racineCarre(x);
                break;
            case "inv":
                x = inverser(x);
                break;
                default:
                    // ca doit jamais passer par la /!\
                    break;
        }
        return x;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public double OperationBinaire(double x, double y){
        switch (this.affichageOperateur){
            case "/":
                x = diviser(x,y);
                break;
            case "*":
                x = multiplier(x,y);
                break;
            case "-":
                x = soustraire(x,y);
                break;
            case "+":
                x = additionner(x,y);
                break;
                default:
                    // ca doit jamais passer par la non plus /!\
                    break;
        }

        return  x;
    }

}
