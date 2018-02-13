package questionreponse.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import asi.fizaine.adrien.questionreponse.R;
import questionreponse.ADO.UtilisateurADO;
import questionreponse.Class.Utilisateur;
import questionreponse.Tools.DBHelper;
import questionreponse.Tools.DataBaseManager;

public class LoginActivity extends AppCompatActivity {
    private static Context context;
    private static DBHelper dbHelper;
    private ArrayList<Utilisateur> utilisateurs;
    public static Utilisateur connected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // ADO utilisateur
        final UtilisateurADO utilisateurADO = new UtilisateurADO();

        // Contexte de l'application
        context = this.getApplicationContext();
        dbHelper = new DBHelper();
        DataBaseManager.initializeInstance(dbHelper);

        // Récupère tous les utilisateurs
        utilisateurs = utilisateurADO.getAll();

        /* Récup des champs de saisie */
        final EditText inputPseudo = (EditText) findViewById(R.id.inputPseudo);     // Pseudo
        final EditText inputMdp = (EditText) findViewById(R.id.inputPassword);      // Mot de passe

        /* Récup des boutons */
        final Button btnConnecter = (Button) findViewById(R.id.btnConnexion);       // Se connecter
        final Button btnCreerCompte = (Button) findViewById(R.id.btnCreerCompte);   // Créer un compte

        /* Clic sur le bouton "Créer un compte" */
        btnCreerCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        /* Clic sur le bouton "Se connecter" */
        btnConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((inputMdp.getText().toString().equals("")) || inputPseudo.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Remplissez les champs.", Toast.LENGTH_SHORT).show();
                } else {
                    for(Utilisateur u: utilisateurs){
                        if((u.getPseudo().equals(inputPseudo.getText().toString())) && u.getMdp().equals(inputMdp.getText().toString())){
                            setUtilisateurs(u);
                            Intent intent = new Intent(LoginActivity.this, MenuUtilisateurActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Identifiants incorects.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

    public static Context getContext(){
        return context;
    }

    public void setUtilisateurs(Utilisateur u) { this.connected = u; }
}
