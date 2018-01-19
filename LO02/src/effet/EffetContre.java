package effet;

import java.util.Scanner;

import jeu.Carte;
import joueurs.Joueur;
import joueurs.JoueurPhysique;
import main.Manche;

import java.util.ArrayList;
import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * The Class EffetContre.
 */
public class EffetContre extends Observable implements Effet,Runnable {
	
	/** The n couleur. */
private String nCouleur;
	
	/** The attente. */
	private boolean attente;
	
	/** The couleurs. */
	private ArrayList<String> couleurs;
	
	/**
	 * Instantiates a new effet contre.
	 */
	public EffetContre() {
		super();
		couleurs = new ArrayList<String>();
		couleurs.add("Carreau");
		couleurs.add("Coeur");
		couleurs.add("Pique");
		couleurs.add("Trefle");
	}
	
	/**
	 * Gets the n couleur.
	 *
	 * @return the n couleur
	 */
	public String getnCouleur() {
		return nCouleur;
	}

	/**
	 * Sets the n couleur.
	 *
	 * @param nCouleur the new n couleur
	 */
	public void setnCouleur(String nCouleur) {
		this.nCouleur = nCouleur;
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

	/* (non-Javadoc)
	 * @see effet.Effet#lancer(joueurs.Joueur, main.Manche)
	 */
	public void lancer(Joueur leJoueur, Manche laManche) {
		this.addObserver(leJoueur);
		setChanged();
		notifyObservers("Changement de couleurs!");
		Thread t = new Thread(this);
		t.start();
		if (leJoueur instanceof JoueurPhysique) {
			setAttente(true);
						while (attente) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else { 
			//if (Partie.getInstance())
			int rnd = (int) (4 * Math.random());
			nCouleur = couleurs.get(rnd);
		}
					
		laManche.getLeTas().addCartesDessous(laManche.getLeTas().getCarteVisible());
		laManche.getLeTas().setCarteVisible(new Carte("0", nCouleur,0));
		System.out.println("La nouvelle couleur est " + nCouleur + ".");
		leJoueur.getSesCartes().remove(leJoueur.getCarteChoisi());

	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("\nChoisis une nouvelle couleur! Ecris en toute lettre:\n' 0 : Carreau' ou ' 1 : Coeur' ou '2 : Pique' ou ' 3 :Trefle'");
		Scanner sc = new Scanner(System.in);
		
		int choixCouleur = sc.nextInt();
		while (choixCouleur > 3) {
			System.out.println("Cette Couleur n'existe pas , choisis en une autre");
			choixCouleur = sc.nextInt();
		} 
		nCouleur = couleurs.get(choixCouleur);
		setAttente(false);
	}
}
