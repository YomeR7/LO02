package variante;

import effet.EffetContre;
import effet.EffetPasseTour;
import effet.EffetPiocher2;
import effet.EffetRejouer;
import variante.Variante;

// TODO: Auto-generated Javadoc
/**
 * The Class VarianteCarteMaou.
 */
public class VarianteCarteMaou extends Variante {

	/* (non-Javadoc)
	 * @see variante.Variante#Variante()
	 */
	public VarianteCarteMaou() {
		super();
		this.nom = "Carte et Maou";
		this.valeurContre = "Valet";
		valeurEffetDefense.put("10",new EffetRejouer());
		valeurEffetAttaque.put("8", new EffetPasseTour());
		valeurEffetAttaque.put("7", new EffetPiocher2());
		valeurEffetDefense.put("Valet",new EffetContre());
	}
}
