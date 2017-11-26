package main;

import java.util.ArrayList;
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
	private ArrayList<Joueur> lesJoueurs;
	private ArrayList<Difficulte> lesDifficultes;

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

		lesJoueurs = new ArrayList<Joueur>();
		lesDifficultes = new ArrayList<Difficulte>();
		lesDifficultes.add(new Facile());
		for (byte i = 0; i < nbIA; i++) {
			System.out.println("\nChoisir la difficulté de l'IA" + (i + 1) + " QUE 1 POUR LE MOMENT!");
			JoueurArtificiel IA = new JoueurArtificiel("IA" + (i + 1), i, lesDifficultes.get(sc.nextInt()-1));
			lesJoueurs.add(IA);
		}

		lesJoueurs.add(moi);

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

	public ArrayList<Joueur> getLesJoueurs() {
		return lesJoueurs;
	}

	public void setLesJoueurs(ArrayList<Joueur> lesJoueurs) {
		this.lesJoueurs = lesJoueurs;
	}

	public void lancerPartie() {
		if (modeComptage == 0) {
			while (MAXScore <= 100) {
				new Manche();
			}
			int minScore = MAXScore;
			for (int i = 0 ; i<lesJoueurs.size() ;i++) {
				if (getLesJoueurs().get(i).getScore() < minScore){
					minScore = getLesJoueurs().get(i).getScore();
				}
				
			}
			for (int i = 0 ; i<lesJoueurs.size() ;i++) {
				if (getLesJoueurs().get(i).getScore() == minScore){
					System.out.println(getLesJoueurs().get(i).getNom() +"a gagné!");
				}
			}
		}
		if (modeComptage == 1) {
			while (MAXScore <= 200) {
				new Manche();
			}
		}
	}

}
