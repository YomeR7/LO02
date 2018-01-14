package main;

import java.util.ArrayList;
import java.util.Scanner;

import joueurs.Joueur;
import joueurs.JoueurArtificiel;
import joueurs.JoueurPhysique;
import strategie.Aggresif;
import strategie.Difficulte;
import strategie.Facile;

// TODO: Auto-generated Javadoc
/**
 * La classe représente la mise en place d'une partie de 8 américain.
 * 
 * @author Florian
 *
 */

public class Partie {

	/** The nb IA. */
	private byte nbIA;
	
	/** The MAX score. */
	private int MAXScore = 0;
	
	/** The sc. */
	private Scanner sc;
	
	/** The les joueurs. */
	private ArrayList<Joueur> lesJoueurs;
	
	/** The les difficultes. */
	private ArrayList<Difficulte> lesDifficultes;

	/**
	 * Le constructeur partie crée tout le système du jeu: choix du nom du joueur,
	 * nombre d'IA, leurs difficultés puis lance les manches du jeu.
	 */

	/*
	 * private Partie() { System.out.println("PQ?");
	 * 
	 * sc = new Scanner(System.in);
	 * 
	 * System.out.println("Quel est votre nom?"); String nomJoueur = sc.nextLine();
	 * 
	 * System.out.println("Veuillez choisir le nombre d'IA"); nbIA = sc.nextByte();
	 * JoueurPhysique moi = new JoueurPhysique(nomJoueur, nbIA);
	 * 
	 * System.out.
	 * println("Veuillez choisir le mode de comptage (1 : positif ou 0 : negatif)");
	 * modeComptage = sc.nextByte(); while (modeComptage != 1 && modeComptage != 0)
	 * { System.out.println("Ce mode de comptage n'existe pas! \nEssaye encore ;)");
	 * modeComptage = sc.nextByte(); }
	 * 
	 * lesJoueurs = new ArrayList<Joueur>(); lesDifficultes = new
	 * ArrayList<Difficulte>(); lesDifficultes.add(new Facile());
	 * lesDifficultes.add(new Aggresif()); for (byte i = 0; i < nbIA; i++) {
	 * System.out.println("\nChoisir la difficulté de l'IA" + (i + 1) +
	 * "\n0: Facile\n1: Aggressif\n"); JoueurArtificiel IA = new
	 * JoueurArtificiel("IA" + (i + 1), i, lesDifficultes.get(sc.nextInt()));
	 * lesJoueurs.add(IA); }
	 * 
	 * lesJoueurs.add(moi);
	 * 
	 * }
	 */

	private Partie() {
	}

	/**
	 * Update P.
	 *
	 * @param lesJoueurs the les joueurs
	 */
	public void updateP(ArrayList<Joueur> lesJoueurs) {
		this.nbIA = (byte) lesJoueurs.size();
		this.lesJoueurs = lesJoueurs;
	}

	/**
	 * Gets the nb IA.
	 *
	 * @return the nb IA
	 */
	public int getNbIA() {
		return nbIA;
	}

	/**
	 * Sets the nb IA.
	 *
	 * @param nbIA the new nb IA
	 */
	public void setNbIA(byte nbIA) {
		this.nbIA = nbIA;
	}

	/**
	 * Gets the single instance of Partie.
	 *
	 * @return single instance of Partie
	 */
	public static Partie getInstance() {
		return PARTIE;
	}

	/** The partie. */
	private static Partie PARTIE = new Partie();

	/**
	 * Gets the MAX score.
	 *
	 * @return the MAX score
	 */
	public int getMAXScore() {
		return MAXScore;
	}

	/**
	 * Sets the MAX score.
	 *
	 * @param mAXScore the new MAX score
	 */
	public void setMAXScore(int mAXScore) {
		MAXScore = mAXScore;
	}

	/**
	 * Gets the les joueurs.
	 *
	 * @return the les joueurs
	 */
	public ArrayList<Joueur> getLesJoueurs() {
		return lesJoueurs;
	}

	/**
	 * Sets the les joueurs.
	 *
	 * @param lesJoueurs the new les joueurs
	 */
	public void setLesJoueurs(ArrayList<Joueur> lesJoueurs) {
		this.lesJoueurs = lesJoueurs;
	}

	/**
	 * Nouvelle manche.
	 *
	 * @return the manche
	 */
	public Manche nouvelleManche() {
		return new Manche();
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
				System.out.println(getLesJoueurs().get(i).getNom() + " a gagné la partie!");
			}
		}
		return null;
	}

}
