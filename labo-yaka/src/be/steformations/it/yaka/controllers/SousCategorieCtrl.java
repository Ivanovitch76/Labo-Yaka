package be.steformations.it.yaka.controllers;

import be.steformations.it.yaka.dao.JpaGestionnaireYaka;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class SousCategorieCtrl {

	@org.springframework.beans.factory.annotation.Autowired
	private JpaGestionnaireYaka gestionnaire;
	
	public SousCategorieCtrl() {
		super();
		System.out.println("SousCategorieCtrl.SousCategorieCtrl()");
	}
	
//	@org.springframework.web.bind.annotation.RequestMapping("sous-categories")
//	public String listeSousCategories(
//			java.util.Map<String, Object> attributs
//			){
//		System.out.println("SousCategorieCtrl.listeSousCategories()");
//		attributs.put("listeSousCategories", gestionnaire.getAllSousCategories());
//		return "/sousCategorie.jsp";
//	}
	
	@org.springframework.web.bind.annotation.RequestMapping("selectCateg")
	public String listeSousCategories(
			@org.springframework.web.bind.annotation.RequestParam("categId") String id,
			java.util.Map<String, Object> attributs
			){
		int catId = Integer.parseInt(id);
		System.out.println("SousCategorieCtrl.listeSousCategories(" + catId + ")");
//		gestionnaire.addStatCategorie(catId);
		attributs.put("listeSousCategories", gestionnaire.getSousCategoriesByCategorieId(catId));
		return "/sousCategorie.jsp";
	}
	
	
	
}
