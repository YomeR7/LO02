package main;

import java.util.Scanner;

public class JoueurPhysique extends Joueur {

	public JoueurPhysique(String nom,int id) {
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
		Scanner sc = new Scanner(System.in);
		System.out.println("\nChoisis une de tes cartes (1 ou 2 ou 3 etc) ou choisis 0 pour piocher une carte.");
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

}
