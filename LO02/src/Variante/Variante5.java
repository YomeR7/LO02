package Variante;

import Effet.EffetChangeSens;
import Effet.EffetContre;
import Effet.EffetPiocher2ouContre;
import Effet.EffetRejouer;
import Variante.Variante;

public class Variante5 extends Variante {
	
	public Variante5() {
		super();
		this.nom = "5";
		this.valeurContre = "8";
		valeurEffetDefense.put("10",new EffetRejouer());
		valeurEffetDefense.put("8", new EffetContre());
		valeurEffetDefense.put("7", new EffetChangeSens());
		valeurEffetAttaque.put("As", new EffetPiocher2ouContre());
		
	}
}
