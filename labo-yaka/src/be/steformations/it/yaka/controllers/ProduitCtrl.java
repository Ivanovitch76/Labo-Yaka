package be.steformations.it.yaka.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import be.steformations.it.yaka.beans.ArticleImpl;
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
//		gestionnaire.addStatSousCategorie(ssCatId);
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
		
		List<CaracByProprietes> carByProp = new ArrayList<>();
	
		attributs.put("afficheUnProduit", gestionnaire.getProduitbyId(prodId));
		attributs.put("afficherProprietes", listeCaracteristiques(prodId));


		return "/detailProduit.jsp";
	}	
	
	@org.springframework.web.bind.annotation.RequestMapping("sousProduit")
	public String afficherSousProduit(
			@org.springframework.web.bind.annotation.RequestParam("ssprodId") String id,
			java.util.Map<String, Object> attributs
			){
		int ssprodId = Integer.parseInt(id);
		List<CaracByProprietes> carByPropSs = new ArrayList<>();
		System.out.println("ProduitCtrl.configSousProduit(" + ssprodId + ")");
	
		attributs.put("afficheUnProduit", gestionnaire.getProduitbyId(ssprodId));
		attributs.put("afficherProprietes", listeCaracteristiques(ssprodId));
		return "/detailProduit.jsp";
		
	}
	
	private List<CaracByProprietes> listeCaracteristiques(int idp){
		System.out.println("ProduitCtrl.afficherProduit(" + idp + ")");
//		gestionnaire.addStatProduit(idp);	
		List<CaracByProprietes> carByProp = new ArrayList<>();
		for (ProprieteImpl prop : gestionnaire.getProprietesbyProduitId(idp)){
			System.out.println("ProduitCtrl propId= " + gestionnaire.getProprietesbyProduitId(idp));
			CaracByProprietes cbp = new CaracByProprietes();
			List<CaracteristiqueImpl> listCar = new ArrayList<>();
			listCar = gestionnaire.getCaracteristiquesbyProprieteId(prop.getId(), idp);
			for (CaracteristiqueImpl car : listCar){
				System.out.println("ProduitCtrl liste Caracteristiques: " + car.getArticle().size());
				System.out.println("ProduitCtrl liste Caracteristiques: " + car.getArticle());
				System.out.println("ProduitCtrl proprieteId: " + car.getProprieteId());
				for(ArticleImpl art : car.getArticle()){
					System.out.println("ProduitCtrl prix: " + art.getPrixHtva());
				}
			}
			cbp.setProp(prop);
			cbp.setCarac(listCar);
			carByProp.add(cbp);
		}	
		return carByProp;
	}
	
	
}
