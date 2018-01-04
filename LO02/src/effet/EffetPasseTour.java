package effet;

import joueurs.Joueur;
import main.Manche;

public class EffetPasseTour implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		System.out.println(leJoueur.getNom() + " passe son tour!\n");
		laManche.changerJoueurEnCours();
	}
}
