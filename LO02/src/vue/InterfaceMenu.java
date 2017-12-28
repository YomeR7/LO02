package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceMenu {

	private JFrame frame;

	/**
	 * Launch the application.
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
	 * Create the application.
	 */
	public InterfaceMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		btnNouvellePartie.setBounds(172, 105, 175, 33);
		frame.getContentPane().add(btnNouvellePartie);
		
		JButton btnNewButton = new JButton("Charger Partie");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(172, 176, 175, 33);
		frame.getContentPane().add(btnNewButton);
		
		btnNouvellePartie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("clic");
				frame.getContentPane().removeAll();
				frame.repaint();
				new InterfacePartie(frame);
			}
		});
	}

}
