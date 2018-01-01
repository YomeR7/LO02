package strategie;

import jeu.Paquet;
import jeu.Tas;
import joueurs.Joueur;
import main.Manche;

public interface Difficulte {

	public void appliquer(Joueur leJoueur, Manche laManche);
	
}
