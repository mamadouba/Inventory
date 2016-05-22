package com.bantignel.inventory.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="PAIEMENT")
public class Paiement {
	@TableGenerator(name = "PAY", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", initialValue=8000)
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "PAY")
	private long idPaiement;
	private String typePaiement;
	private String datePaiement;
	@OneToOne
	private Facture facture;
	public Paiement() {
	}
	public Paiement(String typePaiement, String datePaiement) {
		super();
		this.typePaiement = typePaiement;
		this.datePaiement = datePaiement;
	}
	public long getIdPaiement() {
		return idPaiement;
	}
	public void setIdPaiement(long idPaiement) {
		this.idPaiement = idPaiement;
	}
	public String getTypePaiement() {
		return typePaiement;
	}
	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}
	public String getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(String datePaiement) {
		this.datePaiement = datePaiement;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
}
