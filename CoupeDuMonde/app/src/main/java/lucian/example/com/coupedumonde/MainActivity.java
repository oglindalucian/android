package lucian.example.com.coupedumonde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void ecranAfrique(View view) {
        Intent intent = new Intent(this, Afrique.class);
        startActivity(intent);
    }

    public void ecranEurope(View view) {
        Intent intent = new Intent(this, Europe.class);
        startActivity(intent);
    }

    public void ecranANC(View view) {
        Intent intent = new Intent(this, AmeriqueNordCentrale.class);
        startActivity(intent);
    }

    public void ecranAS(View view) {
        Intent intent = new Intent(this, AmeriqueSud.class);
        startActivity(intent);
    }

    public void ecranAsie(View view) {
        Intent intent = new Intent(this, Asie.class);
        startActivity(intent);
    }
}
