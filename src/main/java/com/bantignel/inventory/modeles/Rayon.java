package com.bantignel.inventory.modeles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="RAYON")
public class Rayon {
	@TableGenerator(name = "RAY", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", initialValue=6000)
	@Id @GeneratedValue(strategy = GenerationType.TABLE, generator = "RAY")
	private long idRayon;
	private String reference;
	public Rayon() {
	}
	public Rayon(String reference) {
		this.reference = reference;
	}
	public long getIdRayon() {
		return idRayon;
	}
	public void setIdRayon(long idRayon) {
		this.idRayon = idRayon;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
}
