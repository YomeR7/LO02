package main;

import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;

import jeu.Paquet;
import jeu.Tas;
import joueurs.*;
import variante.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Manche.
 */
public class Manche extends Observable implements Runnable {

	/** Random et sens et byte car le codage int est inutile. */
	private byte sens = 1, rnd;
	
	/** joueur en cours. */
	private Joueur joueurEnCours;
	
	/** scanner */
	private Scanner sc;
	
	/** nb manche. */
	private static byte nbManche = 0;
	
	/** variante manche. */
	private Variante varianteManche;
	
	/** le paquet. */
	private Paquet lePaquet;
	
	/** le tas. */
	private Tas leTas;
	
	/** HashMap des variantes permettant de lié une valeur avec un classe de variante. */
	private HashMap<String, Variante> lesVariantes;
	
	/** The attente. */
	private boolean attente = false;

	
	public byte getSens() {
		return sens;
	}
	
	public void setSens(byte sens) {
		this.sens = sens;
	}
	
	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}
	
	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}
	
	public Variante getVarianteManche() {
		return varianteManche;
	}
	
	public void setVarianteManche(String nomManche) {
		varianteManche = lesVariantes.get(nomManche);
	}
	
	public static byte getNbManche() {
		return nbManche;
	}
	
	public static void setNbManche(byte nbManche) {
		Manche.nbManche = nbManche;
	}
	
	public Paquet getLePaquet() {
		return lePaquet;
	}
	
	public void setLePaquet(Paquet lePaquet) {
		this.lePaquet = lePaquet;
	}
	
	public Tas getLeTas() {
		return leTas;
	} 
	
	public void setLeTas(Tas leTas) {
		this.leTas = leTas;
	}

	/**
	 * Constructeur de la manche. Permet de mettre en place les variables.
	 */
	public Manche() {

		lesVariantes = new HashMap<String, Variante>();
		lesVariantes.put("Variante Minimale", new VarianteMinimale());
		lesVariantes.put("Variante Monclar", new VarianteMonclar());
		lesVariantes.put("Variante Maou", new VarianteCarteMaou());
		lesVariantes.put("Variante Man et Rasta", new VarianteManRasta());
		lesVariantes.put("Variante 5", new Variante5());

		nbManche++;
	}

	/**
	 * Commencer manche permet de récupérer le tas.
	 *
	 * @return le tas
	 */
	public Tas commencerManche() {
		lePaquet = new Paquet(varianteManche);
		lePaquet.melanger();
		lePaquet.distribuer();
		leTas = new Tas(lePaquet);
		return leTas;
	}

	/**
	 * Jouer tour Graphique et en console.
	 */
	public void jouerTourG() {
		joueurEnCours.trierCartes();
		joueurEnCours.afficherCartes();
		joueurEnCours.choisirUneCarte(this);
		if (joueurEnCours.uneCarteEstChoisi() && joueurEnCours.isEffetActif()) {
			joueurEnCours.appliquerEffet(this);
		}
		if (joueurEnCours.getSesCartes().size() > 1) {
			this.changerJoueurEnCours();
		} else if (joueurEnCours.getSesCartes().size() == 0) {
			mancheFinie();
		}
	}

	/**
	 * Gets the joueur suivant.
	 *
	 * @return the joueur suivant
	 */
	public Joueur getJoueurSuivant() {
		return Partie.getInstance().getLesJoueurs()
				.get((joueurEnCours.getId() + sens) % (Partie.getInstance().getLesJoueurs().size()));
	}

	/**
	 * Manche finie permet de terminer un manche. Les joueurs comptes leurs points
	 */
	private void mancheFinie() {
		// TODO Auto-generated method stub
		System.out.println(joueurEnCours.getNom() + " a gagné la manche!\n");
		for (int i = 0; i < Partie.getInstance().getLesJoueurs().size(); i++) {
			Partie.getInstance().getLesJoueurs().get(i).compterSesPoints();
			
		}

		if (nbManche != 1) {
			for (int i = 0; i < Partie.getInstance().getLesJoueurs().size(); i++) {
				System.out.println(Partie.getInstance().getLesJoueurs().get(i).getNom() + " a au total "
						+ Partie.getInstance().getLesJoueurs().get(i).getScore() + " points.\n");
				if (Partie.getInstance().getMAXScore() < Partie.getInstance().getLesJoueurs().get(i).getScore()) {
					Partie.getInstance().setMAXScore(Partie.getInstance().getLesJoueurs().get(i).getScore());
				}
			}
		}
		setChanged();
		notifyObservers("fin");
	}

	/**
	 * Méthode permettant de dire carte et contre carte. Etait seulement utilisable lors du livrable 2.
	 */
	public void uneCarte() {
		Scanner scc = new Scanner(System.in);
		System.out.println(joueurEnCours.getNom() + " n'a plus qu'une carte!\nDis 'carte' ou 'contre carte'. ");
		long t1 = System.currentTimeMillis();
		long delai = 8100, t2;
		String direCarte = scc.nextLine();
		if (!direCarte.isEmpty()) {
			t2 = System.currentTimeMillis();
			delai = t2 - t1;
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (delai <= 4000) {
			if (joueurEnCours instanceof JoueurArtificiel && direCarte.equals("contre carte")) {
				System.out.println("Tu as contré " + joueurEnCours.getNom() + "! Il poche 2 cartes.");
				joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
				joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
				this.changerJoueurEnCours();
			} else if (joueurEnCours instanceof JoueurPhysique && direCarte.equals("carte")) {
				System.out.println("Bravo! Tu ne t'es pas fait contrer!");
				this.changerJoueurEnCours();
			} else {
				if (Math.random() >= 0.5) {
					System.out.println(joueurEnCours.getNom() + " s'est fait contrer par un autre joueur!");
					joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
					joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
				} else {
					System.out.println(joueurEnCours.getNom() + " n'a pas été contré!");
				}
				this.changerJoueurEnCours();
			}
		} else if (joueurEnCours instanceof JoueurPhysique) {
			System.out.println("Tu n'as pas été assez rapide. Tu pioches 2 cartes.");
			joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
			joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
			this.changerJoueurEnCours();
		} else {
			System.out.println("Tu n'as pas été assez rapide, dommage!");
			this.changerJoueurEnCours();
		}
	}

	/**
	 * Checks if is attente.
	 *
	 * @return true, if is attente
	 */
	public boolean isAttente() {
		return attente;
	}

	/**
	 * Sets the attente.
	 *
	 * @param attente the new attente
	 */
	public void setAttente(boolean attente) {
		this.attente = attente;
	}

	/**
	 * Changer joueur en cours en fonction du sens.
	 */
	public void changerJoueurEnCours() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (joueurEnCours.getId() == 0 && sens == -1) {
			joueurEnCours = Partie.getInstance().getLesJoueurs().get(Partie.getInstance().getLesJoueurs().size() - 1);
		} else {
			joueurEnCours = Partie.getInstance().getLesJoueurs()
					.get((joueurEnCours.getId() + sens) % (Partie.getInstance().getLesJoueurs().size()));
		}
		setChanged();
		notifyObservers();
	}

	/*
	 * Methode run lié au thread de la manche. Elle permet d'enchainer les tours de jeu jusqu'à la fin de la manche.
	 */
	public void run() {
		// TODO Auto-generated method stub
		rnd = (byte) (Partie.getInstance().getLesJoueurs().size() * (Math.random()));
		joueurEnCours = Partie.getInstance().getLesJoueurs().get(rnd);
		setChanged();
		notifyObservers();
		while (this.getJoueurEnCours().getSesCartes().size() != 0) {
			if (lePaquet.getCartes().size() == 0) {
				lePaquet.setCartes(leTas.getCartesDessous());
				leTas.viderCartesDessous();
				System.out.println("Le paquet a été changé et se mélange");
				lePaquet.melanger();
			}
			if (leTas.isAvoirEffet()) {
				leTas.setAvoirEffet(false);
				joueurEnCours.subirEffet(leTas, lePaquet, this);
			}
			this.jouerTourG();
			while (attente) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
