package main;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class JoueurPhysique extends Joueur {

	public JoueurPhysique(String nom,byte id) {
		super(nom,id);
		// TODO Auto-generated constructor stub
	}
	
	public void afficherCartes() {
		for (int i = 0; i < sesCartes.size(); i++) {
			System.out.println(i+1 + " : " + sesCartes.get(i));
		}
	}

	public void choisirUneCarte(Tas leTas, Paquet lePaquet) {
		// TODO Auto-generated method stub
		trierCartes();
		Scanner sc = new Scanner(System.in);
		System.out.println("\nChoisis une de tes cartes (1 ou 2 ou 3 etc)\n0 : Piocher une carte");
		numCarte = sc.nextInt();
		if (numCarte != 0 && numCarte != 13) {
			carteChoisi = sesCartes.get(numCarte-1);
			//System.out.println(carteChoisi);
			this.poserCarte(leTas,lePaquet);
		} else if (numCarte == 13) {
			System.out.println(leTas.getCartesDessous());
		} else {
			sesCartes.add(lePaquet.piocherUneCarte());
			leTas.afficherCarteVisible();
		}
		
	}
	
	public void trierCartes() {
		Collections.sort(sesCartes, new Comparator<Carte>() {
		    @Override
		    public int compare(Carte c1, Carte c2) {
		        if(c1.getCouleur().compareTo(c2.getCouleur()) == 0) { // Si la couleur est �gale pour les deux cartes compar�s
		          return c1.getValeur().compareTo(c2.getValeur()); // Alors on compare les valeur
		        } else { // Sinon, les cartes ont une couleur diff�rente
		          return c1.getCouleur().compareTo(c2.getCouleur()); // Le tri doit s'effectuer sur la couleur
		        }
		    }
		});
		
		//Collections.sort(sesCartes,  new Comparator<Carte>() {
			
		//});
	}

}
