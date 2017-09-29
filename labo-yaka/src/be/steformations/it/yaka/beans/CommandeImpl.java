package be.steformations.it.yaka.beans;

import java.util.List;

public class CommandeImpl {

	private Integer id;
	private java.util.Date dateCommande;
	private boolean facture;
	private ClientImpl client;
	private List<LigneCommandeImpl> lignes;
	
	public CommandeImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(java.util.Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public boolean isFacture() {
		return facture;
	}

	public void setFacture(boolean facture) {
		this.facture = facture;
	}

	public ClientImpl getClient() {
		return client;
	}

	public void setClient(ClientImpl client) {
		this.client = client;
	}

	public List<LigneCommandeImpl> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneCommandeImpl> lignes) {
		this.lignes = lignes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((dateCommande == null) ? 0 : dateCommande.hashCode());
		result = prime * result + (facture ? 1231 : 1237);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lignes == null) ? 0 : lignes.hashCode());
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
		CommandeImpl other = (CommandeImpl) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (dateCommande == null) {
			if (other.dateCommande != null)
				return false;
		} else if (!dateCommande.equals(other.dateCommande))
			return false;
		if (facture != other.facture)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lignes == null) {
			if (other.lignes != null)
				return false;
		} else if (!lignes.equals(other.lignes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommandeImpl [id=" + id + ", dateCommande=" + dateCommande + ", facture=" + facture + ", client="
				+ client + ", lignes=" + lignes + "]";
	}
	
	
	
}
