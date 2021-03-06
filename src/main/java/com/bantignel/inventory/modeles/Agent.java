package com.bantignel.inventory.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="AGENT")
public class Agent {
	@TableGenerator(name = "AGT", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", initialValue=1000)
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "AGT")
	private long idAgent;
	private String nom;
	private String telephone;
	private String email;
	private String adresse;
	private String login;
	private String motdepasse;
	public Agent() {
	}
	public Agent(String nom, String telephone, String email, String adresse,
			String login, String motdepasse) {
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
		this.login = login;
		this.motdepasse = motdepasse;
	}
	public long getIdAgent() {
		return idAgent;
	}
	public void setIdAgent(long idAgent) {
		this.idAgent = idAgent;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotdepasse() {
		return motdepasse;
	}
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	
}
