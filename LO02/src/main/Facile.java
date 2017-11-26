package main;

public class Facile implements Difficulte {

	@Override
	public void appliquer(Tas leTas, Paquet lePaquet, Joueur leJoueur) {
		// TODO Auto-generated method stub
		if (leJoueur.comparerCarte(leTas)) {
			leJoueur.poserCarte(leTas, lePaquet);
		}
		while (!leJoueur.comparerCarte(leTas)) {
			if (leJoueur.numCarte < leJoueur.sesCartes.size()) {
				leJoueur.numCarte++;
				leJoueur.carteChoisi = leJoueur.sesCartes.get(leJoueur.numCarte - 1);
				leJoueur.poserCarte(leTas, lePaquet);
			} else {
				leJoueur.sesCartes.add(lePaquet.piocherUneCarte());
				System.out.println("L'" + leJoueur.getNom() + " pioche une carte!");
				leTas.afficherCarteVisible();
				return;
			}
		}
	}

}
