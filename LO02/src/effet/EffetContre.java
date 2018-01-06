package effet;

import java.util.Scanner;

import jeu.Carte;
import joueurs.Joueur;
import joueurs.JoueurPhysique;
import main.Manche;

import java.util.ArrayList;

public class EffetContre implements Effet {
// il reste toujours a regler l'erreur quand on ne choisi la bonne couleur (choixCouleur > 3 
	
	private String nCouleur;
	private boolean attente;
	
	public String getnCouleur() {
		return nCouleur;
	}

	public void setnCouleur(String nCouleur) {
		this.nCouleur = nCouleur;
	}

	public boolean isAttente() {
		return attente;
	}

	public void setAttente(boolean attente) {
		this.attente = attente;
	}

	public void lancer(Joueur leJoueur, Manche laManche) {
		/* String nouvCouleur;
		ArrayList<String> couleur = new ArrayList<String>();
		couleur.add("Carreau");
		couleur.add("Coeur");
		couleur.add("Pique");
		couleur.add("Trefle");
		if (leJoueur instanceof JoueurPhysique) {
			System.out.println("\nChoisis une nouvelle couleur! Ecris en toute lettre:\n' 0 : Carreau' ou ' 1 : Coeur' ou '2 : Pique' ou ' 3 :Trefle'");
			Scanner sc = new Scanner(System.in);
			
			int choixCouleur = sc.nextInt();
			while (choixCouleur > 3) {
				System.out.println("Cette Couleur n'existe pas , choisis en une autre");
				choixCouleur = sc.nextInt();
			} 
			nouvCouleur = couleur.get(choixCouleur); */
		if (leJoueur instanceof JoueurPhysique) {
			setAttente(true);
			while (attente) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else { 
			//if (Partie.getInstance())
			int rnd = (int) (4 * Math.random());
			ArrayList<String> couleur = new ArrayList<String>();
			couleur.add("Carreau");
			couleur.add("Coeur");
			couleur.add("Pique");
			couleur.add("Trefle");
			nCouleur = couleur.get(rnd);
		}
					
		laManche.getLeTas().addCartesDessous(laManche.getLeTas().getCarteVisible());
		laManche.getLeTas().setCarteVisible(new Carte("0", nCouleur));
		System.out.println("La nouvelle couleur est " + nCouleur + ".");
		leJoueur.getSesCartes().remove(leJoueur.getCarteChoisi());

	}
}
