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

/**
 * La Classe ControleurCouleurs (MVC).
 */
public class ControleurCouleurs {

	/**
	 * Constructeur du controleur couleurs.
	 * Permet d'attacher une action à chaque boutons couleur.
	 * 
	 * @param manche la manche
	 * @param moi moi
	 * @param couleurs boutons couleurs
	 * @param frame la frame
	 * @param inter l'interface de la manche
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
