package be.steformations.it.yaka.beans;

import java.util.List;

public class ArticleImpl {

	private Integer id;
	private float prixHtva;
	private List<CaracteristiqueImpl> caracteristiques;
	private ProduitImpl produit;
	private Integer quantite;
	private float somme;
	
	public ArticleImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getPrixHtva() {
		return prixHtva;
	}

	public void setPrixHtva(float prixHtva) {
		this.prixHtva = prixHtva;
	}

	public List<CaracteristiqueImpl> getCaracteristiques() {
		return caracteristiques;
	}

	public void setCaracteristiques(List<CaracteristiqueImpl> caracteristiques) {
		this.caracteristiques = caracteristiques;
	}

	public ProduitImpl getProduit() {
		return produit;
	}

	public void setProduit(ProduitImpl produit) {
		this.produit = produit;
	}

	
	
	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public float getSomme() {
		return somme;
	}

	public void setSomme(float somme) {
		this.somme = somme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caracteristiques == null) ? 0 : caracteristiques.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(prixHtva);
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
		ArticleImpl other = (ArticleImpl) obj;
		if (caracteristiques == null) {
			if (other.caracteristiques != null)
				return false;
		} else if (!caracteristiques.equals(other.caracteristiques))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(prixHtva) != Float.floatToIntBits(other.prixHtva))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArticleImpl [id=" + id + ", prixHtva=" + prixHtva + ", caracteristiques=" + caracteristiques + "]";
	}




		
}
