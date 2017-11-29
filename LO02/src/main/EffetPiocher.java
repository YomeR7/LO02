package main;

public class EffetPiocher implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Tas leTas, Paquet lePaquet, Manche laManche) {
		// TODO Auto-generated method stub
		System.out.println(leJoueur.getNom() + " pioche une carte!\n");
		leJoueur.sesCartes.add(lePaquet.piocherUneCarte());
		laManche.changerJoueurEnCours();
	}

}
