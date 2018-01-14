/*
 * 
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import joueurs.JoueurPhysique;
import main.Manche;

// TODO: Auto-generated Javadoc
/**
 * The Class ControleurManche.
 */
public class ControleurManche {

	/**
	 * Instantiates a new controleur manche.
	 *
	 * @param cartesJ the cartes J
	 * @param moi the moi
	 * @param frame the frame
	 * @param laManche the la manche
	 * @param piocher the piocher
	 */
	public ControleurManche(JButton[] cartesJ, JoueurPhysique moi, JFrame frame, Manche laManche,JButton piocher) {
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
