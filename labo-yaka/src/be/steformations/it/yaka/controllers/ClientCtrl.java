package be.steformations.it.yaka.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import be.steformations.it.yaka.dao.JpaGestionnaireYaka;
import be.steformations.it.yaka.session.SessionAchat;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class ClientCtrl {

	@org.springframework.beans.factory.annotation.Autowired
	JpaGestionnaireYaka gestionnaire;
	@org.springframework.beans.factory.annotation.Autowired
	SessionAchat session;
	
	public ClientCtrl() {
	}	
	
	@org.springframework.web.bind.annotation.RequestMapping("commande")
	public String afficherFormulaire(
			java.util.Map<String, Object> attributs
			){
		System.out.println("ClientCtrl.afficherFormulaire()");
		attributs.put("listePays", gestionnaire.getAllPays());
		return "/client.jsp";
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("addClient")
	public String addClientAndCommandes(
			@org.springframework.web.bind.annotation.RequestParam("prenom") String prenom,
			@org.springframework.web.bind.annotation.RequestParam("nom") String nom,
			@org.springframework.web.bind.annotation.RequestParam("adresse")String adresse,
			@org.springframework.web.bind.annotation.RequestParam("cp")String cp,
			@org.springframework.web.bind.annotation.RequestParam("localite")String localite,
			@org.springframework.web.bind.annotation.RequestParam("nat")String abrev,
			@org.springframework.web.bind.annotation.RequestParam("phone")String telephone,
			@org.springframework.web.bind.annotation.RequestParam("carte")String carte,
			@org.springframework.web.bind.annotation.RequestParam("echeance")String echeance,
			@org.springframework.web.bind.annotation.RequestParam("email")String email,
			java.util.Map<String, Object> attributs
			){
		Date dateEch = null;  
		if (echeance != null) {
			try {
				dateEch = new SimpleDateFormat("dd-mm-yyyy").parse(echeance);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ClientCtrl.addClientAndCommandes() dateEch: " + dateEch);
		gestionnaire.addClient(prenom, nom, adresse, cp, localite, abrev, telephone, carte, dateEch, email);
		
		return "/end.jsp";
	}
	
	
}
