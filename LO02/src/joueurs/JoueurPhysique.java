package joueurs;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import jeu.Carte;
import main.Manche;

/**
 * The Class JoueurPhysique.
 */
public class JoueurPhysique extends Joueur {
	
	/** attente vue. */
	private boolean attenteVue = true;

	/**
	 * Checks if is attente vue.
	 *
	 * @return true, if is attente vue
	 */
	public boolean isAttenteVue() {
		return attenteVue;
	}

	/**
	 * Sets the attente vue.
	 *
	 * @param attenteVue the new attente vue
	 */
	public void setAttenteVue(boolean attenteVue) {
		this.attenteVue = attenteVue;
	}

	/**
	 * Constructeur du joueur physique.
	 *
	 * @param nom le nom
	 * @param id id
	 */
	public JoueurPhysique(String nom, byte id) {
		super(nom, id);
		setCarteChoisi(new Carte());
	}
	
	/**
	 * La méthode afficherCartes permet d'afficher dans console ces cartes puis choisir une carte.
	 */
	public void afficherCartes() {
		for (int i = 0; i < sesCartes.size(); i++) {
			System.out.println(i + 1 + " : " + sesCartes.get(i));
		}
		choisirUneCarteC(laManche);
	}

	/**
	 * La méthode redefinie permet de mettre en attente le thread.
	 * Tant que l'utilisateur de choisi pas de carte on ne continue pas.
	 * 
	 * @param laManche la manche
	 */
	public void choisirUneCarte(Manche laManche) {
		super.choisirUneCarte(laManche);
		setChanged();
		notifyObservers();
		while (attenteVue) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.setAttenteVue(true);
	}
	
	/**
	 * Choisir une carte mode console.
	 * Permet de choisir une carte via la console
	 *
	 * @param laManche la manche
	 */
	public void choisirUneCarteC(Manche laManche) {
		// TODO Auto-generated method stub
		super.choisirUneCarte(laManche);
		Scanner sccc = new Scanner(System.in);
		System.out.println("\nChoisis une de tes cartes (entre 1 et " + sesCartes.size() + ")\n0 : Piocher une carte");
		numCarte = sccc.nextInt();
		if (numCarte != 0 && numCarte <= sesCartes.size()) {
			carteChoisi = sesCartes.get(numCarte - 1);
			// System.out.println(carteChoisi);
			this.finirTour();
		} else if (numCarte > sesCartes.size()) {
			System.out.println("Tu n'as pas autant de cartes! Choisis une carte entre 1 et " + sesCartes.size());
			this.choisirUneCarte(this.laManche);
		} else {
			sesCartes.add(laManche.getLePaquet().piocherUneCarte());
			laManche.getLeTas().afficherCarteVisible();
		}

	}

	/**
	 * La méthode permet de trier les cartes grâce à une double comparaison
	 */
	public void trierCartes() {
		Collections.sort(sesCartes, new Comparator<Carte>() {
			@Override
			public int compare(Carte c1, Carte c2) {
				if (c1.getCouleur().compareTo(c2.getCouleur()) == 0) {
																		
					return c1.getValeur().compareTo(c2.getValeur()); 
				} else {
					return c1.getCouleur().compareTo(c2.getCouleur());
				}
			}
		});
	}

	/*
	 * La méthode permet de finir le tour et débloquer l'attente
	 */
	public void finirTour() {
		// TODO Auto-generated method stub
		super.finirTour();
		this.setAttenteVue(false);
	}

}
