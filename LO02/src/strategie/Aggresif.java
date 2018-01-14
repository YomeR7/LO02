package strategie;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import jeu.Carte;
import jeu.Paquet;
import jeu.Tas;
import joueurs.Joueur;
import main.Manche;

// TODO: Auto-generated Javadoc
/**
 * The Class Aggresif.
 */
public class Aggresif implements Difficulte {

	/* (non-Javadoc)
	 * @see strategie.Difficulte#appliquer(joueurs.Joueur, main.Manche)
	 */
	@Override
	public void appliquer(Joueur leJoueur, Manche laManche) {
		// TODO Auto-generated method stub
		HashSet<Carte> cartesPossibles = new HashSet<Carte>();
		HashSet<Carte> cartesPossiblesEffet = new HashSet<Carte>();
		Set<String> valeursAtt = laManche.getVarianteManche().getValeurEffetAttaque().keySet();
		Set<String> valeursDef = laManche.getVarianteManche().getValeurEffetDefense().keySet();
		
		for (int i = 0; i < leJoueur.getSesCartes().size(); i++) {
			leJoueur.setCarteChoisi(leJoueur.getSesCartes().get(i));
			if (leJoueur.comparerCarte()) {
				for (Iterator<String> it = valeursAtt.iterator(); it.hasNext();) {
					String monIT = (String) it.next();
					if (leJoueur.getCarteChoisi().getValeur().equals(monIT)) {
						cartesPossiblesEffet.add(leJoueur.getCarteChoisi());
					}
					
				}
				for (Iterator<String> it = valeursDef.iterator(); it.hasNext();) {
					String monIT = (String) it.next();
					if (leJoueur.getCarteChoisi().getValeur().equals(monIT)) {
						cartesPossiblesEffet.add(leJoueur.getCarteChoisi());
					}
					
				}
				cartesPossibles.add(leJoueur.getCarteChoisi());
			}
		}
		/*System.out.println("Liste carte possibles");
		for (Iterator<Carte> it = cartesPossibles.iterator(); it.hasNext();) {
			System.out.println((Carte) it.next());
		}
		
		System.out.println("Liste carte possibles effet");
		for (Iterator<Carte> it = cartesPossiblesEffet.iterator(); it.hasNext();) {
			System.out.println((Carte) it.next());
		} */
		
		if (!cartesPossiblesEffet.isEmpty()) {
			Carte newCart = (Carte) cartesPossiblesEffet.toArray()[0];
			leJoueur.setCarteChoisi(newCart);
			//System.out.println("la Carte choisi est " + leJoueur.getCarteChoisi());
			leJoueur.poserCarte();
		} else if (!cartesPossibles.isEmpty()) {
			Carte newCart = (Carte) cartesPossibles.toArray()[0];
			leJoueur.setCarteChoisi(newCart);
			//System.out.println("la Carte choisi est " + leJoueur.getCarteChoisi());
			leJoueur.poserCarte();
		} else {
			leJoueur.getSesCartes().add(laManche.getLePaquet().piocherUneCarte());
			System.out.println("L'" + leJoueur.getNom() + " pioche une carte!");
			laManche.getLeTas().afficherCarteVisible();
		}

	}

}
