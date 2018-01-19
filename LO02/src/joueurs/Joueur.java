package joueurs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

import effet.Effet;
import effet.EffetContre;
import jeu.Carte;
import jeu.Paquet;
import jeu.Tas;
import main.Manche;

// TODO: Auto-generated Javadoc
/**
 * The Class Joueur.
 */
public abstract class Joueur extends Observable implements Observer {

	/** The id. */
	private byte id;
	
	/** The ses cartes. */
	protected ArrayList<Carte> sesCartes;
	
	/** The nom. */
	private String nom;
	
	/** The score. */
	private int score;
	
	/** The carte choisi. */
	protected Carte carteChoisi;
	
	/** The num carte. */
	protected int numCarte;
	
	/** The effet actif. */
	private boolean effetActif = false;
	
	/** The la manche. */
	protected Manche laManche;
	
	/** The l effet. */
	private Effet lEffet;

	/**
	 * Instantiates a new joueur.
	 *
	 * @param nom the nom
	 * @param id the id
	 */
	public Joueur(String nom, byte id) {
		super();
		this.carteChoisi = new Carte();
		this.nom = nom;
		sesCartes = new ArrayList<Carte>();
		this.id = id;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Gets the carte choisi.
	 *
	 * @return the carte choisi
	 */
	public Carte getCarteChoisi() {
		return carteChoisi;
	}

	/**
	 * Sets the carte choisi.
	 *
	 * @param carteChoisi the new carte choisi
	 */
	public void setCarteChoisi(Carte carteChoisi) {
		this.carteChoisi = carteChoisi;
	}

	/**
	 * Checks if is effet actif.
	 *
	 * @return true, if is effet actif
	 */
	public boolean isEffetActif() {
		return effetActif;
	}

	/**
	 * Sets the effet actif.
	 *
	 * @param effetActif the new effet actif
	 */
	public void setEffetActif(boolean effetActif) {
		this.effetActif = effetActif;
	}

	/**
	 * Gets the num carte.
	 *
	 * @return the num carte
	 */
	public int getNumCarte() {
		return numCarte;
	}

	/**
	 * Sets the num carte.
	 *
	 * @param numCarte the new num carte
	 */
	public void setNumCarte(int numCarte) {
		this.numCarte = numCarte;
	}

	/**
	 * Choisir une carte.
	 *
	 * @param laManche the la manche
	 */
	public void choisirUneCarte(Manche laManche) {
		this.laManche = laManche;
	}
	
	/**
	 * Poser carte.
	 * 
	 * Cette methode permet de poser une carte en fonction de la methode comparerCarte 
	 * Elle se relance tant que la carte choisi est invalide
	 * Elle active aussi les effet en fonction de leur type (Defense ou Attaque) 
	 * 
	 */
	public void poserCarte() {

		if (comparerCarte()) {
			laManche.getLeTas().addCartesDessous(laManche.getLeTas().getCarteVisible());
			laManche.getLeTas().setCarteVisible(carteChoisi);
			sesCartes.remove(carteChoisi);
			if (this instanceof JoueurArtificiel) {
				System.out.println("L'" + this.getNom() + " joue : " + laManche.getLeTas().getCarteVisible());
			}
			if (laManche.getVarianteManche().getValeurEffetDefense().containsKey(carteChoisi.getValeur())) {
				setEffetActif(true);
			}
			if (laManche.getLeTas().carteVisibleEffetAttaque(laManche.getVarianteManche())) {
				laManche.getLeTas().setAvoirEffet(true);
			}
			laManche.getLeTas().afficherCarteVisible();
			System.out.println(carteChoisi.getValeur());
		} else if (this instanceof JoueurPhysique) {
			System.out.println("\nCarte non valide. Choisis en une autre.");
			choisirUneCarte(this.laManche);
		}
	}

	/**
	 * Gets the ses cartes.
	 *
	 * @return the ses cartes
	 */
	public ArrayList<Carte> getSesCartes() {
		return sesCartes;
	}

	/**
	 * Sets the ses cartes.
	 *
	 * @param sesCartes the new ses cartes
	 */
	public void setSesCartes(ArrayList<Carte> sesCartes) {
		this.sesCartes = sesCartes;
	}

	/**
	 * Gets the l effet.
	 *
	 * @return the l effet
	 */
	public Effet getlEffet() {
		return lEffet;
	}

	/**
	 * Sets the l effet.
	 *
	 * @param lEffet the new l effet
	 */
	public void setlEffet(Effet lEffet) {
		this.lEffet = lEffet;
	}

	/**
	 * Comparer carte.
	 *
	 * @return true, if successful
	 * Cette methode retourne true si la carte à poser choisie est un 8, ou est
	 * de la meme couleur, de la valeur que la carte visible du tas
	 *
	 */
	public boolean comparerCarte() {
		if (carteChoisi.getValeur() == laManche.getLeTas().getCarteVisible().getValeur()
				|| carteChoisi.getCouleur() == laManche.getLeTas().getCarteVisible().getCouleur() 
				|| carteChoisi.getValeur() == "8") {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public byte getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	/**
	 * Compter ses points.
	 * Cette methode compte les points du Joueur en question pour le mode de comptage négatif
	 */
	public void compterSesPoints() {
		// TODO Auto-generated method stub
		int scoreManche = 0;
		for (int i = 0; i < sesCartes.size(); i++) {
			scoreManche += sesCartes.get(i).getPoints();
		}
		System.out.println(this.nom + " a marqué " + scoreManche + " points.\n");
		score += scoreManche;
	}

	/**
	 * Trier cartes.
	 */
	public abstract void trierCartes();

	/**
	 * Afficher cartes.
	 */
	public abstract void afficherCartes();
	
	/**
	 * Afficher cartes G.
	 */
	public abstract void afficherCartesG();
	
	/**
	 * Appliquer effet.
	 *
	 * @param laManche the la manche
	 * Cette methode permet d'appliquer l'effet Defensif associé a la carte posée
	 * 
	 */
	public void appliquerEffet(Manche laManche) {
		lEffet = laManche.getVarianteManche().getValeurEffetDefense().get(carteChoisi.getValeur());
		setEffetActif(false);
		setCarteChoisi(new Carte());
		System.out.println(lEffet);
		System.out.println("effet actif??? " + isEffetActif());
		lEffet.lancer(this,laManche);
	}

	/**
	 * Subir effet.
	 *
	 * @param leTas the le tas
	 * @param lePaquet the le paquet
	 * @param laManche the la manche
	 * Cette methode permet d'appliquer l'effet d'attaque associé a la carte posée
	 * 
	 */
	public void subirEffet(Tas leTas, Paquet lePaquet, Manche laManche) {
		System.out.println(this.nom + " subit un effet!");
			if (laManche.getVarianteManche().getValeurEffetDefense().containsValue(new EffetContre())) {
				if (this.valeursCartes().contains(laManche.getVarianteManche().getValeurContre())) {
					System.out.println(this.nom + " contre l'effet avec un " + laManche.getVarianteManche().getValeurContre());
					this.setCarteChoisi(this.laCarteContre(laManche.getVarianteManche().getValeurContre()));
					this.poserCarte();
				}
			}
		lEffet = laManche.getVarianteManche().getValeurEffetAttaque().get(leTas.getCarteVisible().getValeur());
		lEffet.lancer(this,laManche);
	}

	/**
	 * La carte contre.
	 *
	 * @param valeur the valeur
	 * @return the carte
	 */
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

	/**
	 * Valeurs cartes.
	 *
	 * @return the hash set
	 */
	private HashSet<String> valeursCartes() {
		// TODO Auto-generated method stub
		HashSet<String> vals = new HashSet<String>();
		for (int i = 0; i < sesCartes.size();i++) {
			vals.add(sesCartes.get(i).getValeur());
		}
		return vals;
	}

	/**
	 * Une carte est choisi.
	 *
	 * @return true, if successful
	 */
	public boolean uneCarteEstChoisi() {
		if (this.carteChoisi.equals(laManche.getLeTas().getCarteVisible())) {
			return true;
		} else {
			return false;
		}
		
	}

	/**
	 * Possede.
	 *
	 * @param valeur the valeur
	 * @return true, if successful
	 */
	public boolean possede(String valeur) {
		// TODO Auto-generated method stub
		if (sesCartes.contains(new Carte(valeur))) {
			return true;
		} else {
			return false;
		}
	};
	
	/**
	 * Finir tour.
	 */
	public void finirTour() {
		// TODO Auto-generated method stub
		poserCarte();
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		if (o instanceof Effet) {
			setChanged();
			notifyObservers(arg);
		}
	}
	
	/**
	 * Piocher.
	 */
	public void piocher() {
		sesCartes.add(laManche.getLePaquet().piocherUneCarte());
		setChanged();
		String msg = nom + " pioche!";
		notifyObservers(msg);
	}
}
