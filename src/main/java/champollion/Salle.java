
package champollion;

/**
 *
 * @author mohamednossirat
 */
public class Salle {
    private String nom;
    private int capasite;

    public Salle(String nom, int capasite) {
        this.nom = nom;
        this.capasite = capasite;
    }

    @Override
    public String toString() {
        return "Salle{" + "nom=" + nom + ", capasite=" + capasite + '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapasite() {
        return capasite;
    }

    public void setCapasite(int capasite) {
        this.capasite = capasite;
    }
    

}
