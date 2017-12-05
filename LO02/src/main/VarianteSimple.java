package main;

public class VarianteSimple extends Variante{

	public VarianteSimple() {
		super();
		this.nom = "Man et Resta simplifié";
		valeurEffetAttaque.put("2", new EffetPiocher2());
		valeurEffetDefense.put("10", new EffetRejouer());
		valeurEffetAttaque.put("7", new EffetPasseTour());
		valeurEffetAttaque.put("As", new EffetPiocher2ouContre());
		valeurEffetDefense.put("Valet", new EffetPiocher2());
	}
}
