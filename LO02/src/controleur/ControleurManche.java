/*
 * 
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import joueurs.JoueurPhysique;
import main.Manche;

/**
 * La classe ControleurManche (MVC).
 */
public class ControleurManche {

	/**
	 * Constructeur du controleur manche.
	 *
	 * @param cartesJ Boutons des cartes du joueur
	 * @param moi moi
	 * @param frame la fenetre
	 * @param laManche la manche
	 * @param piocher bouton pour piocher
	 */
	public ControleurManche(JButton[] cartesJ, JoueurPhysique moi, JFrame frame, Manche laManche,JButton piocher) {
		System.out.println("IHIIHI");
		for (int i = 0; i < cartesJ.length; i++) {
			int ind = i;
			cartesJ[ind].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					moi.setCarteChoisi(moi.getSesCartes().get(ind));
					if (moi.comparerCarte()) {
						moi.finirTour();
						frame.getContentPane().remove(cartesJ[ind]);
						frame.repaint();
					}

				}
			});
		}
		;
	}
}
