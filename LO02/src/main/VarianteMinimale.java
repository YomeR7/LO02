package main;

public class VarianteMinimale extends Variante {
	
	public VarianteMinimale() {
		super();
		this.nom = "Minimal";
		this.setCarteRejouer();
		this.setCarteContre();
	}

	public void setCarteRejouer() {
		// TODO Auto-generated method stub
		valeurEffetDefense.put("10",new EffetRejouer());
	}

	public void setCarteContre() {
		// TODO Auto-generated method stub
		valeurEffetDefense.put("8",new EffetContre());
	}

}
