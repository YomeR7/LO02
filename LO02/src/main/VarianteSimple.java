package main;

public class VarianteSimple extends Variante{

	public VarianteSimple() {
		super();
		this.nom = "simple";
		valeurEffetAttaque.put("5", new EffetPiocher2());
	}
}
