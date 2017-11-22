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
		byte points[] = { 20, 3, 4, 5, 6, 20, 50, 9, 20, 20, 10, 10, 50}; 
			
		
		int k = 0;
		for (int i=0;i<couleur.length;i++) {
			for (int j=0;j<valeur.length;j++) {
				if (Partie.getInstance().getModeComptage() == 0) {
					cartes.add(k, new Carte(valeur[j],couleur[i],points[j])); // ajout de modeComptage pour affichage
				} else {
					cartes.add(k, new Carte(valeur[j],couleur[i]));
				}
				k++;
			}
		}
	}

	public void melanger() {
		Collections.shuffle(cartes);
	}
	
	public void distribuer() {
		int carteParJoueur = 0;
		if (Partie.getInstance().getLesJoueurs().length >= 4) {
			carteParJoueur = 6;
		} else if (Partie.getInstance().getLesJoueurs().length == 3) {
			carteParJoueur = 8;
		} else if (Partie.getInstance().getLesJoueurs().length == 2) {
			carteParJoueur = 10;
		}
		for (int i=0;i<Partie.getInstance().getLesJoueurs().length;i++) {
			ArrayList<Carte> cartesDuJoueur = new ArrayList<Carte>(cartes.subList(0, carteParJoueur));
			Partie.getInstance().getLesJoueurs()[i].setSesCartes(cartesDuJoueur);
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

	public ArrayList<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(ArrayList<Carte> cartes) {
		this.cartes = cartes;
	}
}


		
	
