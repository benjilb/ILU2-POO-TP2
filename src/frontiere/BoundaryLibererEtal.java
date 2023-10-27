package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		//TODO a completer
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous netes pas inscrit au marche aujourd hui !");
		} else {
			String[] donneesEtal = new String[5];
			donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = false;
			if(donneesEtal[0] == "true") {
				etalOccupe = true;
			}
			if(etalOccupe) {
				System.out.println("Vous avez vendu " + donneesEtal[4] + " sur " + donneesEtal[3] + " " + donneesEtal[2] + ".\n");
				System.out.println("Au revoir " + nomVendeur + " passez une bonne journee.");
				
			}
			
		}
	}

}
