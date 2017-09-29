package be.steformations.it.yaka.services;

import be.steformations.it.yaka.beans.CategorieImpl;
import be.steformations.it.yaka.dao.JpaGestionnaireYaka;


@org.springframework.stereotype.Service
@org.springframework.context.annotation.Scope("application")
public class SpringLibraryService {

	protected JpaGestionnaireYaka delegate;
	protected java.util.List<CategorieImpl> categories;
	
	public SpringLibraryService() {
		super(); 
		System.out.println("SpringLibraryService.SpringLibraryService()");
//		try {
//			javax.persistence.EntityManager em 
//				= javax.persistence.Persistence.createEntityManagerFactory("postgresql_eclipselink").createEntityManager();
//			this.delegate = new JpaGestionnaireYaka(em);
//			this.categories = new java.util.ArrayList<CategorieImpl>();
//
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
	}

	public java.util.List<CategorieImpl> getAllCateg() {
		System.out.println("SpringLibraryService.getAllCateg()");
		if (this.categories.isEmpty()) {
			categories=this.delegate.getAllCategories();
		}
		return this.categories;
	}


	
}
