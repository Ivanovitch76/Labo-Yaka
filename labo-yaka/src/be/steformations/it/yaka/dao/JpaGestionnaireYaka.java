package be.steformations.it.yaka.dao;

import java.util.List;

import be.steformations.it.yaka.beans.ArticleImpl;
import be.steformations.it.yaka.beans.CaracteristiqueImpl;
import be.steformations.it.yaka.beans.CategorieImpl;
import be.steformations.it.yaka.beans.ClientImpl;
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
	
	public java.util.List<CategorieImpl> getAllCategories(){
		System.out.println("JpaGestionnaireYaka.getAllCategories()");
		return this.em.createNamedQuery("getAllCategories", CategorieImpl.class).getResultList();	
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
	
	public java.util.List<ProduitImpl> getProduitsbySousCategorieId(int id){
		System.out.println("JpaGestionnaireYaka.getProduitsbySousCategorieId()");	
		return this.em.createNamedQuery("getProduitsbySousCategorieId", ProduitImpl.class).setParameter("id", id).getResultList();
	}

	public ProduitImpl getProduitbyId(int id){
		System.out.println("JpaGestionnaireYaka.getProduitbyId()");	
		return this.em.find(ProduitImpl.class, id);
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
				this.em.createNamedQuery("getClientByNomAndPrenomAndCarte", ClientImpl.class)
				.setParameter("prenom", prenom).setParameter("nom", nom).setParameter("echeance", echeance)
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
	
}
