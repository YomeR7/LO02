package effet;

import joueurs.Joueur;
import main.Manche;

public class EffetRejouer implements Effet {

	public void lancer(Joueur leJoueur, Manche laManche) {
		System.out.println(leJoueur.getNom() + " doit rejouer une carte!");
		leJoueur.choisirUneCarte(laManche);
	}
}
