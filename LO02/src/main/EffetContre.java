package main;

import java.util.Scanner;

public class EffetContre extends Effet {

	public void lancer(Joueur leJoueur, Tas leTas, Paquet lePaquet) {
		String nouvCouleur;
		if (leJoueur instanceof JoueurPhysique) {
			System.out.println(
					"Choisis une nouvelle couleur! Ecris en toute lettre:\n'Carreau' ou 'Coeur' ou 'Pique' ou 'Trefle'");
			Scanner sc = new Scanner(System.in);
			nouvCouleur = sc.nextLine();
		} else {
			String couleur[] = { "Pique", "Carreau", "Trefle", "Coeur" };
			int rnd = (int) (4 * Math.random());
			nouvCouleur = couleur[rnd];
		}
		Carte nouvCarteVisible = leTas.getCarteVisible();
		nouvCarteVisible.setCouleur(nouvCouleur);
		leTas.setCarteVisible(nouvCarteVisible);
		System.out.println("La nouvelle couleur est " + nouvCouleur + ".");

	}
}
