package vue;

import joueurs.JoueurPhysique;

/**
 * The Class VueTexte. Elle permet l'affiche en console
 */
public class VueTexte implements Runnable{
	
	/** Moi: le joueur physique. */
	private JoueurPhysique moi;

	/**
	 * Constructeur de la classe que lance un thread.
	 *
	 * @param joueur le joueur
	 */
	public VueTexte(JoueurPhysique joueur) {
		this.moi = joueur;
		Thread t = new Thread(this);
		t.start();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	/**
	 * Le lancement du thread permet d'afficher en parallèle les cartes dans la console.
	 */
	public void run() {
		System.out.println("Choisis une carte à jouer.\n");
		moi.afficherCartes();
	}
	
	
}
