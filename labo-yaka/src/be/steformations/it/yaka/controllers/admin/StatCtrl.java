package be.steformations.it.yaka.controllers.admin;

import be.steformations.it.yaka.dao.JpaGestionnaireYaka;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class StatCtrl {

	@org.springframework.beans.factory.annotation.Autowired
	private JpaGestionnaireYaka gestionnaire;
	
	public StatCtrl() {
		// TODO Auto-generated constructor stub
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("statCategCroissant")
	public String statCategCroissant(
			java.util.Map<String, Object> attributs
			){
		System.out.println("croissant: " + gestionnaire.getAllCategoriesCroissant());
		attributs.put("croissant", gestionnaire.getAllCategoriesCroissant());
		return "/admin/statCategCroissant.jsp";
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("statCategDecroissant")
	public String statCategDecroissant(
			java.util.Map<String, Object> attributs
			){
		
		System.out.println("décroissant: " + gestionnaire.getAllCategoriesDecroissant());
		attributs.put("decroissant", gestionnaire.getAllCategoriesDecroissant());
		return "/admin/statCategDecroissant.jsp";
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("statProdCroissant")
	public String statProdCroissant(
			java.util.Map<String, Object> attributs
			){
		attributs.put("croissant", gestionnaire.getAllProduitsCroissant());
		return "/admin/statProdCroissant.jsp";
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("statProdDecroissant")
	public String statProdDecroissant(
			java.util.Map<String, Object> attributs
			){
		
		attributs.put("decroissant", gestionnaire.getAllProduitsDecroissant());
		return "/admin/statProdDecroissant.jsp";
	}
	
}
