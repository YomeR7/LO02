package effet;

import jeu.Paquet;
import jeu.Tas;
import joueurs.Joueur;
import main.Manche;

public class EffetRejouer implements Effet {

	public void lancer(Joueur leJoueur,Tas leTas, Paquet lePaquet, Manche laManche) {
		System.out.println(leJoueur.getNom() + " doit rejouer une carte!");
		leJoueur.choisirUneCarte(leTas, lePaquet,laManche);
	}
}
