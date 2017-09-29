package be.steformations.it.yaka.beans;

import java.util.List;

public class SousCategorieImpl {

	private Integer id;
	private String nom;
	private CategorieImpl categId;
	private Integer stat;
//	private List<ProduitImpl> produits;
	
	public SousCategorieImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public CategorieImpl getCategId() {
		return categId;
	}

	public void setCategId(CategorieImpl categId) {
		this.categId = categId;
	}

	public Integer getStat() {
		return stat;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}	
	
//	public List<ProduitImpl> getProduits() {
//		return produits;
//	}
//
//	public void setProduits(List<ProduitImpl> produits) {
//		this.produits = produits;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categId == null) ? 0 : categId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
//		result = prime * result + ((produits == null) ? 0 : produits.hashCode());
		result = prime * result + ((stat == null) ? 0 : stat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SousCategorieImpl other = (SousCategorieImpl) obj;
		if (categId == null) {
			if (other.categId != null)
				return false;
		} else if (!categId.equals(other.categId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
//		if (produits == null) {
//			if (other.produits != null)
//				return false;
//		} else if (!produits.equals(other.produits))
//			return false;
		if (stat == null) {
			if (other.stat != null)
				return false;
		} else if (!stat.equals(other.stat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SousCategorieImpl [id=" + id + ", nom=" + nom + ", categId=" + categId + ", stat=" + stat + "]"; 
//				+ ", produits=" + produits + "]";
	}

	
	
	
}
