package variante;

import effet.EffetChangeSens;
import effet.EffetContre;
import effet.EffetPiocher2ouContre;
import effet.EffetRejouer;
import variante.Variante;

public class Variante5 extends Variante {
	
	public Variante5() {
		super();
		this.nom = "5";
		this.valeurContre = "8";
		valeurEffetDefense.put("10",new EffetRejouer());
		valeurEffetDefense.put("8", new EffetContre());
		valeurEffetDefense.put("7", new EffetChangeSens());
		valeurEffetAttaque.put("As", new EffetPiocher2ouContre());
		
	}
}
