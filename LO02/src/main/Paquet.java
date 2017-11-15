package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Paquet {
	
	private int nbCarte = 52;
	private ArrayList<Carte> cartes; 
	private static int posPaquet=0;

	public Paquet() {
		super();
		cartes = new ArrayList<Carte>();
		
		String valeur[] = {"2","3","4","5","6","7","8","9","10","Valet","Dame","Roi","As"};
		String couleur[] = {"Pique","Carreau","Trefle","Coeur"};
		
		int k = 0;
		for (int i=0;i<couleur.length;i++) {
			for (int j=0;j<valeur.length;j++) {
				cartes.add(k, new Carte(valeur[j],couleur[i]));
				k++;
			}
		}
	}

	public void melanger() {
		Collections.shuffle(cartes);
	}
	
	public void distribuer(int nbJ, Joueur[] joueurs) {
		int carteParJoueur = 0;
		if (nbJ >= 4) {
			carteParJoueur = 6;
		} else if (nbJ == 3) {
			carteParJoueur = 8;
		} else if (nbJ == 2) {
			carteParJoueur = 10;
		}
		joueurs[0].setSesCartes(new ArrayList<Carte>(cartes.subList(0, 6)));
		for (int i=0;i<nbJ;i++) {
			 joueurs[i].setSesCartes(new ArrayList<Carte>(cartes.subList(carteParJoueur*i, carteParJoueur*i+carteParJoueur)));
		}
		for (int i = 0; i < (nbCarte-carteParJoueur*nbJ);i++){
			cartes.set(i, cartes.get(i+carteParJoueur*nbJ));
		}
		for (int i = (nbCarte-carteParJoueur*nbJ);i < nbCarte;i++) {
			cartes.set(i, new Carte());
		}
	}
	
	public void afficherCartes() {
		 for (int i=0;i<nbCarte;i++) {
			System.out.println(cartes.get(i));
		} 
	}
	
	public Carte piocherUneCarte() {
		Carte cartePioche = cartes.get(posPaquet);
		cartes.set(posPaquet, new Carte());
		posPaquet++;
		return cartePioche;
	}
}


		
	
