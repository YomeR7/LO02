package effet;

import jeu.Paquet;
import jeu.Tas;
import joueurs.Joueur;
import main.Manche;

public interface Effet {
	
	public void lancer(Joueur leJoueur,Tas leTas, Paquet lePaquet, Manche laManche);
}
