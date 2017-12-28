package variante;

import effet.EffetChangeSens;
import effet.EffetPasseTour;
import effet.EffetPiocher2;
import effet.EffetPiocher2ouContre;
import effet.EffetRejouer;

public class VarianteManRasta extends Variante{

	public VarianteManRasta() {
		super();
		this.nom = "Man et Resta simplifié";
		valeurEffetAttaque.put("2", new EffetPiocher2());
		valeurEffetDefense.put("10", new EffetRejouer());
		valeurEffetAttaque.put("7", new EffetPasseTour());
		valeurEffetAttaque.put("As", new EffetPiocher2ouContre());
		valeurEffetDefense.put("Valet", new EffetChangeSens());
	}
}
