package effet;

import java.util.Scanner;

import jeu.Carte;
import joueurs.Joueur;
import joueurs.JoueurPhysique;
import main.Manche;

import java.util.ArrayList;

public class EffetContre implements Effet {
// il reste toujours a regler l'erreur quand on ne choisi la bonne couleur (choixCouleur > 3 
	public void lancer(Joueur leJoueur, Manche laManche) {
		String nouvCouleur;
		ArrayList<String> couleur = new ArrayList<String>();
		couleur.add("Carreau");
		couleur.add("Coeur");
		couleur.add("Pique");
		couleur.add("Trefle");
		if (leJoueur instanceof JoueurPhysique) {
			System.out.println("\nChoisis une nouvelle couleur! Ecris en toute lettre:\n' 0 : Carreau' ou ' 1 : Coeur' ou '2 : Pique' ou ' 3 :Trefle'");
			Scanner sc = new Scanner(System.in);
			
			int choixCouleur = sc.nextInt();
			while (choixCouleur > 3) {
				System.out.println("Cette Couleur n'existe pas , choisis en une autre");
				choixCouleur = sc.nextInt();
			} 
			nouvCouleur = couleur.get(choixCouleur);
		} else { 
			//if (Partie.getInstance())
			int rnd = (int) (4 * Math.random());
			nouvCouleur = couleur.get(rnd);
		}
		
				
			
		Carte nouvCarteVisible = laManche.getLeTas().getCarteVisible();
		System.out.println("CARTE AVANT CHANGEMENT  " + nouvCarteVisible);
		laManche.getLeTas().addCartesDessous(laManche.getLeTas().getCarteVisible());
		nouvCarteVisible.setCouleur(nouvCouleur);
		laManche.getLeTas().setCarteVisible(nouvCarteVisible);
		System.out.println("La nouvelle couleur est " + nouvCouleur + ".");
		leJoueur.getSesCartes().remove(leJoueur.getCarteChoisi());

	}
}
