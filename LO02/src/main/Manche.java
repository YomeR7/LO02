package main;

import java.util.Scanner;

import javafx.beans.binding.When;

public class Manche {

	private byte sens = 1, rnd, numVariante;
	private Joueur joueurEnCours;
	private Scanner sc;
	private static byte nbManche = 0;
	private Variante varianteManche;
	private Paquet lePaquet;
	private Tas leTas;
	// Ajouter list de variantes

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
		System.out.println("\nMANCHE N°" + nbManche);

		StringBuffer sb = new StringBuffer();
		sc = new Scanner(System.in);
		sb.append("\nChoisir une des variantes suivantes:\n");
		sb.append("1 : Minimal\n");
		sb.append("2 : Classique\n");
		System.out.println(sb.toString());
		this.numVariante = sc.nextByte();
		if (numVariante == 1) {
			varianteManche = new VarianteMinimale();
			;
		}

		lePaquet = new Paquet(varianteManche);

		lePaquet.melanger();
		lePaquet.distribuer();

		rnd = (byte) (Partie.getInstance().getLesJoueurs().size() * (Math.random()));
		joueurEnCours = Partie.getInstance().getLesJoueurs().get(rnd);

		leTas = new Tas(lePaquet);
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
				System.out.println("Le paquet a été changé et se mélange");
				lePaquet.melanger();
			}
			jouerTour();
		}
	}

	private void jouerTour() {
		// TODO Auto-generated method stub
		System.out.println("C'est au tour de " + joueurEnCours.getNom() + "\n");
		joueurEnCours.trierCartes();
		joueurEnCours.afficherCartes();
		joueurEnCours.choisirUneCarte(leTas, lePaquet);

		if (joueurEnCours.getSesCartes().size() == 1) {
			this.uneCarte();
		} else if (joueurEnCours.getSesCartes().size() > 1) {
			this.changerJoueurEnCours();
		} else {
			mancheFinie();
		}
	}

	private void mancheFinie() {
		// TODO Auto-generated method stub
		if (Partie.getInstance().getModeComptage() == 0) {
			System.out.println(joueurEnCours.getNom() + " a gagné la manche!\n");
			for (int i = 0; i < Partie.getInstance().getLesJoueurs().size(); i++) {
				Partie.getInstance().getLesJoueurs().get(i).compterSesPoints();
			}
		}

		if (nbManche != 1) {
			for (int i = 0; i < Partie.getInstance().getLesJoueurs().size(); i++) {
				System.out.println(Partie.getInstance().getLesJoueurs().get(i).getNom() + " a au total "
						+ Partie.getInstance().getLesJoueurs().get(i).getScore() + " points.\n");
				if (Partie.getInstance().getMAXScore() < Partie.getInstance().getLesJoueurs().get(i).getScore()) {
					Partie.getInstance().setMAXScore(Partie.getInstance().getLesJoueurs().get(i).getScore());
				}
			}

		}
	}

	public void uneCarte() {
		Scanner scc = new Scanner(System.in);
		System.out.println(joueurEnCours.getNom() + " n'a plus qu'une carte!\nDis 'carte' ou 'contre carte'. ");
		long t1 = System.currentTimeMillis();
		long delai = 8100, t2;
		String direCarte = scc.nextLine();
		if (!direCarte.isEmpty()) {
			t2 = System.currentTimeMillis();
			delai = t2 - t1;
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (delai <= 4000) {
			if (joueurEnCours instanceof JoueurArtificiel && direCarte.equals("contre carte")) {
				System.out.println("Tu as contré " + joueurEnCours.getNom() + "! Il poche 2 cartes.");
				joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
				joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
				this.changerJoueurEnCours();
			} else if (joueurEnCours instanceof JoueurPhysique && direCarte.equals("carte")) {
				System.out.println("Bravo! Tu ne t'es pas fait contrer!");
				this.changerJoueurEnCours();
			} else {
				if (Math.random() >= 0.5) {
					System.out.println(joueurEnCours.getNom() + " s'est fait contrer par un autre joueur!");
					joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
					joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
				} else {
					System.out.println(joueurEnCours.getNom() + " n'a pas été contré!");
				}
				this.changerJoueurEnCours();
			}
		} else if (joueurEnCours instanceof JoueurPhysique) {
			System.out.println("Tu n'as pas été assez rapide. Tu pioches 2 cartes.");
			joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
			joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
			this.changerJoueurEnCours();
		} else {
			System.out.println("Tu n'as pas été assez rapide, dommage!");
			this.changerJoueurEnCours();
		}
	}

	public void changerJoueurEnCours() {
		joueurEnCours = Partie.getInstance().getLesJoueurs().get((joueurEnCours.getId() + sens)
				% (Partie.getInstance().getLesJoueurs().size()));
	}
}
