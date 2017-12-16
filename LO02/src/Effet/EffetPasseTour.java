package Effet;

import Jeu.Paquet;
import Jeu.Tas;
import Joueurs.Joueur;
import main.Manche;

public class EffetPasseTour implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Tas leTas, Paquet lePaquet, Manche laManche) {
		// TODO Auto-generated method stub
		System.out.println(leJoueur.getNom() + " passe son tour!\n");
		laManche.changerJoueurEnCours();
	}
}
