package main;

import java.util.ArrayList;

public abstract class Joueur {

	private byte id;
	protected ArrayList<Carte> sesCartes;
	private String nom;
	private int score;
	protected Carte carteChoisi;
	protected int numCarte;

	public Joueur(String nom, byte id) {
		super();
		this.carteChoisi = new Carte();
		this.nom = nom;
		sesCartes = new ArrayList<Carte>();
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Carte getCarteChoisi() {
		return carteChoisi;
	}

	public void setCarteChoisi(Carte carteChoisi) {
		this.carteChoisi = carteChoisi;
	}

	public abstract void choisirUneCarte(Tas leTas, Paquet lePaquet);
	
	public void poserCarte(Tas leTas, Paquet lePaquet) {

		if (comparerCarte(leTas)) {
			leTas.addCartesDessous(leTas.getCarteVisible());
			leTas.setCarteVisible(carteChoisi);
			sesCartes.remove(numCarte - 1);
			if (this instanceof JoueurArtificiel) {
				System.out.println("L'" + this.getNom() + " joue : " + leTas.getCarteVisible());
			}
			leTas.afficherCarteVisible();
		} else if (this instanceof JoueurPhysique) {
			System.out.println("\nCarte non valide. Choisis en une autre.");
			choisirUneCarte(leTas, lePaquet);
		}
	}

	public ArrayList<Carte> getSesCartes() {
		return sesCartes;
	}

	public void setSesCartes(ArrayList<Carte> sesCartes) {
		this.sesCartes = sesCartes;
	}

	public boolean comparerCarte(Tas leTas) {
		if (carteChoisi.getValeur() == leTas.getCarteVisible().getValeur()
				|| carteChoisi.getCouleur() == leTas.getCarteVisible().getCouleur() 
				|| carteChoisi.getValeur() == "8") {
			return true;
		} else {
			return false;
		}
	}

	public byte getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public void compterSesPoints() {
		// TODO Auto-generated method stub
		int scoreManche = 0;
		for (int i = 0; i < sesCartes.size(); i++) {
			scoreManche += sesCartes.get(i).getPoints();
		}
		System.out.println(this.nom + " a marqué " + scoreManche + " points.\n");
		score += scoreManche;
	}

	public abstract void trierCartes();

	public abstract void afficherCartes();
	
	public void appliquerEffet(Variante varianteManche,Tas leTas, Paquet lePaquet) {
		Effet lEffet = varianteManche.getValeurEffetDefense().get(carteChoisi.getValeur());
		lEffet.lancer(this,leTas,lePaquet);
	}

	public void subirEffet(Variante varianteManche,Tas leTas, Paquet lePaquet) {
		System.out.println(this.nom + " subit un effet!");
		Effet lEffet = varianteManche.getValeurEffetAttaque().get(leTas.getCarteVisible().getValeur());
		lEffet.lancer(this, leTas, lePaquet);
	}

	public boolean uneCarteEstChoisi(Tas leTas) {
		if (this.carteChoisi.equals(leTas.getCarteVisible())) {
			return true;
		} else {
			return false;
		}
		
	};
	

}
