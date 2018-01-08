package main;

import java.util.ArrayList;
import java.util.Scanner;

import joueurs.Joueur;
import joueurs.JoueurArtificiel;
import joueurs.JoueurPhysique;
import strategie.Aggresif;
import strategie.Difficulte;
import strategie.Facile;

/**
 * La classe représente la mise en place d'une partie de 8 américain.
 * 
 * @author Florian
 *
 */

public class Partie {

	private byte nbIA;
	private int MAXScore = 0;
	private Scanner sc;
	private ArrayList<Joueur> lesJoueurs;
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

	public void updateP(ArrayList<Joueur> lesJoueurs) {
		this.nbIA = (byte) lesJoueurs.size();
		this.lesJoueurs = lesJoueurs;
	}

	public int getNbIA() {
		return nbIA;
	}

	public void setNbIA(byte nbIA) {
		this.nbIA = nbIA;
	}

	public static Partie getInstance() {
		return PARTIE;
	}

	private static Partie PARTIE = new Partie();

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

	public Manche nouvelleManche() {
		return new Manche();
	}

	public void lancerPartie() {
		while (MAXScore <= 100) {
			new Manche();
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
	}

}
