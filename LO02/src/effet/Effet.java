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
	 * 
	 * Cette methode est redefinie dans les classes implementant l'interface Effet 
	 * Elle contiendra le code permettant de créer l'effet que l'on souhaite associer a une carte
	 * 
	 */
	public void lancer(Joueur leJoueur, Manche laManche);
}
