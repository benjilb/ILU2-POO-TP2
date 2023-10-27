package controleur;

import villagegaulois.Etal;


public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public boolean isVendeur(String nomVendeur) {
		if(controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur) != null) {
			return true;
		} else 
			return false;
	}
	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		//TODO a completer
		String[] donneesEtal = new String[5];
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		donneesEtal[0] = String.valueOf(etal.isEtalOccupe());
		if(etal.isEtalOccupe()) {
			donneesEtal[1] = etal.getVendeur().getNom();
			donneesEtal[2] = etal.getProduit();
			donneesEtal[3] = etal.etatEtal()[3];
			donneesEtal[4] = etal.etatEtal()[4];
		}
		
		return donneesEtal;
	}

}
/*public String[] etatEtal() {
	String[] donneesVente = new String[5];
	donneesVente[0] = String.valueOf(etalOccupe);
	if (etalOccupe) {
		donneesVente[1] = vendeur.getNom();
		donneesVente[2] = produit;
		donneesVente[3] = String.valueOf(quantiteDebutMarche);
		donneesVente[4] = String.valueOf(quantiteDebutMarche - quantite);
	}
	return donneesVente;
}
*/