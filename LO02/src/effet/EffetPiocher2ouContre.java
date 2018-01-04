package effet;

import java.util.Scanner;

import jeu.Carte;
import joueurs.Joueur;
import joueurs.JoueurPhysique;
import main.Manche;

public class EffetPiocher2ouContre implements Effet {

	private static byte nbAs = 1;
	@Override
	public void lancer(Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		if (laManche.getLePaquet().getCartes().size() < 2*nbAs) {
			laManche.getLePaquet().setCartes(laManche.getLeTas().getCartesDessous());
			laManche.getLeTas().viderCartesDessous();
			System.out.println("Le paquet a été changé et se mélange");
			laManche.getLePaquet().melanger();
		}
		System.out.println(leJoueur.getNom() + " pioche " + 2*nbAs +" cartes ou Contre!\n");
		
		if (leJoueur.possede("As")) {
			if (leJoueur instanceof JoueurPhysique) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Vous voulez jouer votre As pour contrer? 'oui' ou 'non'/n");
				if (sc.nextLine().equals("oui")) {
					int posAs = leJoueur.getSesCartes().indexOf(new Carte("As"));
					leJoueur.setCarteChoisi(leJoueur.getSesCartes().get(posAs));
					leJoueur.poserCarte();
					nbAs++;
				}
			} else {
				int posAs = leJoueur.getSesCartes().indexOf(new Carte("As"));
				leJoueur.setCarteChoisi(leJoueur.getSesCartes().get(posAs));
				leJoueur.poserCarte();
				nbAs++;
			}
		} else if (leJoueur.possede("8")) {
			if (leJoueur instanceof JoueurPhysique) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Vous voulez jouer votre 8 pour contrer? 'oui' ou 'non'/n");
				if (sc.nextLine().equals("oui")) {
					int pos8 = leJoueur.getSesCartes().indexOf(new Carte("8"));
					leJoueur.setCarteChoisi(leJoueur.getSesCartes().get(pos8));
					leJoueur.poserCarte();
				}
			} else {
				int pos8 = leJoueur.getSesCartes().indexOf(new Carte("8"));
				leJoueur.setCarteChoisi(leJoueur.getSesCartes().get(pos8));
				leJoueur.poserCarte();
			}
		} else {
			System.out.println(leJoueur.getNom() +" ne peut pas contrer donc il pioche...");
			for (byte i = 0; i < 2*nbAs; i++) {
				leJoueur.getSesCartes().add(laManche.getLePaquet().piocherUneCarte());
			}
		}
		
		laManche.changerJoueurEnCours();
	}

}
