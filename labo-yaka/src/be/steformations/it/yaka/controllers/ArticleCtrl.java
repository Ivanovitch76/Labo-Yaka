package be.steformations.it.yaka.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import be.steformations.it.yaka.beans.ArticleImpl;
import be.steformations.it.yaka.beans.CaracteristiqueImpl;
import be.steformations.it.yaka.beans.ProduitImpl;
import be.steformations.it.yaka.beans.ProprieteImpl;
import be.steformations.it.yaka.dao.JpaGestionnaireYaka;
import be.steformations.it.yaka.session.SessionAchat;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class ArticleCtrl {

	@org.springframework.beans.factory.annotation.Autowired
	private JpaGestionnaireYaka gestionnaire;
	@org.springframework.beans.factory.annotation.Autowired
	private SessionAchat session;
	
	public ArticleCtrl() {
		System.out.println("ArticleCtrl.ArticleCtrl()");
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("panier")
	public String ajouterAuPanier(
//		HttpServletRequest parametres,	
		@org.springframework.web.bind.annotation.RequestParam("valid") String id,
		@org.springframework.web.bind.annotation.RequestParam("caracteristiques") List<String> ids,	
		@org.springframework.web.bind.annotation.RequestParam("quantite") String q,	
		java.util.Map<String, Object> attributs){
		System.out.println("ArticleCtrl.ajouterAuPanier");
		int quant = 0;
		if (q.equals("")){
			quant = 1;
		} else {
			quant = Integer.parseInt(q);
		}
		int prodId = Integer.parseInt(id);
		int carId;
		List<Integer> carIds = new ArrayList<>();
		for (String string : ids) {
			try{
			carId = Integer.parseInt(string);
			carIds.add(carId);
			System.out.println("ArticleCtrl string: " + string);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		ArticleImpl art = gestionnaire.getPrixbyCaracteristiquesId(carIds, ids.size());
		ProduitImpl prod = gestionnaire.getProduitbyId(prodId);
		art.setProduit(prod);
		float somme = art.getPrixHtva()*quant;
		art.setQuantite(quant);
		art.setSomme(somme);

		session.getListe().add(art);
		System.out.println("TEST: " + art.getProduit().getNom());
		for (CaracteristiqueImpl c : art.getCaracteristiques()){
			System.out.println("caract: " + c.getProprieteId().getNom() + "=" + c.getValeur());
		}
		
		
//		attributs.put("produit", gestionnaire.getProduitbyId(prodId));
//		attributs.put("prix", gestionnaire.getPrixbyCaracteristiquesId(carIds, ids.size()));
//		attributs.put("prix", art);
		attributs.put("liste", session.getListe());
		
		
		return "/panier.jsp";
	}
	
}
