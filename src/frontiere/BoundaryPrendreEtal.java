package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println(
					"Je suis desolee " + nomVendeur + " mais il faut etre un habitant du village pour commercer ici.");
		} else {
			System.out.println(
					"Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un etal.");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out.println("Desolee " + nomVendeur + " je nai plus detals qui ne soit pas deja occupe.");
				
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder renseignement = new StringBuilder();
		renseignement.append("C est parfait il me reste un etal pour vous !\n");
		renseignement.append("il me faudrait quelques renseignements :\n");
		System.out.println(renseignement.toString());
		System.out.println("Quel produit souhaitez vous vendre ?");
		String produit = scan.next();
		StringBuilder questionproduit = new StringBuilder();
		questionproduit.append("Combien souhaitez vous en vendre ?");
		int nbProduit = Clavier.entrerEntier(questionproduit.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s est installe a l etal n " + numeroEtal);
		}
			
	}
}
