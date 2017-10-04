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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CaracteristiqueImpl [id=" + id + ", produitId=" + produitId + ", proprieteId=" + proprieteId
				+ ", valeur=" + valeur + ", article=" + article.size() + "]";
	}




	
	
}
