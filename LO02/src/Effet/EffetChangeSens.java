package Effet;

import Jeu.Paquet;
import Jeu.Tas;
import Joueurs.Joueur;
import main.Manche;

public class EffetChangeSens implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Tas leTas, Paquet lePaquet, Manche laManche) {
		// TODO Auto-generated method stub
		System.out.println("Le sens du jeu a changé!");
		laManche.setSens((byte) -(laManche.getSens()));
	}

}
