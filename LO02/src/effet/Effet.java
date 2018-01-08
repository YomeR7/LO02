package effet;

import joueurs.Joueur;
import main.Manche;

public interface Effet {

	public void lancer(Joueur leJoueur, Manche laManche);
}
