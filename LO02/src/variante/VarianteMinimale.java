package variante;

import effet.EffetContre;
import effet.EffetRejouer;

public class VarianteMinimale extends Variante {
	
	public VarianteMinimale() {
		super();
		this.nom = "Minimal";
		this.valeurContre = "8";
		valeurEffetDefense.put("10",new EffetRejouer());
		valeurEffetDefense.put("8",new EffetContre());
	}
}
