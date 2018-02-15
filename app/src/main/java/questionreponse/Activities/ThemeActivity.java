package questionreponse.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import asi.fizaine.adrien.questionreponse.R;
import questionreponse.Class.Theme;

/**
 * Created by Adrien on 13/02/2018.
 */

public class ThemeActivity extends AppCompatActivity {

    public static Theme selectedTheme = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);

        final ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd);

        /* Clic sur le bouton ajouter */
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTheme = null;
                Intent intent = new Intent(ThemeActivity.this, CreateThemeActivty.class);
                startActivity(intent);
            }
        });
    }
}
