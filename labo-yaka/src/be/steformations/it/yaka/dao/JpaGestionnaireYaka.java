package be.steformations.it.yaka.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import be.steformations.it.yaka.beans.ArticleImpl;
import be.steformations.it.yaka.beans.CaracteristiqueImpl;
import be.steformations.it.yaka.beans.CategorieImpl;
import be.steformations.it.yaka.beans.ClientImpl;
import be.steformations.it.yaka.beans.CommandeImpl;
import be.steformations.it.yaka.beans.ConnectImpl;
import be.steformations.it.yaka.beans.LigneCommandeImpl;
import be.steformations.it.yaka.beans.PaysImpl;
import be.steformations.it.yaka.beans.ProduitImpl;
import be.steformations.it.yaka.beans.ProprieteImpl;
import be.steformations.it.yaka.beans.SousCategorieImpl;
@org.springframework.stereotype.Service
@org.springframework.context.annotation.Scope("application")
public class JpaGestionnaireYaka {

	protected javax.persistence.EntityManager em;
	

//	public JpaGestionnaireYaka(javax.persistence.EntityManager em) {
	public JpaGestionnaireYaka() {
		super();
//		this.em = em;
		this.em = javax.persistence.Persistence.createEntityManagerFactory("postgresql_eclipselink").createEntityManager();
	}

//************************ CATEGORIES *********************************
	public java.util.List<CategorieImpl> getAllCategories(){
		System.out.println("JpaGestionnaireYaka.getAllCategories()");
		return this.em.createNamedQuery("getAllCategories", CategorieImpl.class).getResultList();	
	}
	
	public java.util.List<CategorieImpl> getAllCategoriesCroissant(){
		System.out.println("JpaGestionnaireYaka.getAllCategoriesCroissant()");
		return this.em.createNamedQuery("getAllCategoriesCroissant", CategorieImpl.class).getResultList();	
	}	
	
	public java.util.List<CategorieImpl> getAllCategoriesDecroissant(){
		System.out.println("JpaGestionnaireYaka.getAllCategoriesDecroissant()");
		return this.em.createNamedQuery("getAllCategoriesDecroissant", CategorieImpl.class).getResultList();	
	}	
	
	public CategorieImpl getCategoriebyId(int id){
		System.out.println("JpaGestionnaireYaka.getCategoriebyId()");	
		return this.em.find(CategorieImpl.class, id);
	}	
	
	public CategorieImpl addStatCategorie(int id) {
		CategorieImpl categorie = getCategoriebyId(id);
		categorie.setStat(categorie.getStat()+1);
		if (this.em.isJoinedToTransaction()) {
			this.em.persist(categorie);
		} else {
			this.em.getTransaction().begin();
			this.em.persist(categorie);
			this.em.getTransaction().commit();
		}
		return categorie;
	}
	
	public CategorieImpl addCategorie(String nom){
		CategorieImpl categorie = null;
		System.out.println("JpaGestionnaireYaka.addCategorie()");
		if(nom != null && ! nom.isEmpty()){
			categorie = new CategorieImpl();
			categorie.setNom(nom);
			categorie.setStat(0);
			if (this.em.isJoinedToTransaction()){
				this.em.persist(categorie);
			} else {
				this.em.getTransaction().begin();
				this.em.persist(categorie);
				this.em.getTransaction().commit();
			}
		}	
		return categorie;
	}
	
	public void removeCategorie(int id) {
		CategorieImpl categorie = this.getCategoriebyId(id);
		if (categorie != null) {
			try{
				if (this.em.isJoinedToTransaction()) {
					this.em.remove(categorie);
				} else {
					this.em.getTransaction().begin();
					this.em.remove(categorie);
					this.em.getTransaction().commit();				
				}
			} catch (NoResultException e) {
				e.printStackTrace();
			}
		}
	}
	
	//************************ SOUS-CATEGORIES *********************************	
	public java.util.List<SousCategorieImpl> getAllSousCategories(){
		System.out.println("JpaGestionnaireYaka.getAllSousCategories()");	
		return this.em.createNamedQuery("getAllSousCategories", SousCategorieImpl.class).getResultList();				
	}
	
	public SousCategorieImpl getSousCategoriebyId(int id){
		System.out.println("JpaGestionnaireYaka.getSousCategoriebyId()");	
		return this.em.find(SousCategorieImpl.class, id);
	}	
	
	public java.util.List<SousCategorieImpl> getSousCategoriesByCategorieId(int id){
		System.out.println("JpaGestionnaireYaka.getSousCategoriesByCategorieId()");	
		return this.em.createNamedQuery("getSousCategoriesByCategorieId", SousCategorieImpl.class).setParameter("id", id).getResultList();
	}

	public SousCategorieImpl addStatSousCategorie(int id) {
		SousCategorieImpl sscategorie = getSousCategoriebyId(id);
		sscategorie.setStat(sscategorie.getStat()+1);
		if (this.em.isJoinedToTransaction()) {
			this.em.persist(sscategorie);
		} else {
			this.em.getTransaction().begin();
			this.em.persist(sscategorie);
			this.em.getTransaction().commit();
		}
		return sscategorie;
	}
	
	public SousCategorieImpl addSsCategorie(String nom, int id){
		SousCategorieImpl sscat = null;
		System.out.println("JpaGestionnaireYaka.addSsCategorie()");
		if(nom != null && ! nom.isEmpty()){
			sscat = new SousCategorieImpl();
			sscat.setNom(nom);
			sscat.setStat(0);
			sscat.setCategId(getCategoriebyId(id));
			if (this.em.isJoinedToTransaction()){
				this.em.persist(sscat);
			} else {
				this.em.getTransaction().begin();
				this.em.persist(sscat);
				this.em.getTransaction().commit();
			}
		}	
		return sscat;
	}
	
	public void removeSsCategorie(int id) {
		SousCategorieImpl sscat = this.getSousCategoriebyId(id);
		if (sscat != null) {
			try{
				if (this.em.isJoinedToTransaction()) {
					this.em.remove(sscat);
				} else {
					this.em.getTransaction().begin();
					this.em.remove(sscat);
					this.em.getTransaction().commit();				
				}
			} catch (NoResultException e) {
				e.printStackTrace();
			}
		}
	}
	
//************************ PRODUITS *********************************		
	public java.util.List<ProduitImpl> getProduitsbySousCategorieId(int id){
		System.out.println("JpaGestionnaireYaka.getProduitsbySousCategorieId()");	
		return this.em.createNamedQuery("getProduitsbySousCategorieId", ProduitImpl.class).setParameter("id", id).getResultList();
	}

	public ProduitImpl getProduitbyId(int id){
		System.out.println("JpaGestionnaireYaka.getProduitbyId()");	
		return this.em.find(ProduitImpl.class, id);
	}
	
	public java.util.List<ProduitImpl> getAllProduitsCroissant(){
		System.out.println("JpaGestionnaireYaka.getAllProduitsCroissant()");
		return this.em.createNamedQuery("getAllProduitsCroissant", ProduitImpl.class).getResultList();	
	}	
	
	public java.util.List<ProduitImpl> getAllProduitsDecroissant(){
		System.out.println("JpaGestionnaireYaka.getAllProduitsDecroissant()");
		return this.em.createNamedQuery("getAllProduitsDecroissant", ProduitImpl.class).getResultList();	
	}	
	
	public ProduitImpl addStatProduit(int id) {
		ProduitImpl produit = getProduitbyId(id);
		produit.setStat(produit.getStat()+1);
		if (this.em.isJoinedToTransaction()) {
			this.em.persist(produit);
		} else {
			this.em.getTransaction().begin();
			this.em.persist(produit);
			this.em.getTransaction().commit();
		}
		return produit;
	}
	
	public ProduitImpl addProduit(String nom, int id, String dc, String dl){
		ProduitImpl prod = null;
		System.out.println("JpaGestionnaireYaka.addCategorie()");
		if(nom != null && ! nom.isEmpty()){
			prod = new ProduitImpl();
			prod.setNom(nom);
			prod.setStat(0);
			prod.setDescCourte(dc);
			prod.setDescLongue(dl);
			prod.setSousCateg(getSousCategoriebyId(id));
			prod.setImage("img_i.jpg");
			prod.setVignette("vign_v.jpg");
			if (this.em.isJoinedToTransaction()){
				this.em.persist(prod);
			} else {
				this.em.getTransaction().begin();
				this.em.persist(prod);
				this.em.getTransaction().commit();
			}
		}	
		return prod;
	}
	
	public void removeProduit(int id) {
		ProduitImpl prod = this.getProduitbyId(id);
		if (prod != null) {
			try{
				if (this.em.isJoinedToTransaction()) {
					this.em.remove(prod);
				} else {
					this.em.getTransaction().begin();
					this.em.remove(prod);
					this.em.getTransaction().commit();				
				}
			} catch (NoResultException e) {
				e.printStackTrace();
			}
		}
	}
	
	
//************************ PROPRIETES *********************************		
	public java.util.List<ProprieteImpl> getProprietesbyProduitId(int id){
		System.out.println("JpaGestionnaireYaka.getProprietesbyProduitId()");
		return this.em.createNamedQuery("getProprietesbyProduitId", ProprieteImpl.class).setParameter("id", id).getResultList();
	}
	
	public java.util.List<CaracteristiqueImpl> getCaracteristiquesbyProprieteId(int idProp, int idProd){
		System.out.println("JpaGestionnaireYaka.getCaracteristiquesbyProprieteId()");
		return this.em.createNamedQuery("getCaracteristiquesbyProprieteId", CaracteristiqueImpl.class).setParameter("idProp", idProp).setParameter("idProd", idProd).getResultList();
	}
	
	public ArticleImpl getPrixbyCaracteristiquesId (List<Integer> carId, int number){
		System.out.println("JpaGestionnaireYaka.getPrixbyCaracteristiquesId()");
		return this.em.createNamedQuery("getPrixbyCaracteristiquesId", ArticleImpl.class).setParameter("carId", carId).setParameter("number", number).getSingleResult();
	}
	
	public java.util.List<PaysImpl> getAllPays(){
		System.out.println("JpaGestionnaireYaka.getAllPays()");
		return this.em.createNamedQuery("getAllPays", PaysImpl.class).getResultList();			
	}
	
	public PaysImpl getPaysByAbrev(String abrev){
		System.out.println("JpaGestionnaireYaka.getPaysByAbrev()");
		return this.em.find(PaysImpl.class, abrev);
	}	
	
	public ClientImpl addClient(String prenom, String nom, String adresse, String cp, String localite, String abrev, String telephone, String carte, java.util.Date echeance, String email){
		System.out.println("JpaGestionnaireYaka.addClient()");
		ClientImpl client = null;
		PaysImpl pays = null;
		if (prenom != null && nom != null && 
			adresse != null && cp != null && localite != null &&
		   (pays = this.getPaysByAbrev(abrev)) != null && 
		   telephone != null && carte != null && echeance != null)
		  {
			try{
				client = this.em.createNamedQuery("getClientByNomAndPrenomAndTelephone", ClientImpl.class)
				.setParameter("prenom", prenom).setParameter("nom", nom).setParameter("telephone", telephone)
				.getSingleResult();
				
				
			} catch(javax.persistence.NoResultException ok){
				client = new ClientImpl();
				client.setPrenom(prenom);
				client.setNom(nom);
				client.setAdresse(adresse);
				client.setCp(cp);
				client.setLocalite(localite);
				client.setTelephone(telephone);
				client.setCarte(carte);
				client.setDateEcheance(echeance);
				client.setEmail(email);
				client.setPaysAbrev(pays);	
				if (this.em.isJoinedToTransaction()){
					this.em.persist(client);
				} else {
					this.em.getTransaction().begin();
					this.em.persist(client);
					this.em.getTransaction().commit();
				}
			}	
		}
		return client;
	}
	
//	public ClientImpl getClientByNomAndPrenomAndTelephone(String nom, String prenom, String telephone){
//		System.out.println("JpaGestionnaireYaka.getClientByNomAndPrenomAndTelephone()");
//		return this.em.createNamedQuery("getClientByNomAndPrenomAndTelephone", ClientImpl.class)
//		.setParameter("prenom", prenom).setParameter("nom", nom).setParameter("telephone", telephone)
//		.getSingleResult();
//	}
	
	public CommandeImpl addCommande(ClientImpl client){
		CommandeImpl commande = new CommandeImpl();
		System.out.println("JpaGestionnaireYaka.addCommande()");
		if(client.getId() != 0){
			commande.setDateCommande(new java.util.Date(System.currentTimeMillis()));
			commande.setFacture(false);
			commande.setClient(client);
			if (this.em.isJoinedToTransaction()){
				this.em.persist(commande);
			} else {
				this.em.getTransaction().begin();
				this.em.persist(commande);
				this.em.getTransaction().commit();
			}
		}	
		return commande;
	}
	
	public LigneCommandeImpl addLigneCommande(CommandeImpl commande, ArticleImpl article){
		System.out.println("JpaGestionnaireYaka.addLigneCommande()");
		LigneCommandeImpl ligne = new LigneCommandeImpl();
		if (commande.getId() != 0 && article.getId() != 0){
			ligne.setCommande(commande);
			ligne.setArticles(article);
			ligne.setQuantite(article.getQuantite());
			if (this.em.isJoinedToTransaction()){
				this.em.persist(ligne);
			} else {
				this.em.getTransaction().begin();
				this.em.persist(ligne);
				this.em.getTransaction().commit();
			}
		}
		return ligne;
	}
	
	public ConnectImpl getConnectbyLoginAndPassword(String login, String password){
		System.out.println("JpaGestionnaireYaka.getConnectbyLoginAndPassword()");	
		try{
		return this.em.createNamedQuery("getConnectbyLoginAndPassword", ConnectImpl.class)
				.setParameter("login", login).setParameter("password", password).getSingleResult();
		} catch (NoResultException e){
			return null;
		}
				
	}	
}


