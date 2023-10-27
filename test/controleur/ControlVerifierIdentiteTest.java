package controleur;

import static org.junit.jupiter.api.Assertions.*;
import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("Le village des irreductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}


	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite,"Constructeur ne renvoie pas null");
		
	}
	
	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		assertTrue(controlVerifierIdentite.verifierIdentite("Bonemine"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Panoramix"));
		
	}

}
