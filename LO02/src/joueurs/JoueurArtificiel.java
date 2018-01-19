package joueurs;

import main.Manche;
import strategie.Difficulte;

/**
 * La classe JoueurArtificiel.
 */
public class JoueurArtificiel extends Joueur {

	/** Le niveau de difficulté. */
	private Difficulte niveau;

	/**
	 * Constructeur du joueur artificiel.
	 * Cette methode crée un joueur IA en lui associant un nom et un niveau de Difficulté 
	 *
	 * @param nom le nom
	 * @param id id
	 * @param niveau sa difficulté
	 * 
	 *
	 */
	public JoueurArtificiel(String nom, byte id, Difficulte niveau) {
		super(nom, id);
		this.niveau = niveau;
	}

	/**
	 * Choisir une carte.
	 * Permet d'appliquer la difficulté: niveau.appliquer grâce au pattern stratégie.
	 *
	 * @param laManche la manche
	 */
	public void choisirUneCarte(Manche laManche) {
		super.choisirUneCarte(laManche);
		numCarte = 1;
		carteChoisi = sesCartes.get(numCarte - 1);
		niveau.appliquer(this,laManche);
	}

	@Override
	public void trierCartes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherCartes() {
		// TODO Auto-generated method stub
		
	}

}
