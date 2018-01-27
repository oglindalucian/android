package lucian.example.com.coupedumonde;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Afrique extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afrique);

        Integer[] imgid={
                R.drawable.egypt,
                R.drawable.morocco
        };


        final ArrayList<Pays> pays = new ArrayList<Pays>();
        pays.add(new Pays("Morocco", "Rabat", imgid[1]));
        pays.add(new Pays("Egypte", "Cairo", imgid[0]));

        PaysAdapter paysAdapter=new PaysAdapter(this, pays);
        ListView listeAfrique = (ListView)findViewById(R.id.list);
        listeAfrique.setAdapter(paysAdapter);

        listeAfrique.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Pays SelectedPays= pays.get(position);
                String nom = SelectedPays.getNom();
                String capitale = SelectedPays.getCapitale();
                Intent myIntent = new Intent(view.getContext(), EquipeActivity.class);
                myIntent.putExtra("nomPays",nom);
                myIntent.putExtra("nomCapitale",capitale);
                startActivityForResult(myIntent, 0);
            }
        });

    }
}
