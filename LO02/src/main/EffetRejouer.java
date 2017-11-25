package main;

public class EffetRejouer extends Effet {

	
	public void lancer(Joueur leJoueur,Tas leTas, Paquet lePaquet) {
		System.out.println(leJoueur.getNom() + " doit rejouer une carte!");
		leJoueur.choisirUneCarte(leTas, lePaquet);
		
	}
}
