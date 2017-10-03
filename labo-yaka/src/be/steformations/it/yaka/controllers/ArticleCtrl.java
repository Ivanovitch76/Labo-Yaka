package be.steformations.it.yaka.controllers;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import be.steformations.it.yaka.beans.ProprieteImpl;
import be.steformations.it.yaka.dao.JpaGestionnaireYaka;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class ArticleCtrl {

	@org.springframework.beans.factory.annotation.Autowired
	private JpaGestionnaireYaka gestionnaire;
	
	public ArticleCtrl() {
		System.out.println("ArticleCtrl.ArticleCtrl()");
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("panier")
	public String ajouterAuPanier(
//		HttpServletRequest parametres,	
		@org.springframework.web.bind.annotation.RequestParam("valid") String id,
		@org.springframework.web.bind.annotation.RequestParam("caracteristiques") List<String> ids,	
		java.util.Map<String, Object> attributs){
		System.out.println("ArticleCtrl.ajouterAuPanier");
		int prodId = Integer.parseInt(id);
		for (String string : ids) {
			System.out.println("ArticleCtrl string: " + string);
		}
//		switch (prodId) {
//		case 1:
//			parametres.getParameter("dimensions") String id2;
//			break;
//		case 5:
//			parametres.getParameter("largeur");
//			parametres.getParameter("hauteur");
//			parametres.getParameter("profondeur");
//			parametres.getParameter("revet");
//			break;
//		case 6:
//			parametres.getParameter("dimensions");
//			parametres.getParameter("revet");
//			break;
//		case 7:
//			parametres.getParameter("largeur");
//			break;
//		case 8:
//			parametres.getParameter("largeur");
//			parametres.getParameter("profondeur");
//			parametres.getParameter("revet");			
//			break;
//		default:
//			parametres.getParameter("largeur");
//			parametres.getParameter("hauteur");
//			break;
//		}	
//		attributs.put("afficheUnProduit", gestionnaire.getProduitbyId(prodId));
		
		
		return "/panier.jsp";
	}
	
}
