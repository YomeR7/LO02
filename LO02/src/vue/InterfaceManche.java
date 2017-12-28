package vue;

import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class InterfaceManche {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public InterfaceManche() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblCc = new JLabel("CC");
		frame.getContentPane().add(lblCc, BorderLayout.CENTER);
	}

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

}
