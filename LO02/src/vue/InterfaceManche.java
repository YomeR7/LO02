package vue;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controleur.ControleurCouleurs;
import controleur.ControleurManche;
import jeu.Tas;
import joueurs.*;
import main.Manche;
import main.Partie;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceManche implements Observer {

	private JFrame frame;
	private Manche manche;
	private Joueur moi;
	private Tas leTas;
	private JButton[] cartesJ,couleurs;
	private JLabel carteV,tourDe,choisir;
	private ControleurManche controleur;
	private JLabel[] ias;
	private Boolean attente = false;
	private JButton piocher;
	/**
	 * Launch the application.
	 */
	
	public Boolean getAttente() {
		return attente;
	}

	public void setAttente(Boolean attente) {
		this.attente = attente;
	}

	/**
	 * Create the application.
	 */
	public InterfaceManche(JFrame frame, Manche manche) {
		
		this.frame = frame;
		this.manche = manche;
		this.manche.addObserver(this);
		leTas = manche.commencerManche();
		leTas.addObserver(this);
		moi = Partie.getInstance().getLesJoueurs().get(Partie.getInstance().getLesJoueurs().size()-1);
		initialize();
		leTas.notifier();
		for (int i = 0; i<Partie.getInstance().getLesJoueurs().size(); i++) {
			Partie.getInstance().getLesJoueurs().get(i).addObserver(this);
		}
		affichageCartes();
		ias = new JLabel[Partie.getInstance().getLesJoueurs().size()-1];
		affichageIAs();
		Thread thread = new Thread(manche);
		thread.start();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(200, 50, 870, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setContentPane(new JLabel(new ImageIcon("cartes/tapis.png")));
		
		JLabel lblMancheN = new JLabel("MANCHE n\u00B0"+ Manche.getNbManche());
		lblMancheN.setForeground(Color.WHITE);
		lblMancheN.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMancheN.setBounds(300, 110, 168, 25);
		frame.getContentPane().add(lblMancheN);
		
		JLabel dosCarte = new JLabel(new ImageIcon("cartes/dos_carte.png"));
		dosCarte.setBounds(300, 150, 85, 125);
		frame.getContentPane().add(dosCarte);
		
		piocher = new JButton(new ImageIcon("cartes/piocher.png"));
		piocher.setBounds(300, 150, 85, 125);
		piocher.setVisible(false);
		piocher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moi.piocher();
				((JoueurPhysique) moi).setAttenteVue(false);
				affichageCartes();
				frame.repaint();
			}
		});
		frame.getContentPane().add(piocher);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (o instanceof Joueur) {
			if (arg instanceof String) {
				JLabel effet = new JLabel((String) arg);
				effet.setForeground(Color.WHITE);
				effet.setBounds(300,50,250,25);
				effet.setFont(new Font("Tahoma", Font.PLAIN, 20));
				this.frame.getContentPane().add(effet);
				this.frame.repaint();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.frame.getContentPane().remove(effet);
			}
		}
		
		if (o instanceof Tas) {
			if (carteV instanceof JLabel) {
				this.frame.getContentPane().remove(carteV);
			}
			if (couleurs instanceof JButton[]) {
				this.frame.getContentPane().remove(choisir);
				for (int i=0; i<4;i++) {
					this.frame.getContentPane().remove(couleurs[i]);
				}
			}
			if (piocher instanceof JButton) {
				piocher.setVisible(false);
			}
			carteV = new JLabel(new ImageIcon("cartes/" + leTas.getCarteVisible().getValeur().toLowerCase()+"_"+ leTas.getCarteVisible().getCouleur().toLowerCase()+".png"));
			carteV.setBounds(400, 150, 85, 125);
			this.frame.getContentPane().add(carteV);
			affichageCartes();
			if (leTas.getCarteVisible().getValeur().equals("8") && manche.getJoueurEnCours() instanceof JoueurPhysique) {
				setAttente(true);
				afficherCouleurs();
				new ControleurCouleurs(manche,(JoueurPhysique) moi, couleurs,frame,this);
				new VueTexteCouleur((JoueurPhysique) moi, manche);
			}
			this.frame.repaint();
		}
		
		if (o instanceof Manche) {
			if (tourDe instanceof JLabel) {
				this.frame.getContentPane().remove(tourDe);
				for (int i = 0; i < ias.length; i++) {
					this.frame.getContentPane().remove(ias[i]);
				}
				affichageIAs();
			}
			if (arg instanceof String && arg.equals("fin")) {
				frame.getContentPane().removeAll();
				new InterfaceVariante(frame, Partie.getInstance().lancerPartie());
			}
			tourDe = new JLabel("Tour de "+ manche.getJoueurEnCours().getNom());
			tourDe.setForeground(Color.WHITE);
			tourDe.setFont(new Font("Tahoma", Font.BOLD, 20));
			tourDe.setBounds(300, 280, 168, 25);
			this.frame.getContentPane().add(tourDe);
			this.frame.repaint();
		}
		
		if (o instanceof JoueurPhysique) {
			controleur = new ControleurManche(cartesJ,(JoueurPhysique) moi,frame,manche,piocher);
			if (!attente) {
				new VueTexte((JoueurPhysique) moi);	
			}		
		}
	}
	
	public void afficherCouleurs() {
		couleurs = new JButton[4];
		couleurs[0] = new JButton("Carreau");
		couleurs[1] = new JButton("Coeur");
		couleurs[2] = new JButton("Pique");
		couleurs[3] = new JButton("Trefle");
		for (int i = 0; i < 4; i++) {
			couleurs[i].setFont(new Font("Tahoma", Font.PLAIN, 20));
			couleurs[i].setBounds(120+150*i, 350, 125, 25);
			this.frame.getContentPane().add(couleurs[i]);
		}
		choisir = new JLabel("Choisir la nouvelle couleur");
		choisir.setForeground(Color.WHITE);
		choisir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		choisir.setBounds(225, 325, 300, 25);
		this.frame.getContentPane().add(choisir);
		this.frame.repaint();
	}
	
	public void affichageCartes() {
		moi.trierCartes();
		if (cartesJ instanceof JButton[]) {
			for (int i = 0; i < cartesJ.length; i++) {
				this.frame.getContentPane().remove(cartesJ[i]);
			}
		}
		cartesJ = new JButton[moi.getSesCartes().size()];
		for (int i = 0; i < moi.getSesCartes().size(); i++) {
			JButton carte = new JButton(new ImageIcon("cartes/"+moi.getSesCartes().get(i).getValeur().toLowerCase()+"_"+moi.getSesCartes().get(i).getCouleur().toLowerCase()+".png"));
			carte.setBounds(10+85*i, 400, 85, 125);
			cartesJ[i] = carte;
			this.frame.getContentPane().add(cartesJ[i]);
		}
		piocher.setVisible(true);
		frame.repaint();
		
	}
	
	public void affichageIAs() {
		for (int i = 0; i < (Partie.getInstance().getLesJoueurs().size()-1); i++) {
			JLabel ia = new JLabel(Partie.getInstance().getLesJoueurs().get(i).getNom() + ": " + Partie.getInstance().getLesJoueurs().get(i).getSesCartes().size() + " carte(s)");
			ia.setForeground(Color.WHITE);
			ia.setFont(new Font("Tahoma", Font.BOLD, 12));
			ia.setBounds(250+125*i + i, 10, 125, 25);
			ias[i] = ia;
			this.frame.getContentPane().add(ias[i]);
		}
	}
}
