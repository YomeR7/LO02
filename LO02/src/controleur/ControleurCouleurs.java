/*
 * 
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import effet.EffetContre;
import joueurs.Joueur;
import main.Manche;
import vue.InterfaceManche;

// TODO: Auto-generated Javadoc
/**
 * The Class ControleurCouleurs.
 */
public class ControleurCouleurs {

	/**
	 * Instantiates a new controleur couleurs.
	 *
	 * @param manche the manche
	 * @param moi the moi
	 * @param couleurs the couleurs
	 * @param frame the frame
	 * @param inter the inter
	 */
	public ControleurCouleurs(Manche manche, Joueur moi, JButton[] couleurs,JFrame frame,InterfaceManche inter) {
		for (int i = 0;i<4;i++) {
			int ind = i;
			couleurs[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EffetContre effet = (EffetContre) moi.getlEffet();
					effet.setnCouleur(couleurs[ind].getText());
					effet.setAttente(false);
					inter.setAttente(false);
				}
			});
		}
	}
	
}
