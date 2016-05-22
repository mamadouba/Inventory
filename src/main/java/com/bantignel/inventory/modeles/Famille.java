package com.bantignel.inventory.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="FAMILLE")
public class Famille {
	@TableGenerator(name = "FAM", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", initialValue=3000)
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "FAM")
	private long idFamille;
	private String reference;
	public Famille() {
	}
	public Famille(String reference) {
		this.reference = reference;
	}
	public long getIdFamille() {
		return idFamille;
	}
	public void setIdFamille(long idFamille) {
		this.idFamille = idFamille;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
}
