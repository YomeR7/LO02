package main;
import java.util.Scanner;

public class Manche {

	private int variante;
	private int sens = 1,rnd;
	private Joueur joueurEnCours;
	private Scanner sc;
	
	public int getVariante() {
		return variante;
	}
	
	public void setVariante(int variante) {
		this.variante = variante;
	}
	
	public int getSens() {
		return sens;
	}
	
	public void setSens(int sens) {
		this.sens = sens;
	}
	
	public Joueur getJoueurEnCours() {
		return joueurEnCours;
	}
	
	public void setJoueurEnCours(Joueur joueurEnCours) {
		this.joueurEnCours = joueurEnCours;
	}

	public Manche(int nbIA, Joueur moi, Joueur[] ia) {
		super();
		
		Paquet lePaquet = new Paquet();
		
		Joueur lesJoueurs[] = new Joueur[nbIA+1];
		for (int i=0;i<nbIA;i++) {
			lesJoueurs[i] = ia[i];
		}
		lesJoueurs[nbIA] = moi;
		
		lePaquet.melanger();
		lePaquet.distribuer(nbIA+1, lesJoueurs);
		
		StringBuffer sb = new StringBuffer();
		sc = new Scanner(System.in);
		sb.append("\nChoisir une des variantes suivantes:\n");
		sb.append("1 : Minimal\n");
		sb.append("2 : Classique\n");
		System.out.println(sb.toString());
		this.variante = sc.nextInt();
		
		rnd = (int) (lesJoueurs.length*(Math.random()));
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
			jouerTour(leTas,lesJoueurs,nbIA,lePaquet);
		}
	}

	private void jouerTour(Tas leTas,Joueur[] lesJoueurs, int nbIA, Paquet lePaquet) {
		// TODO Auto-generated method stub
		System.out.println("C'est au tour de " + joueurEnCours.getNom() + "\n");
		if (joueurEnCours instanceof JoueurPhysique) {
			((JoueurPhysique) joueurEnCours).afficherCartes();
			joueurEnCours.choisirUneCarte(leTas,lePaquet);
		} else {
			joueurEnCours.choisirUneCarte(leTas,lePaquet); 
		}
		joueurEnCours = lesJoueurs[(joueurEnCours.getId()+sens)%(nbIA+1)];
	}
	
}
