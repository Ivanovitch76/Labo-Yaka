package be.steformations.it.yaka.controllers.admin;

import java.util.ArrayList;
import java.util.List;

import be.steformations.it.yaka.beans.CategorieImpl;
import be.steformations.it.yaka.beans.ConnectImpl;
import be.steformations.it.yaka.beans.ProduitImpl;
import be.steformations.it.yaka.beans.SousCategorieImpl;
import be.steformations.it.yaka.dao.JpaGestionnaireYaka;
import be.steformations.it.yaka.intermediaires.ProdBySousCat;
import be.steformations.it.yaka.intermediaires.SousCatByCat;
import be.steformations.it.yaka.session.SessionAdmin;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class ConnectCtrl {
	
	@org.springframework.beans.factory.annotation.Autowired
	JpaGestionnaireYaka gestionnaire;
	@org.springframework.beans.factory.annotation.Autowired
	SessionAdmin session;
	
	public ConnectCtrl() {
		System.out.println("ConnectCtrl.ConnectCtrl()");
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("menu")
	public String accesAdmin(
			@org.springframework.web.bind.annotation.RequestParam("login") String login,
			@org.springframework.web.bind.annotation.RequestParam("password") String password,
			java.util.Map<String, Object> attributs
			){
		System.out.println("ConnectCtrl.accesAdmin()");	
		ConnectImpl connexion =  gestionnaire.getConnectbyLoginAndPassword(login, password);
		session.setConnexion(connexion);
		//attributs.put("donneesAdmin", gestionnaire.getConnectbyLoginAndPassword(login, password));
		
		return "/admin/menu.jsp";
		}

	@org.springframework.web.bind.annotation.RequestMapping("categAdd")
	public String affAddCateg(
			java.util.Map<String, Object> attributs
			){
		System.out.println("ConnectCtrl.affAddCateg()");
		
		attributs.put("listeCat", gestionnaire.getAllCategories());
		attributs.put("donneesAdmin", gestionnaire.getConnectbyLoginAndPassword(session.getConnexion().getLogin(), session.getConnexion().getPassword()));
		return "/admin/categAdd.jsp";
	}
	
	
	@org.springframework.web.bind.annotation.RequestMapping("affSsCateg")
	public String affAddSsCateg(
			@org.springframework.web.bind.annotation.RequestParam("catId") String id,
			java.util.Map<String, Object> attributs
			){
		System.out.println("ConnectCtrl.affAddSsCateg()");
		
		int cid = Integer.parseInt(id);
		attributs.put("listeSsCat", gestionnaire.getSousCategoriesByCategorieId(cid));
		attributs.put("idCatMere", cid);
		attributs.put("donneesAdmin", gestionnaire.getConnectbyLoginAndPassword(session.getConnexion().getLogin(), session.getConnexion().getPassword()));
		return "/admin/ssCategAdd.jsp";
	}	
	
	@org.springframework.web.bind.annotation.RequestMapping("affProd")
	public String affAddProd(
			@org.springframework.web.bind.annotation.RequestParam("sscatId") String id,
			java.util.Map<String, Object> attributs
			){
		System.out.println("ConnectCtrl.affAddProd()");
		
		int scid = Integer.parseInt(id);
		attributs.put("listeProd", gestionnaire.getProduitsbySousCategorieId(scid));
		attributs.put("idSsCatMere", scid);
		attributs.put("donneesAdmin", gestionnaire.getConnectbyLoginAndPassword(session.getConnexion().getLogin(), session.getConnexion().getPassword()));
		return "/admin/prodAdd.jsp";
	}	
	
	@org.springframework.web.bind.annotation.RequestMapping("addCateg")
	public String addCateg(
			@org.springframework.web.bind.annotation.RequestParam("cat") String nom,
			java.util.Map<String, Object> attributs
			){
		System.out.println("ConnectCtrl.addCateg()");
		gestionnaire.addCategorie(nom);
		attributs.put("listeCat", gestionnaire.getAllCategories());
		return "/admin/categAdd.jsp";
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("addSsCateg")
	public String addSsCateg(
			@org.springframework.web.bind.annotation.RequestParam("sscat") String nom,
			@org.springframework.web.bind.annotation.RequestParam("cid") String cid,			
			java.util.Map<String, Object> attributs
			){
		int id = Integer.parseInt(cid);
		System.out.println("ConnectCtrl.addSsCateg()");
		gestionnaire.addSsCategorie(nom, id);
		attributs.put("listeSsCat", gestionnaire.getSousCategoriesByCategorieId(id));
//		attributs.put("idCat", id);
		return "/admin/ssCategAdd.jsp";
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("addProd")
	public String addProd(
			@org.springframework.web.bind.annotation.RequestParam("prod") String nom,
			@org.springframework.web.bind.annotation.RequestParam("scid") String scid,			
			@org.springframework.web.bind.annotation.RequestParam("descCourte") String dc,			
			@org.springframework.web.bind.annotation.RequestParam("descLongue") String dl,			
			java.util.Map<String, Object> attributs
			){
		int id = Integer.parseInt(scid);
		System.out.println("ConnectCtrl.addSsCateg()");
		gestionnaire.addProduit(nom, id, dc, dl);
		attributs.put("listeProd", gestionnaire.getProduitsbySousCategorieId(id));
//		attributs.put("idCat", id);
		return "/admin/prodAdd.jsp";
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("categDel")
	public String affDelCateg(
			java.util.Map<String, Object> attributs
			){
		System.out.println("ConnectCtrl.affDelCateg()");
		
		attributs.put("listeCat", getListeCSCP());
//		attributs.put("donneesAdmin", gestionnaire.getConnectbyLoginAndPassword(session.getConnexion().getLogin(), session.getConnexion().getPassword()));
		return "/admin/categDel.jsp";
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("delCateg")
	public String deleteCateg(
			@org.springframework.web.bind.annotation.RequestParam("cId") String cid,
			java.util.Map<String, Object> attributs
			){
		System.out.println("ConnectCtrl.deleteCateg()");
		int id = Integer.parseInt(cid);
		gestionnaire.removeCategorie(id);
		attributs.put("listeCat", getListeCSCP());
		return "/admin/categDel.jsp";
	}	
	
	@org.springframework.web.bind.annotation.RequestMapping("delSsCateg")
	public String deleteSsCateg(
			@org.springframework.web.bind.annotation.RequestParam("scId") String scid,
			java.util.Map<String, Object> attributs
			){
		System.out.println("ConnectCtrl.deleteSsCateg()");
		int id = Integer.parseInt(scid);
		gestionnaire.removeSsCategorie(id);
		attributs.put("listeCat", getListeCSCP());
		return "/admin/categDel.jsp";
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("delProd")
	public String deleteProduit(
			@org.springframework.web.bind.annotation.RequestParam("pId") String pid,
			java.util.Map<String, Object> attributs
			){
		System.out.println("ConnectCtrl.deleteProduit()");
		int id = Integer.parseInt(pid);
		gestionnaire.removeProduit(id);
		attributs.put("listeCat", getListeCSCP());
		return "/admin/categDel.jsp";
	}
	
	private List<SousCatByCat> getListeCSCP(){
		List<SousCatByCat> listeCSCP = new ArrayList<>();
//		List<ProdBySousCat> prod = new ArrayList<>();
		for (CategorieImpl cat : gestionnaire.getAllCategories()) {
			SousCatByCat scbc = new SousCatByCat();
			List<ProdBySousCat> lpbsc = new ArrayList<>();
			scbc.setCategorie(cat);
			System.out.println("CATEGORIE: " + cat.getNom());
			for(SousCategorieImpl scat : gestionnaire.getSousCategoriesByCategorieId(cat.getId())){
				ProdBySousCat psc = new ProdBySousCat();
				psc.setSousCatgorie(scat);
				System.out.println("  SOUS-CATEGORIE: " + psc.getSousCatgorie().getNom());
				List<ProduitImpl> lp = new ArrayList<>();
				lp = gestionnaire.getProduitsbySousCategorieId(scat.getId());
				psc.setProduits(lp);
				for (ProduitImpl produitImpl : lp) {
					System.out.println("    PRODUIT: " + produitImpl.getNom());
				}
				psc.setSousCatgorie(scat);
				lpbsc.add(psc);
			}
			
			scbc.setProdBySousCat(lpbsc);
			listeCSCP.add(scbc);
		}
		return listeCSCP;
	}
}
