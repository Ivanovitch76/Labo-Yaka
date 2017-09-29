package be.steformations.it.yaka.controllers;

import java.util.ArrayList;
import java.util.List;

import be.steformations.it.yaka.beans.CaracteristiqueImpl;
import be.steformations.it.yaka.beans.ProprieteImpl;
import be.steformations.it.yaka.dao.JpaGestionnaireYaka;
import be.steformations.it.yaka.intermediaires.CaracByProprietes;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class ProduitCtrl {

	@org.springframework.beans.factory.annotation.Autowired
	private JpaGestionnaireYaka gestionnaire;
	
	public ProduitCtrl() {
		System.out.println("ProduitCtrl.ProduitCtrl()");
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("selectSsCateg")
	public String listeProduits(
			@org.springframework.web.bind.annotation.RequestParam("sousCateg") String id,
			java.util.Map<String, Object> attributs
			){
		int ssCatId = Integer.parseInt(id);
		System.out.println("ProduitCtrl.listeProduits(" + ssCatId + ")");
		gestionnaire.addStatSousCategorie(ssCatId);
		attributs.put("listeProduits", gestionnaire.getProduitsbySousCategorieId(ssCatId));
		return "/produit.jsp";
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("selectProduit")
	public String afficherProduit(
			@org.springframework.web.bind.annotation.RequestParam("produitId") String id,
			java.util.Map<String, Object> attributs
			){
		int prodId = Integer.parseInt(id);
		System.out.println("ProduitCtrl.afficherProduit(" + prodId + ")");
		gestionnaire.addStatProduit(prodId);	
		List<CaracByProprietes> carByProp = new ArrayList<>();
		for (ProprieteImpl prop : gestionnaire.getProprietesbyProduitId(prodId)){
			System.out.println("ProduitCtrl propId= " + gestionnaire.getProprietesbyProduitId(prodId));
			CaracByProprietes cbp = new CaracByProprietes();
			List<CaracteristiqueImpl> listCar = new ArrayList<>();
			listCar = gestionnaire.getCaracteristiquesbyProprieteId(prop.getId(), prodId);
			cbp.setProp(prop);
			cbp.setCarac(listCar);
			carByProp.add(cbp);
		}		
		attributs.put("afficheUnProduit", gestionnaire.getProduitbyId(prodId));
		attributs.put("afficherProprietes", carByProp);
//		attributs.put("afficherPrix", afficherPrix());
//		attributs.put("afficherProprietes", gestionnaire.getProprietesbyProduitId(prodId));

		return "/detailProduit.jsp";
	}	
	
	@org.springframework.web.bind.annotation.RequestMapping("sousProduit")
	public void configSousProduit(
			@org.springframework.web.bind.annotation.RequestParam("ssprodId") String id,
			java.util.Map<String, Object> attributs
			){
		int ssprodId = Integer.parseInt(id);
		System.out.println("ProduitCtrl.configSousProduit");
		//TO DO faire la recherche des carac du sous-produit avant de faire l'appel à afficherProduit
		
	}
	
	
	
	public String afficherPrix(){
		return null;
	}
	
}
