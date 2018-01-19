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
	 * 
	 * Cette methode est redefinie dans les classe implementant l'interface Difficulté
	 * Elle permet permet d'appliquer une difficulté, Facile ou Aggressif, a un joueur IA 
	 */
	public void appliquer(Joueur leJoueur, Manche laManche);
	
}
