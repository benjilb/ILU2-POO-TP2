package controleur;


import static org.junit.jupiter.api.Assertions.*;
import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	
	
	
	private ControlVerifierIdentite controlVerifierIdentite;	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("Le village des irreductibles", 10, 2);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal,"Constructeur ne renvoie pas null");
		
	}
	
	@Test
	void testresteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		Gaulois panoramix = new Gaulois("Panoramix", 10);
		village.installerVendeur(bonemine, "fleurs", 10);
		assertTrue(controlPrendreEtal.resteEtals());
		village.installerVendeur(panoramix, "potion", 10);
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	@Test 
	void testprendreEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		assertTrue(controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 10) >0 );
		assertFalse(controlPrendreEtal.prendreEtal("Panoramix", "fleurs", 10) >0 );
	}
	
}
