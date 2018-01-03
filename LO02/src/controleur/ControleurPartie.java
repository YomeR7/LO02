package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import joueurs.Joueur;
import joueurs.JoueurArtificiel;
import joueurs.JoueurPhysique;
import main.Manche;
import main.Partie;
import strategie.Aggresif;
import strategie.Facile;
import vue.InterfaceVariante;

public class ControleurPartie {
	
	public ControleurPartie(HashMap<String, JCheckBox> IAs, HashMap<String, JRadioButton> diffs 
			,JButton lancer,JRadioButton positif,JRadioButton  negatif, JTextField textField, Partie maPartie, JFrame frame) {
		

		positif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				negatif.setSelected(!positif.isSelected());
			}
		});
		
		negatif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				positif.setSelected(!negatif.isSelected());
			}
		});
		
		for (int i = 1; i < 7; i++) {
			int ind = i;
			IAs.get("IA"+i).addActionListener(new ActionListener() {
				public final void actionPerformed(ActionEvent e) {
					System.out.println("PRESS");
					diffs.get("IA"+ ind +"f").setSelected(IAs.get("IA"+ind).isSelected());
				}
			}
			);
		};
		
		for (int i = 1; i < 7; i++) {
			int ind = i;
			diffs.get("IA"+i+"f").addActionListener(new ActionListener() {
				public final void actionPerformed(ActionEvent e) {
					diffs.get("IA"+ ind +"a").setSelected(!diffs.get("IA"+ ind +"a").isSelected());
				}
			});
			diffs.get("IA"+i+"a").addActionListener(new ActionListener() {
				public final void actionPerformed(ActionEvent e) {
					diffs.get("IA"+ ind +"f").setSelected(!diffs.get("IA"+ ind +"f").isSelected());
				}
			});
		};
		
		
		
		lancer.addActionListener(new ActionListener() {
			Partie laPartie = maPartie;
			public void actionPerformed(ActionEvent e) {
				System.out.println("BIM");
				ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
				byte modeComptage;
				if (positif.isSelected()) {
					modeComptage = 1;
				} else {
					modeComptage = 0;
				}
				for (int i = 0; i < 6; i++) {
					if (IAs.get("IA"+(i+1)).isSelected()) {
						if (diffs.get("IA"+(i+1)+"f").isSelected()) {
							joueurs.add(new JoueurArtificiel("IA"+(i+1), (byte) i, new Facile()));
						} else {
							joueurs.add(new JoueurArtificiel("IA"+(i+1), (byte) i, new Aggresif()));
						}
					}
				}
				int i = joueurs.size();
				joueurs.add(new JoueurPhysique(textField.getText(), (byte) i));
				laPartie.updateP(modeComptage, joueurs);
				Manche manche = laPartie.nouvelleManche();
				frame.getContentPane().removeAll();
				frame.repaint();
				new InterfaceVariante(frame,manche);
			}
		});
		
	}
	
}
