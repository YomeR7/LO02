package vue;

import joueurs.JoueurPhysique;
import main.Manche;

/**
 * The Class VueTexteCouleur. Permet de choisir une couleur en ligne de commande
 */
public class VueTexteCouleur implements Runnable{
	
	/** moi. */
	private JoueurPhysique moi;
	
	/** la manche. */
	private Manche laManche;

	/**
	 * Constructeur de la vue qui lance un thread pour la console
	 *
	 * @param joueur le joueur
	 * @param manche la manche
	 */
	public VueTexteCouleur(JoueurPhysique joueur, Manche manche) {
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
