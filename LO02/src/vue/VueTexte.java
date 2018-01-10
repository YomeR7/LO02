package vue;

import joueurs.JoueurPhysique;

public class VueTexte implements Runnable{
	
	private JoueurPhysique moi;

	VueTexte(JoueurPhysique joueur) {
		this.moi = joueur;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		System.out.println("Choisis une carte à jouer.\n");
		moi.afficherCartes();
	}
	
	
}
