package effet;

import java.util.Observable;

import joueurs.Joueur;
import main.Manche;

// TODO: Auto-generated Javadoc
/**
 * The Class EffetRejouer.
 */
public class EffetRejouer extends Observable implements Effet {

	/* (non-Javadoc)
	 * @see effet.Effet#lancer(joueurs.Joueur, main.Manche)
	 */
	public void lancer(Joueur leJoueur, Manche laManche) {
		this.addObserver(leJoueur);
		setChanged();
		notifyObservers(leJoueur.getNom() + " doit rejouer une carte!");
		System.out.println(leJoueur.getNom() + " doit rejouer une carte!");
		leJoueur.choisirUneCarte(laManche);
	}
}
