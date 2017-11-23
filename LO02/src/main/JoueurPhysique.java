package main;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class JoueurPhysique extends Joueur {

	public JoueurPhysique(String nom, byte id) {
		super(nom, id);
		// TODO Auto-generated constructor stub
	}

	public void afficherCartes() {
		for (int i = 0; i < sesCartes.size(); i++) {
			System.out.println(i + 1 + " : " + sesCartes.get(i));
		}
	}

	public void choisirUneCarte(Tas leTas, Paquet lePaquet) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("\nChoisis une de tes cartes (entre 1 et " + sesCartes.size() + ")\n0 : Piocher une carte");
		numCarte = sc.nextInt();
		if (numCarte != 0 && numCarte <= sesCartes.size()) {
			carteChoisi = sesCartes.get(numCarte - 1);
			// System.out.println(carteChoisi);
			this.poserCarte(leTas, lePaquet);
		} else if (numCarte == 13) {
			System.out.println(leTas.getCartesDessous());
		} else if (numCarte > sesCartes.size()) {
			System.out.println("Tu n'as pas autant de cartes! Choisis une carte entre 1 et " + sesCartes.size());
			this.choisirUneCarte(leTas, lePaquet);
		} else {
			sesCartes.add(lePaquet.piocherUneCarte());
			leTas.afficherCarteVisible();
		}

	}

	public void trierCartes() {
		Collections.sort(sesCartes, new Comparator<Carte>() {
			@Override
			public int compare(Carte c1, Carte c2) {
				if (c1.getCouleur().compareTo(c2.getCouleur()) == 0) { // Si la couleur est égale pour les deux cartes
																		// comparés
					return c1.getValeur().compareTo(c2.getValeur()); // Alors on compare les valeur
				} else { // Sinon, les cartes ont une couleur différente
					return c1.getCouleur().compareTo(c2.getCouleur()); // Le tri doit s'effectuer sur la couleur
				}
			}
		});
	}

}
