package vue;

import joueurs.JoueurPhysique;
import main.Manche;

public class VueTexte implements Runnable{
	
	private JoueurPhysique moi;
	private Manche laManche;
	private boolean attente;

	VueTexte(JoueurPhysique joueur, Manche manche) {
		this.laManche = manche;
		this.moi = joueur;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		System.out.println("Choisis une carte à jouer.\n");
		moi.afficherCartes();
		moi.choisirUneCarteC(laManche);
	}
	
	
}
