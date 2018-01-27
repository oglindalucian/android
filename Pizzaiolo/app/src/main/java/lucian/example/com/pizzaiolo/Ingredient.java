package lucian.example.com.pizzaiolo;

/**
 * Created by lucian on 2018-01-20.
 */

public class Ingredient {
    private String nomIngredient;
    private String CatergorieIngredient;

    public Ingredient(String nom, String categorie) {
        this.nomIngredient = nom;
        this.CatergorieIngredient = categorie;
    }

    public String getNomIngredient() {
        return nomIngredient;
    }

    public String getCategorieIngredient() {
        return CatergorieIngredient;
    }
}

