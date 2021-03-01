package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
    private int volumeCM;
	private int volumeTD;
	private int volumeTP;
	private final UE ue;

    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP, UE ue) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.ue = ue;
    }
    
    public UE getUe(){
        return ue;
    }

    public int getVolumeCM() {
        return volumeCM;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }
    // return les resultats par type de UE //
    public int getVolumPourCours(TypeIntervention type){
        int resultat = 0;
        switch(type){
            case CM : resultat = getVolumeCM();
            break;
            case TD : resultat = getVolumeTD();
            break;
            case TP : resultat = getVolumeTP();
            break;
        }
        return resultat;
    }
        

}
