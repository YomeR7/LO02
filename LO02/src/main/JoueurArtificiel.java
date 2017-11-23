package main;

public class JoueurArtificiel extends Joueur {

	private byte difficulte;

	public JoueurArtificiel(String nom, byte id, byte difficulte) {
		super(nom, id);
		this.difficulte = difficulte;
	}

	public void choisirUneCarte(Tas leTas, Paquet lePaquet) {
		numCarte = 1;
		carteChoisi = sesCartes.get(numCarte - 1);
		if (difficulte == 1) {
			if (comparerCarte(leTas)) {
				poserCarte(leTas, lePaquet);
			}
			while (!comparerCarte(leTas)) {
				if (numCarte < sesCartes.size()) {
					numCarte++;
					carteChoisi = sesCartes.get(numCarte - 1);
					poserCarte(leTas, lePaquet);
				} else {
					sesCartes.add(lePaquet.piocherUneCarte());
					System.out.println("L'" + this.getNom() + " pioche une carte!");
					leTas.afficherCarteVisible();
					return;
				}
			}

		}
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
