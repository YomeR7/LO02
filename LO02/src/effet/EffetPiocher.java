package effet;

import java.util.Observable;

import joueurs.Joueur;
import main.Manche;

public class EffetPiocher extends Observable implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		this.addObserver(leJoueur);
		setChanged();
		notifyObservers(leJoueur.getNom() + " pioche une carte!");
		System.out.println(leJoueur.getNom() + " pioche une carte!\n");
		leJoueur.getSesCartes().add(laManche.getLePaquet().piocherUneCarte());
		laManche.changerJoueurEnCours();
	}

}
