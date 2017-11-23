package main;

import java.util.Scanner;

public class Manche {

	private byte sens = 1, rnd,numVariante;
	private Joueur joueurEnCours;
	private Scanner sc;
	private static byte nbManche = 0;
	private Variante varianteManche;
	//Ajouter list de variantes

	public int getSens() {
		return sens;
	}

	public void setSens(byte sens) {
		this.sens = sens;
	}

	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}

	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}

	public byte getNumVariante() {
		return numVariante;
	}

	public void setNumVariante(byte numVariante) {
		this.numVariante = numVariante;
	}

	public Variante getVarianteManche() {
		return varianteManche;
	}

	public void setVarianteManche(Variante varianteManche) {
		this.varianteManche = varianteManche;
	}

	public Manche() {
		super();

		nbManche++;
		System.out.println("\nMANCHE N�" + nbManche);

		StringBuffer sb = new StringBuffer();
		sc = new Scanner(System.in);
		sb.append("\nChoisir une des variantes suivantes:\n");
		sb.append("1 : Minimal\n");
		sb.append("2 : Classique\n");
		System.out.println(sb.toString());
		this.numVariante = sc.nextByte();
		if (numVariante == 1) {
			varianteManche = new VarianteMinimale();
;		}
		
		Paquet lePaquet = new Paquet(varianteManche);

		lePaquet.melanger();
		lePaquet.distribuer();


		rnd = (byte) (Partie.getInstance().getLesJoueurs().length * (Math.random()));
		joueurEnCours = Partie.getInstance().getLesJoueurs()[rnd];

		Tas leTas = new Tas(lePaquet);
		leTas.afficherCarteVisible();

		while (joueurEnCours.sesCartes.size() != 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (lePaquet.getCartes().size() == 0) {
				lePaquet.setCartes(leTas.getCartesDessous());
				System.out.println("Le paquet a �t� chang� et se m�lange");
				lePaquet.melanger();
			}
			jouerTour(leTas, lePaquet);
		}
	}

	private void jouerTour(Tas leTas, Paquet lePaquet) {
		// TODO Auto-generated method stub
		System.out.println("C'est au tour de " + joueurEnCours.getNom() + "\n");
		joueurEnCours.trierCartes();
		joueurEnCours.afficherCartes();
		joueurEnCours.choisirUneCarte(leTas, lePaquet);

		if (joueurEnCours.getSesCartes().size() != 0) {
			joueurEnCours = Partie.getInstance().getLesJoueurs()[(joueurEnCours.getId() + sens)
					% (Partie.getInstance().getLesJoueurs().length)];
		} else {
			mancheFinie();
		}
	}

	private void mancheFinie() {
		// TODO Auto-generated method stub
		if (Partie.getInstance().getModeComptage() == 0) {
			System.out.println(joueurEnCours.getNom() + " a gagn� la manche!\n");
			for (int i = 0; i < Partie.getInstance().getLesJoueurs().length; i++) {
				Partie.getInstance().getLesJoueurs()[i].compterSesPoints();
			}
		}

		if (nbManche != 1) {
			for (int i = 0; i < Partie.getInstance().getLesJoueurs().length; i++) {
				System.out.println(Partie.getInstance().getLesJoueurs()[i].getNom() + " a au total "
						+ Partie.getInstance().getLesJoueurs()[i].getScore() + " points.\n");
				if (Partie.getInstance().getMAXScore() < Partie.getInstance().getLesJoueurs()[i].getScore()) {
					Partie.getInstance().setMAXScore(Partie.getInstance().getLesJoueurs()[i].getScore());
				}
			}

		}
	}
}
