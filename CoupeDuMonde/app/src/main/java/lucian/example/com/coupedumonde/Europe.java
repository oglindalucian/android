package lucian.example.com.coupedumonde;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by lucian on 2018-01-25.
 */

public class Europe extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afrique);

        Integer[] imgid={
                R.drawable.germany,
                R.drawable.uk,
                R.drawable.france,
                R.drawable.russia,
                R.drawable.denmark,
                R.drawable.spain,
                R.drawable.portugal,
                R.drawable.belgium,
                R.drawable.croatia,
                R.drawable.iceland,
                R.drawable.poland,
                R.drawable.serbia,
                R.drawable.sweden,
                R.drawable.switzerland
        };

        final ArrayList<Pays> pays = new ArrayList<Pays>();
        pays.add(new Pays("Allemagne", "Berlin", imgid[0]));
        pays.add(new Pays("Angleterre", "Londres", imgid[1]));
        pays.add(new Pays("France", "Paris", imgid[2]));
        pays.add(new Pays("Russie", "Moscou", imgid[3]));
        pays.add(new Pays("Danemark", "Copenhagen", imgid[4]));
        pays.add(new Pays("Espagne", "Madrid", imgid[5]));
        pays.add(new Pays("Portugal", "Lisbone", imgid[6]));
        pays.add(new Pays("Belgique", "Brusselles", imgid[7]));
        pays.add(new Pays("Croatie", "Zagreb", imgid[8]));
        pays.add(new Pays("Islande", "Rjekjavik", imgid[9]));
        pays.add(new Pays("Pologne", "Warshaw", imgid[10]));
        pays.add(new Pays("Serbie", "Belgrade", imgid[11]));
        pays.add(new Pays("Suède", "Stockholm", imgid[12]));
        pays.add(new Pays("Suisse", "Bern", imgid[13]));

        PaysAdapter paysAdapter=new PaysAdapter(this, pays);
        ListView listeEurope = (ListView)findViewById(R.id.list);
        listeEurope.setAdapter(paysAdapter);

        listeEurope.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Pays SelectedPays= pays.get(position);
                String nom = SelectedPays.getNom();
                String capitale = SelectedPays.getCapitale();
                if(SelectedPays.getNom()=="Allemagne") {
                    Intent myIntent = new Intent(view.getContext(), Allemagne.class);
                    startActivityForResult(myIntent, 0);
                } else {
                    Intent myIntent = new Intent(view.getContext(), EquipeActivity.class);
                    myIntent.putExtra("nomPays",nom);
                    myIntent.putExtra("nomCapitale",capitale);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}
