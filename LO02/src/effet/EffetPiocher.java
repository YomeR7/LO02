package effet;

import joueurs.Joueur;
import main.Manche;

public class EffetPiocher implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		System.out.println(leJoueur.getNom() + " pioche une carte!\n");
		leJoueur.getSesCartes().add(laManche.getLePaquet().piocherUneCarte());
		laManche.changerJoueurEnCours();
	}

}
