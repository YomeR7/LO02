package main;

public class EffetPiocher3 implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Tas leTas, Paquet lePaquet, Manche laManche) {
		// TODO Auto-generated method stub
		System.out.println(leJoueur.getNom() + " pioche 3 cartes!\n");
		leJoueur.sesCartes.add(lePaquet.piocherUneCarte());
		leJoueur.sesCartes.add(lePaquet.piocherUneCarte());
		leJoueur.sesCartes.add(lePaquet.piocherUneCarte());
		laManche.changerJoueurEnCours();
	}

}
