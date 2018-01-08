package controleur;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import jeu.Tas;
import joueurs.JoueurPhysique;
import main.Manche;

public class ControleurManche {

	public ControleurManche(JButton[] cartesJ, JoueurPhysique moi, JFrame frame, Manche laManche) {
		System.out.println("CREATION");
		JButton piocher = new JButton("Piocher");
		piocher.setFont(new Font("Tahoma", Font.BOLD, 20));
		piocher.setBounds(200, 150, 85, 125);
		piocher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("PIOCHER");
				moi.getSesCartes().add(laManche.getLePaquet().piocherUneCarte());
				moi.setAttenteVue(false);
				frame.repaint();
			}
		});
		frame.getContentPane().add(piocher);
		frame.repaint();
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
