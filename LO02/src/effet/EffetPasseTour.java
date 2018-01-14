package effet;

import java.util.Observable;

import joueurs.Joueur;
import main.Manche;

// TODO: Auto-generated Javadoc
/**
 * The Class EffetPasseTour.
 */
public class EffetPasseTour extends Observable implements Effet {

	/* (non-Javadoc)
	 * @see effet.Effet#lancer(joueurs.Joueur, main.Manche)
	 */
	@Override
	public void lancer(Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		this.addObserver(leJoueur);
		setChanged();
		notifyObservers(leJoueur.getNom() + " passe son tour!");
		System.out.println(leJoueur.getNom() + " passe son tour!\n");
		laManche.changerJoueurEnCours();
	}
}
