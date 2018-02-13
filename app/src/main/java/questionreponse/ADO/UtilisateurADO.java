package questionreponse.ADO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import questionreponse.Class.Utilisateur;
import questionreponse.Tools.DataBaseManager;

/**
 * Created by Adrien on 09/02/2018.
 */

public class UtilisateurADO {
    private Utilisateur user;
    public UtilisateurADO(){
        user = new Utilisateur();
    }

    public static String createTable(){
        return "CREATE TABLE " + Utilisateur.TABLE  + "("
                + Utilisateur.KEY_UtilisateurID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Utilisateur.KEY_Nom + " TEXT, "
                + Utilisateur.KEY_Prenom + " TEXT, "
                + Utilisateur.KEY_Pseudo + " TEXT, "
                + Utilisateur.KEY_Mdp  + " TEXT )";
    }

    public int insert(Utilisateur utilisateur) {
        SQLiteDatabase db = DataBaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilisateur.KEY_Nom, utilisateur.getNom());
        values.put(Utilisateur.KEY_Prenom, utilisateur.getPrenom());
        values.put(Utilisateur.KEY_Pseudo, utilisateur.getPseudo());
        values.put(Utilisateur.KEY_Mdp, utilisateur.getMdp());
        // Inserting Row
        long id = db.insert(utilisateur.TABLE, null, values);
        DataBaseManager.getInstance().closeDatabase();
        return (int)id;
    }

    public ArrayList<Utilisateur> getAll() {
        SQLiteDatabase db = DataBaseManager.getInstance().openDatabase();
        Cursor c = db.query(Utilisateur.TABLE, new String[] {}, null, null, null, null, Utilisateur.KEY_UtilisateurID);
        if (c.getCount() == 0) {
            c.close();
            return null;
        }

        ArrayList<Utilisateur> userList = new
                ArrayList<> ();
        while (c.moveToNext()) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(c.getInt(0));
            utilisateur.setPrenom((c.getString(1)));
            utilisateur.setNom((c.getString(2)));
            utilisateur.setPseudo((c.getString(3)));
            utilisateur.setMdp((c.getString(4)));
            userList.add(utilisateur);
        }
        c.close();
        return userList;
    }

    public Utilisateur findUserByPseudo(String pseudo) {
        SQLiteDatabase db = DataBaseManager.getInstance().openDatabase();

        String whereClause = Utilisateur.KEY_Pseudo + " = ? ";
        String[] whereArgs = {pseudo};

        Cursor c = db.query(Utilisateur.TABLE, new String[]{Utilisateur.KEY_Pseudo}, whereClause, whereArgs, null, null, Utilisateur.KEY_UtilisateurID);

        if (c.getCount() == 0) {
            c.close();
            return null;
        } else {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(c.getInt(0));
                utilisateur.setPrenom((c.getString(1)));
                utilisateur.setNom((c.getString(2)));
                utilisateur.setPseudo((c.getString(3)));
                utilisateur.setMdp((c.getString(4)));

                c.close();
                return utilisateur;
        }
    }
}
