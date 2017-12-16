package Variante;

import Effet.EffetChangeSens;
import Effet.EffetPasseTour;
import Effet.EffetPiocher2;
import Effet.EffetPiocher2ouContre;
import Effet.EffetRejouer;

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
