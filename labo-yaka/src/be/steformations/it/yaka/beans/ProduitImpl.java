package be.steformations.it.yaka.beans;

import java.util.List;

public class ProduitImpl {

	private Integer id;
	private String nom;
	private String vignette;
	private String image;
	private String descCourte;
	private String descLongue;
	private Integer stat;
	private SousCategorieImpl sousCateg;
	private List<ProduitImpl> sousProduits;
//	private List<CaracteristiqueImpl> caracteristiques;
	
	public ProduitImpl() {
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

	public String getVignette() {
		return vignette;
	}

	public void setVignette(String vignette) {
		this.vignette = vignette;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescCourte() {
		return descCourte;
	}

	public void setDescCourte(String descCourte) {
		this.descCourte = descCourte;
	}

	public String getDescLongue() {
		return descLongue;
	}

	public void setDescLongue(String descLongue) {
		this.descLongue = descLongue;
	}

	public Integer getStat() {
		return stat;
	}

	public void setStat(Integer stat) {
		this.stat = stat;
	}

	public SousCategorieImpl getSousCateg() {
		return sousCateg;
	}

	public void setSousCateg(SousCategorieImpl sousCateg) {
		this.sousCateg = sousCateg;
	}
	
	
	
//	public List<CaracteristiqueImpl> getCaracteristiques() {
//		return caracteristiques;
//	}
//
//	public void setCaracteristiques(List<CaracteristiqueImpl> caracteristiques) {
//		this.caracteristiques = caracteristiques;
//	}


	public List<ProduitImpl> getSousProduits() {
		return sousProduits;
	}

	public void setSousProduits(List<ProduitImpl> sousProduits) {
		this.sousProduits = sousProduits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descCourte == null) ? 0 : descCourte.hashCode());
		result = prime * result + ((descLongue == null) ? 0 : descLongue.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((sousCateg == null) ? 0 : sousCateg.hashCode());
		result = prime * result + ((sousProduits == null) ? 0 : sousProduits.hashCode());
		result = prime * result + ((stat == null) ? 0 : stat.hashCode());
		result = prime * result + ((vignette == null) ? 0 : vignette.hashCode());
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
		ProduitImpl other = (ProduitImpl) obj;
		if (descCourte == null) {
			if (other.descCourte != null)
				return false;
		} else if (!descCourte.equals(other.descCourte))
			return false;
		if (descLongue == null) {
			if (other.descLongue != null)
				return false;
		} else if (!descLongue.equals(other.descLongue))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (sousCateg == null) {
			if (other.sousCateg != null)
				return false;
		} else if (!sousCateg.equals(other.sousCateg))
			return false;
		if (sousProduits == null) {
			if (other.sousProduits != null)
				return false;
		} else if (!sousProduits.equals(other.sousProduits))
			return false;
		if (stat == null) {
			if (other.stat != null)
				return false;
		} else if (!stat.equals(other.stat))
			return false;
		if (vignette == null) {
			if (other.vignette != null)
				return false;
		} else if (!vignette.equals(other.vignette))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProduitImpl [id=" + id + ", nom=" + nom + ", vignette=" + vignette + ", image=" + image
				+ ", descCourte=" + descCourte + ", descLongue=" + descLongue + ", stat=" + stat + ", sousCateg="
				+ sousCateg + ", sousProduits=" + sousProduits + "]";
	}



	
	
	
}
