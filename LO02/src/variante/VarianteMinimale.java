package variante;

import effet.EffetContre;
import effet.EffetRejouer;

// TODO: Auto-generated Javadoc
/**
 * The Class VarianteMinimale.
 */
public class VarianteMinimale extends Variante {
	
	/* (non-Javadoc)
	 * @see variante.Variante#Variante()
	 */
	public VarianteMinimale() {
		super();
		this.nom = "Minimal";
		this.valeurContre = "8";
		valeurEffetDefense.put("10",new EffetRejouer());
		valeurEffetDefense.put("8",new EffetContre());
	}
}
