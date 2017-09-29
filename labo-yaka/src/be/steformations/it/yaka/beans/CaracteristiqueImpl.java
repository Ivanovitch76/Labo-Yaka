package be.steformations.it.yaka.beans;

import java.util.List;

public class CaracteristiqueImpl {
	private Integer id;
	private ProduitImpl produitId;
	private ProprieteImpl proprieteId;
	private String valeur;
	private List<ArticleImpl> article;
	
	public CaracteristiqueImpl() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProduitImpl getProduitId() {
		return produitId;
	}

	public void setProduitId(ProduitImpl produitId) {
		this.produitId = produitId;
	}

	public ProprieteImpl getProprieteId() {
		return proprieteId;
	}

	public void setProprieteId(ProprieteImpl proprieteId) {
		this.proprieteId = proprieteId;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	public List<ArticleImpl> getArticle() {
		return article;
	}

	public void setArticle(List<ArticleImpl> article) {
		this.article = article;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((produitId == null) ? 0 : produitId.hashCode());
		result = prime * result + ((proprieteId == null) ? 0 : proprieteId.hashCode());
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
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
		CaracteristiqueImpl other = (CaracteristiqueImpl) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (produitId == null) {
			if (other.produitId != null)
				return false;
		} else if (!produitId.equals(other.produitId))
			return false;
		if (proprieteId == null) {
			if (other.proprieteId != null)
				return false;
		} else if (!proprieteId.equals(other.proprieteId))
			return false;
		if (valeur == null) {
			if (other.valeur != null)
				return false;
		} else if (!valeur.equals(other.valeur))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CaracteristiqueImpl [id=" + id + ", produitId=" + produitId + ", proprieteId=" + proprieteId
				+ ", valeur=" + valeur + ", article=" + article + "]";
	}




	
	
}
