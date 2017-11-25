package main;

public class VarianteMinimale extends Variante {
	
	public VarianteMinimale() {
		super();
		this.nom = "Minimal";
		valeurEffetDefense.put("10",new EffetRejouer());
		valeurEffetDefense.put("8",new EffetContre());
	}
}
