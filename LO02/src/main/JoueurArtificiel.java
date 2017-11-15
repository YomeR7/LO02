package main;

public class JoueurArtificiel extends Joueur {
	
	private int difficulte;
	
	public JoueurArtificiel(String nom,int id,int difficulte) {
		super(nom,id);
		this.difficulte = difficulte;
	}

	public void choisirUneCarte(Tas leTas, Paquet lePaquet) {
		numCarte = 1;
		carteChoisi = sesCartes.get(numCarte-1);
		if (difficulte == 1) {
			if (comparerCarte(leTas)) {
				poserCarte(leTas,lePaquet);
			}
			while(!comparerCarte(leTas))  {
				if (numCarte<sesCartes.size()) {
					numCarte++;
					carteChoisi = sesCartes.get(numCarte-1);
					poserCarte(leTas,lePaquet);
				} else {
					sesCartes.add(lePaquet.piocherUneCarte());
					System.out.println("L'" + this.getNom() + " pioche une carte!");
					leTas.afficherCarteVisible();
					return;
				}
			}
			
		}
	}
	
}
