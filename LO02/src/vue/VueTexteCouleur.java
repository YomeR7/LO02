package vue;

import joueurs.JoueurPhysique;
import main.Manche;

public class VueTexteCouleur implements Runnable{
	
	private JoueurPhysique moi;
	private Manche laManche;

	VueTexteCouleur(JoueurPhysique joueur, Manche manche) {
		this.laManche = manche;
		this.moi = joueur;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void run() {
		System.out.println("Choisis une couleur.\n");
	}
	
	
}
