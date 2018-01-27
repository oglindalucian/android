package lucian.example.com.pizzaiolo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// Nouvelles classes importées
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int nbPizza = 2;
    int prixUnitaire = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_ingredients = (Button) findViewById(R.id.button_ingredients);
        button_ingredients.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                specifierIngredient(v);
            }
        });
    }

    /**
     * Méthode envoyerCommande est appelée à chaque fois
     * qu'on clique sur le bouton "Commander".
     */
    public void envoyerCommande(View view) {
        afficher(nbPizza);
        afficherPrix(nbPizza*prixUnitaire);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Commande de Pizzaiolo");
        intent.putExtra(Intent.EXTRA_TEXT,"Vous avez commandez " + nbPizza +
                " Pizza.\n Le total est: " +nbPizza*prixUnitaire +"$\n Merci!\n\n L'application Pizzaiolo.");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void ajouter (View view){
        nbPizza++;
        afficher(nbPizza);
    }

    public void retirer (View view){
        if (nbPizza == 1){
            return;
        }
        nbPizza--;
        afficher(nbPizza);
    }

    /**
     * Méthode permet d'afficher un nombre donné en paramètre
     * dans le TextView.
     */
    private void afficher(int quantite) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantite_text_view);
        quantityTextView.setText("" + quantite);
    }

    private void afficherPrix (int prix){
        TextView prixTextView = (TextView) findViewById(R.id.prixFinal);
        prixTextView.setText(NumberFormat.getCurrencyInstance().format(prix));
        Log.v("MainActivity", "Le prix calcule est: "+prix);
    }

    public void specifierIngredient(View view) { //NEW WINDOW
        Intent intent = new Intent(this, IngredientActivity.class);
        startActivity(intent);
    }

    public void telephonner (String nr) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + nr));
        if(intent.resolveActivity(getPackageManager())!=null) {
            startActivity(intent);
        }
    }

    public void telephonnerNb() {
        telephonner("5140000000");
    }

}

