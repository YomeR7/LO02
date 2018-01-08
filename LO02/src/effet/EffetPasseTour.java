package effet;

import java.util.Observable;

import joueurs.Joueur;
import main.Manche;

public class EffetPasseTour extends Observable implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		this.addObserver(leJoueur);
		setChanged();
		notifyObservers(leJoueur.getNom() + " passe son tour!");
		System.out.println(leJoueur.getNom() + " passe son tour!\n");
		laManche.changerJoueurEnCours();
	}
}
