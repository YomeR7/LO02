package joueurs;

import jeu.Paquet;
import jeu.Tas;
import main.Manche;
import strategie.Difficulte;

// TODO: Auto-generated Javadoc
/**
 * The Class JoueurArtificiel.
 */
public class JoueurArtificiel extends Joueur {

	/** The niveau. */
	private Difficulte niveau;

	/**
	 * Instantiates a new joueur artificiel.
	 *
	 * @param nom the nom
	 * @param id the id
	 * @param niveau the niveau
	 * Cette methode crée un joueur IA en lui associant un nom et un niveau de Difficulté 
	 *
	 */
	public JoueurArtificiel(String nom, byte id, Difficulte niveau) {
		super(nom, id);
		this.niveau = niveau;
	}

	/* (non-Javadoc)
	 * @see joueurs.Joueur#choisirUneCarte(main.Manche)
	 */
	public void choisirUneCarte(Manche laManche) {
		super.choisirUneCarte(laManche);
		numCarte = 1;
		carteChoisi = sesCartes.get(numCarte - 1);
		niveau.appliquer(this,laManche);
	}

	/* (non-Javadoc)
	 * @see joueurs.Joueur#trierCartes()
	 */
	@Override
	public void trierCartes() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see joueurs.Joueur#afficherCartes()
	 */
	@Override
	public void afficherCartes() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see joueurs.Joueur#afficherCartesG()
	 */
	@Override
	public void afficherCartesG() {
		// TODO Auto-generated method stub
		
	}

}
