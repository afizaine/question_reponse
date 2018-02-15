package questionreponse.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import asi.fizaine.adrien.questionreponse.R;

/**
 * Created by Adrien on 13/02/2018.
 */

public class MenuUtilisateurActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utilisateur);

        /* Récupère les boutons */
        final Button btnThemes = (Button) findViewById(R.id.btnThemes);
        final Button btnStats = (Button) findViewById(R.id.btnStats);
        final Button btnConfig = (Button) findViewById(R.id.btnConfig);
        final Button btnDeco = (Button) findViewById(R.id.btnDeconnexion);

        /* Clic sur le bouton "Thêmes" */
        btnThemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Affiche la liste des thêmes
                Intent intent = new Intent(MenuUtilisateurActivity.this, ThemeActivity.class);
                startActivity(intent);
            }
        });
    }
}
