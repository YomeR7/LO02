package Effet;

import Jeu.Paquet;
import Jeu.Tas;
import Joueurs.Joueur;
import main.Manche;

public class EffetPiocher implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Tas leTas, Paquet lePaquet, Manche laManche) {
		// TODO Auto-generated method stub
		System.out.println(leJoueur.getNom() + " pioche une carte!\n");
		leJoueur.getSesCartes().add(lePaquet.piocherUneCarte());
		laManche.changerJoueurEnCours();
	}

}
