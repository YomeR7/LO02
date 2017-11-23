package main;

import java.util.Scanner;

/**
 * La classe représente la mise en place d'une partie de 8 américain.
 * 
 * @author Florian
 *
 */

public class Partie {

	private byte nbIA, modeComptage;
	private int MAXScore = 0;
	private Scanner sc;
	private Joueur[] lesJoueurs;

	/**
	 * Le constructeur partie crée tout le système du jeu: choix du nom du joueur,
	 * nombre d'IA, leurs difficultés puis lance les manches du jeu.
	 */

	private Partie() {

		sc = new Scanner(System.in);

		System.out.println("Quel est votre nom?");
		String nomJoueur = sc.nextLine();

		System.out.println("Veuillez choisir le nombre d'IA");
		nbIA = sc.nextByte();
		JoueurPhysique moi = new JoueurPhysique(nomJoueur, nbIA);

		System.out.println("Veuillez choisir le mode de comptage (1 : positif ou 0 : negatif)");
		modeComptage = sc.nextByte();
		while (modeComptage != 1 && modeComptage != 0) {
			System.out.println("Ce mode de comptage n'existe pas! \nEssaye encore ;)");
			modeComptage = sc.nextByte();
		}

		lesJoueurs = new Joueur[nbIA + 1];
		for (byte i = 0; i < nbIA; i++) {
			System.out.println("\nChoisir la difficulté de l'IA" + (i + 1) + " (1,2 ou 3)");
			byte diff = sc.nextByte();
			JoueurArtificiel IA = new JoueurArtificiel("IA" + (i + 1), i, diff);
			lesJoueurs[i] = IA;
		}

		lesJoueurs[nbIA] = moi;

	}

	private static Partie INSTANCE = new Partie();

	public byte getModeComptage() {
		return modeComptage;
	}

	public void setModeComptage(byte modeComptage) {
		this.modeComptage = modeComptage;
	}

	public int getNbIA() {
		return nbIA;
	}

	public void setNbIA(byte nbIA) {
		this.nbIA = nbIA;
	}

	public static Partie getInstance() {
		return INSTANCE;
	}

	public int getMAXScore() {
		return MAXScore;
	}

	public void setMAXScore(int mAXScore) {
		MAXScore = mAXScore;
	}

	public Joueur[] getLesJoueurs() {
		return lesJoueurs;
	}

	public void setLesJoueurs(Joueur[] lesJoueurs) {
		this.lesJoueurs = lesJoueurs;
	}

	public void lancerPartie() {
		if (modeComptage == 0) {
			while (MAXScore <= 100) {
				new Manche();
			}
		}
	}

}
