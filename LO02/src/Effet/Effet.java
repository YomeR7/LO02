package Effet;

import Jeu.Paquet;
import Jeu.Tas;
import Joueurs.Joueur;
import main.Manche;

public interface Effet {
	
	public void lancer(Joueur leJoueur,Tas leTas, Paquet lePaquet, Manche laManche);
}
