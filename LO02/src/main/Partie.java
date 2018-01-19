package main;

import java.util.ArrayList;
import java.util.Scanner;

import joueurs.Joueur;

// TODO: Auto-generated Javadoc
/**
 * La classe repr�sente la mise en place d'une partie de 8 am�ricain.
 * C'est un singleton.
 * 
 * @author Florian
 *
 */

public class Partie {
	
	/** The MAX score. */
	private int MAXScore = 0;
	
	/** The sc. */
	private Scanner sc;
	
	/** The les joueurs. */
	private ArrayList<Joueur> lesJoueurs;
	
	/** La partie unique (singleton). */
	private static Partie PARTIE = new Partie();

	/**
	 * Permet de r�cup�rer le singleton
	 *
	 * @return l'unique partie
	 */
	public static Partie getInstance() {
		return PARTIE;
	}

	/**
	 * La m�thode met � jour les informations de la partie.
	 *
	 * @param lesJoueurs Les joueurs de la partie
	 */
	public void updateP(ArrayList<Joueur> lesJoueurs) {
		this.lesJoueurs = lesJoueurs;
	}
	
	public int getMAXScore() {
		return MAXScore;
	}
	
	public void setMAXScore(int mAXScore) {
		MAXScore = mAXScore;
	}
	
	public ArrayList<Joueur> getLesJoueurs() {
		return lesJoueurs;
	}
	
	public void setLesJoueurs(ArrayList<Joueur> lesJoueurs) {
		this.lesJoueurs = lesJoueurs;
	}

	/**
	 * Lancer partie.
	 *
	 * @return the manche
	 */
	public Manche lancerPartie() {
		if (MAXScore <= 100) {
			return new Manche();
		}
		int minScore = MAXScore;
		for (int i = 0; i < lesJoueurs.size(); i++) {
			if (getLesJoueurs().get(i).getScore() < minScore) {
				minScore = getLesJoueurs().get(i).getScore();
			}

		}
		for (int i = 0; i < lesJoueurs.size(); i++) {
			if (getLesJoueurs().get(i).getScore() == minScore) {
				System.out.println(getLesJoueurs().get(i).getNom() + " a gagn� la partie!");
			}
		}
		return null;
	}

}
