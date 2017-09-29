package be.steformations.it.yaka.beans;

import java.util.List;

public class ArticleImpl {

	private Integer id;
	private float prixHtva;
	private List<CaracteristiqueImpl> caracteristiques;
	
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
