package jeu;

/**
 * La classe Carte.
 */
public class Carte {
	
	/** Les points attaché à une carte. */
	private int points;
	
	/** La valeur et couleur de la carte. */
	private String couleur,valeur;
	
	
	/**
	 * Constructeur de carte.
	 *
	 * @param valeur la valeur
	 * @param couleur la couleur
	 * @param points les points
	 */
	
	public Carte(String valeur, String couleur, int points) {
		this.valeur = valeur;
		this.couleur = couleur;
		this.points = points;
	
	}
	

	/**
	 * Constructeur d'une carte vide.
	 */
	public Carte() {
		this.valeur = "0";
		this.couleur = "0";
	}
	
	/**
	 * Constructeur d'une carte seulement par rapport à sa valeur.
	 *
	 * @param string une valeur
	 */
	public Carte(String string) {
		// TODO Auto-generated constructor stub
		this.valeur = string;
	}
	
	/**
	 * Getter de valeur.
	 *
	 * @return la valeur
	 */
	public String getValeur() {
		return valeur;
	}
	
	/**
	 * Setter valeur.
	 *
	 * @param valeur une valeur
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	/**
	 * Getter couleur.
	 *
	 * @return la couleur
	 */
	public String getCouleur() {
		return couleur;
	}
	
	/**
	 * Setter couleur.
	 *
	 * @param couleur la couleur
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}	
	
	/**
	 * Getter points.
	 *
	 * @return les points
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Setter points.
	 *
	 * @param points nouveaux points
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
