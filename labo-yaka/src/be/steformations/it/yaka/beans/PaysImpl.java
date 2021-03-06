package be.steformations.it.yaka.beans;

import java.util.List;

public class PaysImpl {
	
	private String abrev;
	private String nom;
	
	public PaysImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAbrev() {
		return abrev;
	}

	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abrev == null) ? 0 : abrev.hashCode());
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
		PaysImpl other = (PaysImpl) obj;
		if (abrev == null) {
			if (other.abrev != null)
				return false;
		} else if (!abrev.equals(other.abrev))
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
		return "PaysImpl [abrev=" + abrev + ", nom=" + nom + "]";
	}
	
	
	
}
