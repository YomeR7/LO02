package main;

import java.util.Scanner;

/**
 * La classe représente la mise en place d'une partie de 8 américain.
 * 
 * @author Florian
 *
 */

public class Partie {
	
	private byte modeComptage;
	private int nbIA,test;
	private Scanner sc,s;
	
	/**
	 * Le constructeur partie crée tout le système du jeu: choix du nom du joueur, nombre d'IA, leurs difficultés puis lance les manches du jeu.
	 */
	
	public Partie() {
		
		sc = new Scanner(System.in);	
		
		System.out.println("Quel est votre nom?");
		String nomJoueur = sc.nextLine();
		
		System.out.println("Veuillez choisir le nombre d'IA");
		nbIA = sc.nextInt();		
		JoueurPhysique moi = new JoueurPhysique(nomJoueur,nbIA);
		//System.out.println(moi.getNom());
		
		System.out.println("Veuillez choisir le mode de comptage (1 : positif ou 0 : negatif)");
		s = new Scanner(System.in);
		modeComptage = s.nextByte();
		while (modeComptage != 1 && modeComptage != 0) {
			System.out.println("Ce mode de comptage n'existe pas! \nEssaye encore ;)");
			s = new Scanner(System.in);
			modeComptage = s.nextByte();
		}
		
		JoueurArtificiel ia[] = new JoueurArtificiel[nbIA];
		for (int i=0;i<nbIA;i++) {
			System.out.println("\nChoisir la difficulté de l'IA"+(i+1)+" (1,2 ou 3)");
			int diff = sc.nextInt();
			JoueurArtificiel IA = new JoueurArtificiel("IA"+(i+1),i,diff);
			ia[i] = IA;
		}
				
		Manche manche1 = new Manche(nbIA, moi, ia, modeComptage);
		
	}

	
	public byte getModeComptage() {
		return modeComptage;
	}
	public void setModeComptage(byte modeComptage) {
		this.modeComptage = modeComptage;
	}
	public int getNbIA() {
		return nbIA;
	}
	public void setNbIA(int nbIA) {
		this.nbIA = nbIA;
	}
	
	

}
