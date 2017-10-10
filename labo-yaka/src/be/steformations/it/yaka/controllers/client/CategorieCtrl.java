package be.steformations.it.yaka.controllers.client;

import be.steformations.it.yaka.dao.JpaGestionnaireYaka;
import be.steformations.it.yaka.services.SpringLibraryService;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class CategorieCtrl {

	@org.springframework.beans.factory.annotation.Autowired
	private JpaGestionnaireYaka gestionnaire;
//	private SpringLibraryService service;
	
	public CategorieCtrl() {
		super();
		System.out.println("CategorieCtrl.CategorieCtrl()");
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("categories")
	public String listeCategories(
			java.util.Map<String, Object> attributs
			){
		System.out.println("CategorieCtrl.listeCategories()");
		attributs.put("listeCategories", gestionnaire.getAllCategories());
//		attributs.put("listeCategories", service.getAllCateg());
		
		return "/client/categorie.jsp";
	}
	
	
}
