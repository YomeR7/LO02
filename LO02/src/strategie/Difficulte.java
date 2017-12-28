package strategie;

import jeu.Paquet;
import jeu.Tas;
import joueurs.Joueur;
import main.Manche;

public interface Difficulte {

	public void appliquer(Tas leTas, Paquet lePaquet, Joueur leJoueur, Manche laManche);
	
}
