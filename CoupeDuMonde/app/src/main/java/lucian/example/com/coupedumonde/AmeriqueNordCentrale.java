package lucian.example.com.coupedumonde;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import lucian.example.com.coupedumonde.Pays;
import lucian.example.com.coupedumonde.PaysAdapter;
import lucian.example.com.coupedumonde.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by lucian on 2018-01-25.
 */

public class AmeriqueNordCentrale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afrique);

        Integer[] imgid={
                R.drawable.mexico,
                R.drawable.costarica
        };

        final ArrayList<Pays> pays = new ArrayList<Pays>();
        pays.add(new Pays("Mexique", "Mexico City", imgid[0]));
        pays.add(new Pays("Costa Rica", "San José", imgid[1]));

        PaysAdapter paysAdapter=new PaysAdapter(this, pays);
        ListView listeANC = (ListView)findViewById(R.id.list);
        listeANC.setAdapter(paysAdapter);

        listeANC.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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
