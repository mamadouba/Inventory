package com.bantignel.inventory.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="CLIENT")
public class Client {
	@TableGenerator(name = "CLT", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", initialValue=2500)
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "CLT")
	private long idClient;
	private String nom;
	private String telephone;
	private String email;
	private String adresse;
	private String raisonCommerciale;
	@OneToOne
	private Ville ville;
	public Client() {
	}
	public Client(String nom, String telephone, String email, String adresse,String raisonCommerciale) {
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
		this.raisonCommerciale = raisonCommerciale;
		
	}
	
	
	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRaisonCommerciale() {
		return raisonCommerciale;
	}
	public void setRaisonCommerciale(String raisonCommerciale) {
		this.raisonCommerciale = raisonCommerciale;
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
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	
}
