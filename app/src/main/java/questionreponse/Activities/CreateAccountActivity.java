package questionreponse.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import asi.fizaine.adrien.questionreponse.R;
import questionreponse.ADO.UtilisateurADO;
import questionreponse.Class.Utilisateur;
import questionreponse.Tools.DBHelper;
import questionreponse.Tools.DataBaseManager;

/**
 * Created by Adrien on 09/02/2018.
 */

public class CreateAccountActivity extends AppCompatActivity {

    private static DBHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        dbHelper = new DBHelper();
        DataBaseManager.initializeInstance(dbHelper);

        /* Récupération des champs de saisie */
        final EditText inputPseudo = (EditText) findViewById(R.id.inputPseudo);                 // Pseudo
        final EditText inputMdp = (EditText) findViewById(R.id.inputPassword);                  // Mdp
        final EditText inputConfirmMdp = (EditText) findViewById(R.id.inputConfirmPassword);    // Confirmation de Mdp
        final EditText inputNom = (EditText) findViewById(R.id.inputNom);                       // Nom
        final EditText inputPrenom = (EditText) findViewById(R.id.inputPrenom);                 // Prénom

        /* Récupération du bouton */
        final Button btnValider = (Button) findViewById(R.id.btnValider); // Bouton valider

        /* Clic sur valider */
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputMdp.getText().toString().equals(inputConfirmMdp.getText().toString()))
                    Toast.makeText(getContext(), "Mots de passe différents.", Toast.LENGTH_SHORT).show();
                else {
                    // Crée un utilisateur
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setPseudo(inputPseudo.getText().toString());
                    utilisateur.setMdp(inputMdp.getText().toString());
                    utilisateur.setNom(inputNom.getText().toString());
                    utilisateur.setPrenom(inputPrenom.getText().toString());

                    // Insère l'utilisateur en bdd
                    UtilisateurADO utilisateurADO = new UtilisateurADO();
                    utilisateurADO.insert(utilisateur);

                    // Affiche le message
                    Toast.makeText(CreateAccountActivity.this, "Utilisateur créé", Toast.LENGTH_SHORT).show();

                    // Retourne à la page d'accueil
                    Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public CreateAccountActivity getContext(){
        return this;
    }
}
