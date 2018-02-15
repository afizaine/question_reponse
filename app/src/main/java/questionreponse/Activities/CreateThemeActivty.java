package questionreponse.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import asi.fizaine.adrien.questionreponse.R;

/**
 * Created by Adrien on 15/02/2018.
 */

public class CreateThemeActivty extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_theme);

        final Button btnValider = (Button) findViewById(R.id.btnValider);

        if(ThemeActivity.selectedTheme == null){
            btnValider.setText(R.string.add);
        } else {
            btnValider.setText(R.string.edit);
        }
    }
}