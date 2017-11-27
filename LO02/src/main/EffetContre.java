package main;

import java.util.Scanner;

public class EffetContre implements Effet {

	public void lancer(Joueur leJoueur, Tas leTas, Paquet lePaquet) {
		String nouvCouleur;
		
		String couleur[] = { "Carreau", "Coeur", "Pique", "Trefle" };
		if (leJoueur instanceof JoueurPhysique) {
			System.out.println("\nChoisis une nouvelle couleur! Ecris en toute lettre:\n' 0 : Carreau' ou ' 1 : Coeur' ou '2 : Pique' ou ' 3 :Trefle'");
			Scanner sc = new Scanner(System.in);
			int choixCouleur = sc.nextInt(); 
			if (!(choixCouleur == 0 || choixCouleur == 1 || choixCouleur == 2 || choixCouleur == 3)) {
				System.out.println("Cette Couleur n'existe pas , choisis en une autre");
				this.lancer(leJoueur, leTas, lePaquet);
			}
			nouvCouleur = couleur[choixCouleur];
		} else { 
			int rnd = (int) (4 * Math.random());
			nouvCouleur = couleur[rnd];
		}
		
				
			
		Carte nouvCarteVisible = leTas.getCarteVisible();
		System.out.println("CARTE AVANT CHANGEMENT  " + nouvCarteVisible);
		leTas.addCartesDessous(leTas.getCarteVisible());
		nouvCarteVisible.setCouleur(nouvCouleur);
		leTas.setCarteVisible(nouvCarteVisible);
		System.out.println("La nouvelle couleur est " + nouvCouleur + ".");

	}
}
