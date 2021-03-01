
package champollion;

import java.util.Date;

/**
 *
 * @author mohamednossirat
 */
public class Intervention {
    private int duree;
    private Date date;
    private Enseignant ensignant;
    private UE cours;
    private TypeIntervention type;
    private Salle lieu;
    
    public Intervention(int duree, Date date, Enseignant enseignant, UE cours, TypeIntervention type, Salle lieu){
        this.duree = duree;
        this.date = date; 
        this.ensignant = enseignant;
        this.cours = cours;
        this.type = type;
        this.lieu = lieu;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Enseignant getEnsignant() {
        return ensignant;
    }

    public void setEnsignant(Enseignant ensignant) {
        this.ensignant = ensignant;
    }

    public UE getCours() {
        return cours;
    }

    public void setCours(UE cours) {
        this.cours = cours;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }

    public Salle getLieu() {
        return lieu;
    }

    public void setLieu(Salle lieu) {
        this.lieu = lieu;
    }
    
    
}
