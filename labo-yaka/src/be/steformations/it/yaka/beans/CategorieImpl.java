package be.steformations.it.yaka.beans;

import java.util.List;

public class CategorieImpl {
	
	private Integer id;
	private String nom;
	private Integer stat;
//	private List<SousCategorieImpl> sousCateg;
		
	public CategorieImpl() {
		super();

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
	public Integer getStat() {
		return stat;
	}
	public void setStat(Integer stat) {
		this.stat = stat;
	}
//	public List<SousCategorieImpl> getSousCateg() {
//		return sousCateg;
//	}
//	public void setSousCateg(List<SousCategorieImpl> sousCateg) {
//		this.sousCateg = sousCateg;
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
//		result = prime * result + ((sousCateg == null) ? 0 : sousCateg.hashCode());
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
		CategorieImpl other = (CategorieImpl) obj;
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
//		if (sousCateg == null) {
//			if (other.sousCateg != null)
//				return false;
//		} else if (!sousCateg.equals(other.sousCateg))
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
//		return "CategorieImpl [id=" + id + ", nom=" + nom + ", stat=" + stat + ", sousCateg=" + sousCateg + "]";
		return "CategorieImpl [id=" + id + ", nom=" + nom + ", stat=" + stat + "]";
	}	

}
