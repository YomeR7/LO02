package vue;

import controleur.*;
import main.Partie;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class InterfacePartie {

	private JFrame frame;
	private JTextField textField;
	private HashMap<String, JCheckBox> IAs;
	private HashMap<String,JRadioButton> diffs;
	private JButton lancer;
	private JRadioButton positif,negatif;
	private Partie maPartie;
	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacePartie window = new InterfacePartie();
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
	public InterfacePartie(JFrame aFrame) {
		this.frame = aFrame;
		IAs = new HashMap<String, JCheckBox>();
		diffs = new HashMap<String, JRadioButton>();
		initialize();
		new ControleurPartie(IAs, diffs,lancer,positif,negatif,textField,Partie.getInstance());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 542, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblB = new JLabel("8 AMERICAIN : Configuration Partie");
		lblB.setBounds(182, 11, 177, 14);
		frame.getContentPane().add(lblB);
		
		JCheckBox IA1 = new JCheckBox("IA1");
		IA1.setSelected(true);
		IA1.setBounds(56, 106, 97, 23);
		frame.getContentPane().add(IA1);
		IAs.put("IA1", IA1);
		
		JRadioButton IA1f = new JRadioButton("Facile");
		IA1f.setSelected(true);
		IA1f.setBounds(228, 106, 109, 23);
		frame.getContentPane().add(IA1f);
		diffs.put("IA1f", IA1f);
		
		JRadioButton IA1a = new JRadioButton("Aggresif");
		IA1a.setBounds(339, 106, 109, 23);
		frame.getContentPane().add(IA1a);
		diffs.put("IA1a", IA1a);
		
		JCheckBox IA2 = new JCheckBox("IA2");
		IA2.setBounds(56, 132, 97, 23);
		frame.getContentPane().add(IA2);
		IAs.put("IA2", IA2);
		
		JRadioButton IA2f = new JRadioButton("Facile");
		IA2f.setBounds(228, 132, 109, 23);
		frame.getContentPane().add(IA2f);
		diffs.put("IA2f", IA2f);
		
		JRadioButton IA2a = new JRadioButton("Aggresif");
		IA2a.setBounds(339, 132, 109, 23);
		frame.getContentPane().add(IA2a);
		diffs.put("IA2a", IA2a);
		
		JCheckBox IA3 = new JCheckBox("IA3");
		IA3.setBounds(56, 158, 97, 23);
		frame.getContentPane().add(IA3);
		IAs.put("IA3", IA3);
		
		JRadioButton IA3f = new JRadioButton("Facile");
		IA3f.setBounds(228, 158, 109, 23);
		frame.getContentPane().add(IA3f);
		diffs.put("IA3f", IA3f);
		
		JRadioButton IA3a = new JRadioButton("Aggresif");
		IA3a.setBounds(339, 158, 109, 23);
		frame.getContentPane().add(IA3a);
		diffs.put("IA3a", IA3a);
	
		JCheckBox IA4 = new JCheckBox("IA4");
		IA4.setBounds(56, 184, 97, 23);
		frame.getContentPane().add(IA4);
		IAs.put("IA4", IA4);
		
		JRadioButton IA4f = new JRadioButton("Facile");
		IA4f.setBounds(228, 184, 109, 23);
		frame.getContentPane().add(IA4f);
		diffs.put("IA4f", IA4f);
		
		JRadioButton IA4a = new JRadioButton("Aggresif");
		IA4a.setBounds(339, 184, 109, 23);
		frame.getContentPane().add(IA4a);
		diffs.put("IA4a", IA4a);
		
		JCheckBox IA5 = new JCheckBox("IA5");
		IA5.setBounds(56, 210, 97, 23);
		frame.getContentPane().add(IA5);
		IAs.put("IA5", IA5);
		
		JRadioButton IA5f = new JRadioButton("Facile");
		IA5f.setBounds(228, 210, 109, 23);
		frame.getContentPane().add(IA5f);
		diffs.put("IA5f", IA5f);
		
		JRadioButton IA5a = new JRadioButton("Aggresif");
		IA5a.setBounds(339, 210, 109, 23);
		frame.getContentPane().add(IA5a);
		diffs.put("IA5a", IA5a);
		
		JCheckBox IA6 = new JCheckBox("IA6");
		IA6.setBounds(56, 236, 97, 23);
		frame.getContentPane().add(IA6);
		IAs.put("IA6", IA6);
		
		JRadioButton IA6f = new JRadioButton("Facile");
		IA6f.setBounds(228, 236, 109, 23);
		frame.getContentPane().add(IA6f);
		diffs.put("IA6f", IA6f);
		
		JRadioButton IA6a = new JRadioButton("Aggresif");
		IA6a.setBounds(339, 236, 109, 23);
		frame.getContentPane().add(IA6a);
		diffs.put("IA6a", IA6a);
		
		JLabel lblNewLabel = new JLabel("IA(s)");
		lblNewLabel.setBounds(56, 85, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDiificult = new JLabel("Diificult\u00E9");
		lblDiificult.setBounds(228, 85, 46, 14);
		frame.getContentPane().add(lblDiificult);
		
		lancer = new JButton("Lancer Partie");
		lancer.setBounds(221, 296, 110, 23);
		frame.getContentPane().add(lancer);
		
		JLabel lblModeComptage = new JLabel("Mode comptage :");
		lblModeComptage.setBounds(107, 270, 97, 14);
		frame.getContentPane().add(lblModeComptage);
		
		negatif = new JRadioButton("N\u00E9gatif");
		negatif.setSelected(true);
		negatif.setBounds(200, 266, 109, 23);
		frame.getContentPane().add(negatif);
		
		positif = new JRadioButton("Positif");
		
		positif.setBounds(311, 266, 109, 23);
		frame.getContentPane().add(positif);
		
		JLabel lblVotreNom = new JLabel("Votre nom: ");
		lblVotreNom.setBounds(56, 57, 60, 14);
		frame.getContentPane().add(lblVotreNom);
		
		textField = new JTextField();
		textField.setBounds(118, 54, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
