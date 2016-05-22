package com.bantignel.inventory.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="FOURNITURE")
public class Fourniture {
	@TableGenerator(name = "FRN", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", initialValue=7000)
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "FRN")
	private long idFourniture;
	private String dateFourniture;
	@OneToOne
	private Fournisseur fournisseur;
	@OneToOne
	private Agent agent;
	public Fourniture() {
	}
	public Fourniture(String dateFourniture) {
		super();
		this.dateFourniture = dateFourniture;
	}
	public long getIdFourniture() {
		return idFourniture;
	}
	public void setIdFourniture(long idFourniture) {
		this.idFourniture = idFourniture;
	}
	public String getDateFourniture() {
		return dateFourniture;
	}
	public void setDateFourniture(String dateFourniture) {
		this.dateFourniture = dateFourniture;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
}
