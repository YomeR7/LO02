package main;

import java.util.LinkedList;
import java.util.List;

public class VarianteMinimale extends Variante {
	
	public VarianteMinimale() {
		super();
		this.nom = "Minimal";
		this.setCarteRejouer();
		this.setCarteContre();
	}

	public List<String> getValeurEffet() {
		return valeurEffet;
	}

	public void setValeurEffet(LinkedList<String> valeurEffet) {
		this.valeurEffet = valeurEffet;
	}

	@Override
	public void setCarteRejouer() {
		// TODO Auto-generated method stub
		valeurEffet.add("10");
	}

	@Override
	public void setCartePasseSonTour() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setCarteChangeDeSens() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setCarteContre() {
		// TODO Auto-generated method stub
		valeurEffet.add("8");
	}

	@Override
	public void setCartePiocher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCarteTirerCarteDuJoueur() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCarteQuatre() {
		// TODO Auto-generated method stub
		
	}

}
