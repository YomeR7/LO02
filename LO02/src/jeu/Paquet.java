package jeu;

import java.util.ArrayList;
import java.util.Collections;

import main.Partie;
import variante.Variante;

/**
 * La classe Paquet.
 */
public class Paquet {

	/** Les cartes. */
	private ArrayList<Carte> cartes;

	/**
	 * Constructeur du paquet.
	 *
	 * @param VarianteManche la variante manche
	 */
	public Paquet(Variante VarianteManche) {
		super();

		cartes = new ArrayList<Carte>();

		String valeur[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As" };
		String couleur[] = { "Pique", "Carreau", "Trefle", "Coeur" };
		byte points[] = { 20, 3, 4, 5, 6, 20, 50, 9, 20, 20, 10, 10, 50 };

		int k = 0;
		for (int i = 0; i < couleur.length; i++) {
			for (int j = 0; j < valeur.length; j++) {
				cartes.add(k, new Carte(valeur[j], couleur[i], points[j]));
				k++;
			}
		}
	}

	/**
	 * Melanger le paquet.
	 */
	public void melanger() {
		Collections.shuffle(cartes);
	}

	/**
	 * Distribuer le paquet.
	 */
	public void distribuer() {
		int carteParJoueur = 0;
		if (Partie.getInstance().getLesJoueurs().size() >= 4) {
			carteParJoueur = 6;
		} else if (Partie.getInstance().getLesJoueurs().size() == 3) {
			carteParJoueur = 8;
		} else if (Partie.getInstance().getLesJoueurs().size() == 2) {
			carteParJoueur = 10;
		}
		for (int i = 0; i < Partie.getInstance().getLesJoueurs().size(); i++) {
			ArrayList<Carte> cartesDuJoueur = new ArrayList<Carte>(cartes.subList(0, carteParJoueur));
			Partie.getInstance().getLesJoueurs().get(i).setSesCartes(cartesDuJoueur);
			cartes.removeAll(cartesDuJoueur);
		}
	}

	/**
	 * Afficher cartes les cartes (uniquement pour joueur physique).
	 */
	public void afficherCartes() {
		for (int i = 0; i < cartes.size(); i++) {
			System.out.println(cartes.get(i));
		}
	}

	/**
	 * Piocher une carte.
	 *
	 * @return une carte
	 */
	public Carte piocherUneCarte() {
		Carte cartePioche = cartes.get(0);
		cartes.remove(0);
		return cartePioche;
	}

	/**
	 * Getter les cartes.
	 *
	 * @return les cartes
	 */
	public ArrayList<Carte> getCartes() {
		return cartes;
	}

	/**
	 * Setter les cartes.
	 *
	 * @param cartes nouvelles cartes
	 */
	public void setCartes(ArrayList<Carte> cartes) {
		this.cartes = cartes;
	}
}
