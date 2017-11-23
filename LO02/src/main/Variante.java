package main;

import java.util.ArrayList;
import java.util.List;

public abstract class Variante {
	
	protected ArrayList<String> valeurEffet;
	protected String nom;

	public Variante() {
		valeurEffet = new ArrayList<String>();
	}
	
	public abstract void setCarteRejouer();
	
	public abstract void setCartePasseSonTour();
	
	public abstract void setCarteChangeDeSens();
	
	public abstract void setCarteContre();
	
	public abstract void setCartePiocher();
	
	public abstract void setCarteTirerCarteDuJoueur();
	
	public abstract void setCarteQuatre();
	
	
	
}
