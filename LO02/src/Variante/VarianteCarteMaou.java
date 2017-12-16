package Variante;

import Effet.EffetContre;
import Effet.EffetPasseTour;
import Effet.EffetPiocher2;
import Effet.EffetRejouer;
import Variante.Variante;

public class VarianteCarteMaou extends Variante {

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
