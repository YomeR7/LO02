package strategie;

import jeu.Paquet;
import jeu.Tas;
import joueurs.Joueur;
import main.Manche;

// TODO: Auto-generated Javadoc
/**
 * The Interface Difficulte.
 */
public interface Difficulte {

	/**
	 * Appliquer.
	 *
	 * @param leJoueur the le joueur
	 * @param laManche the la manche
	 */
	public void appliquer(Joueur leJoueur, Manche laManche);
	
}
