package lucian.example.com.coupedumonde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EquipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipe);
        Intent myIntent = getIntent(); // gets the previously created intent
        String nom_pays = myIntent.getStringExtra("nomPays"); // will return "FirstKeyValue"
        String nom_capitale= myIntent.getStringExtra("nomCapitale");
        TextView nomPays = (TextView) findViewById(R.id.nomPays_textView);
        nomPays.setText(nom_pays);
        TextView capitale=(TextView) findViewById(R.id.nomCapitale_textView);
        capitale.setText(nom_capitale);

    }


}
