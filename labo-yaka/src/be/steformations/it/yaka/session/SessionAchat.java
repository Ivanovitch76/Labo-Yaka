package be.steformations.it.yaka.session;

import be.steformations.it.yaka.beans.ArticleImpl;

@org.springframework.stereotype.Component
@org.springframework.context.annotation.Scope("session")
public class SessionAchat {

	public SessionAchat() {
	}
	
	private java.util.List<ArticleImpl> liste;

	public java.util.List<ArticleImpl> getListe() {
		if(this.liste == null){
			this.liste = new java.util.ArrayList<>();
		}
		return liste;
	}

	public void setListe(java.util.List<ArticleImpl> liste) {
		this.liste = liste;
	}
	
	
	
}
