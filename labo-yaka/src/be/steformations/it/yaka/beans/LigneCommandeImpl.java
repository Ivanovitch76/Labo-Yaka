package be.steformations.it.yaka.beans;

public class LigneCommandeImpl {

	private Integer id;
	private CommandeImpl commande;
	private ArticleImpl articles;
	private Integer quantite;
	
	public LigneCommandeImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CommandeImpl getCommande() {
		return commande;
	}

	public void setCommande(CommandeImpl commande) {
		this.commande = commande;
	}

	public ArticleImpl getArticles() {
		return articles;
	}

	public void setArticles(ArticleImpl articles) {
		this.articles = articles;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articles == null) ? 0 : articles.hashCode());
		result = prime * result + ((commande == null) ? 0 : commande.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quantite == null) ? 0 : quantite.hashCode());
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
		LigneCommandeImpl other = (LigneCommandeImpl) obj;
		if (articles == null) {
			if (other.articles != null)
				return false;
		} else if (!articles.equals(other.articles))
			return false;
		if (commande == null) {
			if (other.commande != null)
				return false;
		} else if (!commande.equals(other.commande))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantite == null) {
			if (other.quantite != null)
				return false;
		} else if (!quantite.equals(other.quantite))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LigneCommandeImpl [id=" + id + ", commande=" + commande + ", articles=" + articles + ", quantite="
				+ quantite + "]";
	}
	
	
	
}
