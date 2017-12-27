package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.Partie;

public class ControleurPartie {

	public ControleurPartie(JButton lancer, int[] tabIA) {  //tabIA: lenght = nbIA; 0 = fac 1 = aggressif
		lancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//récuperer les états des boutons et les convertirs en données pour le jeu
				
				Partie.getPartie();
			}
		});
	}
	
}
