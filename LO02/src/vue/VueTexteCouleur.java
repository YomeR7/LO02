package vue;

import joueurs.JoueurPhysique;
import main.Manche;

// TODO: Auto-generated Javadoc
/**
 * The Class VueTexteCouleur.
 */
public class VueTexteCouleur implements Runnable{
	
	/** The moi. */
	private JoueurPhysique moi;
	
	/** The la manche. */
	private Manche laManche;

	/**
	 * Instantiates a new vue texte couleur.
	 *
	 * @param joueur the joueur
	 * @param manche the manche
	 */
	VueTexteCouleur(JoueurPhysique joueur, Manche manche) {
		this.laManche = manche;
		this.moi = joueur;
		Thread t = new Thread(this);
		t.start();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("Choisis une couleur.\n");
	}
	
	
}
