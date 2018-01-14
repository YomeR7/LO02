package effet;

import java.util.Observable;

import joueurs.Joueur;
import main.Manche;

// TODO: Auto-generated Javadoc
/**
 * The Class EffetPiocher3.
 */
public class EffetPiocher3 extends Observable implements Effet {

	/* (non-Javadoc)
	 * @see effet.Effet#lancer(joueurs.Joueur, main.Manche)
	 */
	@Override
	public void lancer(Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		this.addObserver(leJoueur);
		setChanged();
		notifyObservers(leJoueur.getNom() + " pioche 3 cartes!");
		if (laManche.getLePaquet().getCartes().size() < 3) {
			laManche.getLePaquet().setCartes(laManche.getLeTas().getCartesDessous());
			laManche.getLeTas().viderCartesDessous();
			System.out.println("Le paquet a été changé et se mélange");
			laManche.getLePaquet().melanger();
		}
		System.out.println(leJoueur.getNom() + " pioche 3 cartes!\n");
		
		leJoueur.getSesCartes().add(laManche.getLePaquet().piocherUneCarte());
		leJoueur.getSesCartes().add(laManche.getLePaquet().piocherUneCarte());
		leJoueur.getSesCartes().add(laManche.getLePaquet().piocherUneCarte());
		laManche.changerJoueurEnCours();
	}

}
