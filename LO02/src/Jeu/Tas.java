package Jeu;

import java.util.ArrayList;
import java.util.HashSet;
import Variante.Variante;

public class Tas {
	private Carte carteVisible;
	private HashSet<Carte> cartesDessous;
	private boolean avoirEffet = false;
	
	public Tas(Paquet lePaquet) {
		carteVisible = lePaquet.piocherUneCarte();
		cartesDessous = new HashSet<Carte>();
	}

	public ArrayList<Carte> getCartesDessous() {
		ArrayList<Carte> cartes = new ArrayList<Carte>(cartesDessous);
		return cartes;
	}

	public void setCartesDessous(HashSet<Carte> cartesDessous) {
		this.cartesDessous = cartesDessous;
	}

	public boolean isAvoirEffet() {
		return avoirEffet;
	}

	public void setAvoirEffet(boolean avoirEffet) {
		this.avoirEffet = avoirEffet;
	}

	public void addCartesDessous(Carte cartesDessous) {
		this.cartesDessous.add(cartesDessous);
	}

	public Carte getCarteVisible() {
		return carteVisible;
	}

	public void afficherCarteVisible() {
		System.out.println("La carte visible est : " + carteVisible + "\n");
	}

	public void setCarteVisible(Carte carteVisible) {
		this.carteVisible = carteVisible;
	}
	
	public boolean carteVisibleEffetAttaque(Variante var) {
		return var.getValeurEffetAttaque().containsKey(carteVisible.getValeur());
	}

	public void viderCartesDessous() {
		// TODO Auto-generated method stub
		cartesDessous.clear();
	}
	
}
	

