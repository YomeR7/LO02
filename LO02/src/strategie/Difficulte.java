package strategie;

import Jeu.Paquet;
import Jeu.Tas;
import Joueurs.Joueur;
import main.Manche;

public interface Difficulte {

	public void appliquer(Tas leTas, Paquet lePaquet, Joueur leJoueur, Manche laManche);
	
}
