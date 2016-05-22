package com.bantignel.inventory.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="COMMANDE")
public class Commande {
	@TableGenerator(name = "CMD", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", initialValue=9000)
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "CMD")
	private long idCommande;
	private String reference;
	private String dateLivraison;
	@OneToOne
	private Agent agent;
	@OneToOne
	private Client client;
	public Commande() {
	}
	public Commande(long idCommande, String reference, String dateLivraison) {
		super();
		this.idCommande = idCommande;
		this.reference = reference;
		this.dateLivraison = dateLivraison;
	}
	public long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
