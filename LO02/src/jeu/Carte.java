package jeu;

// TODO: Auto-generated Javadoc
/**
 * The Class Carte.
 */
public class Carte {
	
	/** The points. */
	private int points;
	
	/** The valeur. */
	private String couleur,valeur;
	
	
	/**
	 * Instantiates a new carte.
	 *
	 * @param valeur the valeur
	 * @param couleur the couleur
	 */
	public Carte(String valeur, String couleur) {
		this.valeur = valeur;
		this.couleur = couleur;
	}
	
	/**
	 * Instantiates a new carte.
	 *
	 * @param valeur the valeur
	 * @param couleur the couleur
	 * @param points the points
	 */
	//surcharge quand le mode de comptage est en négatif, + affichage comptage des points
	public Carte(String valeur, String couleur, int points) {
		this.valeur = valeur;
		this.couleur = couleur;
		this.points = points;
	
	}
	

	/**
	 * Instantiates a new carte.
	 */
	public Carte() {
		this.valeur = "0";
		this.couleur = "0";
	}
	
	/**
	 * Instantiates a new carte.
	 *
	 * @param string the string
	 */
	public Carte(String string) {
		// TODO Auto-generated constructor stub
		this.valeur = string;
	}
	
	/**
	 * Gets the valeur.
	 *
	 * @return the valeur
	 */
	public String getValeur() {
		return valeur;
	}
	
	/**
	 * Sets the valeur.
	 *
	 * @param valeur the new valeur
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	/**
	 * Gets the couleur.
	 *
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}
	
	/**
	 * Sets the couleur.
	 *
	 * @param couleur the new couleur
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}	
	
	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Sets the points.
	 *
	 * @param points the new points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
			return valeur + " de " + couleur;	
	}

}
