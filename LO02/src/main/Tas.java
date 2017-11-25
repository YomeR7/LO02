package main;

import java.util.ArrayList;

public class Tas {
	private Carte carteVisible;
	private ArrayList<Carte> cartesDessous;

	public Tas(Paquet lePaquet) {
		carteVisible = lePaquet.piocherUneCarte();
		cartesDessous = new ArrayList<Carte>();
	}

	public ArrayList<Carte> getCartesDessous() {
		return cartesDessous;
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
	
}
	

