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

public class Asie extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afrique);

        Integer[] imgid={
                R.drawable.korea,
                R.drawable.jp
        };


        final ArrayList<Pays> pays = new ArrayList<Pays>();
        pays.add(new Pays("Corée du Sud", "Seoul", imgid[0]));
        pays.add(new Pays("Japon", "Tokyo", imgid[1]));


        PaysAdapter paysAdapter=new PaysAdapter(this, pays);
        ListView listeAsie = (ListView)findViewById(R.id.list);
        listeAsie.setAdapter(paysAdapter);

        listeAsie.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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
