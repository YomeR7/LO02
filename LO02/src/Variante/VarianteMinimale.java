package Variante;

import Effet.EffetContre;
import Effet.EffetRejouer;

public class VarianteMinimale extends Variante {
	
	public VarianteMinimale() {
		super();
		this.nom = "Minimal";
		this.valeurContre = "8";
		valeurEffetDefense.put("10",new EffetRejouer());
		valeurEffetDefense.put("8",new EffetContre());
	}
}
