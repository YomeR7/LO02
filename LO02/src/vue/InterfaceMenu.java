package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * La classe InterfaceMenu Vue du MVC.
 */
public class InterfaceMenu {

	/** la fenetre. */
	private JFrame frame;

	/**
	 * Lance le jeu.
	 *
	 * @param args les arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceMenu window = new InterfaceMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Constructeur de Interface Menu qui mets les éléments de la fenetre.
	 */
	public InterfaceMenu() {
		frame = new JFrame();
		frame.setBounds(100, 100, 542, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAmericain = new JLabel("8 AMERICAIN");
		lblAmericain.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAmericain.setBounds(181, 21, 151, 29);
		frame.getContentPane().add(lblAmericain);
		
		JLabel lblParFlorianEsslinger = new JLabel("Par Florian Esslinger et Guillaume Rousselet");
		lblParFlorianEsslinger.setBounds(131, 290, 265, 29);
		frame.getContentPane().add(lblParFlorianEsslinger);
		
		JButton btnNouvellePartie = new JButton("Nouvelle Partie");
		btnNouvellePartie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNouvellePartie.setBounds(172, 150, 175, 33);
		frame.getContentPane().add(btnNouvellePartie);
		
		btnNouvellePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().removeAll();
				frame.repaint();
				new InterfacePartie(frame);
			}
		});
	}

}
