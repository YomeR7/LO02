package strategie;

import Jeu.Paquet;
import Jeu.Tas;
import Joueurs.Joueur;
import main.Manche;

public class Facile implements Difficulte {

	@Override
	public void appliquer(Tas leTas, Paquet lePaquet, Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		if (leJoueur.comparerCarte(leTas)) {
			leJoueur.poserCarte(leTas, lePaquet,laManche);
		}
		while (!leJoueur.comparerCarte(leTas)) {
			if (leJoueur.numCarte < leJoueur.sesCartes.size()) {
				leJoueur.numCarte++;
				leJoueur.setCarteChoisi(leJoueur.sesCartes.get(leJoueur.numCarte - 1));
				leJoueur.poserCarte(leTas, lePaquet,laManche);
			} else {
				leJoueur.sesCartes.add(lePaquet.piocherUneCarte());
				System.out.println("L'" + leJoueur.getNom() + " pioche une carte!");
				leTas.afficherCarteVisible();
				return;
			}
		}
	}

}
