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

public class AmeriqueSud  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afrique);

        Integer[] imgid={
                R.drawable.brazil,
                R.drawable.argentina
        };


        final ArrayList<Pays> pays = new ArrayList<Pays>();
        pays.add(new Pays("Brésil", "Brésil", imgid[0]));
        pays.add(new Pays("Argentine", "Buenos Aires", imgid[1]));


        PaysAdapter paysAdapter=new PaysAdapter(this, pays);
        ListView listeAS = (ListView)findViewById(R.id.list);
        listeAS.setAdapter(paysAdapter);

        listeAS.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Pays SelectedPays= pays.get(position);
                String nom = SelectedPays.getNom();
                String capitale = SelectedPays.getCapitale();
                if(nom=="Brésil") {
                    Intent myIntent = new Intent(view.getContext(), Bresil.class);
                    startActivityForResult(myIntent, 0);
                } else {
                    //EquipeActivity equipe = new EquipeActivity(nom, capitale);
                    Intent myIntent = new Intent(view.getContext(), EquipeActivity.class);
                    myIntent.putExtra("nomPays",nom);
                    myIntent.putExtra("nomCapitale",capitale);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

    }
}
