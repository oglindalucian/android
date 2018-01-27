package lucian.example.com.pizzaiolo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by lucian on 2018-01-20.
 */

public class ingredientAdapter extends ArrayAdapter<Ingredient> {
public ingredientAdapter (Activity context, ArrayList<Ingredient> ingredients) {
    super(context, 0, ingredients);
}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Vérifier si la vue existante est réutiliser
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.element_liste, parent, false);
        }


        // Obtenir l'objet ingredient qui se trouve à cette position de la liste
        Ingredient ingredient = getItem(position);

        // Trouver le TextView ingredient_textView dans le layout element_liste.xml
        TextView ingredientTextView = (TextView) listItemView.findViewById(R.id.ingredient_textView);
        // Obtenir le nom de l'ingrédient courant dans la liste et modifier
        //  le TextView avec cette valeur
        ingredientTextView.setText(ingredient.getNomIngredient());

        // Trouver le TextView ingredient_textView dans le layout element_liste.xml
        TextView categorieTextView = (TextView) listItemView.findViewById(R.id.categorie_textView);
        // Obtenir la catégorie de l'ingredient courant dans la liste et modifier
        //  le TextView avec cette valeur
        categorieTextView.setText(ingredient.getCategorieIngredient());

        // Retourner la liste entière avec le nouvel layout
        return listItemView;
    }


}
