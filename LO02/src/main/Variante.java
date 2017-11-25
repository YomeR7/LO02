package main;

import java.util.HashMap;

public class Variante {
	
	protected HashMap<Effet, String> valeurEffetDefense,valeurEffetAttaque;
	protected String nom;

	protected Variante() {
		valeurEffetDefense = new HashMap<Effet, String>();
		valeurEffetAttaque = new HashMap<Effet, String>();
	}
	
	private static Variante INSTANCE = new Variante();
	
	public static Variante getInstance() {
		return INSTANCE;
	}
	
	public HashMap<Effet, String> getValeurEffetDefense() {
		return valeurEffetDefense;
	}


	public void setValeurEffetDefense(HashMap<Effet, String> valeurEffetDefense) {
		this.valeurEffetDefense = valeurEffetDefense;
	}


	public HashMap<Effet, String> getValeurEffetAttaque() {
		return valeurEffetAttaque;
	}


	public void setValeurEffetAttaque(HashMap<Effet, String> valeurEffetAttaque) {
		this.valeurEffetAttaque = valeurEffetAttaque;
	}	
	
}
