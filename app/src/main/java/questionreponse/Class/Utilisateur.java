package questionreponse.Class;

/**
 * Created by Adrien on 09/02/2018.
 */

public class Utilisateur {
    public static final String TAG = Utilisateur.class.getSimpleName();
    public static final String TABLE = "Utilisateur";
    // Labels Table Columns names
    public static final String KEY_UtilisateurID = "UtilisateurId";
    public static final String KEY_Nom = "Nom";
    public static final String KEY_Prenom = "Prenom";
    public static final String KEY_Pseudo = "Login";
    public static final String KEY_Mdp = "Mdp";


    private int id;
    private String nom;
    private String prenom;
    private String pseudo;
    private String mdp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
