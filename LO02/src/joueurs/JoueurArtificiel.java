package joueurs;

import jeu.Paquet;
import jeu.Tas;
import main.Manche;
import strategie.Difficulte;

public class JoueurArtificiel extends Joueur {

	private Difficulte niveau;

	public JoueurArtificiel(String nom, byte id, Difficulte niveau) {
		super(nom, id);
		this.niveau = niveau;
	}

	public void choisirUneCarte(Manche laManche) {
		super.choisirUneCarte(laManche);
		numCarte = 1;
		carteChoisi = sesCartes.get(numCarte - 1);
		niveau.appliquer(this,laManche);
	}

	@Override
	public void trierCartes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherCartes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherCartesG() {
		// TODO Auto-generated method stub
		
	}

}
