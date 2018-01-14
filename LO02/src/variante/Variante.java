package variante;
import java.util.HashMap;

import effet.Effet;

// TODO: Auto-generated Javadoc
/**
 * The Class Variante.
 */
public class Variante {
	
	/** The valeur effet attaque. */
	protected HashMap<String, Effet> valeurEffetDefense,valeurEffetAttaque;
	
	/** The valeur contre. */
	protected String nom,valeurContre;

	/**
	 * Instantiates a new variante.
	 */
	public Variante() {
		valeurEffetDefense = new HashMap<String, Effet>();
		valeurEffetAttaque = new HashMap<String, Effet>();
	}
	
	/**
	 * Gets the valeur effet defense.
	 *
	 * @return the valeur effet defense
	 */
	public HashMap<String, Effet> getValeurEffetDefense() {
		return valeurEffetDefense;
	}


	/**
	 * Sets the valeur effet defense.
	 *
	 * @param valeurEffetDefense the valeur effet defense
	 */
	public void setValeurEffetDefense(HashMap<String, Effet> valeurEffetDefense) {
		this.valeurEffetDefense = valeurEffetDefense;
	}


	/**
	 * Gets the valeur effet attaque.
	 *
	 * @return the valeur effet attaque
	 */
	public HashMap<String, Effet> getValeurEffetAttaque() {
		return valeurEffetAttaque;
	}


	/**
	 * Sets the valeur effet attaque.
	 *
	 * @param valeurEffetAttaque the valeur effet attaque
	 */
	public void setValeurEffetAttaque(HashMap<String, Effet> valeurEffetAttaque) {
		this.valeurEffetAttaque = valeurEffetAttaque;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Gets the valeur contre.
	 *
	 * @return the valeur contre
	 */
	public String getValeurContre() {
		return valeurContre;
	}

	/**
	 * Sets the valeur contre.
	 *
	 * @param valeurContre the new valeur contre
	 */
	public void setValeurContre(String valeurContre) {
		this.valeurContre = valeurContre;
	}	
	
}
