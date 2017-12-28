package effet;

import jeu.Paquet;
import jeu.Tas;
import joueurs.Joueur;
import main.Manche;


public class EffetPiocher2 implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Tas leTas, Paquet lePaquet, Manche laManche) {
		// TODO Auto-generated method stub
		if (lePaquet.getCartes().size() < 2) {
			lePaquet.setCartes(leTas.getCartesDessous());
			leTas.viderCartesDessous();
			System.out.println("Le paquet a �t� chang� et se m�lange");
			lePaquet.melanger();
		}
		System.out.println(leJoueur.getNom() + " pioche 2 cartes!\n");
		
		leJoueur.getSesCartes().add(lePaquet.piocherUneCarte());
		leJoueur.getSesCartes().add(lePaquet.piocherUneCarte());
		laManche.changerJoueurEnCours();
	}

}
