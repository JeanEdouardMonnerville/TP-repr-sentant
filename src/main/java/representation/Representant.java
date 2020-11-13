package representation;
import java.util.ArrayList;

public class Representant {

	private final int numero;
	private final String nom;
	private final String prenom;
	private String adresse;
	private float salaireFixe;
        private ZoneGeographique Secteur;
        private ArrayList<Float> CAMensuel;

	public Representant(int numero, String nom, String prenom, ZoneGeographique Secteur) {
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
                this.Secteur= Secteur;
                CAMensuel= new ArrayList<Float>();
                //on initialise le CA mensuel des 12 mois
                for(int i=0 ;i<12 ;i++){
                    CAMensuel.add(0f);
                }
               
                
	}

	public int getNumero() {
		return numero;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public float getSalaireFixe() {
		return salaireFixe;
	}

	public void setSalaireFixe(float salaireFixe) {
		this.salaireFixe = salaireFixe;
	}

	public ZoneGeographique getSecteur() {
		// On retourne le secteur initialisé dans le constructeur
             
		return Secteur;
	}

	public void setSecteur(ZoneGeographique secteur) {
		// On remplace le secteur crée par un autre
                Secteur=secteur;
		
	}

	/**
	 * Enregistre le CA de ce représentant pour un mois donné. 
	 * @param mois le numéro du mois (de 0 à 11)
	 * @param montant le CA réalisé pour ce mois (positif ou nul)
	 **/
	public void enregistrerCA(int mois, float montant) {
		// vérifier les paramètres
		if (mois < 0 || mois > 11) {
			throw new IllegalArgumentException("Le mois doit être compris entre 0 et 11");
		}
		if (montant < 0) {
			throw new IllegalArgumentException("Le montant doit être positif ou null");
		}
                CAMensuel.add(mois, montant);
                
		
	}

	/**
	 * Calcule le salaire mensuel de ce répresentant pour un mois donné
	 * @param mois le numéro du mois (de 0 à 11)
	 * @param pourcentage le pourcentage (>= 0 ) à appliquer sur le CA réalisé pour ce mois
	 * @return le salaire pour ce mois, tenant compte du salaire fixe, de l'indemnité repas, et du pourcentage sur CA
	 */
	public float salaireMensuel(int mois, float pourcentage) {
		// vérifier les paramètres
		if (mois < 0 || mois > 11) {
			throw new IllegalArgumentException("Le mois doit être compris entre 0 et 11");
		}
                if (pourcentage< 0f || pourcentage > 1f){
                    throw new IllegalArgumentException("Un pourcentage est compris entre 0 et 1");
                }
                //On va chercher le Chiffre d'affaire du mois désiré
                float CA;
                CA=CAMensuel.get(mois);
                //Le salaire est la résultante du pourcentage sur le CA+l'indémnité+le salaire fixe
                return pourcentage*CA+Secteur.getIndemniteRepas()+salaireFixe;
                    
	}

	@Override
	public String toString() {
		return "Representant{" + "numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + '}';
	}

}
