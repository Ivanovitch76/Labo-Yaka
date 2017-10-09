package be.steformations.it.yaka.intermediaires;

import java.util.List;

import be.steformations.it.yaka.beans.CategorieImpl;

public class SousCatByCat {
	CategorieImpl categorie;
	List<ProdBySousCat> prodBySousCat;
	
	public CategorieImpl getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieImpl categorie) {
		this.categorie = categorie;
	}
	public List<ProdBySousCat> getProdBySousCat() {
		return prodBySousCat;
	}
	public void setProdBySousCat(List<ProdBySousCat> prodBySousCat) {
		this.prodBySousCat = prodBySousCat;
	}	
	
}
