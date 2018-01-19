package variante;
import java.util.HashMap;

import effet.Effet;

/**
 * La classe Variante.
 * Cette classe et ses classes filles va gérer les differentes variante du jeu 
 * Chaque variante differe par les effet associé au cartes 
 */
public class Variante {
	
	/** Valeur effet attaque. */
	protected HashMap<String, Effet> valeurEffetDefense,valeurEffetAttaque;
	
	/** Valeur contre. */
	protected String nom,valeurContre;

	/**
	 * Constructeur, permet de lier une carte a un effet 
	 * Ce constructeur est redefini dans toute les classes héritant de Variante
	 */
	public Variante() {
		valeurEffetDefense = new HashMap<String, Effet>();
		valeurEffetAttaque = new HashMap<String, Effet>();
	}
	
	public HashMap<String, Effet> getValeurEffetDefense() {
		return valeurEffetDefense;
	}

	public void setValeurEffetDefense(HashMap<String, Effet> valeurEffetDefense) {
		this.valeurEffetDefense = valeurEffetDefense;
	}


	public HashMap<String, Effet> getValeurEffetAttaque() {
		return valeurEffetAttaque;
	}


	public void setValeurEffetAttaque(HashMap<String, Effet> valeurEffetAttaque) {
		this.valeurEffetAttaque = valeurEffetAttaque;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getValeurContre() {
		return valeurContre;
	}

	public void setValeurContre(String valeurContre) {
		this.valeurContre = valeurContre;
	}	
	
}
