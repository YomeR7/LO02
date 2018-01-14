package effet;

import java.util.Observable;

import joueurs.Joueur;
import main.Manche;

// TODO: Auto-generated Javadoc
/**
 * The Class EffetChangeSens.
 */
public class EffetChangeSens extends Observable implements Effet {

	/* (non-Javadoc)
	 * @see effet.Effet#lancer(joueurs.Joueur, main.Manche)
	 */
	@Override
	public void lancer(Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		System.out.println("Le sens du jeu a changé!");
		laManche.setSens((byte) -(laManche.getSens()));
		this.addObserver(leJoueur);
		setChanged();
		notifyObservers("Le sens du jeu a changé!");
	}

}
