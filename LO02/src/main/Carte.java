package main;

public class Carte {
	private int points;
	private String couleur,valeur;
	
	
	public Carte(String valeur, String couleur) {
		super();
		this.valeur = valeur;
		this.couleur = couleur;
	}
	//surcharge quand le mode de comptage est en négatif, + affichage comptage des points
	public Carte(String valeur, String couleur, int points) {
		super();
		this.valeur = valeur;
		this.couleur = couleur;
		this.points = points;
	
	}
	

	public Carte() {
		this.valeur = null;
		this.couleur = null;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
			return valeur + " de " + couleur;	
	}
}
