package joueurs;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import jeu.Carte;
import jeu.Paquet;
import jeu.Tas;
import main.Manche;

// TODO: Auto-generated Javadoc
/**
 * The Class JoueurPhysique.
 */
public class JoueurPhysique extends Joueur {
	
	/** The attente vue. */
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
	 * Instantiates a new joueur physique.
	 *
	 * @param nom the nom
	 * @param id the id
	 */
	public JoueurPhysique(String nom, byte id) {
		super(nom, id);
		setCarteChoisi(new Carte());
	}

	/* (non-Javadoc)
	 * @see joueurs.Joueur#afficherCartes()
	 */
	public void afficherCartes() {
		for (int i = 0; i < sesCartes.size(); i++) {
			System.out.println(i + 1 + " : " + sesCartes.get(i));
		}
		choisirUneCarteC(laManche);
	}
	
	/* (non-Javadoc)
	 * @see joueurs.Joueur#afficherCartesG()
	 */
	public void afficherCartesG() {
	}

	/* (non-Javadoc)
	 * @see joueurs.Joueur#choisirUneCarte(main.Manche)
	 */
	public void choisirUneCarte(Manche laManche) {
		super.choisirUneCarte(laManche);
		setChanged();
		notifyObservers();
		while (attenteVue) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated caxtch block
				e.printStackTrace();
			}
		}
		this.setAttenteVue(true);
	}
	
	/**
	 * Choisir une carte C.
	 *
	 * @param laManche the la manche
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
		} else if (numCarte == 13) {
			System.out.println(laManche.getLeTas().getCartesDessous());
		} else if (numCarte > sesCartes.size()) {
			System.out.println("Tu n'as pas autant de cartes! Choisis une carte entre 1 et " + sesCartes.size());
			this.choisirUneCarte(this.laManche);
		} else {
			sesCartes.add(laManche.getLePaquet().piocherUneCarte());
			laManche.getLeTas().afficherCarteVisible();
		}

	}

	/* (non-Javadoc)
	 * @see joueurs.Joueur#trierCartes()
	 */
	public void trierCartes() {
		Collections.sort(sesCartes, new Comparator<Carte>() {
			@Override
			public int compare(Carte c1, Carte c2) {
				if (c1.getCouleur().compareTo(c2.getCouleur()) == 0) { // Si la couleur est égale pour les deux cartes
																		// comparés
					return c1.getValeur().compareTo(c2.getValeur()); // Alors on compare les valeur
				} else { // Sinon, les cartes ont une couleur différente
					return c1.getCouleur().compareTo(c2.getCouleur()); // Le tri doit s'effectuer sur la couleur
				}
			}
		});
	}

	/* (non-Javadoc)
	 * @see joueurs.Joueur#finirTour()
	 */
	public void finirTour() {
		// TODO Auto-generated method stub
		super.finirTour();
		this.setAttenteVue(false);
	}

}
