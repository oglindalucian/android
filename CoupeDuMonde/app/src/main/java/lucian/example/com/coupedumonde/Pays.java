package lucian.example.com.coupedumonde;

/**
 * Created by lucian on 2018-01-24.
 */


public class Pays {
    private String nom;
    private String capitale;
    private int photo;

    public Pays(String nom, String capitale, int photo) {
        this.nom=nom;
        this.capitale=capitale;
        this.photo=photo;
    }


    public String getNom() {return this.nom;}
    public String getCapitale() {return this.capitale;}
    public void setNom(String nom) {this.nom=nom;}
    public void setCapitale(String capitale) {this.capitale=capitale;}
    public int getPhoto() {return this.photo;}
    public void setPhoto(int photo) {this.photo=photo;}
}
