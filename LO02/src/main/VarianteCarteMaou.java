package main;

public class VarianteCarteMaou extends Variante {

	public VarianteCarteMaou() {
		super();
		this.nom = "Carte et Maou";
		valeurEffetDefense.put("10",new EffetRejouer());
		valeurEffetAttaque.put("8", new EffetPasseTour());
		valeurEffetAttaque.put("7", new EffetPiocher2());
		valeurEffetDefense.put("Valet",new EffetContre());
	}
}
