package controleur;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import effet.EffetContre;
import joueurs.Joueur;
import main.Manche;
import vue.InterfaceManche;

public class ControleurCouleurs {

	public ControleurCouleurs(Manche manche, Joueur moi, JButton[] couleurs,JFrame frame,InterfaceManche inter) {
		JLabel choisir = new JLabel("Choisir la nouvelle couleur");
		choisir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		choisir.setBounds(125, 325, 300, 25);
		frame.getContentPane().add(choisir);
		frame.repaint();
		for (int i = 0;i<4;i++) {
			JLabel chois = choisir;
			int ind = i;
			couleurs[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for (int i=0; i<4;i++) {
						frame.getContentPane().remove(couleurs[i]);
					}
					frame.getContentPane().remove(chois);
					frame.repaint();
					EffetContre effet = (EffetContre) moi.getlEffet();
					effet.setnCouleur(couleurs[ind].getText());
					effet.setAttente(false);
					inter.setAttente(false);
				}
			});
		}
	}
	
}
