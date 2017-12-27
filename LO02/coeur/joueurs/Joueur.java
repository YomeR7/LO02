package joueurs;


import java.util.ArrayList;
import java.util.HashSet;

import effet.Effet;
import effet.EffetContre;
import jeu.Carte;
import jeu.Paquet;
import jeu.Tas;
import main.Manche;

public abstract class Joueur {

	private byte id;
	protected ArrayList<Carte> sesCartes;
	private String nom;
	private int score;
	protected Carte carteChoisi;
	protected int numCarte;
	private boolean effetActif = false;

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

	public boolean isEffetActif() {
		return effetActif;
	}

	public void setEffetActif(boolean effetActif) {
		this.effetActif = effetActif;
	}

	public int getNumCarte() {
		return numCarte;
	}

	public void setNumCarte(int numCarte) {
		this.numCarte = numCarte;
	}

	public abstract void choisirUneCarte(Tas leTas, Paquet lePaquet, Manche laManche);
	
	public void poserCarte(Tas leTas, Paquet lePaquet, Manche laManche) {

		if (comparerCarte(leTas)) {
			leTas.addCartesDessous(leTas.getCarteVisible());
			leTas.setCarteVisible(carteChoisi);
			sesCartes.remove(carteChoisi);
			if (this instanceof JoueurArtificiel) {
				System.out.println("L'" + this.getNom() + " joue : " + leTas.getCarteVisible());
			}
			if (laManche.getVarianteManche().getValeurEffetDefense().containsKey(carteChoisi.getValeur())) {
				setEffetActif(true);
			}
			if (leTas.carteVisibleEffetAttaque(laManche.getVarianteManche())) {
				leTas.setAvoirEffet(true);
			}
			leTas.afficherCarteVisible();
			System.out.println(carteChoisi.getValeur());
		} else if (this instanceof JoueurPhysique) {
			System.out.println("\nCarte non valide. Choisis en une autre.");
			choisirUneCarte(leTas, lePaquet, laManche);
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
	
	public void appliquerEffet(Tas leTas, Paquet lePaquet, Manche laManche) {
		Effet lEffet = laManche.getVarianteManche().getValeurEffetDefense().get(carteChoisi.getValeur());
		setEffetActif(false);
		setCarteChoisi(new Carte());
		lEffet.lancer(this,leTas,lePaquet,laManche);
	}

	public void subirEffet(Tas leTas, Paquet lePaquet, Manche laManche) {
		System.out.println(this.nom + " subit un effet!");
			if (laManche.getVarianteManche().getValeurEffetDefense().containsValue(new EffetContre())) {
				if (this.valeursCartes().contains(laManche.getVarianteManche().getValeurContre())) {
					System.out.println(this.nom + " contre l'effet avec un " + laManche.getVarianteManche().getValeurContre());
					this.setCarteChoisi(this.laCarteContre(laManche.getVarianteManche().getValeurContre()));
					this.poserCarte(leTas, lePaquet, laManche);
				}
			}
		Effet lEffet = laManche.getVarianteManche().getValeurEffetAttaque().get(leTas.getCarteVisible().getValeur());
		lEffet.lancer(this, leTas, lePaquet,laManche);
	}

	private Carte laCarteContre(String valeur) {
		// TODO Auto-generated method stub
		boolean trouve = false;
		Carte carteTrouvee = null;
		int i = 0;
		while(!trouve && i < sesCartes.size()) {
			if (sesCartes.get(i).getValeur().equals(valeur)) {
				carteTrouvee = sesCartes.get(i);
			} else {
				i++;
			}
		}
		return carteTrouvee;
	}

	private HashSet<String> valeursCartes() {
		// TODO Auto-generated method stub
		HashSet<String> vals = new HashSet<String>();
		for (int i = 0; i < sesCartes.size();i++) {
			vals.add(sesCartes.get(i).getValeur());
		}
		return vals;
	}

	public boolean uneCarteEstChoisi(Tas leTas) {
		if (this.carteChoisi.equals(leTas.getCarteVisible())) {
			return true;
		} else {
			return false;
		}
		
	}

	public boolean possede(String valeur) {
		// TODO Auto-generated method stub
		if (sesCartes.contains(new Carte(valeur))) {
			return true;
		} else {
			return false;
		}
	};
	

}
