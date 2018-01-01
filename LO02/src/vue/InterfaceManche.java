package vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controleur.ControleurManche;
import jeu.Tas;
import joueurs.*;
import main.Manche;
import main.Partie;
import java.awt.Font;

public class InterfaceManche implements Observer,Runnable {

	private JFrame frame;
	private Manche manche;
	private byte nbManche;
	private Joueur moi;
	private Tas leTas;
	private JButton[] cartesJ;
	private JLabel carteV,tourDe;
	private ControleurManche controleur;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public InterfaceManche(JFrame frame, Manche manche) {
		this.frame = frame;
		this.manche = manche;
		this.manche.addObserver(this);
		System.out.println(manche.getVarianteManche().getNom());
		initialize();
		System.out.println("fin ini");
		leTas = manche.commencerManche();
		leTas.addObserver(this);
		leTas.notifier();
		moi = Partie.getInstance().getLesJoueurs().get(Partie.getInstance().getLesJoueurs().size()-1);
		moi.addObserver(this);
		moi.trierCartes();
		cartesJ = new JButton[moi.getSesCartes().size()];
		for (int i = 0; i < moi.getSesCartes().size(); i++) {
			JButton carte = new JButton(new ImageIcon("cartes/"+moi.getSesCartes().get(i).getValeur().toLowerCase()+"_"+moi.getSesCartes().get(i).getCouleur().toLowerCase()+".png"));
			carte.setBounds(i+85*i, 400, 85, 125);
			cartesJ[i] = carte;
			this.frame.getContentPane().add(cartesJ[i]);
		}
		Thread thread = new Thread(this);
		thread.start();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMancheN = new JLabel("MANCHE n\u00B0"+ Manche.getNbManche());
		lblMancheN.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMancheN.setBounds(198, 110, 168, 25);
		frame.getContentPane().add(lblMancheN);
		
		JLabel dosCarte = new JLabel(new ImageIcon("cartes/dos_carte.png"));
		dosCarte.setBounds(200, 150, 85, 125);
		frame.getContentPane().add(dosCarte);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof Tas) {
			if (carteV instanceof JLabel) {
				this.frame.getContentPane().remove(carteV);
			}
			carteV = new JLabel(new ImageIcon("cartes/" + leTas.getCarteVisible().getValeur().toLowerCase()+"_"+ leTas.getCarteVisible().getCouleur().toLowerCase()+".png"));
			carteV.setBounds(300, 150, 85, 125);
			this.frame.getContentPane().add(carteV);
			this.frame.repaint();
		} else if (o instanceof Manche) {
			if (tourDe instanceof JLabel) {
				this.frame.getContentPane().remove(tourDe);
			}
			tourDe = new JLabel("Tour de "+ manche.getJoueurEnCours().getNom());
			tourDe.setFont(new Font("Tahoma", Font.BOLD, 20));
			tourDe.setBounds(198, 280, 168, 25);
			this.frame.getContentPane().add(tourDe);
			this.frame.repaint();
		}
		
		if (o instanceof JoueurPhysique) {
			System.out.println("ca remplace");
			for (int i = 0; i < cartesJ.length; i++) {
				this.frame.getContentPane().remove(cartesJ[i]);
			}
			cartesJ = new JButton[moi.getSesCartes().size()];
			for (int i = 0; i < moi.getSesCartes().size(); i++) {
				JButton carte = new JButton(new ImageIcon("cartes/"+moi.getSesCartes().get(i).getValeur().toLowerCase()+"_"+moi.getSesCartes().get(i).getCouleur().toLowerCase()+".png"));
				carte.setBounds(i+85*i, 400, 85, 125);
				cartesJ[i] = carte;
				this.frame.getContentPane().add(cartesJ[i]);
				this.frame.repaint();
			}
			
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (manche.getJoueurEnCours().getSesCartes().size() != 0) {
			if (manche.getJoueurEnCours() instanceof JoueurPhysique) {
				new ControleurManche(cartesJ,(JoueurPhysique) moi,frame,manche);
			}
			System.out.println("WOUHOU");
			manche.jouerTourG();
			System.out.println("fin tour");
		}
	}
}
