package effet;

import jeu.Paquet;
import jeu.Tas;
import joueurs.Joueur;
import main.Manche;

public class EffetChangeSens implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Tas leTas, Paquet lePaquet, Manche laManche) {
		// TODO Auto-generated method stub
		System.out.println("Le sens du jeu a changé!");
		laManche.setSens((byte) -(laManche.getSens()));
	}

}
