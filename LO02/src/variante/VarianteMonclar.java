package variante;

import effet.EffetChangeSens;
import effet.EffetContre;
import effet.EffetPasseTour;
import effet.EffetPiocher;
import effet.EffetPiocher3;
import effet.EffetRejouer;

// TODO: Auto-generated Javadoc
/**
 * The Class VarianteMonclar.
 */
public class VarianteMonclar extends Variante {

	/**
	 * Instantiates a new variante monclar.
	 */
	public VarianteMonclar() {
		super();
		this.nom = "Monclar";
		this.valeurContre = "8";
		valeurEffetDefense.put("10",new EffetRejouer());
		valeurEffetDefense.put("8",new EffetContre());
		valeurEffetAttaque.put("7", new EffetPasseTour());
		valeurEffetDefense.put("Valet", new EffetChangeSens());
		valeurEffetAttaque.put("9", new EffetPiocher());
		valeurEffetAttaque.put("As", new EffetPiocher3());
	}
}

