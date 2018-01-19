package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;

import variante.Variante;

/**
 * La classe Tas.
 */
public class Tas extends Observable{
	
	/** la carte visible. */
	private Carte carteVisible;
	
	/** les cartes du dessous. */
	private HashSet<Carte> cartesDessous;
	
	/** boolean pour voir si le tas a un effet. */
	private boolean avoirEffet = false;
	
	/**
	 * Constructeur du tas.
	 *
	 * @param lePaquet le paquet.
	 */
	public Tas(Paquet lePaquet) {
		carteVisible = lePaquet.piocherUneCarte();
		cartesDessous = new HashSet<Carte>();
	}

	/**
	 * Getter des cartes du dessous.
	 *
	 * @return les cartes du dessous
	 */
	public ArrayList<Carte> getCartesDessous() {
		ArrayList<Carte> cartes = new ArrayList<Carte>(cartesDessous);
		return cartes;
	}

	/**
	 * Setter des cartes du dessous.
	 *
	 * @param cartesDessous nouvelles cartes du dessous
	 */
	public void setCartesDessous(HashSet<Carte> cartesDessous) {
		this.cartesDessous = cartesDessous;
	}

	/**
	 * Check s'il y a un effet.
	 *
	 * @return vrai, s'il y a un effet.
	 */
	public boolean isAvoirEffet() {
		return avoirEffet;
	}

	/**
	 * Setter avoir effet.
	 *
	 * @param avoirEffet vrai ou faux
	 */
	public void setAvoirEffet(boolean avoirEffet) {
		this.avoirEffet = avoirEffet;
	}

	/**
	 * Ajouter une carte au dessous.
	 *
	 * @param cartesDessous une carte (l'ancienne carte visible généralement)
	 */
	public void addCartesDessous(Carte cartesDessous) {
		this.cartesDessous.add(cartesDessous);
	}

	/**
	 * Getter carte visible.
	 *
	 * @return la carte visible
	 */
	public Carte getCarteVisible() {
		return carteVisible;
	}

	/**
	 * Afficher carte visible.
	 * notify en même temps les observers.
	 */
	public void afficherCarteVisible() {
		System.out.println("La carte visible est : " + carteVisible + "\n");
		setChanged();
		notifyObservers();
	}

	/**
	 * Setter carte visible.
	 * Notify les observers.
	 *
	 * @param carteVisible nouvelle carte visible
	 */
	public void setCarteVisible(Carte carteVisible) {
		this.carteVisible = carteVisible;
		setChanged();
		notifyObservers();
		
	}
	
	/**
	 * Vérifie si la carte visible est un effet d'attaque.
	 *
	 * @param var la variante en cours
	 * @return true, si effet d'attaque
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
	

