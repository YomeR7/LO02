package strategie;

import jeu.Paquet;
import jeu.Tas;
import joueurs.Joueur;
import main.Manche;

// TODO: Auto-generated Javadoc
/**
 * The Class Facile.
 */
public class Facile implements Difficulte {

	/* (non-Javadoc)
	 * @see strategie.Difficulte#appliquer(joueurs.Joueur, main.Manche)
	 */
	@Override
	public void appliquer(Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		if (leJoueur.comparerCarte()) {
			leJoueur.poserCarte();
		}
		while (!leJoueur.comparerCarte()) {
			if (leJoueur.getNumCarte() < leJoueur.getSesCartes().size()) {
				leJoueur.setNumCarte(leJoueur.getNumCarte()+1);
				leJoueur.setCarteChoisi(leJoueur.getSesCartes().get(leJoueur.getNumCarte() - 1));
				leJoueur.poserCarte();
			} else {
				leJoueur.getSesCartes().add(laManche.getLePaquet().piocherUneCarte());
				System.out.println("L'" + leJoueur.getNom() + " pioche une carte!");
				laManche.getLeTas().afficherCarteVisible();
				return;
			}
		}
	}

}
