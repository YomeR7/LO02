package main;

import java.util.HashMap;

public class Variante {
	
	protected HashMap<String, Effet> valeurEffetDefense,valeurEffetAttaque;
	protected String nom;

	protected Variante() {
		valeurEffetDefense = new HashMap<String, Effet>();
		valeurEffetAttaque = new HashMap<String, Effet>();
	}
	
	private static Variante INSTANCE = new Variante();
	
	public static Variante getInstance() {
		return INSTANCE;
	}
	
	public HashMap<String, Effet> getValeurEffetDefense() {
		return valeurEffetDefense;
	}


	public void setValeurEffetDefense(HashMap<String, Effet> valeurEffetDefense) {
		this.valeurEffetDefense = valeurEffetDefense;
	}


	public HashMap<String, Effet> getValeurEffetAttaque() {
		return valeurEffetAttaque;
	}


	public void setValeurEffetAttaque(HashMap<String, Effet> valeurEffetAttaque) {
		this.valeurEffetAttaque = valeurEffetAttaque;
	}	
	
}
