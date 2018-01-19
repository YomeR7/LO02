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
	 * Cette methode appliquer est redefinie dans les classe implementant l'interface Difficulté
	 * Elle permet permet d'appliquer une difficulté, Facile ou Aggressif, a un joueur IA 
	 *
	 * @param leJoueur le joueur
	 * @param laManche la manche
	 */
	public void appliquer(Joueur leJoueur, Manche laManche);
	
}
