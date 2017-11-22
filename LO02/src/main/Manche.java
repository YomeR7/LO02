package main;
import java.util.Scanner;

public class Manche {

	private byte sens = 1, rnd,variante;
	private Joueur joueurEnCours;
	private Scanner sc;
	private static byte nbManche=0;
	
	public int getVariante() {
		return variante;
	}
	
	public void setVariante(byte variante) {
		this.variante = variante;
	}
	
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

	public Manche() {
		super();
		
		nbManche++;
		System.out.println("\nMANCHE N°" + nbManche);
		
		Paquet lePaquet = new Paquet();
				
		lePaquet.melanger();
		lePaquet.distribuer();
		
		StringBuffer sb = new StringBuffer();
		sc = new Scanner(System.in);
		sb.append("\nChoisir une des variantes suivantes:\n");
		sb.append("1 : Minimal\n");
		sb.append("2 : Classique\n");
		System.out.println(sb.toString());
		this.variante = sc.nextByte();
		
		rnd = (byte) (Partie.getInstance().getLesJoueurs().length*(Math.random()));
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
				System.out.println("Le paquet a été changé et se mélange");
				lePaquet.melanger();
			}
			jouerTour(leTas,lePaquet);
		}
	}

	private void jouerTour(Tas leTas, Paquet lePaquet) {
		// TODO Auto-generated method stub
		System.out.println("C'est au tour de " + joueurEnCours.getNom() + "\n");
		if (joueurEnCours instanceof JoueurPhysique) {
			((JoueurPhysique) joueurEnCours).trierCartes();
			((JoueurPhysique) joueurEnCours).afficherCartes();
			joueurEnCours.choisirUneCarte(leTas,lePaquet);
		} else {
			joueurEnCours.choisirUneCarte(leTas,lePaquet); 
		}
		
		if (joueurEnCours.getSesCartes().size() != 0) {
			joueurEnCours = Partie.getInstance().getLesJoueurs()[(joueurEnCours.getId()+sens)%(Partie.getInstance().getLesJoueurs().length)];
		} else {
			mancheFinie();
		}
	}

	private void mancheFinie() {
		// TODO Auto-generated method stub
		if (Partie.getInstance().getModeComptage() == 0) {
			System.out.println(joueurEnCours.getNom() + " a gagné la manche!\n");
			for (int i = 0; i<Partie.getInstance().getLesJoueurs().length; i++) {
				Partie.getInstance().getLesJoueurs()[i].compterSesPoints();
			}
		}
		
		if (nbManche!=1) {
			for (int i = 0; i<Partie.getInstance().getLesJoueurs().length; i++) {
				System.out.println(Partie.getInstance().getLesJoueurs()[i].getNom() + " a au total " + Partie.getInstance().getLesJoueurs()[i].getScore() + " points.\n");
				if (Partie.getInstance().getMAXScore() < Partie.getInstance().getLesJoueurs()[i].getScore()) {
					Partie.getInstance().setMAXScore(Partie.getInstance().getLesJoueurs()[i].getScore());
				}
			}
			
		}
	}
}
