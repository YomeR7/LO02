package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;

import variante.Variante;

// TODO: Auto-generated Javadoc
/**
 * The Class Tas.
 */
public class Tas extends Observable{
	
	/** The carte visible. */
	private Carte carteVisible;
	
	/** The cartes dessous. */
	private HashSet<Carte> cartesDessous;
	
	/** The avoir effet. */
	private boolean avoirEffet = false;
	
	/**
	 * Instantiates a new tas.
	 *
	 * @param lePaquet the le paquet
	 */
	public Tas(Paquet lePaquet) {
		carteVisible = lePaquet.piocherUneCarte();
		cartesDessous = new HashSet<Carte>();
	}

	/**
	 * Gets the cartes dessous.
	 *
	 * @return the cartes dessous
	 */
	public ArrayList<Carte> getCartesDessous() {
		ArrayList<Carte> cartes = new ArrayList<Carte>(cartesDessous);
		return cartes;
	}

	/**
	 * Sets the cartes dessous.
	 *
	 * @param cartesDessous the new cartes dessous
	 */
	public void setCartesDessous(HashSet<Carte> cartesDessous) {
		this.cartesDessous = cartesDessous;
	}

	/**
	 * Checks if is avoir effet.
	 *
	 * @return true, if is avoir effet
	 */
	public boolean isAvoirEffet() {
		return avoirEffet;
	}

	/**
	 * Sets the avoir effet.
	 *
	 * @param avoirEffet the new avoir effet
	 */
	public void setAvoirEffet(boolean avoirEffet) {
		this.avoirEffet = avoirEffet;
	}

	/**
	 * Adds the cartes dessous.
	 *
	 * @param cartesDessous the cartes dessous
	 */
	public void addCartesDessous(Carte cartesDessous) {
		this.cartesDessous.add(cartesDessous);
	}

	/**
	 * Gets the carte visible.
	 *
	 * @return the carte visible
	 */
	public Carte getCarteVisible() {
		return carteVisible;
	}

	/**
	 * Afficher carte visible.
	 */
	public void afficherCarteVisible() {
		System.out.println("La carte visible est : " + carteVisible + "\n");
		setChanged();
		notifyObservers();
	}

	/**
	 * Sets the carte visible.
	 *
	 * @param carteVisible the new carte visible
	 */
	public void setCarteVisible(Carte carteVisible) {
		this.carteVisible = carteVisible;
		setChanged();
		notifyObservers();
		
	}
	
	/**
	 * Carte visible effet attaque.
	 *
	 * @param var the var
	 * @return true, if successful
	 */
	public boolean carteVisibleEffetAttaque(Variante var) {
		return var.getValeurEffetAttaque().containsKey(carteVisible.getValeur());
	}

	/**
	 * Vider cartes dessous.
	 */
	public void viderCartesDessous() {
		// TODO Auto-generated method stub
		cartesDessous.clear();
	}

	/**
	 * Notifier.
	 */
	public void notifier() {
		// TODO Auto-generated method stub
		setChanged();
		notifyObservers();
	}
	
}
	

