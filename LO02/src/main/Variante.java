package main;

import java.util.LinkedList;

public abstract class Variante {
	
	protected LinkedList<String> valeurEffet;
	protected String nom;

	public Variante() {
		valeurEffet = new LinkedList<String>();
	}
	
	public abstract void setCarteRejouer();
	
	public abstract void setCartePasseSonTour();
	
	public abstract void setCarteChangeDeSens();
	
	public abstract void setCarteContre();
	
	public abstract void setCartePiocher();
	
	public abstract void setCarteTirerCarteDuJoueur();
	
	public abstract void setCarteQuatre();
	
	
	
}
