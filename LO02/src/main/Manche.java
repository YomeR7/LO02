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

	public Manche(Joueur[] lesJoueurs, byte modeComptage) {
		super();
		
		nbManche++;
		
		Paquet lePaquet = new Paquet(modeComptage);
				
		lePaquet.melanger();
		lePaquet.distribuer(lesJoueurs.length, lesJoueurs);
		
		StringBuffer sb = new StringBuffer();
		sc = new Scanner(System.in);
		sb.append("\nChoisir une des variantes suivantes:\n");
		sb.append("1 : Minimal\n");
		sb.append("2 : Classique\n");
		System.out.println(sb.toString());
		this.variante = sc.nextByte();
		
		rnd = (byte) (lesJoueurs.length*(Math.random()));
		joueurEnCours = lesJoueurs[rnd];
				
		Tas leTas = new Tas(lePaquet);
		leTas.afficherCarteVisible();
		
		while (joueurEnCours.sesCartes.size() != 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jouerTour(leTas,lesJoueurs,lePaquet,modeComptage);
		}
	}

	private void jouerTour(Tas leTas,Joueur[] lesJoueurs, Paquet lePaquet, byte modeComptage) {
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
			joueurEnCours = lesJoueurs[(joueurEnCours.getId()+sens)%(lesJoueurs.length)];
		} else {
			mancheFinie(modeComptage, lesJoueurs);
		}
	}

	private void mancheFinie(byte modeComptage, Joueur[] lesJoueurs) {
		// TODO Auto-generated method stub
		if (modeComptage == 0) {
			System.out.println(joueurEnCours.getNom() + " a gagné la manche!\n");
			for (int i = 0; i<lesJoueurs.length; i++) {
				lesJoueurs[i].compterSesPoints();
			}
		}
		
		if (nbManche!=1) {
			for (int i = 0; i<lesJoueurs.length; i++) {
				System.out.println(lesJoueurs[i].getNom() + " a au total " + lesJoueurs[i].getScore() + " points.");
			}
			
		}
	}
}
