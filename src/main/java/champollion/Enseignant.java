package champollion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
    
    //ilste de interventions //
    private final HashSet<Intervention> interventions = new HashSet<>();
    
    //list des enseignements prévus//
    private final HashMap<UE, ServicePrevu> enseignements = new HashMap<>();
    //Set des UE pour lesquels l'enseignant intervient//
    public Set<UE> UEPrevues() {
		return enseignements.keySet();
	}
    
    
    
    public Enseignant(String nom, String email) {
        super(nom, email);
    }
    
    public void ajouteIntervention(Intervention inter) {
		if (!enseignements.containsKey(inter.getCours())) {
			throw new IllegalArgumentException("La matière ne fait pas partie des enseignements");
		}

		interventions.add(inter);
	}
    public int heuresPlanifiee() {
		float result = 0f;
		for (Intervention inter : interventions) {
			result += equivalentCours(inter.getType(), inter.getDuree());
		}

		return Math.round(result);
	}
    private int equivalentCours(TypeIntervention type, int horaires) {
		float result = 0f;
		switch (type) {
			case CM:
				result = horaires * 1.5f;
				break;
			case TD:
				result = horaires;
				break;
			case TP:
				result = horaires * 0.75f;
				break;
		}
		return Math.round(result);
	}
    

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
		float result = 0f;
		for (UE ue : enseignements.keySet()) {
			result += heuresPrevuesPourUE(ue);
		}
		return Math.round(result);
	}
    

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
		float result = 0;

		ServicePrevu p = enseignements.get(ue);
		if (p != null) {
			result = 
				p.getVolumeCM() * 1.5f
				+ p.getVolumeTD()
				+ p.getVolumeTP() * 0.75f
			;
		}
		return Math.round(result);
	}

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        if (volumeCM < 0 | volumeTD < 0 | volumeTP < 0) {
			throw new IllegalArgumentException("Les valeurs doivent être positives");
		}

		ServicePrevu s = enseignements.get(ue);
		if (s == null) { // Pas de UE
			s = new ServicePrevu(volumeCM, volumeTD, volumeTP, ue);
			enseignements.put(ue, s);
		} else { // Mette à jour le service prévu pour cette UE
			s.setVolumeCM(volumeCM + s.getVolumeCM());
			s.setVolumeTD(volumeTD + s.getVolumeTD());
			s.setVolumeTP(volumeTP + s.getVolumeTP());
		}
    }
    

}
