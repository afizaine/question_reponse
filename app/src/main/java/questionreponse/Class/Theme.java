package questionreponse.Class;

import java.util.ArrayList;

/**
 * Created by Adrien on 15/02/2018.
 */

public class Theme {

    /* ATTRIBUTS */
    private String nomTheme;
    private ArrayList<Question> questions;

    // Pour les stats
    private int nbJouer;
    private int nbQuestionRepondue;
    private double tauxReussite;


    /* GET / SET */
    public String getNomTheme() { return nomTheme; }
    public void setNomTheme(String nomTheme) { this.nomTheme = nomTheme; }

    public ArrayList<Question> getQuestions() { return questions; }
    public void setQuestions(ArrayList<Question> questions) { this.questions = questions; }

    public int getNbJouer() { return nbJouer; }
    public void setNbJouer(int nbJouer) { this.nbJouer = nbJouer; }

    public double getTauxReussite() { return tauxReussite; }
    public void setTauxReussite(double tauxReussite) { this.tauxReussite = tauxReussite; }

    public int getNbQuestionRepondue() { return nbQuestionRepondue; }
    public void setNbQuestionRepondue(int nbQuestionRepondue) { this.nbQuestionRepondue = nbQuestionRepondue; }
}
