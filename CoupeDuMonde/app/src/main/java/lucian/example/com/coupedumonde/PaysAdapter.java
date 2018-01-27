package lucian.example.com.coupedumonde;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lucian on 2018-01-24.
 */

public class PaysAdapter extends ArrayAdapter<Pays> {
    public PaysAdapter (Activity context, ArrayList<Pays> pays) {
        //Initialiser le stockage interne de notre ArrayAdpater pour le context et la liste des ingrédients
        // Le 2ème arguemnt (resource) est utilisé lorsque le ArrayAdapter rempli un unique TextView. Ceci
        // n'est pas notre cas. Donc le adapter ne va pas utiliser ce 2ème argument qu'on choisi de mettre =0
        super(context, 0, pays);
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // Vérifier si la vue existante est réutiliser
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.element_liste, parent, false);
        }


        // Obtenir l'objet ingredient qui se trouve à cette position de la liste
        Pays lePays = getItem(position);

        // Trouver le TextView ingredient_textView dans le layout element_liste.xml
        TextView nomPaysTextView = (TextView) listItemView.findViewById(R.id.pays_textView);
        // Obtenir le nom de l'ingrédient courant dans la liste et modifier
        //  le TextView avec cette valeur
        nomPaysTextView.setText(lePays.getNom());

        // Trouver le TextView ingredient_textView dans le layout element_liste.xml
        TextView capitaleTextView = (TextView) listItemView.findViewById(R.id.capitale_textView);
        // Obtenir la catégorie de l'ingredient courant dans la liste et modifier
        //  le TextView avec cette valeur
        capitaleTextView.setText(lePays.getCapitale());

        ImageView laPhoto = (ImageView)listItemView.findViewById(R.id.drapeau_imageView);
        laPhoto.setImageResource(lePays.getPhoto());

        // Retourner la liste entière avec le nouvel layout
        return listItemView;
    }
}
