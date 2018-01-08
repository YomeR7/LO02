package effet;

import java.util.Observable;

import joueurs.Joueur;
import main.Manche;

public class EffetRejouer extends Observable implements Effet {

	public void lancer(Joueur leJoueur, Manche laManche) {
		this.addObserver(leJoueur);
		setChanged();
		notifyObservers(leJoueur.getNom() + " doit rejouer une carte!");
		System.out.println(leJoueur.getNom() + " doit rejouer une carte!");
		leJoueur.choisirUneCarte(laManche);
	}
}
