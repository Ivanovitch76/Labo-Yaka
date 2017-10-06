package be.steformations.it.yaka.session;

import be.steformations.it.yaka.beans.ConnectImpl;

@org.springframework.stereotype.Component
@org.springframework.context.annotation.Scope("session")
public class SessionAdmin {
	
	public SessionAdmin() {
	}
	
	private ConnectImpl connexion;

	public ConnectImpl getConnexion() {
		return connexion;
	}

	public void setConnexion(ConnectImpl connexion) {
		this.connexion = connexion;
	}

	

}
