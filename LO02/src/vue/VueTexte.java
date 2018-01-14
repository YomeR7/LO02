package vue;

import joueurs.JoueurPhysique;

// TODO: Auto-generated Javadoc
/**
 * The Class VueTexte.
 */
public class VueTexte implements Runnable{
	
	/** The moi. */
	private JoueurPhysique moi;

	/**
	 * Instantiates a new vue texte.
	 *
	 * @param joueur the joueur
	 */
	VueTexte(JoueurPhysique joueur) {
		this.moi = joueur;
		Thread t = new Thread(this);
		t.start();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("Choisis une carte à jouer.\n");
		moi.afficherCartes();
	}
	
	
}
