package effet;

import joueurs.Joueur;
import main.Manche;

// TODO: Auto-generated Javadoc
/**
 * The Interface Effet.
 */
public interface Effet {

	/**
	 * Lancer.
	 *
	 * @param leJoueur the le joueur
	 * @param laManche the la manche
	 */
	public void lancer(Joueur leJoueur, Manche laManche);
}
