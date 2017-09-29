package be.steformations.it.yaka.beans;

import java.util.List;

public class ProprieteImpl {

	private Integer id;
	private String nom;
//	private List<CaracteristiqueImpl> caracteristiques;
	
	public ProprieteImpl() {
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

//	public List<CaracteristiqueImpl> getCaracteristiques() {
//		return caracteristiques;
//	}
//
//	public void setCaracteristiques(List<CaracteristiqueImpl> caracteristiques) {
//		this.caracteristiques = caracteristiques;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((caracteristiques == null) ? 0 : caracteristiques.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		ProprieteImpl other = (ProprieteImpl) obj;
//		if (caracteristiques == null) {
//			if (other.caracteristiques != null)
//				return false;
//		} else if (!caracteristiques.equals(other.caracteristiques))
//			return false;
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
		return true;
	}

	@Override
	public String toString() {
//		return "ProprieteImpl [id=" + id + ", nom=" + nom + ", caracteristiques=" + caracteristiques + "]";
		return "ProprieteImpl [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
}
