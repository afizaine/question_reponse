package asi.fizaine.adrien.questionreponse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
    }
}
