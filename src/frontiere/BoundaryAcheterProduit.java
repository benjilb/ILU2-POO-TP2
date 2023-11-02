package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO à completer
		System.out.println("Quel produit voulez vous acheter ?");
		String produit = scan.next();
		StringBuilder chaine = new StringBuilder();
		chaine.append("Chez quel commercant voulez vous acheter des " + produit + "\n");
		Gaulois[] listeCommercant = controlAcheterProduit.controlrechercherVendeursProduit(produit);
		if(listeCommercant == null) {
			System.out.println("Desolee, personne ne vend ce produit au marche.\n");
		} else {
			for (int i=0; i < listeCommercant.length ; i++) {
				chaine.append(i+1 +" - " + listeCommercant[i].getNom() +  "\n");
			}
			int choixUtilisateur = Clavier.entrerEntier(chaine.toString());
			String[] infosMarche = controlAcheterProduit.donnerInfosMarche();
			Etal etal = controlAcheterProduit.trouverEtalVendeur(infosMarche[(choixUtilisateur-1)*3]);
			String nomVendeur = etal.getVendeur().getNom();
			if(!controlAcheterProduit.verifierIdentite(nomVendeur)) {
				System.out.println(
						"Je suis desolee " + nomVendeur + " mais il faut etre un habitant de notre village pour commercer ici \n");
			} else {
				transaction(nomAcheteur,nomVendeur, etal);
		
			}
		}
	}
	
	private void transaction(String nomAcheteur,String nomVendeur, Etal etal) {
		StringBuilder chaineproduit = new StringBuilder();
		chaineproduit.append(nomAcheteur + " se deplace jusqua l'etal du vendeur " + nomVendeur + "\n");
		chaineproduit.append("Bonjour " + nomAcheteur + "\n");
		chaineproduit.append("Combien de " + etal.getProduit() + " voulez vous acheter? \n");
		int nbquantite = Clavier.entrerEntier(chaineproduit.toString());
		if(etal.getQuantite()==0) {
			System.out.println(nomAcheteur + " veut acheter " + nbquantite + " " + etal.getProduit() + ", malheuresement il n'y en a plus ! \n");
		} else if (nbquantite>etal.getQuantite()){
			System.out.println(nomAcheteur + " veut acheter " + nbquantite + ", malheureusement " + nomVendeur + " n'en a plus que " + etal.getQuantite() + ". " + nomAcheteur + " achete tout le stock de " + nomVendeur + "\n");
			etal.acheterProduit(etal.getQuantite());
		} else {
			etal.acheterProduit(nbquantite);
			System.out.println(nomAcheteur + " achete " + nbquantite + " " + etal.getProduit() + " a " + nomVendeur);
		}
		
	}
			
}
