package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Paquet {
	
	private byte nbCarte = 52;
	private ArrayList<Carte> cartes; 

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
		for (int i=0;i<nbJ;i++) {
			ArrayList<Carte> cartesDuJoueur = new ArrayList<Carte>(cartes.subList(0, carteParJoueur));
			joueurs[i].setSesCartes(cartesDuJoueur);
			cartes.removeAll(cartesDuJoueur); 
		}
	}
	
	public void afficherCartes() {
		 for (int i=0;i<cartes.size();i++) {
			System.out.println(cartes.get(i));
		} 
	}
	
	public Carte piocherUneCarte() {
		Carte cartePioche = cartes.get(0);
		cartes.remove(0);
		return cartePioche;
	}
}


		
	
