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

/**
 * La classe Joueur.
 */
public abstract class Joueur extends Observable implements Observer {

	/** ID du joueur. */
	private byte id;
	
	/** Ses cartes. */
	protected ArrayList<Carte> sesCartes;
	
	/** Son nom. */
	private String nom;
	
	/** son score. */
	private int score;
	
	/** sa carte choisi. */
	protected Carte carteChoisi;
	
	/** Le numéro de carte. */
	protected int numCarte;
	
	/** Effet actif. */
	private boolean effetActif = false;
	
	/** La manche. */
	protected Manche laManche;
	
	/** L'effet. */
	private Effet lEffet;

	/**
	 * Constructeur du joueur
	 *
	 * @param nom son nom
	 * @param id son ID
	 */
	public Joueur(String nom, byte id) {
		super();
		this.carteChoisi = new Carte();
		this.nom = nom;
		sesCartes = new ArrayList<Carte>();
		this.id = id;
	}

	/**
	 * Getter score.
	 *
	 * @return le score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Setter score.
	 *
	 * @param score nouveau score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Getter nom.
	 *
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter nom.
	 *
	 * @param nom nouveau nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter carte choisi.
	 *
	 * @return la carte choisi
	 */
	public Carte getCarteChoisi() {
		return carteChoisi;
	}

	/**
	 * Setter carte choisi.
	 *
	 * @param carteChoisi nouvelle carte choisi
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
	 * Getter numero carte.
	 *
	 * @return le num carte
	 */
	public int getNumCarte() {
		return numCarte;
	}

	/**
	 * Setter numéro carte.
	 *
	 * @param numCarte nouveau numéro carte
	 */
	public void setNumCarte(int numCarte) {
		this.numCarte = numCarte;
	}

	/**
	 * Choisir une carte.
	 * Sera compléter par joueur physique et artificiel.
	 *
	 * @param laManche la manche
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
	 * Getter ses cartes.
	 *
	 * @return ses cartes
	 */
	public ArrayList<Carte> getSesCartes() {
		return sesCartes;
	}

	/**
	 * Setterses cartes.
	 *
	 * @param sesCartes nouvelles cartes
	 */
	public void setSesCartes(ArrayList<Carte> sesCartes) {
		this.sesCartes = sesCartes;
	}

	/**
	 * Getter l effet.
	 *
	 * @return l effet
	 */
	public Effet getlEffet() {
		return lEffet;
	}

	/**
	 * Setter l effet.
	 *
	 * @param lEffet nouveau effet
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
	 * Cette methode compte les points du Joueur à la fin de la manche.
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
	 * Appliquer effet.
	 * Cette methode permet d'appliquer l'effet Defensif associé a la carte posée
	 *
	 * @param laManche la manche
	 * 
	 * 
	 */
	public void appliquerEffet(Manche laManche) {
		lEffet = laManche.getVarianteManche().getValeurEffetDefense().get(carteChoisi.getValeur());
		setEffetActif(false);
		setCarteChoisi(new Carte());
		lEffet.lancer(this,laManche);
	}

	/**
	 * Subir effet.
	 * Cette methode permet d'appliquer l'effet d'attaque associé a la carte posée
	 *
	 * @param leTas le tas
	 * @param lePaquet le paquet
	 * @param laManche la manche
	 * 
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
	 * La méthode permet de contrer une carte à effet.
	 *
	 * @param valeur la valeur
	 * @return la carte
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
	 * @return les valeurs des cartes du joueur.
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
	 * Possede. Vérifie si le joueur possède une valeur spécifique
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

	public abstract void afficherCartesG();
}
