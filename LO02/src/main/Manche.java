package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;

import jeu.Paquet;
import jeu.Tas;
import joueurs.*;
import variante.*;

public class Manche extends Observable implements Runnable{

	private byte sens = 1, rnd;
	private Joueur joueurEnCours;
	private Scanner sc;
	private static byte nbManche = 0;
	private Variante varianteManche;
	private Paquet lePaquet;
	private Tas leTas;
	private HashMap<String, Variante> lesVariantes;
	private boolean attente = false;
	
	public byte getSens() {
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

	public Variante getVarianteManche() {
		return varianteManche;
	}

	public void setVarianteManche(String nomManche) {
		varianteManche = lesVariantes.get(nomManche);
	}
	
	public static byte getNbManche() {
		return nbManche;
	}

	public static void setNbManche(byte nbManche) {
		Manche.nbManche = nbManche;
	}

	public Paquet getLePaquet() {
		return lePaquet;
	}

	public void setLePaquet(Paquet lePaquet) {
		this.lePaquet = lePaquet;
	}

	public Tas getLeTas() {
		return leTas;
	}

	public void setLeTas(Tas leTas) {
		this.leTas = leTas;
	}

	public Tas commencerManche() {
		lePaquet = new Paquet(varianteManche);
		lePaquet.melanger();
		lePaquet.distribuer();
		rnd = (byte) (Partie.getInstance().getLesJoueurs().size() * (Math.random()));
		joueurEnCours = Partie.getInstance().getLesJoueurs().get(rnd);

		leTas = new Tas(lePaquet);
		setChanged();
		notifyObservers();
		return leTas;
	}

	public Manche() {
		
		lesVariantes = new HashMap<String, Variante>();
		lesVariantes.put("Variante Minimale",new VarianteMinimale());
		lesVariantes.put("Variante Monclar", new VarianteMonclar());
		lesVariantes.put("Variante Maou",new VarianteCarteMaou());
		lesVariantes.put("Variante Man et Rasta", new VarianteManRasta());
		lesVariantes.put("Variante 5",new Variante5());
		
		nbManche++;
		/* System.out.println("\nMANCHE N�" + nbManche);

		StringBuffer sb = new StringBuffer();
		sc = new Scanner(System.in);
		sb.append("\nChoisir une des variantes suivantes:\n");
		for (int i=0; i < lesVariantes.size(); i++) {
			sb.append((i+1) + " : " + lesVariantes.get(i).getNom() + "\n");
		}
		System.out.println(sb.toString());
		varianteManche = lesVariantes.get(sc.nextInt()-1);

		lePaquet = new Paquet(varianteManche);

		lePaquet.melanger();
		lePaquet.distribuer();

		rnd = (byte) (Partie.getInstance().getLesJoueurs().size() * (Math.random()));
		joueurEnCours = Partie.getInstance().getLesJoueurs().get(rnd);

		leTas = new Tas(lePaquet);
		leTas.afficherCarteVisible();

		while (joueurEnCours.getSesCartes().size() != 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (lePaquet.getCartes().size() == 0) {
				lePaquet.setCartes(leTas.getCartesDessous());
				leTas.viderCartesDessous();
				System.out.println("Le paquet a �t� chang� et se m�lange");
				lePaquet.melanger();
			}
			if (leTas.isAvoirEffet()) {
				leTas.setAvoirEffet(false);
				joueurEnCours.subirEffet(leTas,lePaquet,this);
			}
			jouerTour();
		} */
	}

	public void jouerTourG() {
		joueurEnCours.trierCartes();
		joueurEnCours.afficherCartesG();
		joueurEnCours.choisirUneCarte(this);
		System.out.println(joueurEnCours.uneCarteEstChoisi()+"  carte select + "+joueurEnCours.isEffetActif());
		if (joueurEnCours.uneCarteEstChoisi() && joueurEnCours.isEffetActif()) {
			joueurEnCours.appliquerEffet(this);
		}
		if (joueurEnCours.getSesCartes().size() > 1) {
			this.changerJoueurEnCours();
		} else if (Partie.getInstance().getModeComptage() == 0 && joueurEnCours.getSesCartes().size() == 0){
			mancheFinie();
		}
	}
	
	public void jouerTour() {
		// TODO Auto-generated method stub
	
		System.out.println("C'est au tour de " + joueurEnCours.getNom() + "\n");
		joueurEnCours.trierCartes();
		joueurEnCours.afficherCartes();
		joueurEnCours.choisirUneCarte(this);
		if (joueurEnCours.uneCarteEstChoisi() && joueurEnCours.isEffetActif()) { //retour au if, le while bloquait le jeu au changement de couleur 
			joueurEnCours.appliquerEffet(this);																				// id�e : d�placer ce if dans choisirCarte
		}
		if (joueurEnCours.getSesCartes().size() == 1) {
			this.uneCarte();
		} else if (joueurEnCours.getSesCartes().size() > 1) {
			this.changerJoueurEnCours();
		} else if (Partie.getInstance().getModeComptage() == 0 && joueurEnCours.getSesCartes().size() == 0){
			mancheFinie();
		} else if (Partie.getInstance().getModeComptage() == 1 && joueurEnCours.getSesCartes().size() == 0) {
			
			ArrayList<Joueur> joueursTemp = new ArrayList<Joueur>(Partie.getInstance().getLesJoueurs());
			int nombreJoueur = Partie.getInstance().getNbIA()+1;
			Joueur jGagnant,joueurSuivant;
			
			if (nombreJoueur == Partie.getInstance().getLesJoueurs().size() && nombreJoueur >= 2) {
				System.out.println(joueurEnCours.getNom() + " a gagn� la manche!\n");
				jGagnant = joueurEnCours;
				joueurEnCours.setScore(50);
				joueurSuivant = this.getJoueurSuivant();
				Partie.getInstance().getLesJoueurs().remove(jGagnant);
				joueurEnCours = joueurSuivant;
			} else if (nombreJoueur == Partie.getInstance().getLesJoueurs().size() && nombreJoueur == 2) {
				System.out.println(joueurEnCours.getNom() + " a gagn� la manche!\n");
				joueurEnCours.setScore(50);
				joueurSuivant = this.getJoueurSuivant();
				joueurSuivant.setScore(20);
				System.out.println(joueurEnCours.getNom() + " a marqu� 50 points et " + joueurSuivant.getNom() + " 20 points!\n");
				mancheFinie();
			} else if (nombreJoueur-1 == Partie.getInstance().getLesJoueurs().size() && nombreJoueur >= 3) {
				System.out.println(joueurEnCours.getNom() + " est deuxi�me!\n");
				jGagnant = joueurEnCours;
				joueurEnCours.setScore(20);
				joueurSuivant = this.getJoueurSuivant();
				Partie.getInstance().getLesJoueurs().remove(jGagnant);
				joueurEnCours = joueurSuivant;
			} else if (nombreJoueur-1 == Partie.getInstance().getLesJoueurs().size() || nombreJoueur == 3) {
					System.out.println(joueurEnCours.getNom() + " est deuxi�me!\n");
					joueurEnCours.setScore(20);
					joueurSuivant = this.getJoueurSuivant();
					joueurSuivant.setScore(10);
					Partie.getInstance().setLesJoueurs(joueursTemp);
					mancheFinie();
			} else {
				System.out.println(joueurEnCours.getNom() + " est troisi�me!\n");
				joueurEnCours.setScore(10);
				Partie.getInstance().setLesJoueurs(joueursTemp);
				mancheFinie();
			}
		}
		
	
			
	}

	public Joueur getJoueurSuivant() {
		return Partie.getInstance().getLesJoueurs()
				.get((joueurEnCours.getId() + sens) % (Partie.getInstance().getLesJoueurs().size()));
	}

	private void mancheFinie() {
		// TODO Auto-generated method stub
		if (Partie.getInstance().getModeComptage() == 0) {
			System.out.println(joueurEnCours.getNom() + " a gagn� la manche!\n");
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
				System.out.println("Tu as contr� " + joueurEnCours.getNom() + "! Il poche 2 cartes.");
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
					System.out.println(joueurEnCours.getNom() + " n'a pas �t� contr�!");
				}
				this.changerJoueurEnCours();
			}
		} else if (joueurEnCours instanceof JoueurPhysique) {
			System.out.println("Tu n'as pas �t� assez rapide. Tu pioches 2 cartes.");
			joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
			joueurEnCours.getSesCartes().add(lePaquet.piocherUneCarte());
			this.changerJoueurEnCours();
		} else {
			System.out.println("Tu n'as pas �t� assez rapide, dommage!");
			this.changerJoueurEnCours();
		}
	}

	public boolean isAttente() {
		return attente;
	}

	public void setAttente(boolean attente) {
		this.attente = attente;
	}

	public void changerJoueurEnCours() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (joueurEnCours.getId() == 0 && sens == -1) {
			joueurEnCours = Partie.getInstance().getLesJoueurs().get(Partie.getInstance().getLesJoueurs().size()-1);
		} else {
			joueurEnCours = Partie.getInstance().getLesJoueurs()
				.get((joueurEnCours.getId() + sens) % (Partie.getInstance().getLesJoueurs().size()));
		}
		setChanged();
		notifyObservers();	
	}
	
	public void run() {
		// TODO Auto-generated method stub
		while (this.getJoueurEnCours().getSesCartes().size() != 0) {
			if (lePaquet.getCartes().size() == 0) {
				lePaquet.setCartes(leTas.getCartesDessous());
				leTas.viderCartesDessous();
				System.out.println("Le paquet a �t� chang� et se m�lange");
				lePaquet.melanger();
			}
			if (leTas.isAvoirEffet()) {
				leTas.setAvoirEffet(false);
				joueurEnCours.subirEffet(leTas,lePaquet,this);
			}
			this.jouerTourG();
			while(attente){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
