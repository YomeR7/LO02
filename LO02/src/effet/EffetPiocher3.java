package effet;

import joueurs.Joueur;
import main.Manche;

public class EffetPiocher3 implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		if (laManche.getLePaquet().getCartes().size() < 3) {
			laManche.getLePaquet().setCartes(laManche.getLeTas().getCartesDessous());
			laManche.getLeTas().viderCartesDessous();
			System.out.println("Le paquet a �t� chang� et se m�lange");
			laManche.getLePaquet().melanger();
		}
		System.out.println(leJoueur.getNom() + " pioche 3 cartes!\n");
		
		leJoueur.getSesCartes().add(laManche.getLePaquet().piocherUneCarte());
		leJoueur.getSesCartes().add(laManche.getLePaquet().piocherUneCarte());
		leJoueur.getSesCartes().add(laManche.getLePaquet().piocherUneCarte());
		laManche.changerJoueurEnCours();
	}

}
