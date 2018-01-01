package joueurs;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import jeu.Carte;
import jeu.Paquet;
import jeu.Tas;
import main.Manche;

public class JoueurPhysique extends Joueur {
	
	private boolean attenteVue = true;

	public boolean isAttenteVue() {
		return attenteVue;
	}

	public void setAttenteVue(boolean attenteVue) {
		this.attenteVue = attenteVue;
	}

	public JoueurPhysique(String nom, byte id) {
		super(nom, id);
		// TODO Auto-generated constructor stub
	}

	public void afficherCartes() {
		for (int i = 0; i < sesCartes.size(); i++) {
			System.out.println(i + 1 + " : " + sesCartes.get(i));
		}
	}
	
	public void afficherCartesG() {
	}

	public void choisirUneCarte(Manche laManche) {
		super.choisirUneCarte(laManche);
		while (attenteVue) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("attenteChoix");
		}
		setChanged();
		notifyObservers();
		this.setAttenteVue(true);
	}
	
	public void choisirUneCarteC(Manche laManche) {
		// TODO Auto-generated method stub
		super.choisirUneCarte(laManche);
		Scanner sccc = new Scanner(System.in);
		System.out.println("\nChoisis une de tes cartes (entre 1 et " + sesCartes.size() + ")\n0 : Piocher une carte");
		numCarte = sccc.nextInt();
		if (numCarte != 0 && numCarte <= sesCartes.size()) {
			carteChoisi = sesCartes.get(numCarte - 1);
			// System.out.println(carteChoisi);
			this.poserCarte();
		} else if (numCarte == 13) {
			System.out.println(laManche.getLeTas().getCartesDessous());
		} else if (numCarte > sesCartes.size()) {
			System.out.println("Tu n'as pas autant de cartes! Choisis une carte entre 1 et " + sesCartes.size());
			this.choisirUneCarte(this.laManche);
		} else {
			sesCartes.add(laManche.getLePaquet().piocherUneCarte());
			laManche.getLeTas().afficherCarteVisible();
		}

	}

	public void trierCartes() {
		Collections.sort(sesCartes, new Comparator<Carte>() {
			@Override
			public int compare(Carte c1, Carte c2) {
				if (c1.getCouleur().compareTo(c2.getCouleur()) == 0) { // Si la couleur est égale pour les deux cartes
																		// comparés
					return c1.getValeur().compareTo(c2.getValeur()); // Alors on compare les valeur
				} else { // Sinon, les cartes ont une couleur différente
					return c1.getCouleur().compareTo(c2.getCouleur()); // Le tri doit s'effectuer sur la couleur
				}
			}
		});
	}

	public void finirTour() {
		// TODO Auto-generated method stub
		super.finirTour();
		this.setAttenteVue(false);
	}

}
