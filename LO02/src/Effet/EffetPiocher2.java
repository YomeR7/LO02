package main;

public class EffetPiocher2 implements Effet {

	@Override
	public void lancer(Joueur leJoueur, Tas leTas, Paquet lePaquet, Manche laManche) {
		// TODO Auto-generated method stub
		if (lePaquet.getCartes().size() < 2) {
			lePaquet.setCartes(leTas.getCartesDessous());
			leTas.viderCartesDessous();
			System.out.println("Le paquet a été changé et se mélange");
			lePaquet.melanger();
		}
		System.out.println(leJoueur.getNom() + " pioche 2 cartes!\n");
		
		leJoueur.sesCartes.add(lePaquet.piocherUneCarte());
		leJoueur.sesCartes.add(lePaquet.piocherUneCarte());
		laManche.changerJoueurEnCours();
	}

}
