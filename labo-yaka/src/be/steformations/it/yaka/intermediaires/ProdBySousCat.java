package be.steformations.it.yaka.intermediaires;

import java.util.List;

import be.steformations.it.yaka.beans.ProduitImpl;
import be.steformations.it.yaka.beans.SousCategorieImpl;

public class ProdBySousCat {

	SousCategorieImpl sousCatgorie;
	List<ProduitImpl> produits;
	
	public SousCategorieImpl getSousCatgorie() {
		return sousCatgorie;
	}
	public void setSousCatgorie(SousCategorieImpl sousCatgorie) {
		this.sousCatgorie = sousCatgorie;
	}
	public List<ProduitImpl> getProduits() {
		return produits;
	}
	public void setProduits(List<ProduitImpl> produits) {
		this.produits = produits;
	}

	
	
	
	
}
