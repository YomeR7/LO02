package effet;

import java.util.Observable;

import joueurs.Joueur;
import main.Manche;

public class EffetChangeSens extends Observable implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		System.out.println("Le sens du jeu a changé!");
		laManche.setSens((byte) -(laManche.getSens()));
		this.addObserver(leJoueur);
		setChanged();
		notifyObservers("Le sens du jeu a changé!");
	}

}
