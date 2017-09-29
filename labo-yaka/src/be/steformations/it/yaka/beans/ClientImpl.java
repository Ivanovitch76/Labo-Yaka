package be.steformations.it.yaka.beans;

import java.util.List;

public class ClientImpl {

	private Integer id;
	private String nom;
	private String prenom;
	private String adresse;
	private String cp;
	private String localite;
	private PaysImpl paysAbrev;
	private String telephone;
	private String carte;
	private java.util.Date dateEcheance;
	private String email;
	private List<CommandeImpl> commandes;
	
	public ClientImpl() {
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public PaysImpl getPaysAbrev() {
		return paysAbrev;
	}

	public void setPaysAbrev(PaysImpl paysAbrev) {
		this.paysAbrev = paysAbrev;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCarte() {
		return carte;
	}

	public void setCarte(String carte) {
		this.carte = carte;
	}

	public java.util.Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(java.util.Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CommandeImpl> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<CommandeImpl> commandes) {
		this.commandes = commandes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((carte == null) ? 0 : carte.hashCode());
		result = prime * result + ((commandes == null) ? 0 : commandes.hashCode());
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + ((dateEcheance == null) ? 0 : dateEcheance.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((localite == null) ? 0 : localite.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((paysAbrev == null) ? 0 : paysAbrev.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
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
		ClientImpl other = (ClientImpl) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (carte == null) {
			if (other.carte != null)
				return false;
		} else if (!carte.equals(other.carte))
			return false;
		if (commandes == null) {
			if (other.commandes != null)
				return false;
		} else if (!commandes.equals(other.commandes))
			return false;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		if (dateEcheance == null) {
			if (other.dateEcheance != null)
				return false;
		} else if (!dateEcheance.equals(other.dateEcheance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localite == null) {
			if (other.localite != null)
				return false;
		} else if (!localite.equals(other.localite))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (paysAbrev == null) {
			if (other.paysAbrev != null)
				return false;
		} else if (!paysAbrev.equals(other.paysAbrev))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClientImpl [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cp=" + cp
				+ ", localite=" + localite + ", paysAbrev=" + paysAbrev + ", telephone=" + telephone + ", carte="
				+ carte + ", dateEcheance=" + dateEcheance + ", email=" + email + ", commandes=" + commandes + "]";
	}
	
	
	
}
