package lucian.example.com.pizzaiolo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class IngredientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);

        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient("Tomatos", "Legumes"));
        ingredients.add(new Ingredient("Poivrons", "Legumes"));
        ingredients.add(new Ingredient("Champinions", "Legumes"));
        ingredients.add(new Ingredient("Fromages", "Produits laitiers"));
        ingredients.add(new Ingredient("Pepperonis", "Legumes"));
        ingredients.add(new Ingredient("Basilic", "Legumes"));
        ingredients.add(new Ingredient("Oignons", "Herbes et epices"));

        ingredientAdapter ingredientAdapter = new ingredientAdapter(this, ingredients);


        // Trouver le listView défini dans activity_ingredient identifié par "liste"
        ListView listView = (ListView) findViewById(R.id.list);

// Faire en sorte que le listView utiliser le ArrayAdapter qu'on a crée grâce à la méthode
// serAdapter
        listView.setAdapter(ingredientAdapter);
    }



}
