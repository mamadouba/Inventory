package com.bantignel.inventory.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="FACTURE")
public class Facture {
	@TableGenerator(name = "FAC", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", initialValue=4000)
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "FAC")
	private long idFacture;
	private String dateFacture;
	private String echeanceFacture;
	@OneToOne
	private Client client;
	@OneToOne
	private Agent agent;
	public Facture() {
	}
	public Facture(String dateFacture, String echeanceFacture) {
		super();
		this.dateFacture = dateFacture;
		this.echeanceFacture = echeanceFacture;
	}
	public long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}
	public String getDateFacture() {
		return dateFacture;
	}
	public void setDateFacture(String dateFacture) {
		this.dateFacture = dateFacture;
	}
	public String getEcheanceFacture() {
		return echeanceFacture;
	}
	public void setEcheanceFacture(String echeanceFacture) {
		this.echeanceFacture = echeanceFacture;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
}
