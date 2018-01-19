package vue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import main.Manche;

import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Class InterfaceVariante.
 */
public class InterfaceVariante {

	/** La fenetre */
	private JFrame frame;
	
	/** Liste des variantes. */
	private JList<Object> list;
	
	/** Bouton choisir variante. */
	private JButton btnChoisirVariante;
	
	/** La manche. */
	private Manche manche;

	/**
	 * Constructeur de la variante
	 *
	 * @param aFrame the a frame
	 * @param manche the manche
	 */

	public InterfaceVariante(JFrame aFrame,Manche manche) {
		this.manche = manche;
		this.frame = aFrame;
		initialize();
		
	}

	/**
	 * Initialisation des composants de la fenetre.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 453, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		list = new JList<Object>();
		list.setFont(new Font("Dialog", Font.PLAIN, 12));
		list.setBounds(151, 93, 122, 90);
		list.setModel(new AbstractListModel<Object>() {
			String[] values = new String[] {"Variante Minimale", "Variante Monclar", "Variante 5", "Variante Maou", "Variante Man et Rasta"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(0);
		frame.getContentPane().add(list);
		
		JLabel lblListeDesVariantes = new JLabel("Liste des variantes");
		lblListeDesVariantes.setBounds(151, 68, 109, 14);
		frame.getContentPane().add(lblListeDesVariantes);
		
		JLabel lblChoixDeLa = new JLabel("CHOIX DE LA VARIANTE");
		lblChoixDeLa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChoixDeLa.setBounds(105, 23, 203, 14);
		frame.getContentPane().add(lblChoixDeLa);
		
		btnChoisirVariante = new JButton("Choisir variante");
		btnChoisirVariante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manche.setVarianteManche((String) list.getSelectedValue());
				frame.getContentPane().removeAll();
				frame.repaint();
				new InterfaceManche(frame,manche);
			}
		});
		btnChoisirVariante.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnChoisirVariante.setBounds(138, 214, 144, 23);
		frame.getContentPane().add(btnChoisirVariante);
	}
}
