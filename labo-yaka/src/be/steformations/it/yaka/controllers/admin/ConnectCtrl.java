package be.steformations.it.yaka.controllers.admin;

import be.steformations.it.yaka.beans.ConnectImpl;
import be.steformations.it.yaka.dao.JpaGestionnaireYaka;
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
	
	@org.springframework.web.bind.annotation.RequestMapping("categDel")
	public String affDelCateg(
			java.util.Map<String, Object> attributs
			){
		System.out.println("ConnectCtrl.affDelCateg()");
		
		attributs.put("listeCat", gestionnaire.getAllCategories());
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
		attributs.put("listeCat", gestionnaire.getAllCategories());
		return "/admin/categDel.jsp";
	}	
}
