package main;

public class JoueurArtificiel extends Joueur {

	private Difficulte niveau;

	public JoueurArtificiel(String nom, byte id, Difficulte niveau) {
		super(nom, id);
		this.niveau = niveau;
	}

	public void choisirUneCarte(Tas leTas, Paquet lePaquet) {
		numCarte = 1;
		carteChoisi = sesCartes.get(numCarte - 1);
		niveau.appliquer(leTas,lePaquet,this);
	}

	@Override
	public void trierCartes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherCartes() {
		// TODO Auto-generated method stub
		
	}

}
