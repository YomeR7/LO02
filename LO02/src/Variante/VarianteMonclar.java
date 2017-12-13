package main;

public class VarianteMonclar extends Variante {

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

