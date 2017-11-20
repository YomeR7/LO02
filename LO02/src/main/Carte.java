package main;

public class Carte {
	private byte points;
	private String couleur,valeur;
	
	public Carte(String valeur, String couleur) {
		super();
		this.valeur = valeur;
		this.couleur = couleur;
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
	@Override
	public String toString() {
		return valeur + " de " + couleur;
	}

	public byte getPoint() {
		// TODO Auto-generated method stub
		return this.points;
	}
}
